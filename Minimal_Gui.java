import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Minimal_Gui extends JFrame{ //needs to implement ActionListener
    private Container pane;

    /*
      Important things:
      actionPerformed()
      ActionEvent e
      .addActionListener(this)
      e.getActionCommand()
    */
    
    public Minimal_Gui(){
	this.setTitle("Saturn Grades");
	this.setSize(1024, 768);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	pane = this.getContentPane();
    }
    
    public static void main(String[] args){
	Minimal_Gui window = new Minimal_Gui();
	window.setVisible(true);
    }
}
