package bankManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Cash_Withdrawal extends JFrame implements ActionListener {

	String pinNo;
	
	TextField textField1;
	
	JButton buttonDeposit, buttonBack;
	
	Cash_Withdrawal(String pinNo){
		
		this.pinNo = pinNo;
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1550, 830,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,1540, 830);
		add(image);
		
		JLabel l1 = new JLabel("PLEASE ENTER THE AMOUNT");
		l1.setFont(new Font("arial",Font.BOLD, 18));
		l1.setForeground(Color.white);
		l1.setBounds(400,180,400,35);
		image.add(l1);
		
		JLabel l2 = new JLabel("(Max. withdrawal is Rs. 10,000)");
		l2.setFont(new Font("arial",Font.BOLD, 12));
		l2.setForeground(Color.white);
		l2.setBounds(400,200,400,35);
		image.add(l2);
		
		textField1 = new TextField();
		textField1.setBounds(400, 235, 370, 25);
		textField1.setFont(new Font("arial", Font.BOLD, 22));
		textField1.setBackground(new Color(65,125,128));
		textField1.setForeground(Color.white);
		textField1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String value = textField1.getText();
				int l = value.length();
				if(e.getKeyChar() >= '0' && e.getKeyChar() <= '9')
				{
					textField1.setEditable(true);
					
				}else {
					textField1.setEditable(false);
					l1.setText(" * Enter the amount correctly * ");
				}
			}
		});
		image.add(textField1);
		
		buttonDeposit = new JButton("WITHDRAW");
		buttonDeposit.setBounds(738, 405, 150, 33);
		buttonDeposit.setBackground(new Color(65,125,128));
		buttonDeposit.setForeground(Color.white);
		buttonDeposit.addActionListener(this);
		image.add(buttonDeposit);
		
		buttonBack = new JButton("BACK");
		buttonBack.setBounds(738, 445, 150, 33);
		buttonBack.setBackground(new Color(65,125,128));
		buttonBack.setForeground(Color.white);
		buttonBack.addActionListener(this);
		image.add(buttonBack);
		
		
		setLayout(null);
		setSize(1570, 1000);
		setLocation(0,0);;
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==buttonDeposit) {
		
		try {
			
			String amount = textField1.getText();
			Date date = new Date();
			
			if(textField1.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Please enter the amount to be withdrawn");
			}else {
				ConnectingDatabase  c = new ConnectingDatabase();
				ResultSet resultSet = c.statement.executeQuery("Select * from bank where Pin_no = '"+pinNo+"'");
				int balance = 0;
				while(resultSet.next()) {
					if(resultSet.getString("Type").equals("deposit")) {
						balance = balance + Integer.parseInt(resultSet.getString("amount"));
					}else {
						balance = balance - Integer.parseInt(resultSet.getString("amount"));
					}
				}
				if(balance < Integer.parseInt(amount)) {
					JOptionPane.showMessageDialog(null, "Insufficient Balance");
					return;
				}
				
				c.statement.executeUpdate("insert into bank values('"+pinNo+"', '"+date+"', 'Withdrawal', '"+amount+"')");
				JOptionPane.showMessageDialog(null, "Rs. "+amount+ " Debited Succesfully");
				setVisible(false);
				new Main_class(pinNo);
			}
			
		} catch (Exception e2) {

			
		}
		}else if(e.getSource()==buttonBack)
		{
			setVisible(false);
			new Main_class(pinNo);
		}
		
	}
	
	public static void main(String[] args) {
		
		new Cash_Withdrawal("");
	}

}
