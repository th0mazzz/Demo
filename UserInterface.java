import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import javax.swing.event;
import java.awt.image.BufferedImage;

public class SaturnGradesGUI extends JFrame implements ActionListener{
    private JPanel homePane;
    private JPanel subjectPane;
    private SaturnGrades program;
    private String title;

    public JPanel getHomePane(){
	return homePane;
    }
    public JPanel getSubjectPane(){
	return subjectPane;
    }
    public SaturnGrades getProgram(){
	return program;
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
    public void setProgram(SaturnGrades sg){
	program = sg;
    }
    public void setTheTitle(String smth){
	title=smth;
	this.setTitle(title);
    }
    
    public SaturnGradesGUI(SaturnGrades user){
	program=user;
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	//set the title
	this.setTheTitle("Saturn Grades");

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
	JLabel GPA = new JLabel(""+program.getAverage());
	GPA.setOpaque(true);
	GPA.setBackground(new Color(124,135,124));
	GPA.setPreferredSize(new Dimension(200, 200));
	right.add(GPA);
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
	//initialize the pane
	subjectPane = new JPanel();
	//JLabel notSupp = new JLabel("Sorry, not supported now. Come back later!");	subjectPane.add(notSupp, BorderLayout.NORTH);

	//add a "back" button
	JButton viewhome = new JButton("Go back to homepage");
	viewhome.setActionCommand("see_homepage");
	viewhome.addActionListener(this);

	//adds cushioning around the back button for a better look
	subjectPane.setBorder(BorderFactory.createEmptyBorder(100,100,100,100));
	subjectPane.add(viewhome);

	//make array of subjects
	Subject[] arr = new Subject[program.size()];
	for(int i=0;i<program.size();i++){
	    arr[i]=program.getElement(i);
	}

	//creating new button for each subject
	for(int g=0;g<arr.length;g++){
	    // JButton newButton = createSubButton(arr[g]);
	    subjectPane.add(createSubButton(arr[g]));
	}
    }

    public JButton createSubButton(Subject subj){
	JButton newthang = new JButton(subj.getName());
	SubjectInterface interact = makeNewSubInterface(subj);
	newthang.addActionListener(new ActionListener(){
		@Override public void actionPerformed(ActionEvent e){
		    mvToSubPanel(interact);
		}
	    });
	return newthang;
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

    public void mvToSubPanel(SubjectInterface pane){
	this.setContentPane(pane);
    }
    
    public SubjectInterface makeNewSubInterface(Subject sub){
	SubjectInterface pane = new SubjectInterface(this, sub);
	return pane;
    }

    public static void main(String[] args){
	SaturnGrades Meredith = new SaturnGrades();
	Subject Precalc = new Subject("Precalc");
	Subject APUSH = new Subject("APUSH");

	Meredith.addSubject(Precalc);
	Meredith.addSubject(APUSH);

	SaturnGradesGUI test = new SaturnGradesGUI(Meredith);
	test.pack();
	test.setVisible(true);
    }
}
