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
	average = calcAverage();
	average = (Math.round(average * 10.0)) / 10.0;
	return average;
    }

    public ArrayList<Subcategory> getSubcats(){
	return collection;
    }

    public Subcategory getElement(int index){
	return collection.get(index);
    }

    public boolean checkIfSubcategoryPresent(String subcategoryName){
	for(int index = 0; index < collection.size(); index++){
	    if((this.getElement(index).getName()).equals(subcategoryName)){
		return true;
	    }
	}
	System.out.println("Subcategory does not exist.");
	return false;
    }

    public int getSubcategoryIndex(String subcategoryName){
	for(int index = 0; index < collection.size(); index++){
	    if((this.getElement(index).getName()).equals(subcategoryName)){
		return index;
	    }
	}
	System.out.println("Subcategory does not exist");
	return -1;
    }

    public int size(){
	return collection.size();
    }

    public boolean checkSubcategorySum(){
	double sumOfSub = 0.0;
	for(int index = 0; index < collection.size(); index++){
	    sumOfSub = sumOfSub + (collection.get(index)).getWeight();
	}
	if(sumOfSub == 0.0){
	    return true;
	}
	return sumOfSub == 100.0;
    }
    
    public void addSubcategory(String name, double weight){
	Subcategory a = new Subcategory(name, weight);
	collection.add(a);
    }
    
    public void removeSubcategory(String name){
	for(int index = 0; index < collection.size(); index++){
	    if((collection.get(index).getName()).equals(name)){
		collection.remove(index);
	    }
	}
    }

    public void addSubcategory(Subcategory subcat){
	collection.add(subcat);
    }
    public void removeSubcategory(Subcategory subcat){
	collection.remove(subcat);
    }

    public double calcAverage(){
	 if(checkSubcategorySum()){
	     double sumOfSubcategories = 0.0;
	     for(int index = 0; index < collection.size(); index++){
		 sumOfSubcategories = sumOfSubcategories + (collection.get(index).getAverage()) *
		     ((collection.get(index).getWeight()) / 100);
	     }
	     if(collection.size() == 0){
		 return 100.0;
	     }
	     double calculatedAverage = sumOfSubcategories;
	     return calculatedAverage;
	     
	 }
	 else{
	     System.out.println("Your subcategory weights do not total to 100.0!");
	     System.exit(0);
	 }
	return 0.0;
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
	    return "This subject has no subcategories!";
	}
    }
}
