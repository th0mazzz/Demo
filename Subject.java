import java.util.ArrayList;
public class Subject{
    private double average = 100.0;
    private String name = "Untitled";
    private ArrayList<Subcategory> collection = new ArrayList<>();
    
    public Subject(String n){
	name=n;
    }
    
    public void setName(String n){
	name=n;
    }
    public String getName(){
	return name;
    }
   
    public double getAverage(){
	return average;
    }

    public boolean checkSubcategorySum(){ //TEST
	double sumOfSub = 0.0;
	for(int index = 0; index < collection.size(); index++){
	    sumOfSub = sumOfSub + (collection.get(index)).getWeight();
	}
	return sumOfSub == 100.0;
    }
    
    public String toString(){
	return "Subject name: "+displaySubcats();
    }

    public String displaySubcats(){
	String returnString = "";
	for(int index = 0; index < collection.size(); index++){
	    returnString += collection.get(index) + ", ";
	}
	return returnString;
    }
    
    public void addSubCat(Subcategory a){
	collection.add(a);
    }
    public void rmSubCat(Subcategory b){
	collection.remove(b);
    }
    

    public static void main(String[] args){
	Subject n = new Subject("foo");
	System.out.println(n);
	n.setName("APCS");
	System.out.println(n.getName());
	Subcategory abcd = new Subcategory("Participation", 20.0);
	Subcategory tests = new Subcategory("Tests", 60.0);
	Subcategory quizzes = new Subcategory("Quizzes", 0.0);
	Subcategory projects = new Subcategory("Projects", 0.0);
	n.addSubCat(abcd);
	n.addSubCat(tests);
	n.addSubCat(quizzes);
	n.addSubCat(projects);
	//System.out.println(n.collection.size());
	System.out.println(n.checkSubcategorySum());
    }			    
}
