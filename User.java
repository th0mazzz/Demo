import java.util.ArrayList;
public class User{
    public static void main(String[] args){
	User foo = new User("Bob");
	System.out.println(foo);
	Subject a = new Subject("Precalc");
	foo.addSubject(a);
	System.out.println(foo);
    }
    
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
	String c = "";
	for(int i=0;i<classes.size();i++){
	    c+=classes.get(i);
	}
	return "Name: "+name+
	    "\nClasses: "+c;
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
}
