package examcentre;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import student.Student;
import exam.Exam;

public class ExamCenter {
	private ArrayList<Exam> examList; // lista de examene
	private static ExamCenter examCenter; //pt singleton
	private static ExamRegistration examRegister;//registru inregistrare examene

	private ExamCenter() {
		examList = new ArrayList<Exam>();
		examRegister = new ExamRegistration();
	}

	public static ExamCenter getInstance() {
		if (examCenter == null)
			return new ExamCenter();
		else
			return examCenter;
	}

	public void addExam(Exam e) {
		examList.add(e);
		System.out.println("Exam " + e.getName() + " added with success!\n");
	}

	public void removeExam(Exam e) {
		examList.remove(e);
		System.out.println("Exam " + e.getName() + " removed with success!\n");
	}

	public boolean searchExam(Exam e) {
		System.out.println("Searching for exam " + e.getName()
				+ " at our center");
		boolean ok = false;
		for (Exam ex : examList)
			if (e.equals(ex)) {
				System.out
						.println("The exam "
								+ e.getName()
								+ " is registered at our exam center!. \n You can register for it! \n");
				ok = true;
				return true;
			}

		if (ok == false) {
			System.out.println("The exam " + e.getName()
					+ " could not be found! \n");
			return false;
		}

		return false;

	}

	// salvarea examenelor disponibile in fisier
	public void saveExams(File f) {
		FileOutputStream fs = null;
		ObjectOutputStream os = null;
		try {
			try {
				fs = new FileOutputStream(f);
			} catch (FileNotFoundException e1) {
				throw new IOException();
			}

			try {
				os = new ObjectOutputStream(fs);
			} catch (IOException e1) {
				throw new IOException();
			}

			for (Exam e : examList)

				os.writeObject(e);

		} catch (IOException ex) {
			System.out.println("Problem saving data! Please contact the admin");
		} finally {
			if (os != null)
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

	}

	// citirea examenelor din fisier
	public void readExams(File f) {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		examList.clear();
		Exam exam = null;
		Object obj = null;

		try {
			try {
				fis = new FileInputStream(f);
			} catch (FileNotFoundException e) {

				throw new IOException();
			}
			try {
				ois = new ObjectInputStream(fis);
			} catch (IOException e) {

				throw new IOException();
			}
			while (true) {

				try {
					exam = (Exam) ois.readObject();
				} catch (ClassNotFoundException e) {
					throw new IOException();
				}

				// System.out.println("read one exam!");
				examList.add(exam);
				// System.out.println("added one exam!");

			}
		} catch (EOFException e) {
			System.out.println("Finished reading from file!");
		} catch (IOException ex) {
			System.out
					.println("Problems reading from file! Talk with the administrator.");

		} finally {
			try {
				if (ois != null)
					ois.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

	}

	// printare in consola
	public void listExams() {
		if (!examList.isEmpty()) {
			System.out.println("Our exam center has the following exams:");
			for (Exam e : examList) {
				System.out.println("========================================");
				System.out
						.println("Exam " + e.getName() + " -> " + e.getType());
				System.out.println(e.getLevel() + " , " + e.getPrice() + " "
						+ e.getCurrency());
				System.out.println(e.getCurrency().getExchangeRate());
				
				System.out.println("Held at " + e.getRoom());
			}
			System.out.println();

		} else
			System.out.println("Currently our exam center has no exams!\n");

	}

	public ArrayList<Exam> getExamList() {
		return examList;
	}

	public void setExamList(ArrayList<Exam> examList) {
		this.examList = examList;
	}

	public void registerForExam(Exam ex, Student s) {
		examRegister.registerForExam(ex, s);
	}

	// printare in consola a hashmapului de studenti inscrisi la examene din
	// centru
	public void listExamRegistration() {
		examRegister.listRegisteredStudents();

	}

	// salvarea studentilor inregistrati si a examenelor aferente intr-un fisier
	public void saveRegistrations(File file) {
		examRegister.saveRegistrations(file);
	}

	public void unregisterForExam(Exam ex, Student s) {
		examRegister.unregisterForExam(ex, s);
	}

}
