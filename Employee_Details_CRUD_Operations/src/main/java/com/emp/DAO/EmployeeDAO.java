package com.emp.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.emp.Been.Employee;


public class EmployeeDAO {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/demo?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "somu12";
	
	
	private static final String INSERT_EMPLOYERS_SQL = "INSERT INTO emp" + "  (empid, name, designation, salary) VALUES "
			+ " (?, ?, ?, ?);";

	private static final String SELECT_EMPLOYEE_BY_NUM = "select num, empid, name, designation, salary from emp where num =?";
	private static final String SELECT_ALL_EMPLOYERS = "select * from emp";
	private static final String DELETE_EMPLOYERS_SQL = "delete from emp where num = ?;";
	private static final String UPDATE_EMPLOYERS_SQL = "update emp set empid=?, name = ?,designation= ?, salary =? where num = ?;";

	
	public EmployeeDAO() {
	}
	
	
	//Database Connection Method
	protected Connection getConnection() {
		Connection connection =null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	// Create or Insert Employee
		public void insertEmployee(Employee employee) throws SQLException {
			System.out.println(INSERT_EMPLOYERS_SQL);
			// try-with-resource statement will auto close the connection.
			try (Connection connection = getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYERS_SQL)) {
				preparedStatement.setString(1, employee.getEmpid());
				preparedStatement.setString(2, employee.getName());
				preparedStatement.setString(3, employee.getDesignation());
				preparedStatement.setInt(4, employee.getSalary());
				System.out.println(preparedStatement);
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				printSQLException(e);
			}
		}
		
		
		//Select User By Num
		public Employee selectEmployee(int num) {
			Employee employee = null;
			// Step 1: Establishing a Connection
			try (Connection connection = getConnection();
					// Step 2:Create a statement using connection object
					PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_NUM);) {
				preparedStatement.setInt(1, num);
				System.out.println(preparedStatement);
				// Step 3: Execute the query or update query
				ResultSet rs = preparedStatement.executeQuery();

				// Step 4: Process the ResultSet object.
				while (rs.next()) {
					String empid = rs.getString("empid");
					String name = rs.getString("name");
					String designation = rs.getString("designation");
					int salary = rs.getInt("salary");
					employee = new Employee(num, empid, name, designation, salary);
				}
			} catch (SQLException e) {
				printSQLException(e);
			}
			return employee;
		}
		
		
		public List<Employee> selectAllEmployers() {

			// using try-with-resources to avoid closing resources (boiler plate code)
			List<Employee> employers = new ArrayList<>();
			// Step 1: Establishing a Connection
			try (Connection connection = getConnection();

					// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYERS);) {
				System.out.println(preparedStatement);
				// Step 3: Execute the query or update query
				ResultSet rs = preparedStatement.executeQuery();

				// Step 4: Process the ResultSet object.
				while (rs.next()) {
					int num = rs.getInt("num");
					String empid = rs.getString("empid");
					String name = rs.getString("name");
					String designation = rs.getString("designation");
					int salary = rs.getInt("salary");
					employers.add(new Employee(num, empid, name, designation, salary));
				}
			} catch (SQLException e) {
				printSQLException(e);
			}
			return employers;
		}
		
		
		//Delete Employee 
		public boolean deleteEmployee(int num) throws SQLException {
			boolean rowDeleted;
			try (Connection connection = getConnection();
					PreparedStatement statement = connection.prepareStatement(DELETE_EMPLOYERS_SQL);) {
				statement.setInt(1, num);
				rowDeleted = statement.executeUpdate() > 0;
			}
			return rowDeleted;
		}
		
		
		//Update Employee
		public boolean updateEmployee(Employee employee) throws SQLException {
			boolean rowUpdated;
			try (Connection connection = getConnection();
					PreparedStatement statement = connection.prepareStatement(UPDATE_EMPLOYERS_SQL);) {
				statement.setString(1, employee.getEmpid());
				statement.setString(2, employee.getName());
				statement.setString(3, employee.getDesignation());
				statement.setInt(4, employee.getSalary());
				statement.setInt(5, employee.getNum());

				rowUpdated = statement.executeUpdate() > 0;
			}
			return rowUpdated;
		}
		
		
		private void printSQLException(SQLException ex) {
			for (Throwable e : ex) {
				if (e instanceof SQLException) {
					e.printStackTrace(System.err);
					System.err.println("SQLState: " + ((SQLException) e).getSQLState());
					System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
					System.err.println("Message: " + e.getMessage());
					Throwable t = ex.getCause();
					while (t != null) {
						System.out.println("Cause: " + t);
						t = t.getCause();
					}
				}
			}
		}


}
