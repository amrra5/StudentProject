import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);

	public static void menu() {

		System.out.println("\n*****STUDENT MENU*****");
		System.out
				.println("\n1- Create student\n2- Print all students\n3- Print student\n4- Edit student\n5- Delete student\n6- Exit");
		int input = sc.nextInt();
		switch (input) {
		case 1:
			System.out.println("Unesite id studenta:");
			String id = sc.next();
			System.out.println("Unesite ime studenta:");
			String ime = sc.next();
			System.out.println("Unesite prezime studenta:");
			String prezime = sc.next();
			System.out.println("Unesite datum:");
			String dobUnos = sc.next();
			System.out.println();
			System.out.println("Unesite broj indexa:");
			String index = sc.next();
			Management.createStudent(id, ime, prezime, dobUnos, index);
			menu();
			break;
		case 2:
			System.out.println("Lista svih studenata:");
			Management.printAllStudents();
			menu();
			break;
		case 3:
			System.out.println("Unesite id studenta:");
			String id1 = sc.next();
			while (Management.checkId(id1) == 1) {
				System.out.println("Navedeni ID ne postoji!");
				System.out.println("Unesite id studenta:");
				id1 = sc.next();
			}
			Management.printStudent(id1);
			menu();
			break;
		case 4:
			System.out.println("Unesite id studenta:");
			String id2 = sc.next();
			while (Management.checkId(id2) == 1) {
				System.out.println("Navedeni ID ne postoji!");
				System.out.println("Unesite id studenta:");
				id2 = sc.next();
			}
			Management.editStudent(id2);
			menu();
			break;
		case 5:
			System.out.println("Unesite id studenta za brisanje:");
			String removeId = sc.next();
			Management.deleteStudent(removeId);
			menu();
			break;
		case 6:
			System.exit(input);

		}
	}

	public static void main(String[] args) {

		menu();

	}

}
