package bankManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Balance_Enquiry extends JFrame implements ActionListener{
	
	JLabel l1,l2;
	
	JButton buttonBack;
	
	String pinNo;
	
	Balance_Enquiry(String pinNo){
		
		this.pinNo = pinNo;
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1550, 830,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,1540, 830);
		add(image);
		
		l1 = new JLabel("YOUR CURRENT BALANCE IS Rs. ");
		l1.setFont(new Font("arial",Font.BOLD, 18));
		l1.setForeground(Color.white);
		l1.setBounds(400,180,400,35);
		image.add(l1);
		
		l2 = new JLabel();
		l2.setFont(new Font("arial",Font.BOLD, 18));
		l2.setForeground(Color.white);
		l2.setBounds(400,220,400,35);
		image.add(l2);
		
		buttonBack = new JButton("BACK");
		buttonBack.setBounds(738, 445, 150, 33);
		buttonBack.setBackground(new Color(65,125,128));
		buttonBack.setForeground(Color.white);
		buttonBack.addActionListener(this);
		image.add(buttonBack);
		
		int balance = 0;
		try {
			ConnectingDatabase c = new  ConnectingDatabase();
			ResultSet resultSet = c.statement.executeQuery("Select * from bank where Pin_no = '"+pinNo+"'");
			while(resultSet.next())
			{
				if(resultSet.getString("Type").equals("deposit")) {
					balance = balance + Integer.parseInt(resultSet.getString("amount"));
				}else {
					balance = balance - Integer.parseInt(resultSet.getString("amount"));
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		l2.setText(""+balance);
		
		setLayout(null);
		setSize(1570, 1000);
		setLocation(0,0);;
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
		new Main_class(pinNo);
		
	}
	
	public static void main(String[] args) {
		new Balance_Enquiry("");
;	}

}
