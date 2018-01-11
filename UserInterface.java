import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import javax.swing.event;

public class UserInterface extends JFrame{ //needs to implement ActionListener
    private JPanel homePane;
    private JPanel subjectPane;
    private User user;
    private String title;

    public UserInterface(User person){
	user=person;
	title=person.getName();
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	//set the title
	this.setTitle(user.getName()+"'s Saturn Grades");

	/*
	  //actually, let's not do a menu for now
	//create and add a menu bar
	JMenuBar theMenu = new JMenuBar();
	theMenu.setOpaque(true);
	theMenu.setBackground(new Color(154, 165, 123));
	theMenu.setPreferredSize(new Dimension(200, 20));
	this.setJMenuBar(theMenu);
	*/

	this.setUpHomePane();
	this.setContentPane(homePane);
    }

    public void setUpHomePane(){
	homePane = new JPanel(new BorderLayout());

	JLabel SaturnGrades = new JLabel("Saturn Grades");
	SaturnGrades.setOpaque(true);
	SaturnGrades.setBackground(new Color(124, 132,142));
	SaturnGrades.setPreferredSize(new Dimension(40, 40));
	homePane.add(SaturnGrades);

	JLabel UserName = new JLabel("Name: "+user.getName());
	UserName.setOpaque(true);
	UserName.setBackground(new Color(124,135,124));
	UserName.setPreferredSize(new Dimension(40, 40));
	homePane.add(UserName);	
    }

    public static void main(String[] args){
	User Meredith = new User("Meredith");
	UserInterface test = new UserInterface(Meredith);
	test.pack();
	test.setVisible(true);
    }
}
