import java.util.ArrayList;
public class Subcategory{

    private double average = 100.0;
    private String name = "Untitled";
    private double weight = 100.0;
    private ArrayList<Assignment> collection = new ArrayList<>();
    
    public Subcategory(String name, double weight){
	this.average = average;
	this.name = name;
	this.weight = weight;
	
    }

    public void setName(String updatedName){name = updatedName;}
    public void setWeight(double updatedWeight){weight = updatedWeight;}

    public double getAverage(){return average;}
    public double getWeight(){return weight;}
    public String getName(){return name;}

    public void addAssignment(double grade, String name, String date){
	Assignment newAssignment = new Assignment(grade, name, date);
	collection.add(newAssignment);
    }
    
    
    public String toString(){
	String returnString = "";
	for(int index = 0; index < collection.size(); index++){
	    returnString = returnString + collection.get(index) + ", ";
	}
	return returnString;
    }
    
    public static void main(String[] args){
	Subcategory testOne = new Subcategory("this is the name", 50.0);

	System.out.println(testOne.getAverage() + ", " + testOne.getWeight()+ ", " + testOne.getName());
	testOne.setName("changed name");
	testOne.setWeight(60.0);
	System.out.println(testOne.getAverage()+ ", " + testOne.getWeight() + ", " + testOne.getName());
	System.out.println(testOne);
        testOne.addAssignment(99.0, "Exam 1", "01/01/2018");
	testOne.addAssignment(88.0, "Exam 2", "01/02/2018");
	System.out.println(testOne);
	System.out.println("end");
       
    }
}
