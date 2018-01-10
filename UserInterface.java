import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import javax.swing.event;

public class UserInterface extends JFrame{ //needs to implement ActionListener

    /*
    private Container pane;

      Important things:
      JPanels are crucial for this to work!

      actionPerformed()
      ActionEvent e
      .addActionListener(this)
      e.getActionCommand()
    
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
    */

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("UserInterface");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	//create a menu bar
	JMenuBar aMenuBar = new JMenuBar();
	aMenuBar.setOpaque(true);
	aMenuBar.setBackground(new Color(154, 165, 123));
	aMenuBar.setPreferredSize(new Dimension(200, 20));
	
        //Make the label.
        JLabel aLabel = new JLabel("hello");
	aLabel.setOpaque(true);
	aLabel.setBackground(new Color(124, 132, 142));
	aLabel.setPreferredSize(new Dimension(200, 180));
	
	//add the label to the content pane, set the menu bar
	frame.setJMenuBar(aMenuBar);
	frame.getContentPane().add(aLabel, BorderLayout.CENTER);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
