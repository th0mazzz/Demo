public class subDrive{
    public static void main(String[] args){
	Subcategory exams = new Subcategory("Exams", 30.0);
	System.out.println(exams);
	exams.addAssignment("Exam1", 90.0, "01/01/2018");
	System.out.println(exams);
	exams.addAssignment("Exam2", 100, "02/02/2018");
	System.out.println(exams);

	System.out.println(exams.getElement(1));
	System.out.println(exams.calcAverage());
	System.out.println(exams.getAverage());

	exams.removeAssignment("Exam2");
	System.out.println(exams);
	System.out.println(exams.getAverage());
    }
}
