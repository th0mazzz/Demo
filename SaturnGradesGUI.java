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
    private ArrayList<JButton> subButtons = new ArrayList<>();

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
	setSize(1000, 700);
	setVisible(true);
    }

    public void setUpHomePane(){
	homePane = new JPanel(new BorderLayout());

	//adding the saturn grades label at the top
	JLabel SaturnGrades = new JLabel("Saturn Grades");
	SaturnGrades.setOpaque(true);
	SaturnGrades.setBackground(new Color(124, 132,142));
	SaturnGrades.setPreferredSize(new Dimension(200,150));
	homePane.add(SaturnGrades, BorderLayout.NORTH);

	//adding the middle pane with GPA reports and navigation tools
	homePane.add(setUpMidPane(), BorderLayout.CENTER);

	//adding the bottom pane with logout, settings, and home navigation
	JPanel bottom = new JPanel(new FlowLayout());
	JLabel comingsoon = new JLabel("Stuff coming soon");
	bottom.add(comingsoon);
	homePane.add(bottom, BorderLayout.SOUTH);
    }

    public JPanel setUpMidPane(){
	JPanel midPane = new JPanel(new BorderLayout());

	//top of pane w/ GPA reports
	JLabel sem = new JLabel("Semester GPA: " +program.getAverage());
	midPane.add(sem, BorderLayout.NORTH);
	
	//middle of pane with navigational buttons
	JButton viewsubs = new JButton("View Subjects");
	viewsubs.setActionCommand("see_subjects");
	viewsubs.addActionListener(this);
	midPane.add(viewsubs, BorderLayout.WEST);

	return midPane;
    }

    public void setUpSubjectPane(){
	JPanel pane = new JPanel();

	//initialize the pane
	subjectPane = new JPanel(new BorderLayout());

	//creating top label & add subject button
	JPanel top = new JPanel(new FlowLayout());
	JLabel subs = new JLabel("My Subjects");
	top.add(subs);
	JLabel add = new JLabel("Add a subject: ");
	top.add(add);
	JTextField addsubs = new JTextField(10);
	JButton addit = new JButton("add");
	addit.addActionListener(new ActionListener(){
		@Override public void actionPerformed(ActionEvent e){
		    Subject a = new Subject(addsubs.getText());
		    arr.add(a);
		    program.addSubject(a,addsubs.getText());
		    program.writeFile();
		    pane.add(createSubButton(a));
		    addsubs.setText("");
		    revalidate();
		    repaint();
		}
	    });
	top.add(addsubs);
	top.add(addit);

	//adding to the top panel a remove button
	JLabel remove = new JLabel("remove");
	top.add(remove);
	JTextField rmsubs = new JTextField(10);
	JButton rmit = new JButton("remove");
	rmit.addActionListener(new ActionListener(){
		@Override public void actionPerformed(ActionEvent e){
		    arr.remove(rmsubs.getText());
		    for(int i=0;i<subButtons.size();i++){
			if(subButtons.get(i).getText().equals(rmsubs.getText())){
			    pane.remove(i);
			    subButtons.remove(i);
			}
		    }
		    program.removeSubject(rmsubs.getText());
		    program.writeFile();
		    rmsubs.setText("");
		    revalidate();
		    repaint();
		}
	    });
	top.add(rmsubs);
	top.add(rmit);

	subjectPane.add(top, BorderLayout.NORTH);

	//creating middle scrollable pane with subject buttons
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
		    repaint();
		}
	    });
	newthang.setAlignmentX(Component.CENTER_ALIGNMENT);
	subButtons.add(newthang);
	return newthang;
    }

    public void actionPerformed(ActionEvent e){
	String command = e.getActionCommand();
	if("see_subjects".equals(command)){
	    this.setContentPane(subjectPane);
	    revalidate();
	    repaint();
	}
	if("see_homepage".equals(command)){
	    this.setContentPane(homePane);
	    revalidate();
	    repaint();
	}	    
    }

    public void mvToSubPanel(SubjectInterface pane){
	this.setContentPane(pane);
	revalidate();
	repaint();
    }
    
    public SubjectInterface makeNewSubInterface(Subject sub){
	SubjectInterface pane = new SubjectInterface(this, sub);
	return pane;
    }

    public static void main(String[] args){
	SaturnGrades Meredith = new SaturnGrades();     
	SwingUtilities.invokeLater(new Runnable() {
		@Override
		    public void run(){
		    SaturnGradesGUI test = new SaturnGradesGUI(Meredith);
		}
	    });
	
    }
}
