public class test_checkIfSubjectPresentAndgetSubjectIndexDriver{

    public static void main(String[] args){

	SaturnGrades user = new SaturnGrades();
	user.addSubject("Biology");
	user.getElement(0).addSubcategory("Homework", 25.0);
	user.getElement(0).getElement(0).addAssignment("HW1", 95.0, "01/01/18");
	user.getElement(0).addSubcategory("Exams", 60.0);
	user.getElement(0).getElement(1).addAssignment("Exam1", 99.0, "02/01/18");
	user.getElement(0).getElement(1).addAssignment("Exam2", 96.0, "03/01/18");
	user.getElement(0).addSubcategory("Participation", 15.0);
	user.getElement(0).getElement(2).addAssignment("Raised-hand", 100.0, "01/01/18");
	user.getElement(0).getElement(2).addAssignment("Helped-teacher", 90.0, "01/02/18");
	user.getElement(0).getElement(2).addAssignment("Spoke", 100.0, "01/03/18");
	user.addSubject("APUSH");
	user.getElement(1).addSubcategory("Reading", 10.0);
	user.getElement(1).getElement(0).addAssignment("Reading1", 20.0, "01/01/18");
	user.getElement(1).addSubcategory("DBQs", 30.0);
	user.getElement(1).getElement(1).addAssignment("DBQ1", 88.0, "02/01/18");
	user.getElement(1).getElement(1).addAssignment("DBQ2", 98.0, "03/01/18");
	user.getElement(1).addSubcategory("Participation", 10.0);
	user.getElement(1).getElement(2).addAssignment("Handed-out-books", 100.0, "01/01/18");
	user.getElement(1).getElement(2).addAssignment("Did-Do-Now", 50.0, "01/02/18");
	user.getElement(1).getElement(2).addAssignment("Spoke", 0.0, "01/03/18");
	user.getElement(1).addSubcategory("Tests", 50.0);
	user.getElement(1).getElement(3).addAssignment("Test1", 99.5, "03/03/18");

	System.out.println(user.checkIfSubjectPresent("APUSH")); //true
	System.out.println(user.checkIfSubjectPresent("Biology")); //true
	System.out.println(user.checkIfSubjectPresent("FakeSubject")); //false
	System.out.println(user.getSubjectIndex("APUSH")); //1
	System.out.println(user.getSubjectIndex("Biology")); //0
	System.out.println(user.getSubjectIndex("FakeSubject")); //error

	System.out.println(user.getElement(1).checkIfSubcategoryPresent("DBQs"));//true
	System.out.println(user.getElement(0).checkIfSubcategoryPresent("DBQs"));//false
	System.out.println(user.getElement(1).getSubcategoryIndex("DBQs"));//1
    }
}
