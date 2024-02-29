package jdbcproject;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//conenection.driver,result,statement

class MyProject1 extends JFrame implements ActionListener 
{
	JLabel l1,l2,tit;
	JTextField t1;
	JPasswordField t2;
	JButton login,reset,register;
	Font f1;
	
	MyProject1()
	{
		setLayout(null);
		setTitle("My Project");
		tit = new JLabel("Employee registration form");
		f1 = new Font("Times",Font.BOLD,30);
		tit.setFont(f1);
		
		l1 = new JLabel("Enter Name:");
		t1 = new JTextField();
		
		l2 = new JLabel("Enter Password:");
		t2 = new JPasswordField();
		
		login = new JButton ("Sign IN");
		reset = new JButton ("Clear");
		register = new JButton ("Insert/Save");
		
		reset.addActionListener(this);// Go to override method
		login.addActionListener(this);// Go to override method
		register.addActionListener(this);// Go to override method
		
		
		tit.setBounds(100, 50, 200, 30);
		l1.setBounds(100,100,300,30);
		t1.setBounds(250,100,200,30);
		l2.setBounds(100,150,300,30);
		t2.setBounds(250,150,200,30);
		login.setBounds(250,200,100,30);
		reset.setBounds(350,200,100,30);
		register.setBounds(450, 200, 100, 30);
		
		add (l1);
		add (t1);
		add (l2);
		add (t2);
		add (tit);
		add (login);
		add (reset);
		add (register);
	}

	//@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String un = t1.getText();
		String pw = t2.getText();
		
		if(e.getSource()==login)
		{
			//JOptionPane.showMessageDialog(null,"User Name:"+un+"Password:"+pw);
			
			try
			{
				
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Accepted");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/panneer","root","12345");
			System.out.println("Connection Success");
			
			Statement st  = con.createStatement();
			ResultSet rs = st.executeQuery("Select * from login");
			boolean ch = false; 
			while(rs.next())
			{
				//System.out.println(""+rs.getString(1)+""+rs.getString(2)+""+rs.getString(3));
				if(un.equals(rs.getString(1))&& pw.equals(rs.getString(2)))
				{
					ch =true;
					JOptionPane.showMessageDialog(null,"Success valid user");
				}
				
			}
			
			if(ch==false)
			{
				JOptionPane.showMessageDialog(null,"Invalid user");
			}
			
			rs.close();
			st.close();
			con.close();
			
			}
			
			catch(Exception e2)
			{
				System.out.println("Error:"+e2.toString());
			}
		
	}
		else if(e.getSource()==reset)
		{
			t1.setText("");
			t2.setText("");
			t1.requestFocus();
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
			int res = st.executeUpdate("insert into login values('"+un+"','"+pw+"')");
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
public class Test {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		JFrame mp = new MyProject1();
		mp.setSize(500,400);
		mp.setVisible(true);
		
	}
}
