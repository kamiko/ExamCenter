package examcentre;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import student.Student;
import exam.Exam;

public class ExamRegistration {
	private HashMap<Exam, List<Student>> registrationList;
	
	public ExamRegistration(){
		registrationList=new HashMap<Exam,List<Student>>();
	}
	
	public void registerForExam(Exam ex, Student s){
		List<Student> studentList;
		if(!registrationList.containsKey(ex)){
			studentList=new ArrayList<Student>();
			studentList.add(s);
			registrationList.put(ex, studentList);
			}
		else{
			studentList=registrationList.get(ex);
			studentList.add(s);
		}
		
	}
	
	public void unregisterForExam(Exam ex, Student s){
		List<Student> studentList;
		
		if(registrationList.containsKey(ex)){
			studentList=new ArrayList<Student>();
			studentList=registrationList.get(ex);
			studentList.remove(s);
			}
		
	}
	
	/*public boolean searchRegisteredStudent(Exam ex, Student s){
		List<Student> studentList;
		if(registrationList.containsKey(ex)){
			studentList=new ArrayList<Student>();
			studentList=registrationList.get(ex);
			if (studentList.contains(s)){
				return true;
			}
						
			else{
				return false;
			}
		}
		else {
			return false;
		
		}
	}
*/
	
	public void listRegisteredStudents(){
		
		List<Student> studentList;
		if (!registrationList.isEmpty()) {
			studentList=new ArrayList<Student>();
			System.out.println("Our exam center has students for the following exams:");
			System.out.println("========================================");
			int counter=1;
			for(Map.Entry<Exam,List<Student>> entry: registrationList.entrySet())
			{
				Exam key= entry.getKey();
				studentList=entry.getValue();
				System.out.println(counter + ". " + key.getName());
				counter++;
				for(Student s: studentList)
					System.out.println("\t " + s.getPrenume() + " "+ s.getNume());
			}
				
			
			System.out.println();
			
		}
		else System.out.println("Currently no students are registered for exams!\n");

	}
	public HashMap<Exam, List<Student>> getRegistrationList() {
		return registrationList;
	}
	
	public void saveRegistrations(File file){
		List<Student> studentList;
		BufferedWriter bw=null;
		try {
			FileWriter fw=new FileWriter(file.getAbsoluteFile());
			if (!file.exists()){
				file.createNewFile();}
			else{
				
				bw= new BufferedWriter(fw);
				bw.write("Exam Centre Registrations");
				bw.newLine();
				
				for(Map.Entry<Exam,List<Student>> entry: registrationList.entrySet())
				{
					Exam key= entry.getKey();
					studentList=entry.getValue();
				bw.write(key.toString());
				bw.newLine();
				bw.write("\t" + studentList.toString());
				
				}
			}
			
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			if (bw!=null)
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	
	/*public void readRegistrations(File f){
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		registrationList.clear();
	
		try {
			fis = new FileInputStream(f);
			ois = new ObjectInputStream(fis);
			while(true) 
				{
				Map.Entry<Exam,List<Student>> entry = (	Map.Entry<Exam,List<Student>> ) ois.readObject();
				System.out.println("read one exam registration!");
				registrationList.put(entry.getKey(), entry.getValue());
				 System.out.println("added one exam registration!");
			}
		   
			
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}  catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		catch(EOFException e){
			System.out.println("Reached end of file!\n");
			//e.printStackTrace();
		}
		catch (IOException e) {

			e.printStackTrace();
		}
		finally {
			try {
				if (ois != null)
					ois.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}*/
	
}
