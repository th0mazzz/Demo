public class testQuickView{
    public static void main(String[] args){

	SaturnGrades user = new SaturnGrades();
	user.addSubject("Precalculus");
	user.getElement(0).addSubcategory("Homework", 20.0);
	user.getElement(0).getElement(0).addAssignment("HW1", 100.0, "01/01/18");
	user.getElement(0).addSubcategory("Exams", 70.0);
	user.getElement(0).getElement(1).addAssignment("Exam1", 80.0, "02/01/18");
	user.getElement(0).getElement(1).addAssignment("Exam2", 90.0, "03/01/18");
	user.getElement(0).getElement(1).addAssignment("Exam3", 10.0, "04/01/18");
	user.getElement(0).addSubcategory("Participation", 10.0);
	user.getElement(0).getElement(2).addAssignment("Raised hand", 100.0, "01/01/18");
	user.getElement(0).getElement(2).addAssignment("Helped teacher", 90.0, "01/02/18");
	user.getElement(0).getElement(2).addAssignment("Spoke", 0.0, "01/03/18");
	user.addSubject("English");
	user.getElement(1).addSubcategory("Reading", 30.0);
	user.getElement(1).getElement(0).addAssignment("Reading1", 20.0, "01/01/18");
	user.getElement(1).addSubcategory("Essays", 50.0);
	user.getElement(1).getElement(1).addAssignment("Essay1", 60.0, "02/01/18");
	user.getElement(1).getElement(1).addAssignment("Essay2", 95.0, "03/01/18");
	user.getElement(1).addSubcategory("Participation", 10.0);
	user.getElement(1).getElement(2).addAssignment("Handed out books", 100.0, "01/01/18");
	user.getElement(1).getElement(2).addAssignment("Did Do Now", 50.0, "01/02/18");
	user.getElement(1).getElement(2).addAssignment("Spoke", 0.0, "01/03/18");
	user.getElement(1).addSubcategory("Check-ins", 10.0);
	user.getElement(1).getElement(3).addAssignment("Check-in1", 100.0, "03/03/18");

	user.quickView();
	
	
    }
}
