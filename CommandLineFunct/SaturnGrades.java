import java.util.ArrayList;
public class SaturnGrades{

    private double average;
    private ArrayList<Subject> collection;

    public void addSubject(String name){
	Subject newSubject = new Subject(name);
	collection.add(newSubject);
    }

    //Working on this right now
    public void removeSubject(String name){
	for(int index = 0; index < collection.size(); index++){
	    if((collection.get(index).getName()).equals(name)){
		collection.remove(index);
	    }
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
