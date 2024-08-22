package bankManagementSystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

import java.util.Date;

public class Deposit extends JFrame implements ActionListener{
	
	String pinNo;
	
	TextField textField1;
	
	JButton buttonDeposit, buttonBack;
	
	Deposit(String pinNo){
		
		this.pinNo = pinNo;
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1550, 830,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,1540, 830);
		add(image);
		
		JLabel l1 = new JLabel("ENTER THE AMOUNT TO BE DEPOSITED: ");
		l1.setFont(new Font("arial",Font.BOLD, 18));
		l1.setForeground(Color.white);
		l1.setBounds(400,180,400,35);
		image.add(l1);
		
		textField1 = new TextField();
		textField1.setBounds(400, 240, 370, 25);
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
		
		buttonDeposit = new JButton("DEPOSIT");
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
		try {
			
			String amount = textField1.getText();
			Date date = new Date();
			
			if(e.getSource()==buttonDeposit)
			{
				if(textField1.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Please enter the amount to be deposited");
				}else {
					ConnectingDatabase c = new ConnectingDatabase();
					c.statement.executeUpdate("Insert into bank values('"+pinNo+"', '"+date+"', 'deposit', '"+amount+"')");
					JOptionPane.showMessageDialog(null, "Rs. "+amount+" Deposited Succesfully");
					setVisible(false);				
					new Main_class(pinNo);
				}
			}else if(e.getSource()==buttonBack){
				setVisible(false);
				new Main_class(pinNo);
				
			}
			
		} catch (Exception e2) {
			
		}
				
	}

	
	public static void main(String[] args) {
		
		new Deposit(" ");
		
	}
}
