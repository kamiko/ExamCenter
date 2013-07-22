package examcentre;

public interface ExamCentreStatus {
	//pentru strategy -> centrul de examinare are mai multe statusuri posibile: deschis, in renovare sau in vacanta
	public void changeStatus();
}
