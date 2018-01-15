import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SubjectInterface extends JPanel implements ActionListener{
    private JLabel title;
    private SaturnGradesGUI topLevel;
    private Subject subject;
    private ArrayList<Subcategory> arr;

    public SubjectInterface(SaturnGradesGUI frame, Subject sub){
	topLevel = frame;
	subject = sub;
	title=new JLabel(frame.getTitle()+"-"+subject.getName());
	this.add(title);
	addBackButton();

	//make array of subcategories
	arr = subject.getSubcats();
	
	//creates a new button for each subcategory
	for(int g=0;g<arr.size();g++){
	    this.add(createSubcatButton(arr.get(g)));
	}
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
	this.add(back);
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