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
	if(collection.size() > 0){
	    average = calcAverage();
	    average = (Math.round(average * 10.0)) / 10.0;
	    return average;
	}else{
	    System.out.print("Add some subjects! ");
	    return 100.0;
	}
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

    public void addSubject(Subject subj, String name){
	collection.add(subj);
	subj.setName(name);
    }
    public void removeSubject(Subject subj){
	collection.remove(subj);
    }

    public double calcAverage(){
	double sumOfSubjects = 0.0;
	for(int index = 0; index < collection.size(); index++){
	    sumOfSubjects = sumOfSubjects + (collection.get(index)).getAverage();
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
	if(this.getAverage() < 0){
	    System.out.println("GPA: Unavaliable because your subcategory weights in one of your subjects do not total to 100.0!");
	}else{
	    System.out.println("GPA: " + this.getAverage() + "%");
	}
	for(int subjectIndex = 0; subjectIndex < collection.size(); subjectIndex++){
	    if(this.getElement(subjectIndex).getAverage() < 0){
		System.out.println("*----------" + this.getElement(subjectIndex).getName() + " (Unavaliable because its subcategory weights do not total to 100.0!)----------*");
	    }else{
		System.out.println("*----------" + this.getElement(subjectIndex).getName() + " (" + this.getElement(subjectIndex).getAverage() + "%)----------*");
	    }
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
	if(this.getAverage() < 0){
	    System.out.println("GPA: Unavaliable because your subcategory weights in one of your subjects do not total to 100.0!");
	}else{
	    System.out.println("GPA: " + this.getAverage() + "%");
	}
	for(int subjectIndex = 0; subjectIndex < collection.size(); subjectIndex++){
	    if(this.getElement(subjectIndex).getAverage() < 0){
		System.out.println("N/A% " + this.getElement(subjectIndex).getName() + " (Unavaliable because its subcategory weights do not total to 100.0!)");
	    }else{
		System.out.println(this.getElement(subjectIndex).getAverage() + "% " + this.getElement(subjectIndex).getName());
	    }
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

    public static boolean checkIfWord(String word){
	return !((word.equals("*")) || (word.equals("!")) || (word.equals("~")) || (word.equals("?")) ||
		 (word.equals(",")) || (word.equals("'")) || (word.equals(".")));
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
	    System.out.println("Welcome to Saturn Grades!\nPlease enter a keyword and follow instructions.\nEnter help as the keyword for a list of keywords.\n\nIt is also recommended that you update your name to replace this welcome screen with a quickview screen.\n\n");
	}else{
	    user.quickView();
	}
	
	String keyword = console.readLine("Please enter a keyword: ");
	
	if(!keyword.equals("")){

	    
	    if(keyword.equals("help")){
		clearScreen();
		System.out.println("Saturn Grades Help!\n" +
				   "Note: Be sure to not include extraneous characters, such as spaces when prompted for user input.\n\n" +
				   "---Commands---\n" +
				   "add - will add a subject, subcategory, or assignment\n" +
                                   "display - will display information about your classes in a basic or informed manner\n" +
				   "exit - will exit the program\n" + 
				   "help - will display this page for reference\n" +
				   "remove - will remove a subject, subcategory, or assignment\n" +
				   "update - will change information regarding a subject, subcategory, assignment, or the user's name\n\n" +
				   "---Keyword Inputs within Commands (to be entered when prompted)---\n" +
				   "subject\nsubcategory\nassignment\nname\nweight\ngrade\ndate" +
                                   "\n\n");
		console.readLine("Press enter to resume to the welcome screen.\n\n");
		user.main(emptyArray);
	    }


	    if(keyword.equals("display")){
		clearScreen();
		String typeOfDisplay = console.readLine("Please enter 'basic' or 'informed' for the type of display: ");
		
		if(typeOfDisplay.equals("basic")){
		    clearScreen();
		    user.displayBasic();
		    console.readLine("Press enter to resume to the welcome screen.\n\n");
		    user.main(emptyArray);;
		}
		if(typeOfDisplay.equals("informed")){
		    clearScreen();
		    user.displayInformed();
		    console.readLine("Press enter to resume to the welcome screen.\n\n");
		    user.main(emptyArray);
		}
		clearScreen();
		console.readLine("Please enter 'basic' or 'informed' next time.\n\nPress enter to resume to the welcome screen.\n\n");
		user.main(emptyArray);
	    }



	    if(keyword.equals("add")){
       		clearScreen();
		String whatYouWannaAdd = console.readLine("Enter whether you want to add a subject, subcategory, or assignment: ");

		if(whatYouWannaAdd.toLowerCase().equals("subject")){
		    clearScreen();
		    String subjectName = console.readLine("Note: Only the first word will be saved as the name. For multi-worded subjects, use hyphens.\nPlease enter the name of this new subject: ");
		    if(subjectName.length() != 0){
			clearScreen();
			user.addSubject(subjectName);
			System.out.println(subjectName + " was added as a subject.\n");
			user.writeFile();
			console.readLine("Press enter to resume to the welcome screen.\n\n");
			user.main(emptyArray);
		    }else{
			clearScreen();
			console.readLine("You must enter a name for the subject!\nPress enter to resume to the welcome screen.\n\n");
			user.main(emptyArray);
		    }
		}

		if(whatYouWannaAdd.toLowerCase().equals("subcategory")){
		    clearScreen();
		    String subjectName = console.readLine("Please enter the name of the subject you wish to add this subcategory to: ");
		    clearScreen();
		    
		    if(user.checkIfSubjectPresent(subjectName)){
			int indexOfSubject = user.getSubjectIndex(subjectName);
			String subcategoryName = console.readLine("Note: Only the first word will be saved as the name. For multi-worded subcategories, use hyphens.\nPlease enter the name of this new subcategory: ");

			if(subcategoryName.length() != 0){
			    clearScreen();
			    String subcategoryWeight = console.readLine("Please enter the weight of this new subcategory: ");
			    clearScreen();
			    try{
			    user.getElement(indexOfSubject).addSubcategory(subcategoryName, Double.parseDouble(subcategoryWeight));
			    }catch(NumberFormatException e){
				System.out.println(subcategoryWeight + " is not a viable value for weight!");
				console.readLine("Press enter to resume to the welcome screen.\n\n");
				user.main(emptyArray);
			    }
			    user.writeFile();
			    System.out.println(subcategoryName + " with weight " + Math.abs(Double.parseDouble(subcategoryWeight)) + " was added as a subcategory in " + subjectName + ".\n");
			    console.readLine("Press enter to resume to the welcome screen.\n\n");
			    user.main(emptyArray);
			}else{
			    clearScreen();
			    console.readLine("You must enter a name for the subcategory!\nPress enter to resume to the welcome screen.\n\n");
			    user.main(emptyArray);
			}
		    }
		    else{
			System.out.println(subjectName + " does not exist as a subject.");
			console.readLine("Press enter to resume to the welcome screen.\n\n");
			user.main(emptyArray);
		    }
		}

		if(whatYouWannaAdd.toLowerCase().equals("assignment")){
		    clearScreen();
		    String subjectName = console.readLine("Please enter the name of the subject you wish to add this assignment to: ");
		    clearScreen();
		    
		    if(user.checkIfSubjectPresent(subjectName)){
			int indexOfSubject = user.getSubjectIndex(subjectName);
			String subcategoryName = console.readLine("Please enter the name of the subcategory you wish to add this assigment to: ");
			clearScreen();
			
			if(user.getElement(indexOfSubject).checkIfSubcategoryPresent(subcategoryName)){
			    int indexOfSubcategory = user.getElement(indexOfSubject).getSubcategoryIndex(subcategoryName);
			    String assignmentName = console.readLine("Note: Only the first word will be saved as the name. For multi-worded assignments, use hyphens.\nPlease enter the name of this new assignment: ");
			    if(assignmentName.length() != 0){
				clearScreen();
				String assignmentGradeString = console.readLine("Please enter the grade of the assignment you wish to add: ");
				double assignmentGradeCopy = 0.0;
				try{
				    double assignmentGrade = Double.parseDouble(assignmentGradeString);
				    assignmentGradeCopy = assignmentGrade;
				}catch(NumberFormatException e){
				    clearScreen();
				    System.out.println(assignmentGradeString + " is not a viable value for grade!");
				    console.readLine("Press enter to resume to the welcome screen.\n\n");
				    user.main(emptyArray);
				}
				clearScreen();
				String assignmentDate = console.readLine("Note: Only the first word will be saved as the date. For multi-worded dates, use hyphens.\nPlease enter the date of the assignment you wish to add: ");
				clearScreen();
				if(assignmentDate.length() != 0){
				    user.getElement(indexOfSubject).getElement(indexOfSubcategory).addAssignment(assignmentName, assignmentGradeCopy, assignmentDate);
				    user.writeFile();
				    System.out.println(assignmentName + " with grade " + Math.abs(assignmentGradeCopy) + " and date " + assignmentDate + " was added as an assignment in subcategory " +
						       subcategoryName + " in " + subjectName + ".\n");
				    console.readLine("Press enter to resume to the welcome screen.\n\n");
				    user.main(emptyArray);
				}else{
				    clearScreen();
				    console.readLine("You must enter a date for the assignment!\nPress enter to resume to the welcome screen.\n\n");
				    user.main(emptyArray);
				}
			    }else{
				clearScreen();
				console.readLine("You must enter a name for the assignment!\nPress enter to resume to the welcome screen.\n\n");
				user.main(emptyArray);
			    }
			}
			else{
			    System.out.println(subcategoryName + " does not exist as a subcategory in subjectName.");
			    console.readLine("Press enter to resume to the welcome screen.\n\n");
			    user.main(emptyArray);
			}
		    }
		    else{
			System.out.println(subjectName + " does not exist as a subject.");
			console.readLine("Press enter to resume to the welcome screen.\n\n");
			user.main(emptyArray);
		    }
		}
	    }

	    if(keyword.equals("remove")){
		clearScreen();
		String whatYouWannaRemove = console.readLine("Please enter whether you want to remove a subject, subcategory, or assignment: ");
		clearScreen();
		
		if(whatYouWannaRemove.toLowerCase().equals("subject")){
		    String subjectName = console.readLine("Please enter the name of the subject to be removed: ");
		    clearScreen();
		    
		    if(user.checkIfSubjectPresent(subjectName)){
			user.removeSubject(subjectName);
			user.writeFile();
			System.out.println(subjectName + " was removed as a subject.\n");
			console.readLine("Press enter to resume to the welcome screen.\n\n");
			user.main(emptyArray);
		    }
		    else{
			System.out.println(subjectName + " cannot be removed because it does not exist as a subject.");
			console.readLine("Press enter to resume to the welcome screen.\n\n");
			user.main(emptyArray);
		    }
		}

		if(whatYouWannaRemove.toLowerCase().equals("subcategory")){
		    clearScreen();
		    String subjectName = console.readLine("Please enter the name of the subject you wish to remove a subcategory from: ");
		    String subcategoryNameRef = "";
		    clearScreen();
		    
		    if(user.checkIfSubjectPresent(subjectName)){
			int indexOfSubject = user.getSubjectIndex(subjectName);
			String subcategoryName = console.readLine("Please enter the name of the subcategory you wish to remove: ");
			subcategoryNameRef = subcategoryName;
			if(user.getElement(indexOfSubject).checkIfSubcategoryPresent(subcategoryName)){
			    int indexOfSubcategory = user.getElement(indexOfSubject).getSubcategoryIndex(subcategoryName);
			    user.getElement(indexOfSubject).removeSubcategory(subcategoryName);
			    user.writeFile();
			    System.out.println(subcategoryName + " was removed as a subcategory from " + subjectName + ".\n");
			    console.readLine("Press enter to resume to the welcome screen.\n\n");
			    user.main(emptyArray);
			}
			else{
			    System.out.println(subcategoryName + " cannot be removed because it is not an existing subcategory in " + subjectName + ".\n");
			    console.readLine("Press enter to resume to the welcome screen.\n\n");
			    user.main(emptyArray);
			}
		    }
		    else{
			System.out.println("Subcategory cannot be removed because " + subjectName + " does not exist."  + "\n");
			console.readLine("Press enter to resume to the welcome screen.\n\n");
			user.main(emptyArray);
		    }
		}

		if(whatYouWannaRemove.toLowerCase().equals("assignment")){
		    clearScreen();
		    String subjectName = console.readLine("Please enter the name of the subject you wish to remove an assignment from: ");
		    String subcategoryNameRef = "";
		    String assignmentNameRef = "";
		    clearScreen();
		    
		    if(user.checkIfSubjectPresent(subjectName)){
			int indexOfSubject = user.getSubjectIndex(subjectName);
			String subcategoryName = console.readLine("Please enter the name of the subcategory you wish to remove an assignment from: ");
			subcategoryNameRef = subcategoryName;
			clearScreen();
			    
			if(user.getElement(indexOfSubject).checkIfSubcategoryPresent(subcategoryName)){
			    int indexOfSubcategory = user.getElement(indexOfSubject).getSubcategoryIndex(subcategoryName);
			    String assignmentName = console.readLine("Please enter the name of the assignment you wish to remove: ");
			    assignmentNameRef = assignmentName;
			    clearScreen();
				
			    if(user.getElement(indexOfSubject).getElement(indexOfSubcategory).checkIfAssignmentPresent(assignmentName)){
				int indexOfAssignment = user.getElement(indexOfSubject).getElement(indexOfSubcategory).getAssignmentIndex(assignmentName);
				user.getElement(indexOfSubject).getElement(indexOfSubcategory).removeAssignment(assignmentName);
				user.writeFile();
				System.out.println(assignmentName  + " was removed as an assignment from " + subcategoryName + " in " + subjectName + ".\n");
				console.readLine("Press enter to resume to the welcome screen.\n\n");
				user.main(emptyArray);
			    }
			    else{
				System.out.println(assignmentNameRef + " cannot be removed because it is not an existing assignment in " + subcategoryNameRef + " in " + subjectName + ".\n");
				console.readLine("Press enter to resume to the welcome screen.\n\n");
				user.main(emptyArray);
			    }
			}
			else{
			    System.out.println("Assignment cannot be removed because " + subcategoryNameRef  + " does not exist in " + subjectName + ".\n");
			    console.readLine("Press enter to resume to the welcome screen.\n\n");
			    user.main(emptyArray);
			}
		    }
		    else{
			System.out.println("Assignment cannot be removed because "  + subjectName + " does not exist.\n");
			console.readLine("Press enter to resume to the welcome screen.\n\n");
			user.main(emptyArray);
		    }
		}      
	    }

	    if(keyword.equals("update")){
		clearScreen();
		String whatYouWannaUpdate = console.readLine("Please enter whether you wish to update a subject, subcategory, assignment, or your name: ");
		clearScreen();

		if(whatYouWannaUpdate.toLowerCase().equals("name")){
		    String updatedName = console.readLine("Note: Only the first word will be saved as the name. For multi-worded names, use hyphens.\nPlease enter what you wish to update your name to: ");
		    if(updatedName.length() != 0){
			clearScreen();
			String oldName = user.getName();
			user.setName(updatedName);
			user.writeFile();
			System.out.println("User's name changed from " + oldName + " to " + updatedName + ".\n");
			console.readLine("Press enter to resume to the welcome screen.\n\n");
			user.main(emptyArray);
		    }else{
			clearScreen();
			console.readLine("You must enter a name!\nPress enter to resume to the welcome screen.\n\n");
			user.main(emptyArray);
		    }
		}
		
		if(whatYouWannaUpdate.toLowerCase().equals("subject")){
		    String partYouWannaUpdate = console.readLine("You may only update a subject's name.\nPress enter to continue.\n\n");
		    clearScreen();
		    String subjectName = console.readLine("Please enter the name of the subject whose name you wish to update: ");
		    
		    if(user.checkIfSubjectPresent(subjectName)){
			clearScreen();
			int indexOfSubject = user.getSubjectIndex(subjectName);
			String oldName = user.getElement(indexOfSubject).getName();
			clearScreen();
			String updatedName = console.readLine("Note: Only the first word will be saved as the name. For multi-worded subjects, use hyphens.\nPlease enter the updated name for this subject: ");
			if(updatedName.length() != 0){
			    clearScreen();
			    user.getElement(indexOfSubject).setName(updatedName);
			    user.writeFile();
			    System.out.println("Subject's name changed from " + oldName + " to " + updatedName + ".\n");
			    console.readLine("Press enter to resume to the welcome screen.\n\n");
			    user.main(emptyArray);
			}else{
			    clearScreen();
			    console.readLine("You must enter a name for the subject!\nPress enter to resume to the welcome screen.\n\n");
			    user.main(emptyArray);
			}
		    }
		    else{
			clearScreen();
			System.out.println("No changes occurred as " + subjectName + " was unable to be located.\n");
			console.readLine("Press enter to resume to the welcome screen.\n\n");
			user.main(emptyArray);
		    }
		}

		if(whatYouWannaUpdate.toLowerCase().equals("subcategory")){
		    clearScreen();
		    String partYouWannaUpdate = console.readLine("Please enter whether you wish to update a subcategory's name or weight: ");
		    clearScreen();
		    
		    if(partYouWannaUpdate.equals("name")){
			String subjectName = console.readLine("Please enter the subject where this subcategory exists in: ");
			clearScreen();
			
			if(user.checkIfSubjectPresent(subjectName)){
			    int indexOfSubject = user.getSubjectIndex(subjectName);
			    String subcategoryName = console.readLine("Please enter the name of the subcategory whose name you wish to update: ");
			    clearScreen();
				
			    if(user.getElement(indexOfSubject).checkIfSubcategoryPresent(subcategoryName)){
				int indexOfSubcategory = user.getElement(indexOfSubject).getSubcategoryIndex(subcategoryName);
				String oldName = user.getElement(indexOfSubject).getElement(indexOfSubcategory).getName();
				String updatedName = console.readLine("Note: Only the first word will be saved as the name. For multi-worded subcategories, use hyphens.\nPlease enter the updated name of this subcategory: ");

				if(updatedName.length() != 0){
				    clearScreen();
				    user.getElement(indexOfSubject).getElement(indexOfSubcategory).setName(updatedName);
				    user.writeFile();
				    clearScreen();
				    System.out.println("Subcategory's name changed from " + oldName + " to " + updatedName + ".\n");
				    console.readLine("Press enter to resume to the welcome screen.\n\n");
				    user.main(emptyArray);
				}else{
				    clearScreen();
				    console.readLine("You must enter a name for the subcategory!\nPress enter to resume to the welcome screen.\n\n");
				    user.main(emptyArray);
				}
			    }
			    else{
				System.out.println("No changes occurred as " + subcategoryName + " was unable to be located.\n");
				console.readLine("Press enter to resume to the welcome screen.\n\n");
				user.main(emptyArray);
			    }
			}else{
			    System.out.println("No changes occurred as " + subjectName + " was unable to be located.\n");
			    console.readLine("Press enter to resume to the welcome screen.\n\n");
			    user.main(emptyArray);
			}
		    }

		    if(partYouWannaUpdate.equals("weight")){
			String subjectName = console.readLine("Please enter the subject where this subcategory exists in: ");
			clearScreen();
			
			if(user.checkIfSubjectPresent(subjectName)){
			    int indexOfSubject = user.getSubjectIndex(subjectName);
			    String subcategoryName = console.readLine("Please enter the name of the subcategory whose weight you wish to update: ");
			    clearScreen();
				
			    if(user.getElement(indexOfSubject).checkIfSubcategoryPresent(subcategoryName)){
				int indexOfSubcategory = user.getElement(indexOfSubject).getSubcategoryIndex(subcategoryName);
				double oldWeight = user.getElement(indexOfSubject).getElement(indexOfSubcategory).getWeight();
				String updatedWeight = console.readLine("Please enter the updated weight of this subcategory: ");
				double updatedWeightCopy = 0.0; //so I can access the double from outside try/catch 
				try{
				    double updatedWeightDouble = Double.parseDouble(updatedWeight); //so we can see if it will convert to double
				    updatedWeightCopy = updatedWeightDouble;
				}catch(NumberFormatException e){
				    clearScreen();
				    System.out.println(updatedWeight + " is not a viable value for weight!\n");
				    console.readLine("Press enter to resume to the welcome screen.\n\n");
				    user.main(emptyArray);
				}
				clearScreen();
				user.getElement(indexOfSubject).getElement(indexOfSubcategory).setWeight(updatedWeightCopy);
				user.writeFile();
				clearScreen();
				System.out.println("Subcategory's weight changed from " + oldWeight + " to " + Math.abs(updatedWeightCopy) + ".\n");
				console.readLine("Press enter to resume to the welcome screen.\n\n");
				user.main(emptyArray);
			    }
			    else{
				System.out.println("No changes occurred as " + subcategoryName + " was unable to be located.\n");
				console.readLine("Press enter to resume to the welcome screen.\n\n");
				user.main(emptyArray);
			    }
			}else{
			    System.out.println("No changes occurred as " + subjectName + " was unable to be located.\n");
			    console.readLine("Press enter to resume to the welcome screen.\n\n");
			    user.main(emptyArray);
			}
		    }
		}

		if(whatYouWannaUpdate.toLowerCase().equals("assignment")){
		    clearScreen();
		    String partYouWannaUpdate = console.readLine("Please enter whether you wish to update an assignment's name, grade, or date: ");
		    clearScreen();

		    if(partYouWannaUpdate.toLowerCase().equals("name")){
			String subjectName = console.readLine("Please enter the name of subject that contains the assignment whose name you wish to update: ");
			clearScreen();
			
			if(user.checkIfSubjectPresent(subjectName)){
			    int indexOfSubject = user.getSubjectIndex(subjectName);
			    String subcategoryName = console.readLine("Please enter the name of the subcategory that contains the assignment whose name you wish to update: ");
			    clearScreen();
			    			    
			    if(user.getElement(indexOfSubject).checkIfSubcategoryPresent(subcategoryName)){
				int indexOfSubcategory = user.getElement(indexOfSubject).getSubcategoryIndex(subcategoryName);
				String assignmentName = console.readLine("Please enter the name of the assignment whose name you wish to update: ");
				clearScreen();
				
				if(user.getElement(indexOfSubject).getElement(indexOfSubcategory).checkIfAssignmentPresent(assignmentName)){
				    int indexOfAssignment = user.getElement(indexOfSubject).getElement(indexOfSubcategory).getAssignmentIndex(assignmentName);
				    String oldName = assignmentName;
				    String updatedName = console.readLine("Note: Only the first word will be saved as the name. For multi-worded assignments, use hyphens.\nPlease enter the new name of this assignment: ");

				    if(updatedName.length() != 0){
					clearScreen();
					user.getElement(indexOfSubject).getElement(indexOfSubcategory).getElement(indexOfAssignment).setName(updatedName);
					user.writeFile();
					System.out.println("Assignment's name changed from " + oldName + " to " + updatedName + ".\n");
					console.readLine("Press enter to resume to the welcome screen.\n\n");
					user.main(emptyArray);
				    }else{
					clearScreen();
					console.readLine("You must enter a name for the assignment!\nPress enter to resume to the welcome screen.\n\n");
					user.main(emptyArray);
				    }
      				}
				else{
				    System.out.println("No changes occurred as " + assignmentName + " was unable to be located.\n");
				    console.readLine("Press enter to resume to the welcome screen.\n\n");
				    user.main(emptyArray);
				}
			    }
			    else{
				System.out.println("No changes occurred as " + subcategoryName + " was unable to be located.\n");
				console.readLine("Press enter to resume to the welcome screen.\n\n");
				user.main(emptyArray);
			    }
			}
			else{
			    System.out.println("No changes occurred as " + subjectName + " was unable to be located.\n");
			    console.readLine("Press enter to resume to the welcome screen.\n\n");
			    user.main(emptyArray);
			}
		    }

		    if(partYouWannaUpdate.toLowerCase().equals("grade")){
			String subjectName = console.readLine("Please enter the name of subject that contains the assignment whose grade you wish to update: ");
			clearScreen();
			
			if(user.checkIfSubjectPresent(subjectName)){
			    int indexOfSubject = user.getSubjectIndex(subjectName);
			    String subcategoryName = console.readLine("Please enter the name of the subcategory that contains the assignment whose grade you wish to update: ");
			    clearScreen();
			    			    
			    if(user.getElement(indexOfSubject).checkIfSubcategoryPresent(subcategoryName)){
				int indexOfSubcategory = user.getElement(indexOfSubject).getSubcategoryIndex(subcategoryName);
				String assignmentName = console.readLine("Please enter the name of the assignment whose grade you wish to update: ");
				clearScreen();
				
				if(user.getElement(indexOfSubject).getElement(indexOfSubcategory).checkIfAssignmentPresent(assignmentName)){
				    int indexOfAssignment = user.getElement(indexOfSubject).getElement(indexOfSubcategory).getAssignmentIndex(assignmentName);
				    double oldGrade = user.getElement(indexOfSubject).getElement(indexOfSubcategory).getElement(indexOfAssignment).getGrade();
				    String updatedGrade = console.readLine("Please enter the new grade of this assignment: ");
				    double updatedGradeCopy = 0.0; //to access the updatedGrade value outside try/catch
				    try{
					double updatedGradeDouble = Double.parseDouble(updatedGrade);
					updatedGradeCopy = updatedGradeDouble;
				    }catch(NumberFormatException e){
					clearScreen();
					System.out.println(updatedGrade + " is not a viable value for grade!\n");
					console.readLine("Press enter to resume to the welcome screen.\n\n");
					user.main(emptyArray);
				    }
				    clearScreen();
				    user.getElement(indexOfSubject).getElement(indexOfSubcategory).getElement(indexOfAssignment).setGrade(updatedGradeCopy);
				    user.writeFile();
				    System.out.println("Assignment's grade changed from " + oldGrade + " to " + Math.abs(updatedGradeCopy) + ".\n");
				    console.readLine("Press enter to resume to the welcome screen.\n\n");
				    user.main(emptyArray);
      				}
				else{
				    System.out.println("No changes occurred as " + assignmentName + " was unable to be located.\n");
				    console.readLine("Press enter to resume to the welcome screen.\n\n");
				    user.main(emptyArray);
				}
			    }
			    else{
				System.out.println("No changes occurred as " + subcategoryName + " was unable to be located.\n");
				console.readLine("Press enter to resume to the welcome screen.\n\n");
				user.main(emptyArray);
			    }
			}
			else{
			    System.out.println("No changes occurred as " + subjectName + " was unable to be located.\n");
			    console.readLine("Press enter to resume to the welcome screen.\n\n");
			    user.main(emptyArray);
			}

		    }

		    if(partYouWannaUpdate.toLowerCase().equals("date")){
			String subjectName = console.readLine("Please enter the name of subject that contains the assignment whose date you wish to update: ");
			clearScreen();
			
			if(user.checkIfSubjectPresent(subjectName)){
			    int indexOfSubject = user.getSubjectIndex(subjectName);
			    String subcategoryName = console.readLine("Please enter the name of the subcategory that contains the assignment whose date you wish to update: ");
			    clearScreen();
			    			    
			    if(user.getElement(indexOfSubject).checkIfSubcategoryPresent(subcategoryName)){
				int indexOfSubcategory = user.getElement(indexOfSubject).getSubcategoryIndex(subcategoryName);
				String assignmentName = console.readLine("Please enter the name of the assignment whose date you wish to update: ");
				clearScreen();
				
				if(user.getElement(indexOfSubject).getElement(indexOfSubcategory).checkIfAssignmentPresent(assignmentName)){
				    int indexOfAssignment = user.getElement(indexOfSubject).getElement(indexOfSubcategory).getAssignmentIndex(assignmentName);
				    String oldDate = user.getElement(indexOfSubject).getElement(indexOfSubcategory).getElement(indexOfAssignment).getDate();
				    String updatedDate = console.readLine("Note: Only the first word will be saved as the date. For multi-worded dates, use hyphens.\nPlease enter the new date of this assignment: ");

				    if(updatedDate.length() != 0){
					clearScreen();
					user.getElement(indexOfSubject).getElement(indexOfSubcategory).getElement(indexOfAssignment).setDate(updatedDate);
					user.writeFile();
					System.out.println("Assignment's date changed from " + oldDate + " to " + updatedDate + ".\n");
					console.readLine("Press enter to resume to the welcome screen.\n\n");
					user.main(emptyArray);
				    }else{
					clearScreen();
					console.readLine("You must enter a date for the assignment!\nPress enter to resume to the welcome screen.\n\n");
					user.main(emptyArray);
				    }
      				}
				else{
				    System.out.println("No changes occurred as " + assignmentName + " was unable to be located.\n");
				    console.readLine("Press enter to resume to the welcome screen.\n\n");
				    user.main(emptyArray);
				}
			    }
			    else{
				System.out.println("No changes occurred as " + subcategoryName + " was unable to be located.\n");
				console.readLine("Press enter to resume to the welcome screen.\n\n");
				user.main(emptyArray);
			    }
			}
			else{
			    System.out.println("No changes occurred as " + subjectName + " was unable to be located.\n");
			    console.readLine("Press enter to resume to the welcome screen.\n\n");
			    user.main(emptyArray);
			}
		    }	    
		}	    
	    }

	    if(keyword.equals("exit")){
		user.writeFile(); //just in case
		System.out.println("You have exited Saturn Grades! Come back with good news!\n\n");
		System.exit(0);
	    }
	    
	    clearScreen();
	    System.out.println("Invalid keyword detected!\nBe sure to not include extraneous characters (including spaces) when prompted for user input.\n\n");
	    String anything = console.readLine("Press enter to resume to the welcome screen.\n\n");
	    user.main(emptyArray);
	    
	}else{

	    clearScreen();
	    System.out.println("No keyword detected!\n\n");
	    String anything = console.readLine("Press enter to resume to the welcome screen.\n\n");
	    user.main(emptyArray);

	}
    }
}

