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
	String c = "";
	for(int i=0;i<classes.size();i++){
	    c = c + classes.get(i).getName();
	    System.out.println("Subject :" + classes.get(i));
	}
	return "Name: "+name+
	    "\nClasses: "+c;
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
	System.out.println("------------------------------------");
	User foo = new User("Bob");
	//System.out.println(foo);
        Subject a = new Subject("Precalc");
	foo.addSubject(a);
	System.out.println("Foo size: " + foo.size());
	System.out.println("Foo 0th element: " + foo.classes.get(0));
	System.out.println("Foo subject array: " + foo.classes);
	
	
	try{
	    System.out.println("Inputted keyword: " + args[0]);
	    int levelCounter = 0;
	    System.out.println("levelCounter :" + levelCounter);
	    String keyword = args[0];
	    
	    if(levelCounter == 0 && keyword.equals("back")){
		System.out.println("You cannot go back anymore!");
		levelCounter++;
	    }
	    // Should also be an upperbounds on levelCounter
	
	    if(keyword.equals("back")){
		levelCounter--;
	    }
	    else{
		levelCounter++;
	    }
	    if(levelCounter == 0){
		System.out.println("Please type in a class from the following list");
		System.out.println(foo);
	    }
	    if(levelCounter == 1){
		for(int index = 0; index < foo.size(); index++){
		    if(keyword == foo.get(index).getName()){
			System.out.println(foo.get(index));
		    }
		}
		System.out.println("Please type a subcategory from the following list");
		    
	    }
	}catch(ArrayIndexOutOfBoundsException e){
	    System.out.println("You must include a key word after 'java User'");
	}	


	
    }
}

/*Issues at hand

- levelCounter won't increase
- elements are added to classes... but won't display themselves... however getName() works

! I changed Meredith's toString() for Subject because it would be necessary to implement
the showing of inner arrays later on. That has seemed to cause the latter issue, however. !
*/
