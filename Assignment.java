public class Assignment{

    public Assignment(double grade, String name, String date){
	this.grade = grade;
	this.name = name;
	this.date = date;
    }
    
    private double grade = 0.0;
    private String name = "Untitled";
    private String date = "00/00/0000";
    
    public double getGrade(){return grade;}
    public String getName(){return name;}
    public String getDate(){return date;}

    private void setGrade(double updatedGrade){grade = updatedGrade;}
    private void setName(String updatedName){name = updatedName;}
    private void setDate(String updatedDate){date = updatedDate;}
    
}
