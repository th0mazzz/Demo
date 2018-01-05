import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UserInterface extends JFrame{ //needs to implement ActionListener
    private Container pane;

    /*
      Important things:
      actionPerformed()
      ActionEvent e
      .addActionListener(this)
      e.getActionCommand()
    */
    
    public UserInterface(){
	this.setTitle("Saturn Grades");
	this.setSize(1024, 768);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	pane = this.getContentPane();
    }
    
    public static void main(String[] args){
	UserInterface window = new UserInterface();
	window.setVisible(true);
    }
}
