package main;

import java.io.File;

import student.Student;
import exam.Exam;
import exam.HSKExam;
import exam.HSKKExam;
import exam.IELTSExam;
import exam.JLPTExam;
import examcentre.ExamCenter;
import examcentre.ExamCentreOpen;
import examcentre.ExamCentreRenovation;
import examcentre.ExamCentreStatus;

public class Main {

	public static void main(String[] args){
		final ExamCenter examCentre=ExamCenter.getInstance();
		ExamCentreStatus status= new ExamCentreOpen();
		status.changeStatus();
		
		examCentre.listExams();
		
		final File file= new File("exams.txt");
		final File file2=new File("registr.txt");
		examCentre.readExams(file);
		System.out.println("After reading from file!");
		examCentre.listExams();
		
		//creating new exams for the exam center
		Exam e1= new HSKExam();
		Exam e2= new HSKKExam();
		Exam e3= new IELTSExam();
		Exam e4= new JLPTExam();
		
		boolean b;
		
		//searching for an exam in the exam list
		b=examCentre.searchExam(e2);
		if (b==false){
			examCentre.addExam(e2);
		}
		
		b=examCentre.searchExam(e1);
		if(b==false)
			{
			examCentre.addExam(e1);
			}
	    
		
		b=examCentre.searchExam(e3);
		if (b==false){
			examCentre.addExam(e3);
		}
		
		b=examCentre.searchExam(e4);
		if (b==false){
			examCentre.addExam(e4);
		}
		
		examCentre.listExams();
		
		
		//searching for an exam in the exam list to delete
		b=examCentre.searchExam(e2);
		if (b==true){
			examCentre.removeExam(e2);
		}
		examCentre.searchExam(e2);
		
		
		//register for exam
		Student s1= new Student("Popescu","Ana","pop@ana.ro");
		Student s2= new Student("Mitrut","Daniel","mitrutdaniel@yahoo.ro");
		Student s3= new Student("Enachescu", "Magda" , "magda.enach@yahoo.ro");
		
		System.out.println("Some students want to register!");
		b=examCentre.searchExam(e4);
		if (b==true) {
		examCentre.registerForExam(e4, s1);
		examCentre.registerForExam(e4, s2);
		
		}else{
			System.out.println("The requested exam could not be found!");
		}
		
		b=examCentre.searchExam(e2);
		if (b==true){
			examCentre.registerForExam(e2, s3);
		}
		else {
			System.out.println("The requested exam could not be found!");
		}
		
		examCentre.listExamRegistration();
		
		examCentre.unregisterForExam(e4, s2);
	
		examCentre.listExamRegistration();
		examCentre.listExams();
		Thread t= new Thread(new Runnable() {

			@Override
			public void run() {
				examCentre.saveExams(file);
				examCentre.saveRegistrations(file2);
				System.out.println("Saving of data complete!");
			}
			
		}
		);
		t.start();
			
		status= new ExamCentreRenovation();
		status.changeStatus();
		
		
	}
}
