import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
//import javax.swing.event;

public class UserInterface extends JFrame implements ActionListener{
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
	//this.setDefaultLookAndFeelDecorated(true);
	Image a = getImageIcon();
	this.setIconImage(getImageIcon()); //get icon from some URL
    }

    public static Image getImageIcon(){
	java.net.URL imgURL = UserInterface.class.getResource("https://d30y9cdsu7xlg0.cloudfront.net/png/129365-200.png");
	if(imgURL != null){
	    return new ImageIcon(imgURL).getImage();
	} else{
	    return null;
	}
    }
    
    public void setUpHomePane(){
	homePane = new JPanel(new BorderLayout());

	/*
	JLabel background = new JLabel("");
	background.setOpaque(true);
	background.setPreferredSize(new Dimension(175, 100));
	homePane.add(background, BorderLayout.CENTER);
	*/

	JPanel left  = new JPanel(new BorderLayout());
	JLabel SaturnGrades = new JLabel("Saturn Grades");
	SaturnGrades.setOpaque(true);
	SaturnGrades.setBackground(new Color(124, 132,142));
	SaturnGrades.setPreferredSize(new Dimension(200, 200));
	left.add(SaturnGrades, BorderLayout.CENTER);

	JPanel right = new JPanel(new BorderLayout());
	JLabel UserName = new JLabel("Name: "+user.getName());
	UserName.setOpaque(true);
	UserName.setBackground(new Color(124,135,124));
	UserName.setPreferredSize(new Dimension(200, 200));
	right.add(UserName, BorderLayout.CENTER);

	homePane.add(left, BorderLayout.WEST);
	homePane.add(right, BorderLayout.EAST);
	homePane.add(setUpMidPane(), BorderLayout.CENTER);
    }

    public JPanel setUpMidPane(){
	JButton viewsubs = new JButton("View Subjects");
	viewsubs.setActionCommand(this.setContentPane(homePane));
	viewsubs.addActionListener(this);

	JPanel centerPane = new JPanel(new BorderLayout());
	centerPane.add(viewsubs, BorderLayout.CENTER);

	return centerPane;
    }

    public static void main(String[] args){
	User Meredith = new User("Meredith");
	UserInterface test = new UserInterface(Meredith);
	test.pack();
	test.setVisible(true);
    }
}
