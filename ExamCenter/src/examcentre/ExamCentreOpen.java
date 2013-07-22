package examcentre;

public class ExamCentreOpen implements ExamCentreStatus {

	@Override
	public void changeStatus() {
		System.out.println("The exam centre is open. You can register for exams!");
		
	}

}
