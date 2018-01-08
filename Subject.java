import java.util.ArrayList;
public class Subject{
    private double average = 100.0;
    private String name = "Untitled";
    private ArrayList<Subcategory> collection = new ArrayList<>();
    
    public Subject(String name){
	this.name = name;
    }

    public void setName(String name){this.name = name;}

    public void getName(){return name;}
    public void getAverage(){return average;}


    public static void main(String[] args){
	
    }			    
}
