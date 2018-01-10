import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UserInterfaceWorkingOn extends JFrame{ //needs to implement ActionListener
    private static JPanel subjects;
    private static JPanel subcategories;

    /*
      Important things:
      JPanels are crucial for this to work!

      actionPerformed()
      ActionEvent e
      .addActionListener(this)
      e.getActionCommand()
    */
    
    public UserInterfaceWorkingOn(){
	this.setTitle("Saturn Grades");
	this.setSize(1024, 768);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane();

	subjects = new JPanel();
	this.add(subjects);

	JButton math = new JButton("Math");
	subjects.add(math);
	
	subcategories = new JPanel();
	this.add(subcategories);
    }
    
    public static void main(String[] args){
	UserInterfaceWorkingOn window = new UserInterfaceWorkingOn();
	window.setVisible(true);
	subjects.setVisible(true);
    }
}
