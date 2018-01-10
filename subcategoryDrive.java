public class subcategoryDrive{
     public static void main(String[] args){
	Subcategory testOne = new Subcategory("this is the name", 50.0);

	System.out.println(testOne);
	
	System.out.println(testOne.getAverage() + ", " + testOne.getWeight()+ ", " + testOne.getName());
	testOne.setName("changed name");
	testOne.setWeight(60.0);
	System.out.println(testOne.getAverage()+ ", " + testOne.getWeight() + ", " + testOne.getName());
	System.out.println(testOne);
        testOne.addAssignment(99.0, "Exam 1", "01/01/2018");
	testOne.addAssignment(100.0, "Exam 2", "01/02/2018");
	System.out.println(testOne);
	testOne.deleteAssignment(99.0, "Exam 1", "01/01/2018");
	System.out.println(testOne);
	testOne.addAssignment(80.0, "Exam 3", "01/02/2018");
	testOne.addAssignment(81.0, "Exam 4", "01/02/2018");
	testOne.addAssignment(99.0, "Exam 5", "01/02/2018");
	System.out.println(testOne);
	System.out.println(testOne.calcAverage());
	System.out.println("end");
	
    }
}
