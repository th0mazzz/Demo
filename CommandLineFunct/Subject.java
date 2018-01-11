import java.util.ArrayList;
public class Subject{
    private double average = 100.0;
    private String name = "UntitledSubject";
    private ArrayList<Subcategory> collection = new ArrayList<>();
    
    public Subject(String name){
	this.name = name;
    }
    
    public void setName(String name){this.name = name;}

    public String getName(){return name;} 
    public double getAverage(){
	if(checkSubcategorySum()){
	    return average;
	}
	else{
	    throw new RuntimeException("Error fetching accurate average: subcategory weights do not total to 100.0");
	}
    }

    public Subcategory getElement(int index){
	return collection.get(index);
    }

    public int size(){
	return collection.size();
    }

    public boolean checkSubcategorySum(){
	double sumOfSub = 0.0;
	for(int index = 0; index < collection.size(); index++){
	    sumOfSub = sumOfSub + (collection.get(index)).getWeight();
	}
	return sumOfSub == 100.0;
    }
    
    public void addSubcategory(String name, double weight){
	Subcategory a = new Subcategory(name, weight);
	collection.add(a);
    }
    
    public void removeSubcategory(String name){
	for(int index = 0; index < collection.size(); index++){
	    if(collection.get(index).getName() == name){
		collection.remove(index);
	    }
	}
    }

     public double calcAverage(){
	 if(checkSubcategorySum()){
	     double sumOfSubcategories = 0.0;
	     for(int index = 0; index < collection.size(); index++){
		 sumOfSubcategories = sumOfSubcategories + (collection.get(index).getAverage()) *
		     ((collection.get(index).getWeight()) / 100);
	     }
	     return sumOfSubcategories / collection.size();
	 }
	 else{
	     throw new RuntimeException("Your subcategory weights do not total to 100.0!");
	 }
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
	    return "This subject has no assignments!";
	}
    }
}
