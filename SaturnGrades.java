import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
public class SaturnGrades{

    private String name = "Unnamed";
    private double average = 100.0;
    private ArrayList<Subject> collection = new ArrayList<>();
    
    public ArrayList<Subject> getCollection(){
	return collection;
    }

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

    public void addSubject(Subject subj){
	collection.add(subj);
    }
    public void removeSubject(Subject subj){
	collection.remove(subj);
    }

    public double calcAverage(){
	double sumOfSubjects = 0.0;
	for(int index = 0; index < collection.size(); index++){
	    sumOfSubjects = sumOfSubjects + (collection.get(index)).getAverage(); //this getAverage() is printing some weird stuff
	}
	return sumOfSubjects / size();
    }

    public boolean checkIfSubjectPresent(String subjectName){
	for(int index = 0; index < collection.size(); index++){
	    if((this.getElement(index).getName()).equals(subjectName)){
		return true;
	    }
	}
	System.out.println("Subject does not exist.");
	return false;
    }

    public int getSubjectIndex(String subjectName){
	for(int index = 0; index < collection.size(); index++){
	    if((this.getElement(index).getName()).equals(subjectName)){
		return index;
	    }
	}
	System.out.println("Subject does not exist");
	return -1;
    }
    
    public void displayBasic(){
	System.out.println(this.getName() + "\n");
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
		System.out.println("Subcategory: " + this.getElement(subjectIndex).getElement(subcategoryIndex).getName() + " (" + this.getElement(subjectIndex).getElement(subcategoryIndex).getAverage() + "%) (Worth " + this.getElement(subjectIndex).getElement(subcategoryIndex).getWeight() + "% of " + this.getElement(subjectIndex).getName()  + " average)");
		System.out.println("Assignments: " + this.getElement(subjectIndex).getElement(subcategoryIndex));
		for(int assignmentIndex = 0; assignmentIndex < this.getElement(subjectIndex).getElement(subcategoryIndex).size(); assignmentIndex++){
		    System.out.println(this.getElement(subjectIndex).getElement(subcategoryIndex).getElement(assignmentIndex));
		}
		System.out.println("\n");
	    }
	}
    }

    public void quickView(){
	System.out.println("Welcome back " + this.getName() + "! Check the overview of your progress below!\n");
	System.out.println("GPA: " + this.getAverage() + "%");
	for(int subjectIndex = 0; subjectIndex < collection.size(); subjectIndex++){
	    System.out.println(this.getElement(subjectIndex).getAverage() + "% " + this.getElement(subjectIndex).getName());
	}
	System.out.println(""); //prints blank line at end
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
	SaturnGrades user = new SaturnGrades();
	Console console = System.console();

	String[] emptyArray = new String[0];
	
	clearScreen();	
	user.readFile();

	if(user.getName().equals("Unnamed")){
		System.out.println("Welcome to Saturn Grades!\nPlease enter a keyword and follow instructions.\nEnter help as the keyword for a list of keywords.\n\nIt is also recommended that you update your name to replace this welcome screen with a quickview screen.\n");
		System.exit(0);
	}else{
	    user.quickView();
	}
	
	String keyword = console.readLine("Please enter a keyword: ");
	
	if(!keyword.equals("")){;

	    
	    if(keyword.equals("help")){
		clearScreen();
		System.out.println("Saturn Grades Help!\n\n" +
                                   "display - will display information about your classes in a basic or informed manner" +
                                   "\n\n");
		String anything = console.readLine("Press enter to resume to the welcome screen.\n\n");
		user.main(emptyArray);
	    }


	    if(keyword.equals("display")){
		clearScreen();
		String typeOfDisplay = console.readLine("Please enter 'basic' or 'informed' for the type of display: ");
		
		if(typeOfDisplay.equals("basic")){
		    clearScreen();
		    user.displayBasic();
		    String anything = console.readLine("Press enter to resume to the welcome screen.\n\n");
		    user.main(emptyArray);;
		}
		if(typeOfDisplay.equals("informed")){
		    clearScreen();
		    user.displayInformed();
		    String anything = console.readLine("Press enter to resume to the welcome screen.\n\n");
		    user.main(emptyArray);
		}
		clearScreen();
		console.readLine("Please enter 'basic' or 'informed' next time.\nPress enter to resume to the welcome screen.\n\n");
		user.main(emptyArray);
	    }


	    

	    clearScreen();
	    System.out.println("Invalid keyword detected!\n\n");
	    String anything = console.readLine("Press enter to continue.\n\n");
	    user.main(emptyArray);
	    
	}else{

	    clearScreen();
	    System.out.println("No keyword detected!\n\n");
	    String anything = console.readLine("Press enter to continue.\n\n");
	    user.main(emptyArray);

	}


	    
	
	
	
	
	/*if(args.length == 0){
	    if(user.getName().equals("Unnamed")){
		System.out.println("Welcome to Saturn Grades!\nPlease enter a keyword followed by the necessary information required.\nEnter help as the keyword for more information.\n\njava SaturnGrades <keyword>\n\nIt is also recommended that you update your name to replace this welcome screen with a quickview screen the next time\n\njava SaturnGrades\n\nis executed.\n");
		System.exit(0);
	    }
	    else{
		user.quickView();
	    }
	}


	else{
      	    String keyword = args[0];
	    if(keyword.equals("help")){
		System.out.println("Saturn Grades --- Help!\n\nWelcome to the help page! This page contains all command information relating to this program!\n\nGeneral Information:\nEach command in Saturn Grades will begin with: \n\n     java SaturnGrades\n\nSyntax of each command is crucial as the same keyword uses different number of inputs to determine what exactly you wish to accomplish.\nTherefore, it is recommended you read carefully at the list of commands that this program currently has\nand pay particular attention to the structure of each command.\n\n" + "List of Saturn Grade commands:\n\n" + "java SaturnGrades\n(Takes you to the welcome page of the program / quickview page of the program.)\n\n"
				             + "java SaturnGrades help\n(Takes you to the help page.)\n\n"
				             + "java SaturnGrades display <type>\n(Displays information regarding your classes.)\n   <type> can be substituted for basic or informed\n   basic will give a general overview\n   informed will provide a detailed view\n\n"
				             + "java SaturnGrades add <subject name>\n(Adds a subject with the name <subject name>.)\n\n"
				             + "java SaturnGrades add <subject name> <subcategory name>\n(Adds a subcategory with the name <subcategory name> in existing subject <subject name>.)\n\n"
				             + "java SaturnGrades add <subject name> <subcategory name> <assignment name>\n(Adds an assignment with the name <assignment name> in the existing subcategory <subcategory name> in <subject name>.)\n\n"
				             + "java SaturnGrades remove <subject name>\n(Removes existing subject with the name <subject name> and all its contents.)\n\n"
				             + "java SaturnGrades remove <subject name> <subcategory name>\n(Removes existing subcategory <subcategory name> from existing subject <subject name> and all its contents.)\n\n"
				             + "java SaturnGrades remove <subject name> <subcategory name> <assignment name>\n(Removes existing assignment <assignment name> from existing subcategory <subcategory name> in <subject name>.)\n\n"
				             + "java SaturnGrades update name <updated name>\n(Updates the user's name to <updated name>.)\n\n"
				             + "java SaturnGrades update name <subject name> <updated name>\n(Updates the name of existing subject <subject name> to <updated name>.)\n\n"
				             + "java SaturnGrades update name <subject name> <subcategory name> <updated name>\n(Updates the name of existing subcategory <subcategory name> in <subject name> to <updated name>.)\n\n"
				             + "java SaturnGrades update weight <subject name> <subcategory name> <updated weight>\n(Updates the weight of existing subcategory <subcategory name> in <subject name> to <updated weight>.)\n\n"
				             + "java SaturnGrades update name <subject name> <subcategory name> <assignment name> <updated name>\n(Updates the name of an existing assignment in <subcategory name> in <subject name>.)\n\n"
				             + "java SaturnGrades update grade <subject name> <subcategory name> <assignment name> <updated grade>\n(Updates the grade of an existing assignment in <subcategory name> in <subject name>.)\n\n"
				             + "java SaturnGrades update date <subject name> <subcategory name> <assignment name> <updated date>\n(Updates the date of an existing assignment in <subcategory name> in <subject name>.)\n\n");
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
		System.out.println("Oops! Something went wrong!\nPlease utilize the following format:\n\njava SaturnGrades display <type>\n\nwhere <type> is either entered as basic* or informed**.\ne.g.     java SaturnGrades display basic\n         java SaturnGrades display informed\n\n* basic - an overall view of all subjects and subcategories, and assignments\n**informed - a more detailed view of all subjects, subcategories, and assignments\n");
		System.exit(0);
	    }
	    if(keyword.equals("add")){ //java SaturnGrades add <subject name> (args.length = 2)
		                       //java SaturnGrades add <subject name> <subcategory name> <weight> (args.length = 4)
		                       //java SaturnGrades add <subject name> <subcategory> <assignment name> <grade> <date> (args.length = 6)
		if(args.length != 2 && args.length != 4 && args.length != 6){
		    System.out.println("Oops! Something went wrong!\nPlease utilize one of following formats:\n\njava SaturnGrades add <subject name>\n(This one adds a subject.)\n\njava SaturnGrades add <subject name> <subcategory name> <subcategory weight*>\n(This one adds a subcategory with its weight to specified subject.)\n\njava SaturnGrades add <subject name> <subcategory> <assignment name> <grade> <date>\n(This one adds an assignment with its grade and date to specified subcategory in specified subject.)\n\ne.g.     java SaturnGrades Calculus\n         java SaturnGrades Calculus Homeworks 25.0\n         java SaturnGrades Calculus Homeworks Homework#1 100 01/01/2018\n\n*weight - the percentage this subcategory will contribute to the subject's average\n");
		    System.exit(0);
		}else{
		    if(args.length == 2){
			user.addSubject(args[1]);
			System.out.println(args[1] + " was added as a subject.\n");
			user.writeFile();
			System.exit(0);
		    }
		    if(args.length == 4){
			if(user.checkIfSubjectPresent(args[1])){
			    int indexOfSubject = user.getSubjectIndex(args[1]);
			    user.getElement(indexOfSubject).addSubcategory(args[2], Double.parseDouble(args[3]));
			    System.out.println(args[2] + " with weight " + args[3] + " was added as a subcategory in " + args[3] + "\n");
			    user.writeFile();
			    System.exit(0);
			}
			else{
			    System.out.println("Please enter an existing subject to add the subcategory to.\n");
			    System.exit(0);
			}
		    }
		    if(args.length == 6){
			if(user.checkIfSubjectPresent(args[1])){
			    int indexOfSubject = user.getSubjectIndex(args[1]);
			    if(user.getElement(indexOfSubject).checkIfSubcategoryPresent(args[2])){
				int indexOfSubcategory = user.getElement(indexOfSubject).getSubcategoryIndex(args[2]);
				user.getElement(indexOfSubject).getElement(indexOfSubcategory).addAssignment(args[3], Double.parseDouble(args[4]), args[5]);
				System.out.println(args[3] + " with grade " + args[4] + " and date " + args[5] + " was added as an assignment in " + args[2] + " in " + args[1] + "\n");
				user.writeFile();
				System.exit(0);
			    }
			    else{
				System.out.println("Please enter an existing subcategory to add the assignment to.\n");
				System.exit(0);
			    }
			}
			else{
			    System.out.println("Please enter an existing subject to add the assignment to.\n");
			    System.exit(0);
			}
		    }

			
		}
	    }
	    if(keyword.equals("remove")){ //java SaturnGrades remove <subject name> (args.length between 2 inclusive and 4 inclusive)
		                          //java SaturnGrades remove <subject name> <subcategory name>
		                          //java SaturnGrades remove <subject name> <subcategory name> <assignment name>
		if(args.length < 2 || args.length > 4){
		    System.out.println("Oops! Something went wrong!\nPlease utilize one of following formats:\n\njava SaturnGrades remove <subject name>\n(This one removes a subject.)\n\njava SaturnGrades remove <subject name> <subcategory name>\n(This one removes a subcategory from specified subject.)\n\njava SaturnGrades remove <subject name> <subcategory name> <assignment name>\n(This one removes a assignment from specified subcategory in specified subject.)\n\ne.g.     java SaturnGrades Chemistry\n         java SaturnGrades Chemistry Exams\n         java SaturnGrades Chemistry Exams Exam#3\n");
		    System.exit(0);
		}else{
		    if(args.length == 2){
			if(user.checkIfSubjectPresent(args[1])){
				user.removeSubject(args[1]);
				System.out.println(args[1] + " was removed as a subject.");
				user.writeFile();
				System.exit(0);
			}
			else{
			    System.out.println(args[1] + " cannot be removed because it is not an existing subject.\n");
			    System.exit(0);
			}
		    }
		    if(args.length == 3){
			if(user.checkIfSubjectPresent(args[1])){
			    int indexOfSubject = user.getSubjectIndex(args[1]);
			    if(user.getElement(indexOfSubject).checkIfSubcategoryPresent(args[2])){
				int indexOfSubcategory = user.getElement(indexOfSubject).getSubcategoryIndex(args[2]);
				user.getElement(indexOfSubject).removeSubcategory(args[2]);
				System.out.println(args[2] + " was removed as a subcategory from " + args[1] + ".\n");
				user.writeFile();
				System.exit(0);
			    }
       			    else{
				System.out.println(args[2] + " cannot be removed because it is not an existing subcategory in " + args[1] + ".\n");
				System.exit(0);
			    }
			}
			else{
			    System.out.println(args[2] + " cannot be removed because " + args[1] + " does not exist."  + "\n");
			    System.exit(0);
			}
		    }
		    if(args.length == 4){
			if(user.checkIfSubjectPresent(args[1])){
			    int indexOfSubject = user.getSubjectIndex(args[1]);
			    if(user.getElement(indexOfSubject).checkIfSubcategoryPresent(args[2])){
				int indexOfSubcategory = user.getElement(indexOfSubject).getSubcategoryIndex(args[2]);
				if(user.getElement(indexOfSubject).getElement(indexOfSubcategory).checkIfAssignmentPresent(args[3])){
				    int indexOfAssignment = user.getElement(indexOfSubject).getElement(indexOfSubcategory).getAssignmentIndex(args[3]);
				    user.getElement(indexOfSubject).getElement(indexOfSubcategory).removeAssignment(args[3]);
				    System.out.println(args[3] + " was removed as an assignment from " + args[2] + " in " + args[1] + ".\n");
				    user.writeFile();
				    System.exit(0);
      				}
				else{
				    System.out.println(args[3] + " cannot be removed because it is not an existing assignment in " + args[2] + " in " + args[1] + ".\n");
				    System.exit(0);
				}
			    }
			    else{
				System.out.println(args[3] + " cannot be removed because " + args[2]  + " does not exist in " + args[1] + ".\n");
				System.exit(0);
			    }
			}
			else{
			    System.out.println(args[3] + " cannot be removed because "  + args[1] + " does not exist.\n");
			    System.exit(0);
			}
		    }
		}
	    }
	    if(keyword.equals("update")){ //java SaturnGrades update name <updated name> (3 args)
		                          //java SaturnGrades update name <subject> <updated name> (4 args)
		                          //java SaturnGrades update name <subject> <subcategory> <updated name> (5 args)
		                          //java SaturnGrades update weight <subject> <subcategory> <updated weight> (5 args)
		                          //java SaturnGrades update name <subject> <subcategory> <assignment> <updated name> (6 args)
		                          //java SaturnGrades update grade <subject> <subcategory> <assignment> <updated grade> (6 args)
                                          //java SaturnGrades update date <subject> <subcategory> <assignment> <updated date> (6 args)
		if(args.length < 3 || args.length > 6){
		    System.out.println("Oops! Something went wrong!\nPlease utilize one of following formats:\n\njava SaturnGrades update name <updated name>\n(This one updates the name associated with the user.)\n\njava SaturnGrades update name <subject> <updated name>\n(This one updates the name of the subject.)\n\njava SaturnGrades update name <subject> <subcategory> <updated name>\n(This one updates the name of the subcategory in the specified subject.)\n\njava SaturnGrades update weight <subject> <subcategory> <updated weight>\n(This one updates the weight of the subcategory in the specified subject.)\n\njava SaturnGrades update name <subject> <subcategory> <assignment> <updated name>\n(This one updates the name of the assignment in the specified subcategory and subject.)\n\njava SaturnGrades update grade <subject> <subcategory> <assignment> <updated grade>\n(This one updates the grade of the assignment in the specified subcategory and subject.)\n\njava SaturnGrades update date <subject> <subcategory> <assignment> <updated date>\n(This one updates the date of the assignment in the specified subcategory and subject.)\n\ne.g.     java SaturnGrades update name John Doe\n         java SaturnGrades update Math Precalculus\n         java SaturnGrades update Math Quizzes Mini-Tests\n         java SaturnGrades Math Quizzes 10.0\n         java SaturnGrades Math Quizzes Quiz#1 Quiz#2\n         java SaturnGrades Math Quizzes Quiz#1 100.0\n         java SaturnGrades Math Quizzes 01/01/2018 12/12/2019\n");
		    System.exit(0);
		}else{
		    if(args.length == 3 && args[1].equals("name")){ //java SaturnGrades update name <updated name> (3 args)
			String oldName = user.getName();
			user.setName(args[2]);
			System.out.println("User's name changed from " + oldName + " to " + args[2] + ".\n");
			user.writeFile();
			System.exit(0);
		    }
		    if(args.length == 4){ //java SaturnGrades update name <subject> <updated name> (4 args)
			if(args[1].equals("name")){
			    if(user.checkIfSubjectPresent(args[2])){
				int indexOfSubject = user.getSubjectIndex(args[2]);
				String oldName = user.getElement(indexOfSubject).getName();
				user.getElement(indexOfSubject).setName(args[3]);
				System.out.println("Subject's name changed from " + oldName + " to " + args[3] + ".\n");
				user.writeFile();
				System.exit(0);
			    }
			    else{
				System.out.println("No changes occurred as " + args[2] + " was unable to be located.\n");
				System.exit(0);
			    }
			}
			else{
			    System.out.println("Please recheck the format of the input.\n\njava SaturnGrades update name <subject> <updated name>\n");
			    System.exit(0);
			}
		    }
		    if(args.length == 5){ //java SaturnGrades update name <subject> <subcategory> <updated name> (5 args)
			if(args[1].equals("name")){
			    if(user.checkIfSubjectPresent(args[2])){
				int indexOfSubject = user.getSubjectIndex(args[2]);
				if(user.getElement(indexOfSubject).checkIfSubcategoryPresent(args[3])){
				    int indexOfSubcategory = user.getElement(indexOfSubject).getSubcategoryIndex(args[3]);
				    String oldName = user.getElement(indexOfSubject).getElement(indexOfSubcategory).getName();
				    user.getElement(indexOfSubject).getElement(indexOfSubcategory).setName(args[4]);
				    System.out.println("Subcategory's name changed from " + oldName + " to " + args[4] + ".\n");
				    user.writeFile();
				    System.exit(0);
				}
				else{
				    System.out.println("No changes occurred as " + args[3] + " was unable to be located.\n");
				    System.exit(0);
				}
			    }
			    else{
				System.out.println("No changes occurred as " + args[2] + " was unable to be located.\n");
				System.exit(0);
			    }
			}else{ //java SaturnGrades update weight <subject> <subcategory> <updated weight> (5 args)
			    if(args[1].equals("weight")){
				if(user.checkIfSubjectPresent(args[2])){
				    int indexOfSubject = user.getSubjectIndex(args[2]);
				    if(user.getElement(indexOfSubject).checkIfSubcategoryPresent(args[3])){
					int indexOfSubcategory = user.getElement(indexOfSubject).getSubcategoryIndex(args[3]);
					double oldWeight = user.getElement(indexOfSubject).getElement(indexOfSubcategory).getWeight();
					user.getElement(indexOfSubject).getElement(indexOfSubcategory).setWeight(Double.parseDouble(args[4]));
					System.out.println("Subcategory's weight changed from " + oldWeight + " to " + args[4] + ".\n");
					user.writeFile();
					System.exit(0);
				    }
				    else{
					System.out.println("No changes occurred as " + args[3] + " was unable to be located.\n");
					System.exit(0);
				    }
				}
				else{
				    System.out.println("No changes occurred as " + args[2] + " was unable to be located.\n");
				    System.exit(0);
				}
			    }
			    else{
				System.out.println("Please recheck the format of the input.\n\njava SaturnGrades update name <subject> <subcategory> <updated name>\n\nor\n\njava SaturnGrades update weight <subject> <subcategory> <updated weight>\n");
				System.exit(0);
			    }
			}
		    }
		    if(args.length == 6){ //java SaturnGrades update name <subject> <subcategory> <assignment> <updated name> (6 args)
			if(args[1].equals("name")){
			    if(user.checkIfSubjectPresent(args[2])){
				int indexOfSubject = user.getSubjectIndex(args[2]);
				if(user.getElement(indexOfSubject).checkIfSubcategoryPresent(args[3])){
				    int indexOfSubcategory = user.getElement(indexOfSubject).getSubcategoryIndex(args[3]);
				    if(user.getElement(indexOfSubject).getElement(indexOfSubcategory).checkIfAssignmentPresent(args[4])){
					int indexOfAssignment = user.getElement(indexOfSubject).getElement(indexOfSubcategory).getAssignmentIndex(args[4]);
					String oldName = user.getElement(indexOfSubject).getElement(indexOfSubcategory).getElement(indexOfAssignment).getName();
					user.getElement(indexOfSubject).getElement(indexOfSubcategory).getElement(indexOfAssignment).setName(args[5]);
					System.out.println("Assignment's name changed from " + oldName + " to " + args[5] + ".\n");
					user.writeFile();
					System.exit(0);
				    }
				    else{
					System.out.println("No changes occurred as " + args[4] + " was unable to be located.\n");
					System.exit(0);
				    }
				}
				else{
				    System.out.println("No changes occurred as " + args[3] + " was unable to be located.\n");
				    System.exit(0);
				}
			    }
			    else{
				System.out.println("No changes occurred as " + args[2] + " was unable to be located.\n");
				System.exit(0);
			    }
			}else{ //java SaturnGrades update grade <subject> <subcategory> <assignment> <updated grade>
			    if(args[1].equals("grade")){
				if(user.checkIfSubjectPresent(args[2])){
				    int indexOfSubject = user.getSubjectIndex(args[2]);
				    if(user.getElement(indexOfSubject).checkIfSubcategoryPresent(args[3])){
					int indexOfSubcategory = user.getElement(indexOfSubject).getSubcategoryIndex(args[3]);
					if(user.getElement(indexOfSubject).getElement(indexOfSubcategory).checkIfAssignmentPresent(args[4])){
					    int indexOfAssignment = user.getElement(indexOfSubject).getElement(indexOfSubcategory).getAssignmentIndex(args[4]);
					    Double oldGrade = user.getElement(indexOfSubject).getElement(indexOfSubcategory).getElement(indexOfAssignment).getGrade();
					    user.getElement(indexOfSubject).getElement(indexOfSubcategory).getElement(indexOfAssignment).setGrade(Double.parseDouble(args[5]));
					    System.out.println("Assignment's grade changed from " + oldGrade + " to " + args[5] + ".\n");
					    user.writeFile();
					    System.exit(0);
					}
					else{
					    System.out.println("No changes occurred as " + args[4] + " was unable to be located.\n");
					    System.exit(0);
					}
				    }
				    else{
					System.out.println("No changes occurred as " + args[3] + " was unable to be located.\n");
					System.exit(0);
				    }
				}
				else{
				    System.out.println("No changes occurred as " + args[2] + " was unable to be located.\n");
				    System.exit(0);
				}
			    }else{
				if(args[1].equals("date")){
				    if(user.checkIfSubjectPresent(args[2])){
					int indexOfSubject = user.getSubjectIndex(args[2]);
					if(user.getElement(indexOfSubject).checkIfSubcategoryPresent(args[3])){
					    int indexOfSubcategory = user.getElement(indexOfSubject).getSubcategoryIndex(args[3]);
					    if(user.getElement(indexOfSubject).getElement(indexOfSubcategory).checkIfAssignmentPresent(args[4])){
						int indexOfAssignment = user.getElement(indexOfSubject).getElement(indexOfSubcategory).getAssignmentIndex(args[4]);
						String oldDate = user.getElement(indexOfSubject).getElement(indexOfSubcategory).getElement(indexOfAssignment).getDate();
						user.getElement(indexOfSubject).getElement(indexOfSubcategory).getElement(indexOfAssignment).setDate(args[5]);
						System.out.println("Assignment's date changed from " + oldDate + " to " + args[5] + ".\n");
						user.writeFile();
						System.exit(0);
					    }
					    else{
						System.out.println("No changes occurred as " + args[4] + " was unable to be located.\n");
						System.exit(0);
					    }
					}
					else{
					    System.out.println("No changes occurred as " + args[3] + " was unable to be located.\n");
					    System.exit(0);
					}
				    }
				    else{
					System.out.println("No changes occurred as " + args[2] + " was unable to be located.\n");
					System.exit(0);
				    }
				}
				else{
				    System.out.println("Please recheck the format of the input.\n\njava SaturnGrades update name <subject> <subcategory> <assignment> <updated name>\n\nor\n\njava SaturnGrades update grade <subject> <subcategory> <assignment> <updated grade>\n\nor\n\njava SaturnGrades update date <subject> <subcategory> <assignment> <updated date>\n");
				    System.exit(0);
				}
			    }
			}
		    }







		    
		}
	    }

	    else{
		System.out.println("Invalid keyword or format. Please check your input again.");
		System.exit(0);
	    }




	       
	}*/

	

    }
}
