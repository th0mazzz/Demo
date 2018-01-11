public class subjectDriver{
    public static void main(String[] args){
	System.out.println("------------------------");
	
	Subject math = new Subject("Geometry");
	System.out.println(math);
	System.out.println(math.size());
	System.out.println(math.checkSubcategorySum());
	math.addSubcategory("Homeworks", 20.0);
	math.addSubcategory("Tests", 60.0);
	math.addSubcategory("Quizzes", 10.0);
	math.addSubcategory("Participation", 10.0);
	System.out.println(math.checkSubcategorySum());
	
	System.out.println(math);
	System.out.println(math.getElement(0));
	math.getElement(0).addAssignment("HW1", 100.0, "01/01/2018");
	System.out.println(math.getElement(0));
	System.out.println(math);

	math.getElement(0).addAssignment("HW2", 80.0, "02/02/2018");
	System.out.println(math.getElement(0));
	System.out.println(math.getElement(0).getElement(1));
	System.out.println(math.getElement(0).getAverage());

	System.out.println(math.getAverage()); // should not be 100

	System.out.println(90.0 * .2);

	/* need to fix Subject's calcAverage */


	
    }
}
