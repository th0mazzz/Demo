import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class SubcatInterface extends JPanel implements ActionListener{
    private SaturnGradesGUI frame;
    private SubjectInterface pane;
    private Subcategory data;
    private ArrayList<Assignment> arr;

    public SubcatInterface(SaturnGradesGUI frame, SubjectInterface pane, Subcategory data){
	setLayout(new BorderLayout());
	this.frame=frame;
	this.pane=pane;
	this.data=data;
	addBackButton();
	
	//initialize array of assignments
	arr = data.getCollection();
	
	//create a new button for each assignment
	for(int i=0;i<arr.size();i++){
	    add(createAssignmentButton(arr.get(i)));
	}
    }

    public JButton createAssignmentButton(Assignment thing){
	JButton newthang = new JButton(thing.getName());
	AssignmentInterface interact = makeNewAssignmentInterface(thing);
	newthang.addActionListener(new ActionListener(){
		@Override public void actionPerformed(ActionEvent e){
		    mvToAssignmentPanel(interact);
		    revalidate();
		}
	    });
	return newthang;
    }

    public AssignmentInterface makeNewAssignmentInterface(Assignment thing){
	AssignmentInterface pane = new AssignmentInterface(frame, this, thing);
	return pane;
    }

    public void mvToAssignmentPanel(AssignmentInterface pane){
	frame.setContentPane(pane);
	revalidate();
    }

    public SaturnGradesGUI getFrame(){
	return frame;
    }
    public SubjectInterface getPane(){
	return pane;
    }
    public Subcategory getData(){
	return data;
    }

    public void setFrame(SaturnGradesGUI newFrame){
	frame=newFrame;
    }
    public void setPane(SubjectInterface newPane){
	pane=newPane;
    }
    public void setData(Subcategory newData){
	data=newData;
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
	    frame.setContentPane(pane);
	    revalidate();
	}
    }
}