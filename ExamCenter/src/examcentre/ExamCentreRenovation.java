package examcentre;

public class ExamCentreRenovation implements ExamCentreStatus{

	@Override
	public void changeStatus() {
		System.out.println("The exam centre is in renovations! Please come back later!");
		
	}

}
