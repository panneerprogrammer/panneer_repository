package jdbcproject;

import java.awt.Button;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

 class Checbox extends JFrame{

		JLabel l5;
		JCheckBox cb1,cb2,cb3;
		
		Checbox()
		{
			setLayout(null);
			setTitle("Checkbox");
			ButtonGroup bg= new ButtonGroup();
			
			l5 = new JLabel("Course:");
	    	l5.setBounds(100,400,300,30);
	    	add (l5);
	    	
			
			cb1 = new JCheckBox("C");
			cb2 = new JCheckBox("C++");
			cb3 = new JCheckBox("Java");
			
			cb1.setBounds(250, 400, 100, 30);
			cb2.setBounds(350, 400, 100, 30);
			cb3.setBounds(450, 400, 100, 30);
			
			
			
			add (cb1);
			add (cb2);
			add (cb3);
		}
		
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			JFrame f1 = new Checbox();
			f1.setSize(700,400);
			f1.setVisible(true);
	}

}
