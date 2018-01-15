import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import javax.swing.event;
import java.awt.image.BufferedImage;

public class SaturnGradesGUI extends JFrame implements ActionListener{
    private JPanel homePane;
    private JPanel subjectPane;
    private SaturnGrades program;
    private ArrayList<Subject> arr;

    public JPanel getHomePane(){
	return homePane;
    }
    public JPanel getSubjectPane(){
	return subjectPane;
    }
    public SaturnGrades getProgram(){
	return program;
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
    
    public SaturnGradesGUI(SaturnGrades user){
	program=user;
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	//set the title
	setTitle("Saturn Grades");

	setUpHomePane();
	setUpSubjectPane();

	setContentPane(homePane);
	setLocationRelativeTo(null);
	//this.setDefaultLookAndFeelDecorated(true);
	//this.setIconImage(new ImageIcon("https://d30y9cdsu7xlg0.cloudfront.net/png/129365-200.png").getImage());
	setSize(500, 500);
	setVisible(true);
    }

    public void setUpHomePane(){
	homePane = new JPanel(new BorderLayout());

	JLabel SaturnGrades = new JLabel("Saturn Grades");
	SaturnGrades.setOpaque(true);
	SaturnGrades.setBackground(new Color(124, 132,142));
	//SaturnGrades.setPreferredSize(new Dimension(150,50));
	homePane.add(SaturnGrades, BorderLayout.NORTH);

	JButton viewsubs = new JButton("View Subjects");
	viewsubs.setActionCommand("see_subjects");
	viewsubs.addActionListener(this);
	homePane.add(viewsubs, BorderLayout.SOUTH);

	//homePane.setBorder(BorderFactory.createEmptyBorder(100,100,100,100));
	homePane.add(setUpMidPane(), BorderLayout.CENTER);
    }

    public JPanel setUpMidPane(){
	JPanel midPane = new JPanel(new FlowLayout());
	JLabel GPA = new JLabel("GPA: "+program.getAverage());
	GPA.setOpaque(true);
	GPA.setBackground(new Color(124,135,124));
	//GPA.setPreferredSize(new Dimension(150, 50));

	//midPane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
	midPane.add(GPA);

	return midPane;
    }

    public void setUpSubjectPane(){
	//initialize the pane
	subjectPane = new JPanel(new BorderLayout());

	//creating top label
	JLabel subs = new JLabel("My Subjects");
	subjectPane.add(subs, BorderLayout.NORTH);

	//creating middle scrollable pane with subject buttons
	JPanel pane = new JPanel();
	pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
	JScrollPane midSubjectPane = new JScrollPane(pane, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

	//make array of subjects
	arr = program.getCollection();

	//creating new button for each subject
	for(int g=0;g<arr.size();g++){
	    pane.add(createSubButton(arr.get(g)));
	}

	subjectPane.add(midSubjectPane, BorderLayout.CENTER);

	//add a "back" button at the bottom
	JButton viewhome = new JButton("Go back to homepage");
	viewhome.setActionCommand("see_homepage");
	viewhome.addActionListener(this);
	subjectPane.add(viewhome, BorderLayout.SOUTH);
    }

    public JButton createSubButton(Subject subj){
	JButton newthang = new JButton(subj.getName());
	SubjectInterface interact = makeNewSubInterface(subj);
	newthang.addActionListener(new ActionListener(){
		@Override public void actionPerformed(ActionEvent e){
		    mvToSubPanel(interact);
		    revalidate();
		}
	    });
	newthang.setAlignmentX(Component.CENTER_ALIGNMENT);
	return newthang;
    }

    public void actionPerformed(ActionEvent e){
	String command = e.getActionCommand();
	if("see_subjects".equals(command)){
	    this.setContentPane(subjectPane);
	    revalidate();
	}
	if("see_homepage".equals(command)){
	    this.setContentPane(homePane);
	    revalidate();
	}
    }

    public void mvToSubPanel(SubjectInterface pane){
	this.setContentPane(pane);
	revalidate();
    }
    
    public SubjectInterface makeNewSubInterface(Subject sub){
	SubjectInterface pane = new SubjectInterface(this, sub);
	return pane;
    }

    public static void main(String[] args){
	SaturnGrades Meredith = new SaturnGrades();

	Subject Precalc = new Subject("Precalc");
	Meredith.addSubject(Precalc);
	Subject APUSH = new Subject("APUSH");
	Meredith.addSubject(APUSH);

	Subcategory PrecalcTests = new Subcategory("Tests", 80.0);
	Precalc.addSubcategory(PrecalcTests);
	Subcategory PrecalcHW = new Subcategory("HW",10.0);
	Precalc.addSubcategory(PrecalcHW);
	Subcategory PrecalcPart = new Subcategory("Participation",10.0);
	Precalc.addSubcategory(PrecalcPart);
	System.out.println(Precalc.checkSubcategorySum());
	
	PrecalcTests.addAssignment("Test 1", 90.0, "10/15/2017");
	PrecalcTests.addAssignment("Test 2", 98.0, "10/30/2017");
	PrecalcHW.addAssignment("hw 1", 97.0, "11/12/2017");
	PrecalcPart.addAssignment("mp 1", 100.0, "12/22/2017");

	System.out.println(PrecalcPart.getCollection());

       
	SwingUtilities.invokeLater(new Runnable() {
		@Override
		    public void run(){
		    SaturnGradesGUI test = new SaturnGradesGUI(Meredith);
		}
	    });
	
    }
}
