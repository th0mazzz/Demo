import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SubjectInterface extends JPanel implements ActionListener{
    private JLabel title;
    private SaturnGradesGUI topLevel;
    private Subject subject;
    private ArrayList<Subcategory> arr;
    private JScrollPane subcatPane;

    public SubjectInterface(SaturnGradesGUI frame, Subject sub){
	setLayout(new BorderLayout());
	topLevel = frame;
	subject = sub;
	title=new JLabel(frame.getTitle()+"-"+subject.getName());
	this.add(title, BorderLayout.NORTH);
	addBackButton();
	setUpSubcatPane();

    }
    
    public void setUpSubcatPane(){
	JPanel pane = new JPanel();
	pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
	subcatPane = new JScrollPane(pane, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

	//make array of subcategories
	arr = subject.getSubcats();
	
	//creates a new button for each subcategory
	for(int g=0;g<arr.size();g++){
	    pane.add(createSubcatButton(arr.get(g)));
	}
	this.add(subcatPane, BorderLayout.CENTER);
    }

    public JButton createSubcatButton(Subcategory subcat){
	JButton newthang = new JButton(subcat.getName());
	SubcatInterface interact = makeNewSubcatInterface(subcat);
	newthang.addActionListener(new ActionListener(){
		@Override public void actionPerformed(ActionEvent e){
		    mvToSubcatPanel(interact);
		    revalidate();
		}
	    });
	newthang.setAlignmentX(Component.CENTER_ALIGNMENT);
	return newthang;
    }

    public SubcatInterface makeNewSubcatInterface(Subcategory subcat){
	SubcatInterface pane = new SubcatInterface(topLevel, this, subcat);
	return pane;
    }
    
    public void mvToSubcatPanel(SubcatInterface pane){
	topLevel.setContentPane(pane);
	revalidate();
    }

    public JLabel getTitle(){
	return title;
    }
    public SaturnGradesGUI getTopLevel(){
	return topLevel;
    }
    public Subject getSubject(){
	return subject;
    }
    
    public void setTheTitle(JLabel words){
	title=words;
    }
    public void setTopLevel(SaturnGradesGUI frame){
	topLevel = frame;
    }
    public void setSubject(Subject topic){
	subject = topic;
    }
    
    public void addBackButton(){
	JButton back = new JButton("Go Back");
	back.setActionCommand("go_back");
	back.addActionListener(this);
	this.add(back, BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent e){
	String command = e.getActionCommand();
	if("go_back".equals(command)){
	    topLevel.setContentPane(topLevel.getSubjectPane());
	    revalidate();
	}
    }

    public static void main(String[] args){
    }
}