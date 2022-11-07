package miniproject;

import java.time.LocalDate;

import java.util.Scanner;

public class project {

	static void C() {
		System.out.println("Course : C ");
		System.out.println("Fee : 10,000 ");
		System.out.println("Course Duration : 30 days ");
	}

	static void JAVA() {
		System.out.println("Course : JAVA ");
		System.out.println("Fee : 15,000 ");
		System.out.println("Course Duration : 60 days ");
	}

	static void Python() {
		System.out.println("Course : Python ");
		System.out.println("Fee : 15,000 ");
		System.out.println("Course Duration : 45 days ");
	}

	static void Data_Science() {
		System.out.println("Course : Data Science ");
		System.out.println("Fee : 20,000 ");
		System.out.println("Course Duration : 60 days ");
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		LocalDate date = LocalDate.now();

		System.out.println("Enter Name of the Candidate : ");
		String Name = sc.nextLine();

		System.out.println("Enter 1: C ");
		System.out.println("Enter 2: JAVA ");
		System.out.println("Enter 3: Python ");
		System.out.println("Enter 4: Data Science ");

		int i = sc.nextInt();
		System.out.println("Date : " + date);
		System.out.println("Name of the Candidate : " + Name);
		switch (i) {
		case 1: {
			C();
			break;
		}
		case 2: {
			JAVA();
			break;
		}
		case 3: {
			Python();
			break;
		}
		case 4: {
			Data_Science();
			break;
		}

		}

	}

}
