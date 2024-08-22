package bankManagementSystem;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Main_class extends JFrame implements ActionListener {
	
	JButton buttonDeposit, buttonCashWithdrawal, buttonFastCash, buttonMiniStatement, buttonPinChange, buttonBalanceEnquiry, buttonExit;
	
	String pin;
	
	Main_class(String pin){
		
		this.pin = pin;
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1550, 830,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,1540 , 830);
		add(image);
		
		JLabel l1 = new JLabel("Please select the facility");
		l1.setBounds(430,200,700,35);
		l1.setForeground(Color.white);
		l1.setFont(new Font("arial", Font.BOLD, 28 ));
		image.add(l1);
		
		buttonDeposit = new JButton("DEPOSIT");
		buttonDeposit.setBounds(260, 320, 150, 33);
		buttonDeposit.setBackground(new Color(65,125,128));
		buttonDeposit.setForeground(Color.white);
		buttonDeposit.addActionListener(this);
		image.add(buttonDeposit);
		
		buttonCashWithdrawal = new JButton("CASH WITHDRAWAL");
		buttonCashWithdrawal.setBounds(738, 320, 150, 33);
		buttonCashWithdrawal.setBackground(new Color(65,125,128));
		buttonCashWithdrawal.setForeground(Color.white);
		buttonCashWithdrawal.addActionListener(this);
		image.add(buttonCashWithdrawal);
		
		buttonFastCash = new JButton("FAST CASH");
		buttonFastCash.setBounds(260, 361, 150, 33);
		buttonFastCash.setBackground(new Color(65,125,128));
		buttonFastCash.setForeground(Color.white);
		buttonFastCash.addActionListener(this);
		image.add(buttonFastCash);
		
		buttonMiniStatement = new JButton("MINI STATEMENT");
		buttonMiniStatement.setBounds(738, 361, 150, 33);
		buttonMiniStatement.setBackground(new Color(65,125,128));
		buttonMiniStatement.setForeground(Color.white);
		buttonMiniStatement.addActionListener(this);
		image.add(buttonMiniStatement);
		
		buttonPinChange = new JButton("PIN CHANGE");
		buttonPinChange.setBounds(260, 403, 150, 33);
		buttonPinChange.setBackground(new Color(65,125,128));
		buttonPinChange.setForeground(Color.white);
		buttonPinChange.addActionListener(this);
		image.add(buttonPinChange);
		
		buttonBalanceEnquiry = new JButton("BALANCE ENQUIRY");
		buttonBalanceEnquiry.setBounds(738, 403, 150, 34);
		buttonBalanceEnquiry.setBackground(new Color(65,125,128));
		buttonBalanceEnquiry.setForeground(Color.white);
		buttonBalanceEnquiry.addActionListener(this);
		image.add(buttonBalanceEnquiry);
		
		buttonExit = new JButton("EXIT");
		buttonExit.setBounds(738, 445, 150, 33);
		buttonExit.setBackground(new Color(65,125,128));
		buttonExit.setForeground(Color.white);
		buttonExit.addActionListener(this);
		image.add(buttonExit);
		
		setLayout(null);
		setSize(1570, 1000);
		setLocation(0, 0);
		setVisible(true);
	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==buttonDeposit) {
			new Deposit(pin);
			setVisible(false);
			
		}else if(e.getSource()==buttonCashWithdrawal) {
			new Cash_Withdrawal(pin);
			setVisible(false);
			
		}else if(e.getSource()==buttonFastCash) {
			new Fast_Cash(pin);
			setVisible(false);
			
		}else if(e.getSource()==buttonMiniStatement) {
			new Mini_Statement(pin);
			setVisible(false);
			
		}else if(e.getSource()==buttonPinChange) {
			new Change_Pin(pin);
			setVisible(false);
			
		}else if(e.getSource()==buttonBalanceEnquiry) {
			new Balance_Enquiry(pin);
			setVisible(false);
			
		}else if(e.getSource()==buttonExit){
			new Login();
			setVisible(false);
//			System.exit(0);			
		}
		
	}
	public static void main(String[] args) {
		new Main_class("");
	}

}
