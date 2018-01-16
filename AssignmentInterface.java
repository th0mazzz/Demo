import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AssignmentInterface extends JPanel implements ActionListener{
    private SaturnGradesGUI frame;
    private SubcatInterface backpane;
    private Assignment data;
    
    public AssignmentInterface(SaturnGradesGUI frame, SubcatInterface pane, Assignment data){
	setLayout(new BorderLayout());
	this.frame=frame;
	backpane=pane;
	this.data=data;
	JLabel title = new JLabel(data.getName());
	add(title, BorderLayout.NORTH);
	addBackButton();
	setUpMidPane();
    }

    public void setUpMidPane(){
	JPanel midpane = new JPanel();
	midpane.setLayout(new BoxLayout(midpane, BoxLayout.Y_AXIS));

	JLabel grade = new JLabel(data.getGrade()+"");
	midpane.add(grade);
	JLabel date = new JLabel("Date assigned: "+data.getDate());
	midpane.add(date);

	this.add(midpane, BorderLayout.CENTER);
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
	    frame.setContentPane(backpane);
	    revalidate();
	}
    }
}