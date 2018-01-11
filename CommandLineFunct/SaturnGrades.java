import java.util.ArrayList;
public class SaturnGrades{

    private double average = 100.0;
    private ArrayList<Subject> collection; //INITIALIZE
    
    public int size(){
	return collection.size();
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
