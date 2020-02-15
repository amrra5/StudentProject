import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Management {

	public static ArrayList<Student> list = new ArrayList<>();
	static Scanner scanner = new Scanner(System.in);

	Management() {

	}

	public static int checkId(String id) {
		for (Student e : list) {
			String sr1 = e.getStudentId();
			if (sr1.equals(id)) {
				return 0;
			}
		}
		return 1;
	}

	public static int checkIndex(String index) {
		for (Student e : list) {
			if (e.getIndexNumber().equals(index)) {

				return 0;
			}
		}
		return 1;
	}

	public static void createStudent(String studentId, String firstName,
			String lastName, String dob, String indexNumber) {
		if (checkId(studentId) == 0 || checkIndex(indexNumber) == 0) {
			System.out.println("Student vec postoji u bazi...");
		} else {
			list.add(new Student(studentId, firstName, lastName, dob,
					indexNumber));
			System.out.println("Student dodat u bazu...");
		}
	}

	public static void printAllStudents() {
		for (Student e : list) {
			System.out.println(e.toString());
		}
	}

	public static void printStudent(String id) {
		for (Student e : list) {
			String s1 = e.getStudentId();
			if (s1.equals(id)) {
				System.out.println(e.toString());
			}

		}
	}

	public static void editStudent(String id) {
		for (Student e : list) {
			String s1 = e.getStudentId();
			if (s1.equals(id)) {
				System.out
						.println("Koji podatak zelite editovati?\n1- ime\n2- prezime\n3-datum\n4- broj indexa");
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

	public static void deleteStudent(String id) {
		for (Student e : list) {
			String s1 = e.getStudentId();
			if (s1.equals(id)) {
				System.out.println(e.toString());
			}
			System.out
					.println("\nDa li zelite da izbrisete datog studenta?(1- DA 2- NE)");
			int input = scanner.nextInt();
			if (input == 1) {
				Iterator<Student> i = list.iterator();
				while (i.hasNext()) {
					Student toRemove = i.next();
					String str2 = toRemove.getStudentId();
					if (str2.equals(id)) {
						i.remove();

						System.out.println("Student uspjesno izbrisan...");
					}
				}
			} else {
				break;
			}
		}

	}
}
