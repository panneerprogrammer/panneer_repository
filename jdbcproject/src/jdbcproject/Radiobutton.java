package jdbcproject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

 class Gen extends JFrame implements ActionListener
{
	JLabel l4;
	JButton b1;
	JRadioButton r1,r2,r3;
	
     Gen()
     {
    	setLayout(null);
    	setTitle("My Project");
    	
    	l4 = new JLabel("Gender:");
    	l4.setBounds(100,350,300,30);
    	add (l4);
    	
    	
 		
 		
 		ButtonGroup bg = new ButtonGroup();
 		
 		r1= new JRadioButton("Male");
 		r2= new JRadioButton("Female");
 		r3= new JRadioButton("Others");
 		
 		
 		
 		
 		
 		bg.add(r1);
 		bg.add(r2);
 		bg.add(r3);
 		
 		
 		
 		
 		
 		
 	
 		
 		
 		r1.setBounds(250,350,100,30);
 		r2.setBounds(350,350,100,30);
 		r3.setBounds(450,350,100,30);
 		
 		
 		
 		
    	add (r1);
    	add (r2);
    	add (r3);
    	
    	
    	b1 = new JButton("answer");
    	b1.addActionListener(this);
    	b1.setBounds(300,450,100,30);;
    	add(b1);
    	
     }


	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(r1.isSelected())
		{
			JOptionPane.showMessageDialog(null, "Male");
		}
		
		else if(r2.isSelected())
		{
			JOptionPane.showMessageDialog(null, "Female");
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Others");
		}
		
	}




}


public class Radiobutton {

	public static void main(String[] args) {
		
		
		JFrame gen= new Gen();
	
		gen.setSize(700,400);
		gen.setVisible(true);
		
		
	}

}
