public class assignmentDrive{
    public static void main(String[] args){

	Assignment test = new Assignment(98.2, "test one", "01/01/2012");
	System.out.println(test.getName() + test.getDate() + test.getGrade());

	test.setName("jason derulo");
	test.setGrade(66.6);
	test.setDate("10111"); //need to make checks on valid dates

	System.out.println(test.getName() + test.getDate() + test.getGrade());
    }
    
}
