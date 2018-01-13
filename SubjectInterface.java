import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SubjectInterface extends JPanel implements ActionListener{
    private JLabel title;
    private UserInterface topLevel;
    private Subject subject;

    public SubjectInterface(UserInterface frame, Subject sub){
	topLevel = frame;
	subject = sub;
	title=new JLabel(frame.getTitle()+"-"+subject.getName());
	this.add(title);
	addBackButton();
    }
    
    public JLabel getTitle(){
	return title;
    }
    public UserInterface getUserInterface(){
	return topLevel;
    }
    public Subject getSubject(){
	return subject;
    }
    
    public void setTheTitle(JLabel words){
	title=words;
    }
    public void setUserInterface(UserInterface frame){
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
	User Meredith = new User("Meredith");
	UserInterface window = new UserInterface(Meredith);
	Subject Precalc = new Subject("Precalc");
	SubjectInterface test = new SubjectInterface(window, Precalc);
    }
}