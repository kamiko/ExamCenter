package examcentre;

public class ExamCentreHoliday implements ExamCentreStatus{

	@Override
	public void changeStatus() {
		System.out.println("The exam centre is in holiday!. Please come back in two weeks!");
		
	}

}
