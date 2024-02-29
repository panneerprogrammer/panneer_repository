package jdbcproject;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MyProject extends JFrame implements ActionListener 
{
	JLabel l1,l2,l3,tit;
	JTextField  t1;
	JTextField t2;
	JButton register;
	JTextArea ta;
	Font f1;
	JLabel l5;
	JCheckBox cb1,cb2,cb3;
	JLabel l4;
	JRadioButton r1,r2,r3;
	
	MyProject()
	{
		setLayout(null);
		setTitle("My Project");
		tit = new JLabel("Employee registration form");
		f1 = new Font("Times",Font.BOLD,30);
		tit.setFont(f1);
		ButtonGroup bg = new ButtonGroup();
		
		l1 = new JLabel("Eno:");
		t1 = new JTextField();
		
		l2 = new JLabel("Ename:");
		t2 = new JTextField();
		
		l3 = new JLabel ("Eadd:");
		ta = new JTextArea();
	
		l4 = new JLabel("Gender:");
    	l4.setBounds(100,350,300,30);
    	add (l4);
    	
    	l5 = new JLabel("Course:");
    	l5.setBounds(100,400,300,30);
    	add (l5);
    	
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
    	
    	
    	cb1 = new JCheckBox("C");
		cb2 = new JCheckBox("C++");
		cb3 = new JCheckBox("Java");
		
		cb1.setBounds(250, 400, 100, 30);
		cb2.setBounds(350, 400, 100, 30);
		cb3.setBounds(450, 400, 100, 30);
		
		add (cb1);
		add (cb2);
		add (cb3);


    	
		register = new JButton ("Insert/Save");
		register.addActionListener(this);
		
		
		tit.setBounds(100, 50, 400, 30);
		l1.setBounds(100,100,300,30);
		t1.setBounds(250,100,200,30);
		l2.setBounds(100,150,300,30);
		t2.setBounds(250,150,200,30);
		l3.setBounds(100,200,300,30);

		ta.setBounds(250,200,200,80);
		register.setBounds(450, 500, 100, 30);
		
		add (l1);
		add (t1);
		add (l2);
		add (t2);
		add (l3);
		add (ta);
		add (tit);
		add (register);
	}

	public void actionPerformed(ActionEvent e) {
	
		int eno = Integer.parseInt(t1.getText());
		String ena = t2.getText();
		String eadd = ta.getText();
		String gen;
		String cou = "";
	
		
		if(r1.isSelected())
		{
			
			gen = "Male";
		}
		
		else if(r2.isSelected())
		{
			
			gen = "Female";
		}
		else
		{
			gen = "Others";
		}
		
		
		if(cb1.isSelected())
		{
			cou = cou+ " C";
		}
		
		if(cb2.isSelected())
		{
			cou = cou+" C++";
		}
		
		
		if(cb3.isSelected())
		{
			cou = cou+ " Java";
		}
		
		
		if(e.getSource()!= register)
		{
			
			
			try
			{
				
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Accepted");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/panneer","root","12345");
			System.out.println("Connection Success");
			
			Statement st  = con.createStatement();
			ResultSet rs = st.executeQuery("Select * from register");
		
			
			rs.close();
			st.close();
			con.close();
			
			}
			
			catch(Exception e2)
			{
				System.out.println("Error:"+e2.toString());
			}
		
	}
		else
		{
			try
			{
				
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Accepted");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/panneer","root","12345");
			System.out.println("Connection Success");
			
			Statement st  = con.createStatement();
			int res = st.executeUpdate  ("insert into register(eno,ena,eadd,gen,cou) values("+eno+",'"+ena+"','"+eadd+"','"+gen+"','"+cou+"')");
			if(res>0)
			{
				JOptionPane.showMessageDialog(null, "Success Inserted");
				t1.setText("");
				t2.setText("");
				t1.requestFocus();
			}
			
			else
			{
				JOptionPane.showMessageDialog(null, "Not Inserted");
				st.close();
				con.close();
			}
			}
			catch(Exception e1)
			{
				System.out.println("Error:"+e1.toString());
			}
			
			}
		}	
}




public class Emp {

	public static void main(String[] args) {
		
		MyProject mp = new MyProject();
		mp.setSize(500,400);
		mp.setVisible(true);
		
	}
}
