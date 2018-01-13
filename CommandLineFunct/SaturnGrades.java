import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
public class SaturnGrades{

    private double average = 100.0;
    private ArrayList<Subject> collection = new ArrayList<>(); //INITIALIZE
    
    public int size(){
	return collection.size();
    }

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
	    sumOfSubjects = sumOfSubjects + (collection.get(index)).getAverage();
	}
	return sumOfSubjects / size();
    }

    public void displayBasic(){
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

	    while(in.hasNext()){
		String word = in.next();
		//do something
		System.out.println(word);
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

	    efficientWriter.write("Mwahahahah");

	    efficientWriter.close();

	}catch(IOException e){
	    System.out.println("The file is missing from the program's directory: storage.txt");
	}
    }

    public String write(){
	String returnString = "";
	for(int userIndex = 0; userIndex < collection.size(); userIndex++){
	    returnString = returnString + "! " + this.getElement(userIndex).getName();
	}
	return returnString;
    }
    
    public static void main(String[] args){
	
		

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
