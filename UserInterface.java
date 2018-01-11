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
	this.setLocationRelativeTo(null);
	this.setDefaultLookAndFeelDecorated(true);
	this.setIconImage(new ImageIcon("https://d30y9cdsu7xlg0.cloudfront.net/png/129365-200.png").getImage());
    }

    public void setUpHomePane(){
	homePane = new JPanel(new BorderLayout());

	/*
	JLabel background = new JLabel("");
	background.setOpaque(true);
	background.setPreferredSize(new Dimension(175, 100));
	homePane.add(background, BorderLayout.CENTER);
	*/

	JLabel SaturnGrades = new JLabel("Saturn Grades");
	SaturnGrades.setOpaque(true);
	SaturnGrades.setBackground(new Color(124, 132,142));
	SaturnGrades.setPreferredSize(new Dimension(200, 200));
	homePane.add(SaturnGrades, BorderLayout.CENTER);

	JLabel UserName = new JLabel("Name: "+user.getName());
	UserName.setOpaque(true);
	UserName.setBackground(new Color(124,135,124));
	UserName.setPreferredSize(new Dimension(200, 200));
	homePane.add(UserName, BorderLayout.PAGE_END);	
    }

    public static void main(String[] args){
	User Meredith = new User("Meredith");
	UserInterface test = new UserInterface(Meredith);
	test.pack();
	test.setVisible(true);
    }
}
