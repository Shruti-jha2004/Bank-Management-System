package bankManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class Change_Pin extends JFrame implements ActionListener{
	
	String pinNo;
	
	JButton buttonChangePin, buttonBack;
	
	JPasswordField passwordNewPin, passwordNewPinConfirm;
	
	Change_Pin(String pinNo){
		
		this.pinNo = pinNo;
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1550, 830,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,1540, 830);
		add(image);
		
		JLabel l1 = new JLabel("CHANGE YOUR PIN");
		l1.setFont(new Font("arial",Font.BOLD, 18));
		l1.setForeground(Color.white);
		l1.setBounds(400,180,400,35);
		image.add(l1);
		
		JLabel declaration = new JLabel("(The pin should be a four digit number) ");
		declaration.setFont(new Font("arial",Font.BOLD, 10));
		declaration.setForeground(Color.white);
		declaration.setBounds(400,200,400,35);
		image.add(declaration);
		
		JLabel l2 = new JLabel("New Pin : ");
		l2.setFont(new Font("arial",Font.BOLD, 16));
		l2.setForeground(Color.white);
		l2.setBounds(400,240,400,35);
		image.add(l2);
		
		passwordNewPin = new JPasswordField();
		passwordNewPin.setBackground(new Color(65,125,128));
		passwordNewPin.setForeground(Color.WHITE);
		passwordNewPin.setBounds(550,243,180,25);
		passwordNewPin.setFont(new Font("Raleway", Font.BOLD,22));
        image.add(passwordNewPin);
        
        JLabel l3 = new JLabel("Confirm Pin : ");
		l3.setFont(new Font("arial",Font.BOLD, 16));
		l3.setForeground(Color.white);
		l3.setBounds(400,270,400,35);
		image.add(l3);
		
		passwordNewPinConfirm = new JPasswordField();
		passwordNewPinConfirm.setBackground(new Color(65,125,128));
		passwordNewPinConfirm.setForeground(Color.WHITE);
		passwordNewPinConfirm.setBounds(550,273,180,25);
		passwordNewPinConfirm.setFont(new Font("Raleway", Font.BOLD,22));
        image.add(passwordNewPinConfirm);		
		
		buttonChangePin = new JButton("CHANGE PIN");
		buttonChangePin.setBounds(738, 405, 150, 33);
		buttonChangePin.setBackground(new Color(65,125,128));
		buttonChangePin.setForeground(Color.white);
		buttonChangePin.addActionListener(this);
		image.add(buttonChangePin);
		
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
		
		try {
			String newPin = passwordNewPin.getText();
			String newPinConfirm = passwordNewPinConfirm.getText();
			
			if(!newPin.equals(newPinConfirm)) {
				JOptionPane.showMessageDialog(null, "Confirm Pin does not match the New Pin.");
				return;
			}
			
			if(e.getSource()==buttonChangePin) {
				if(passwordNewPin.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "No value Entered.");
					return;
				}
				
				else if(passwordNewPinConfirm.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Confirm the pin.");
					return;
				}
				
				ConnectingDatabase c = new ConnectingDatabase();
				String queryBank = "update bank set Pin_no = '"+newPin+"' where Pin_no = '"+pinNo+"'";
				String queryLoginDetails = "update loginDetails set Pin = '"+newPin+"' where Pin = '"+pinNo+"'";
				String querySignup3 = "update signup3 set Pin = '"+newPin+"' where Pin = '"+pinNo+"'";
				
				c.statement.executeUpdate(queryBank);
				c.statement.executeUpdate(queryLoginDetails);
				c.statement.executeUpdate(querySignup3);
				
				JOptionPane.showMessageDialog(null, "Pin Changed Successfully.");
				setVisible(false);
				new Main_class(newPin);
			}else if(e.getSource()==buttonBack) {
				new Main_class(pinNo);
				setVisible(false);
			}
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		
	}
	
	public static void main(String[] args) {
		
		new Change_Pin("");
	}

}
