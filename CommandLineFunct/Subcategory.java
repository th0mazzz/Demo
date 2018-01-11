import java.util.ArrayList;
public class Subcategory{

    private double average = 0;
    private String name = "UntitledSubcategory";
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

    public Assignment getElement(int index){
	return collection.get(index);
    }
    
    public void addAssignment(String name, double grade, String date){
	Assignment newAssignment = new Assignment(name, grade, date);
	collection.add(newAssignment);
	average = calcAverage();
    }

    public void removeAssignment(String name){
	for(int index = 0; index < collection.size(); index++){
	    if(collection.get(index).getName() == name){
		collection.remove(index);
	    }
	}
	average = calcAverage();
    }

    public double calcAverage(){
	double sumOfGrades = 0.0;
	for(int index = 0; index < collection.size(); index++){
	    sumOfGrades = sumOfGrades + collection.get(index).getGrade();
	}
	return sumOfGrades / collection.size();
    }
    
    public String toString(){
	String returnString = "";
	int index = 0;
	if(collection.size() != 0){
	    for(; index < collection.size() - 1; index++){
		returnString = returnString + collection.get(index).getName() + ", ";
	    }
	return returnString + collection.get(index).getName();
	}
	else{
	    return "This subcategory has no assignments!";
	}
    }
}
