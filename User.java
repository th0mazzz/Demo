import java.util.ArrayList;
public class User{
    
    private String name;
    private ArrayList<Subject> classes = new ArrayList<>();
    //private String password;
    
    public User(){
	name="Untitled";
	//password="";
    }
    public User(String foo){
	name=foo;
    }

    public String toString(){
	//use for debugging
	return "Name: "+name+"\n "+
	    displayClasses();
    }

    public String displayClasses(){
	String result ="";
	for(int i=0;i<classes.size();i++){
	    result+="Class"+i+": "+classes.get(i)+", ";
	}
	return result;
    }
    
    public int size(){
	return classes.size();
    }

    public Subject get(int index){
	return classes.get(index);
    }
    
    public String getName(){
	return name;
    }
    public void setName(String newName){
	name=newName;
    }
    
    public void addSubject(Subject x){
	classes.add(x);
    }
    public void rmSubject(Subject n){
	classes.remove(n);
    }

    public static void main(String[] args){
	
	User semester = new User("Jesus");
	
	System.out.println(semester.classes);
	



	
    }
}

