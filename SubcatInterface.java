import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SubcatInterface extends JPanel implements ActionListener{
    private SaturnGradesGUI frame;
    private SubjectInterface pane;
    private Subcategory data;

    public SubcatInterface(SaturnGradesGUI frame, SubjectInterface pane, Subcategory data){
	setLayout(new BorderLayout());
	this.frame=frame;
	this.pane=pane;
	this.data=data;
	addBackButton();
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
	}
    }
}