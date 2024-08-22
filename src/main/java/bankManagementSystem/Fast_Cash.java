package bankManagementSystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Fast_Cash extends JFrame implements ActionListener {
	
	JButton button50, button100, button200, button500, button1000, button2000, buttonBack;
	
	String pinNo;
	
	Fast_Cash(String pinNo){
		
		this.pinNo = pinNo;
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1550, 830,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,1540 , 830);
		add(image);
		
		JLabel l1 = new JLabel("PLEASE SELECT WITHDRAWAL AMOUNT");
		l1.setBounds(360,200,700,35);
		l1.setForeground(Color.white);
		l1.setFont(new Font("arial", Font.BOLD, 22 ));
		image.add(l1);
		
		button50 = new JButton("Rs. 50");
		button50.setBounds(260, 320, 150, 33);
		button50.setBackground(new Color(65,125,128));
		button50.setForeground(Color.white);
		button50.addActionListener(this);
		image.add(button50);
		
		button100 = new JButton("Rs. 100");
		button100.setBounds(738, 320, 150, 33);
		button100.setBackground(new Color(65,125,128));
		button100.setForeground(Color.white);
		button100.addActionListener(this);
		image.add(button100);
		
		button200 = new JButton("Rs. 200");
		button200.setBounds(260, 361, 150, 33);
		button200.setBackground(new Color(65,125,128));
		button200.setForeground(Color.white);
		button200.addActionListener(this);
		image.add(button200);
		
		button500 = new JButton("Rs. 500");
		button500.setBounds(738, 361, 150, 33);
		button500.setBackground(new Color(65,125,128));
		button500.setForeground(Color.white);
		button500.addActionListener(this);
		image.add(button500);
		
		button1000 = new JButton("Rs. 1000");
		button1000.setBounds(260, 403, 150, 33);
		button1000.setBackground(new Color(65,125,128));
		button1000.setForeground(Color.white);
		button1000.addActionListener(this);
		image.add(button1000);
		
		button2000 = new JButton("Rs. 2000");
		button2000.setBounds(738, 403, 150, 34);
		button2000.setBackground(new Color(65,125,128));
		button2000.setForeground(Color.white);
		button2000.addActionListener(this);
		image.add(button2000);
		
		buttonBack = new JButton("BACK");
		buttonBack.setBounds(738, 445, 150, 33);
		buttonBack.setBackground(new Color(65,125,128));
		buttonBack.setForeground(Color.white);
		buttonBack.addActionListener(this);
		image.add(buttonBack);
		
		setLayout(null);
		setSize(1570, 1000);
		setLocation(0, 0);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==buttonBack) {
			setVisible(false);
			new Main_class(pinNo);
		}else {
			String amount  = ((JButton)e.getSource()).getText().substring(4);
			ConnectingDatabase c = new ConnectingDatabase();
			Date date = new Date();
			try {
				ResultSet resultSet = c.statement.executeQuery("select * from bank where Pin_no = '"+pinNo+"'");
				int balance = 0;
				while(resultSet.next()) {
					if(resultSet.getString("Type").equals("deposit")){
						balance = balance + Integer.parseInt(resultSet.getString("amount"));
					}
					else {
						balance = balance - Integer.parseInt(resultSet.getString("amount"));
					}
				}
				
				if(balance < Integer.parseInt(amount)) {
					JOptionPane.showMessageDialog(null, "Inadequate Funds");
					return;
				}
				
				c.statement.executeUpdate("insert into bank values('"+pinNo+"', '"+date+"', 'Withdrawal', '"+amount+"')");
				JOptionPane.showMessageDialog(null, "Rs. "+amount+ " has been Succesfully Debited");
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			finally {
		        try {
		            if(c.statement != null) c.statement.close();
		            if(c.connection != null) c.connection.close();
		        } catch (SQLException e3) {
		            e3.printStackTrace();
		        }
			
			setVisible(false);
			new Main_class(pinNo);
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		new Fast_Cash("");
	}

}
