package management;

import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

import model.StudentModel;

public class StudentManagement {

	CopyOnWriteArrayList<StudentModel> list = new CopyOnWriteArrayList<StudentModel>();
	Scanner scanner = new Scanner(System.in);

	public StudentManagement() {

	}

	public int checkId(String id) {
		for (StudentModel e : list) {
			String sr1 = e.getStudentId();
			if (sr1.equals(id)) {
				return 0;
			}
		}
		return 1;
	}

	public int checkIndex(String index) {
		for (StudentModel e : list) {
			if (e.getIndexNumber().equals(index)) {

				return 0;
			}
		}
		return 1;
	}

	public void createStudent(String studentId, String firstName,
			String lastName, String dob, String indexNumber) {
		if (checkId(studentId) == 0 || checkIndex(indexNumber) == 0) {
			System.out.println("Student vec postoji u bazi...");
		} else {
			list.add(new StudentModel(studentId, firstName,lastName, dob, indexNumber));
			System.out.println("Student dodat u bazu...");
		}
	}

	public void printAllStudents() {
		for (StudentModel e : list) {
			System.out.println(e.toString());
		}
	}

	public void printStudent(String id) {
		for (StudentModel e : list) {
			String s1 = e.getStudentId();
			if (s1.equals(id)) {
				System.out.println(e.toString());
			}

		}
	}

	public void editStudent(String id) {
		for (StudentModel e : list) {
			String s1 = e.getStudentId();
			if (s1.equals(id)) {
				System.out
						.println("Koji podatak zelite editovati?\n1- ime\n2- prezime\n3- datum\n4- broj indexa");
				int input = scanner.nextInt();
				switch (input) {
				case 1:
					System.out.println("Unesite novo ime:");
					String novoIme = scanner.next();
					e.setFirstName(novoIme);
					break;
				case 2:
					System.out.println("Unesite novo prezime:");
					String novoPrezime = scanner.next();
					e.setLastName(novoPrezime);
					break;
				case 3:
					System.out.println("Unesite novi datum:");
					String noviDatum = scanner.nextLine();
					e.setDob(noviDatum);
					break;
				case 4:
					System.out.println("Unesite novi broj indexa:");
					String noviIndex = scanner.next();
					if (checkIndex(noviIndex) == 1) {
						e.setIndexNumber(noviIndex);
						break;
					}
				}
				System.out.println("Student uspjesno editovan...");

			}
		}
	}

	public void deleteStudent(String id) {
		for (StudentModel e : list) {
			String s1 = e.getStudentId();
			if (s1.equals(id)) {
				System.out.println(e.toString());
			}
		}
		System.out
				.println("\nDa li zelite da izbrisete datog studenta?(1- DA 2- NE)");
		int input = scanner.nextInt();
		switch (input) {
		case 1:
			Iterator<StudentModel> i = list.iterator();
			StudentModel toRemove = null;
			String str2 = null;
			while (i.hasNext()) {
				toRemove = i.next();
				str2 = toRemove.getStudentId();
				if (str2.equals(id)) {
					list.remove(toRemove);
				}
			}
			System.out.println("Student uspjesno izbrisan...");
			break;
		default:
			break;

		}
	}

	public void menu() {

		System.out.println("\n*****STUDENT MENU*****");
		System.out
				.println("\n1- Create student\n2- Print all students\n3- Print student\n4- Edit student\n5- Delete student\n6- Exit");
		int input = scanner.nextInt();
		switch (input) {
		case 1:
			System.out.println("Unesite id studenta:");
			String id = scanner.next();
			System.out.println("Unesite ime studenta:");
			String ime = scanner.next();
			System.out.println("Unesite prezime studenta:");
			String prezime = scanner.next();
			System.out.println("Unesite datum:");
			String dobUnos = scanner.next();
			System.out.println();
			System.out.println("Unesite broj indexa:");
			String index = scanner.next();
			createStudent(id, ime, prezime, dobUnos, index);
			menu();
			break;
		case 2:
			System.out.println("Lista svih studenata:");
			printAllStudents();
			menu();
			break;
		case 3:
			System.out.println("Unesite id studenta:");
			String id1 = scanner.next();
			if(checkId(id1) == 1) {
				System.out.println("Navedeni ID ne postoji!");
				menu();
			}else{
				printStudent(id1);
			}
			menu();
			break;
		case 4:
			System.out.println("Unesite id studenta:");
			String id2 = scanner.next();
			if(checkId(id2) == 1) {
				System.out.println("Navedeni ID ne postoji!");
				menu();
			}else {
				editStudent(id2);
			}
			menu();
			break;
		case 5:
			System.out.println("Unesite id studenta za brisanje:");
			String removeId = scanner.next();
			if(checkId(removeId) == 1) {
				System.out.println("Navedeni ID ne postoji!");
				
			}else{
			deleteStudent(removeId);
			}
			menu();
			break;
		case 6:
			System.exit(input);

		}
	}
}

