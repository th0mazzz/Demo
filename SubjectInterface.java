import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SubjectInterface extends JPanel implements ActionListener{
    private JPanel top;
    private SaturnGradesGUI topLevel;
    private Subject subject;
    private ArrayList<Subcategory> arr;
    private JScrollPane subcatPane;
    private ArrayList<JButton> subcatBs = new ArrayList<>();

    public SubjectInterface(SaturnGradesGUI frame, Subject sub){
	setLayout(new BorderLayout());
	topLevel = frame;
	subject = sub;
	top = new JPanel(new FlowLayout());
	JLabel title=new JLabel(frame.getTitle()+"-"+subject.getName());
	top.add(title);
	this.add(top, BorderLayout.NORTH);
	addBackButton();
	setUpSubcatPane();

    }
    
    public void setUpSubcatPane(){
	JPanel pane = new JPanel();
	pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
	subcatPane = new JScrollPane(pane, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

	//makes adding subcategory functionality
	JLabel add = new JLabel("Add a subcategory (name, weight): ");
	top.add(add);
	JTextField subcatname = new JTextField(10);
	JTextField subcatweight = new JTextField(10);
	JButton addit = new JButton("add");
	addit.addActionListener(new ActionListener(){
		@Override public void actionPerformed(ActionEvent e){
		    pane.add(createSubcatButton(new Subcategory(subcatname.getText(),Double.parseDouble(subcatweight.getText()))));
		    subcatname.setText("");
		    subcatweight.setText("");
		    revalidate();
		    repaint();
		}
	    });
	top.add(subcatname);
	top.add(subcatweight);
	top.add(addit);

	//makes remove subcategory functionality
	JLabel remove = new JLabel("remove");
	top.add(remove);
	JTextField rm = new JTextField(10);
	JButton rmstuff = new JButton("remove");
	rmstuff.addActionListener(new ActionListener(){
		@Override public void actionPerformed(ActionEvent e){
		    arr.remove(rm.getText());
		    for(int i=0;i<subcatBs.size();i++){
			if(subcatBs.get(i).getText().equals(rm.getText())){
			    pane.remove(i);
			    subcatBs.remove(i);
			}
		    }
		    subject.removeSubcategory(rm.getText());
		    topLevel.getProgram().writeFile();
		    rm.setText("");
		    revalidate();
		    repaint();
		}
	    });
	top.add(rm);
	top.add(rmstuff);

	//make array of subcategories
	arr = subject.getSubcats();
	
	//creates a new button for each subcategory
	for(int g=0;g<arr.size();g++){
	    pane.add(createSubcatButton(arr.get(g)));
	}
	this.add(subcatPane, BorderLayout.CENTER);
    }

    public JButton createSubcatButton(Subcategory subcat){
	JButton newthang = new JButton(subcat.getName()+"- "+subcat.getWeight()+"%");
	SubcatInterface interact = makeNewSubcatInterface(subcat);
	newthang.addActionListener(new ActionListener(){
		@Override public void actionPerformed(ActionEvent e){
		    mvToSubcatPanel(interact);
		}
	    });
	newthang.setAlignmentX(Component.CENTER_ALIGNMENT);
	subcatBs.add(newthang);
	return newthang;
    }

    public SubcatInterface makeNewSubcatInterface(Subcategory subcat){
	SubcatInterface pane = new SubcatInterface(topLevel, this, subcat);
	return pane;
    }
    
    public void mvToSubcatPanel(SubcatInterface pane){
	topLevel.setContentPane(pane);
	revalidate();
	repaint();
    }

    public SaturnGradesGUI getTopLevel(){
	return topLevel;
    }
    public Subject getSubject(){
	return subject;
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
	this.add(back, BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent e){
	String command = e.getActionCommand();
	if("go_back".equals(command)){
	    topLevel.setContentPane(topLevel.getSubjectPane());
	    revalidate();
	    repaint();
	}
    }

    public static void main(String[] args){
    }
}