import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import javax.swing.event;
import java.awt.image.BufferedImage;

public class UserInterface extends JFrame implements ActionListener{
    private JPanel homePane;
    private JPanel subjectPane;
    private User user;
    private String title;

    public JPanel getHomePane(){
	return homePane;
    }
    public JPanel getSubjectPane(){
	return subjectPane;
    }
    public User getUser(){
	return user;
    }
    public String getTitle(){
	return title;
    }

    public void setHomePane(JPanel pane){
	homePane = pane;
    }
    public void setSubjectPane(JPanel pane){
	subjectPane = pane;
    }
    public void setUser(User person){
	user = person;
    }
    public void setTheTitle(String smth){
	title=smth;
	this.setTitle(title);
    }
    
    public UserInterface(User person){
	user=person;
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	//set the title
	this.setTheTitle(user.getName()+"'s Saturn Grades");

	this.setUpHomePane();

	this.setLocationRelativeTo(null);
	this.setDefaultLookAndFeelDecorated(true);
	this.setIconImage(new ImageIcon("https://d30y9cdsu7xlg0.cloudfront.net/png/129365-200.png").getImage());
	this.setSize(500,500);
	this.setUpSubjectPane();
    }

    public void setUpHomePane(){
	homePane = new JPanel(new BorderLayout());

	JPanel left = new JPanel();
	JLabel SaturnGrades = new JLabel("Saturn Grades");
	SaturnGrades.setOpaque(true);
	SaturnGrades.setBackground(new Color(124, 132,142));
	SaturnGrades.setPreferredSize(new Dimension(200,200));
	left.add(SaturnGrades);
	homePane.add(left, BorderLayout.WEST);

	JPanel right = new JPanel();
	JLabel UserName = new JLabel("Name: "+user.getName());
	UserName.setOpaque(true);
	UserName.setBackground(new Color(124,135,124));
	UserName.setPreferredSize(new Dimension(200, 200));
	right.add(UserName);
	homePane.add(right, BorderLayout.EAST);

	//homePane.setBorder(BorderFactory.createEmptyBorder(100,100,100,100));
	homePane.add(setUpMidPane());
	this.setContentPane(homePane);
    }

    public JPanel setUpMidPane(){
	JPanel midPane = new JPanel();
	JButton viewsubs = new JButton("View Subjects");
	viewsubs.setActionCommand("see_subjects");
	viewsubs.addActionListener(this);

	midPane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
	midPane.add(viewsubs);

	return midPane;
    }

    public void setUpSubjectPane(){
	subjectPane = new JPanel(new BorderLayout());
	JLabel notSupp = new JLabel("Sorry, not supported now. Come back later!");
	subjectPane.add(notSupp, BorderLayout.NORTH);
	JButton viewhome = new JButton("Go back to homepage");
	viewhome.setActionCommand("see_homepage");
	viewhome.addActionListener(this);

	subjectPane.setBorder(BorderFactory.createEmptyBorder(100,100,100,100));
	subjectPane.add(viewhome, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e){
	String command = e.getActionCommand();
	if("see_subjects".equals(command)){
	    this.setContentPane(subjectPane);
	}
	if("see_homepage".equals(command)){
	    this.setContentPane(homePane);
	}
    }
    public static void main(String[] args){
	User Meredith = new User("Meredith");
	UserInterface test = new UserInterface(Meredith);
	test.pack();
	test.setVisible(true);
    }
}
