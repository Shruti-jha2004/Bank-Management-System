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
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener{
	
	JLabel label1, label2, label3;
	
	JTextField textField1;
	
	JPasswordField passwordField1;
	
	JButton button1, button2, button3;
	
	public Login() {
		super("ThePublicBank");
		
		//for the logo of bank to print
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images/bankLogo.png"));
		Image i2 = i1.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(350,10,100, 100);
		add(image);
		
		//for the piggy bank image
		ImageIcon p1 = new ImageIcon(ClassLoader.getSystemResource("Images/pig.png"));
		Image p2 = p1.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
		ImageIcon p3 = new ImageIcon(p2);
		JLabel p_image = new JLabel(p3);
		p_image.setBounds(680,300,100, 100);
		add(p_image);
		
		label1 = new JLabel("Welcome");
		label1.setForeground(Color.white);
		label1.setFont(new Font("arial", Font.BOLD, 35));
		label1.setBounds(320, 125, 450, 40);
		add(label1);
		
		label2 = new JLabel("Card No. :");
		label2.setForeground(Color.white);
		label2.setFont(new Font("courier", Font.BOLD, 28));
		label2.setBounds(150, 155, 375, 90);
		add(label2);
		
		textField1 = new JTextField(15);
		textField1.setBounds(305, 190, 230, 30);
		textField1.setFont(new Font("arial", Font.BOLD, 14));
		textField1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String value = textField1.getText();
				
				if(value.length()>=15) {
					JOptionPane.showMessageDialog(null, "Length of Card no. should not exceed 16.");
				}
				
				if(e.getKeyChar() >= '0' && e.getKeyChar() <= '9')
				{
					if(value.length()>=15) {
						textField1.setEditable(false);
					}else {
						textField1.setEditable(true);					
					}
					
				}else {
					textField1.setEditable(false);
					JOptionPane.showMessageDialog(null, "Card no. must contain digits only");
				}
			}
			});
		add(textField1);
		
		
		label3 = new JLabel("Pin :");
		label3.setForeground(Color.white);
		label3.setFont(new Font("courier", Font.BOLD, 28));
		label3.setBounds(150, 215, 375, 90);
		add(label3);
		
		passwordField1 = new JPasswordField(4);
		passwordField1.setBounds(305, 250, 230, 30);
		passwordField1.setFont(new Font("arial", Font.BOLD, 14));
		passwordField1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent ee) {
				String value1 = passwordField1.getText();
				int l = value1.length();
				
				if(l>=3) {
					JOptionPane.showMessageDialog(null, "Length of password should not exceed 4.");

				}
				if(ee.getKeyChar() >= '0' && ee.getKeyChar() <= '9')
				{
					if(l>=3) {
						passwordField1.setEditable(false);
					}else {
						passwordField1.setEditable(true);
					}
					
				}else {
					textField1.setEditable(false);
					JOptionPane.showMessageDialog(null, "Enter the correct PIN.");
				}
			}
		});
		add(passwordField1);
		
		button1 = new JButton("Sign In");
		button1.setFont(new Font("arial", Font.BOLD, 14));
		button1.setForeground(Color.white);
		button1.setBackground(Color.black);
		button1.setBounds(290,300, 110,30);
		button1.addActionListener(this);
		add(button1);
		
		button2 = new JButton("Clear");
		button2.setFont(new Font("arial", Font.BOLD, 14));
		button2.setForeground(Color.white);
		button2.setBackground(Color.black);
		button2.setBounds(430,300, 110,30);
		button2.addActionListener(this);
		add(button2);
		
		button3 = new JButton("Sign Up");
		button3.setFont(new Font("arial", Font.BOLD, 14));
		button3.setForeground(Color.white);
		button3.setBackground(Color.black);
		button3.setBounds(300,350, 230,30);
		button3.addActionListener(this);
		add(button3);
		
		//for background image
		ImageIcon b1 = new ImageIcon(ClassLoader.getSystemResource("Images/bg1.jpeg"));
		Image b2 = b1.getImage().getScaledInstance(850, 450,Image.SCALE_DEFAULT);
		ImageIcon b3 = new ImageIcon(b2);
		JLabel b_image = new JLabel(b3);
		b_image.setBounds(0,0,850, 450);
		add(b_image);
		
		setLayout(null);
		setSize(850, 450);
//		setUndecorated(true);
		setVisible(true);
		setLocation(450, 200);
			
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ConnectingDatabase c = new ConnectingDatabase();
		try {
			if(e.getSource()==button1) {
				
				String cardNo = textField1.getText();
				String pin = passwordField1.getText();
				String q = "select * from loginDetails where Card_no = '"+cardNo+"' and Pin = '"+pin+"'";
				ResultSet resultSet = c.statement.executeQuery(q);
				
				if(textField1.getText().isEmpty() && passwordField1.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,"Fill the Card No. and pin");
				}
				else if(textField1.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,"Fill the card number correctly");
				}
				else if(passwordField1.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,"Enter the pin");
				}else{
					try {
						if(resultSet.next()) {
							setVisible(true);
							new Main_class(pin);
						}else {
							JOptionPane.showMessageDialog(null,"Incorrect Card number or Pin");
						}
						
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "Error");
						e2.printStackTrace();
					}
					
				}
			}
			else if(e.getSource()==button2) {
				
				textField1.setText("");
				passwordField1.setText("");
				
			}
			else if(e.getSource()==button3){
				new SignUp();
				setVisible(false);
			}
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		new Login();
		
	}

}
