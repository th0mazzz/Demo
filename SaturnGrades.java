import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
public class SaturnGrades{

    private String name = "Unnamed";
    private double average = 100.0;
    private ArrayList<Subject> collection = new ArrayList<>(); //INITIALIZE
    
    public int size(){
	return collection.size();
    }

    public String getName(){return name;}
    public void setName(String name){this.name = name;}
    
    public double getAverage(){
	average = calcAverage();
	average = (Math.round(average * 10.0)) / 10.0;
	return average;
    }

    public Subject getElement(int index){
	return collection.get(index);
    }
    
    public void addSubject(String name){
	Subject newSubject = new Subject(name);
	collection.add(newSubject);
    }

    public void removeSubject(String name){
	for(int index = 0; index < collection.size(); index++){
	    if((collection.get(index).getName()).equals(name)){
		collection.remove(index);
	    }
	}
    }

    public double calcAverage(){
	double sumOfSubjects = 0.0;
	for(int index = 0; index < collection.size(); index++){
	    sumOfSubjects = sumOfSubjects + (collection.get(index)).getAverage(); //this getAverage() is printing some weird stuff
	}
	return sumOfSubjects / size();
    }

    public void displayBasic(){
	System.out.println(this.getName());
	for(int subjectIndex = 0; subjectIndex < collection.size(); subjectIndex++){
	    System.out.println("*----------" + this.getElement(subjectIndex).getName() + "----------*");
	    System.out.println("Subcategories: " + this.getElement(subjectIndex) + "\n");
	    for(int subcategoryIndex = 0; subcategoryIndex < this.getElement(subjectIndex).size(); subcategoryIndex++){
		System.out.println("Subcategory: " + this.getElement(subjectIndex).getElement(subcategoryIndex).getName());
		System.out.println("Assignments: " + this.getElement(subjectIndex).getElement(subcategoryIndex));
		System.out.println("\n");
	    }
	}
    }

    public void displayInformed(){
	System.out.println(this.getName());
	System.out.println("GPA: " + this.getAverage() + "%" + "\n");
	for(int subjectIndex = 0; subjectIndex < collection.size(); subjectIndex++){
	    System.out.println("*----------" + this.getElement(subjectIndex).getName() + " (" + this.getElement(subjectIndex).getAverage() + "%)----------*");
	    System.out.println("Subcategories: " + this.getElement(subjectIndex) + "\n");
	    for(int subcategoryIndex = 0; subcategoryIndex < this.getElement(subjectIndex).size(); subcategoryIndex++){
		System.out.println("Subcategory: " + this.getElement(subjectIndex).getElement(subcategoryIndex).getName() + " (" + this.getElement(subjectIndex).getElement(subcategoryIndex).getAverage() + "%)");
		System.out.println("Assignments: " + this.getElement(subjectIndex).getElement(subcategoryIndex));
		for(int assignmentIndex = 0; assignmentIndex < this.getElement(subjectIndex).getElement(subcategoryIndex).size(); assignmentIndex++){
		    System.out.println(this.getElement(subjectIndex).getElement(subcategoryIndex).getElement(assignmentIndex));
		}
		System.out.println("\n");
	    }
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
	    return "This program has no subjects!";
	}
    }

    public void readFile(){
	String fileName = "storage.txt";
	try{
	    File storageFile = new File(fileName);
	    Scanner in = new Scanner(storageFile);
	    
	    /*
	      Key:
	      * Name
	      
	      ! Subject name
	      
	      ~ Subcategory weight
	      ? Subcategory name
	      
	      , Assignment grade
	      ' Assignment date
	      . Assignment name

	    */

	    int subjectIndex = -1;
	    int subcategoryIndex = -1;
	    
	    double subcategoryWeight = 0.0;

	    double assignmentGrade = 0.0;
	    String assignmentDate = "";

	    while(in.hasNext()){
		
		String word = in.next();
		if(word.equals("*")){
		    this.setName(in.next());
		}else{
		    if(word.equals("!")){
			this.addSubject(in.next());
			subcategoryIndex = -1;
			subjectIndex++;
		    }else{
			if(word.equals("~")){
			    subcategoryWeight = Double.parseDouble(in.next());
			}else{
			    if(word.equals("?")){
				this.getElement(subjectIndex).addSubcategory(in.next(), subcategoryWeight);
				subcategoryIndex++;
			    }else{
				if(word.equals(",")){
				    assignmentGrade = Double.parseDouble(in.next());
				}else{
				    if(word.equals("'")){
					assignmentDate = in.next();
				    }else{
					if(word.equals(".")){
					    this.getElement(subjectIndex).getElement(subcategoryIndex).addAssignment(in.next(), assignmentGrade, assignmentDate);
					}
				    }
				}
			    }
			}
		    }
		}
	    }
	}catch(FileNotFoundException e){
	    System.out.println("The file is missing from the program's directory: storage.txt");
	}		     
    }
    
    public void writeFile(){
	String fileName = "storage.txt";
	try{
	    FileWriter writer = new FileWriter(fileName);
	    BufferedWriter efficientWriter = new BufferedWriter(writer);
	    
	    efficientWriter.write(this.toWrite());
	    
	    efficientWriter.close();
	    
	}catch(IOException e){
	    System.out.println("The file is missing from the program's directory: storage.txt");
	}
    }
    
    /*
      Key:
      
      ! Subject name
      | Subject average
      
      ? Subcategory name
      ~ Subcategory weight
      & Subcategory average
      
      . Assignment name
      , Assignment grade
      ' Assignment date
      
    */
    
    public String toWrite(){
	String returnString = "";
	returnString = returnString + "* " + this.getName();
	for(int subjectIndex = 0; subjectIndex < collection.size(); subjectIndex++){
	    returnString = returnString + " ! " + this.getElement(subjectIndex).getName();
	    for(int subcategoryIndex = 0; subcategoryIndex < this.getElement(subjectIndex).size(); subcategoryIndex++){
		returnString = returnString + " ~ " + this.getElement(subjectIndex).getElement(subcategoryIndex).getWeight();
		returnString = returnString + " ? " + this.getElement(subjectIndex).getElement(subcategoryIndex).getName();
		for(int assignmentIndex = 0; assignmentIndex < this.getElement(subjectIndex).getElement(subcategoryIndex).size(); assignmentIndex++){
		    returnString = returnString + " , " + this.getElement(subjectIndex).getElement(subcategoryIndex).getElement(assignmentIndex).getGrade();
		    returnString = returnString + " ' " + this.getElement(subjectIndex).getElement(subcategoryIndex).getElement(assignmentIndex).getDate();
		    returnString = returnString + " . " + this.getElement(subjectIndex).getElement(subcategoryIndex).getElement(assignmentIndex).getName();
		}
	    }
	}
	return returnString;
    }

    public static void clearScreen() {  
	System.out.print("\033[H\033[2J");  //resets cursor to default location
	System.out.flush();  //clears the terminal
   }  
    
    public static void main(String[] args){
	clearScreen();
	SaturnGrades user = new SaturnGrades();

	user.readFile();
	
	if(args.length == 0){
	    System.out.println("Welcome to Saturn Grades!\nPlease enter a keyword followed by the necessary information required.\nEnter help as the keyword for more information.\n\njava SaturnGrades <keyword>\n");
	    System.exit(0);
	}else{
      	    String keyword = args[0];
	    if(keyword.equals("help")){
		System.out.println("This is where help information should go. Will update when everything else is done.\n");
		System.exit(0);
	    }
	    if(keyword.equals("display")){
		if(args.length != 2){
		    System.out.println("Oops! Something went wrong!\nPlease utilize the following format:\n\njava SaturnGrades display <type>\n\nwhere <type> is either entered as 'basic' or 'informed'\ne.g.     java SaturnGrades display informed\n");
		    System.exit(0);
		}
		if(args[1].equals("basic")){
		    user.displayBasic();
		    System.exit(0);
		}
		if(args[1].equals("informed")){
		    user.displayInformed();
		    System.exit(0);
		}
		System.out.println("Oops! Something went wrong!\nPlease utilize the following format:\n\njava SaturnGrades display <type>\n\nwhere <type> is either entered as 'basic' or 'informed'\ne.g.     java SaturnGrades display informed\n");
		System.exit(0);
	    }










	    else{
		System.out.println("Invalid keyword or format. Please check your input again.");
		System.exit(0);
	    }




	       
	}

	user.writeFile();

    }
}

/*
arg 0 possibilities
  subjectName
  subcategoryName
  assignmentName
  addSubject
  removeSubject
  add




-----------------------------------
  arg0 is keyword
if three args, making assignment
  arg1 is variable info grade
  arg2 is variable info name
  arg3 is variable info date


if two args
  arg1 is subcategory name
  arg2 is subcategory weight

if one arg
  arg1 is subject name


 */
