import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SubjectInterface extends JPanel implements ActionListener{
    private JLabel title;
    private SaturnGradesGUI topLevel;
    private Subject subject;

    public SubjectInterface(SaturnGradesGUI frame, Subject sub){
	topLevel = frame;
	subject = sub;
	title=new JLabel(frame.getTitle()+"-"+subject.getName());
	this.add(title);
	addBackButton();
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
	}
    }

    public static void main(String[] args){
    }
}