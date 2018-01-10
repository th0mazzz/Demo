import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UserInterfaceRef extends JFrame //implements ActionListener
{

    /* there's no way for actionPerformed to access data in main
    public void actionPerformed(ActionEvent e){
	String input = e.getActionCommand();
	System.out.println(input);
	if(input.equals(subject)){
	    seeSubjects.setVisible(false);
	    seeSubcategories.setVisible(true);
	}
	if(input.equals(back)){
	    seeSubjects.setVisible(true);
	    seeSubcategories.setVisible(false);
	}
    }
    */

    public static void main(String[] args){

	JFrame window = new JFrame();
	window.setTitle("Saturn Grades");
	window.setSize(1024, 768);
	window.setDefaultCloseOperation(EXIT_ON_CLOSE);

	window.getContentPane();
	
	JPanel seeSubjects = new JPanel();
	window.add(seeSubjects);

	JPanel seeSubcategories = new JPanel();
	window.add(seeSubcategories);
	
	JButton subject = new JButton("Math");
	seeSubjects.add(subject);

	JButton subcategory = new JButton("Exams");
	seeSubcategories.add(subcategory);

	JButton back = new JButton("to Home");
	seeSubjects.add(back);
	seeSubcategories.add(back);

	window.setVisible(true);
	seeSubjects.setVisible(true);
    }
}
