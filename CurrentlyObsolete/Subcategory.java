import java.util.ArrayList;
public class Subcategory{

    private double average = 0;
    private String name = "Untitled";
    private double weight = 0;
    private ArrayList<Assignment> collection = new ArrayList<>();
    
    public Subcategory(String name, double weight){
	this.average = 100.0;
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

    public void deleteAssignment(double grade, String name, String date){
	for(int index = 0; index < collection.size(); index++){
	    if(collection.get(index).getName() == name){
		collection.remove(index);
	    }
	}
    }

    public double calcAverage(){
	double sumOfGrades = 0.0;
	for(int index = 0; index < collection.size(); index++){
	    sumOfGrades = sumOfGrades + collection.get(index).getGrade();
	    System.out.println(sumOfGrades);
	}
	return sumOfGrades / collection.size();
    }
	    
    public String displayAssignments(){
	String returnString = "[";
	for(int index = 0; index < collection.size() - 1; index++){
	    returnString = returnString + collection.get(index) + ", ";
	}
	if(collection.size() > 0){
	    returnString = returnString + collection.get(collection.size() - 1);
	    return returnString + "]";
	}
	return "Subcat name: "+name+returnString + "]";
    }
    
    public String toString(){
	return name;
    }
}
