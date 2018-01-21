public class Assignment{

    private double grade = 0.0;
    private String name = "UntitledAssignment";
    private String date = "00/00/0000";
    
    public Assignment(String name, double grade, String date){
	this.grade =  Math.abs(grade);
	this.name = name;
	this.date = date;
    }
    
    public double getGrade(){return grade;}
    public String getName(){return name;}
    public String getDate(){return date;}

    public void setGrade(double updatedGrade){grade = Math.abs(updatedGrade);}
    public void setName(String updatedName){name = updatedName;}
    public void setDate(String updatedDate){date = updatedDate;}

    public String toString(){
	return name + " " + grade + "% " + date;
    }
}
