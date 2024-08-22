package bankManagementSystem;

import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;
import javax.swing.*;
import java.text.SimpleDateFormat;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

public class SignUp extends JFrame implements ActionListener{
	
	JRadioButton male,female,others,Married,Unmarried,Others2;
	
	JTextField textfieldName ,textfieldFatherName, textEmailAddress, textMaritalStatus, textAddress, textCity, textPincode, textState ;
	
	JButton next;
	JDateChooser dateChooser;
	Random random = new Random();
	long applicationNo = (random.nextLong() % 9000L) + 1000L;
	String appNo = " " + Math.abs(applicationNo);
	
	public SignUp() {
		
		super("Application form");
		
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images/bankLogo.png"));
		Image i2 = i1.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(25,10,100, 100);
		add(image);
		
		JLabel label1 = new JLabel("Application form no. "+ appNo);
		label1.setBounds(160, 20, 600, 40);
		label1.setFont(new Font("arial", Font.BOLD,38));
		add(label1);
		
		JLabel label2 = new JLabel("Page 1");
		label2.setBounds(330, 70, 600, 30);
		label2.setFont(new Font("arial", Font.BOLD,22));
		add(label2);
		
		JLabel label3 = new JLabel("Personal Details");
		label3.setBounds(290, 95, 600, 30);
		label3.setFont(new Font("arial", Font.BOLD,22));
		add(label3);
		 
		JLabel labelName = new JLabel("Name ");
		labelName.setBounds(100, 190, 100, 30);
		labelName.setFont(new Font("arial", Font.BOLD,20));
		add(labelName);
		
		textfieldName = new JTextField();
		textfieldName.setFont(new Font("arial", Font.BOLD, 14));
		textfieldName.setBounds(300, 190, 400 ,30);
		textfieldName.addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyPressed(KeyEvent e2) {
		       
		        int keyCode = e2.getKeyCode();
		        if (keyCode == KeyEvent.VK_BACK_SPACE || 
		            keyCode == KeyEvent.VK_DELETE || 
		            keyCode == KeyEvent.VK_LEFT || 
		            keyCode == KeyEvent.VK_RIGHT ||
		            keyCode == KeyEvent.VK_SHIFT ||
		            keyCode == KeyEvent.VK_CAPS_LOCK) {
		            textfieldName.setEditable(true);
		            return;
		        }
		    }

		    @Override
		    public void keyTyped(KeyEvent e3) {
		        char keyChar = e3.getKeyChar();

		        if (Character.isLetter(keyChar) || Character.isWhitespace(keyChar)) {
		            textfieldName.setEditable(true);
		        } else {
		            textfieldName.setEditable(false);
		            JOptionPane.showMessageDialog(null, "Name can't contain digits or special characters.");
		        }
		    }

		    @Override
		    public void keyReleased(KeyEvent e) {
		        textfieldName.setEditable(true); // Re-enable editing after the key press event
		    }
		});
		add(textfieldName);
		
		JLabel labelFatherName = new JLabel("Father's Name ");
		labelFatherName.setBounds(100, 240, 200, 30);
		labelFatherName.setFont(new Font("arial", Font.BOLD,20));
		add(labelFatherName);
		
		textfieldFatherName = new JTextField();
	    textfieldFatherName.setFont(new Font("arial", Font.BOLD, 14));
	    textfieldFatherName.setBounds(300, 240, 400 ,30);
		add(textfieldFatherName);
		
		JLabel labelGender = new JLabel("Gender ");
		labelGender.setBounds(100, 290, 200, 30);
		labelGender.setFont(new Font("arial", Font.BOLD,20));
		add(labelGender);
		
		male = new JRadioButton("Male");
		male.setFont(new Font("arial", Font.BOLD, 14));
		male.setBounds(300, 290, 60, 30);
		male.setBackground(new Color(224, 207, 225));
		add(male);
		
		female = new JRadioButton("Female");
		female.setFont(new Font("arial", Font.BOLD, 14));
		female.setBounds(400, 290, 80, 30);
		female.setBackground(new Color(224, 207, 225));
		add(female);
		
		others = new JRadioButton("Others");
		others.setFont(new Font("arial", Font.BOLD, 14));
		others.setBounds(500, 290, 90, 30);
		others.setBackground(new Color(224, 207, 225));
		add(others);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(male);
		buttonGroup.add(female);
		buttonGroup.add(others);
		
		JLabel DOB = new JLabel("Date of Birth ");
		DOB.setBounds(100, 340, 200, 30);
		DOB.setFont(new Font("arial", Font.BOLD,20));
		add(DOB);
		
		dateChooser = new JDateChooser();
		dateChooser.setForeground(new Color(105, 105, 105));
		dateChooser.setBounds(300, 340, 400, 30);
		add(dateChooser);
		
		JLabel EmailAddress = new JLabel("Email Address ");
		EmailAddress.setBounds(100, 390, 200, 30);
		EmailAddress.setFont(new Font("arial", Font.BOLD,20));
		add(EmailAddress);
		
		textEmailAddress = new JTextField();
		textEmailAddress.setFont(new Font("arial", Font.BOLD, 14));
		textEmailAddress.setBounds(300, 390, 400, 30);
		add(textEmailAddress);
		
		JLabel MaritalStatus = new JLabel("Marital Status ");
		MaritalStatus.setBounds(100, 440, 200, 30);
		MaritalStatus.setFont(new Font("arial", Font.BOLD,20));
		add(MaritalStatus);
		
		Married = new JRadioButton("Married");
		Married.setFont(new Font("arial", Font.BOLD, 14));
		Married.setBounds(300, 440, 80, 30);
		Married.setBackground(new Color(224, 207, 225));
		add(Married);
		
		Unmarried = new JRadioButton("Unmarried");
		Unmarried.setFont(new Font("arial", Font.BOLD, 14));
		Unmarried.setBounds(400, 440, 100, 30);
		Unmarried.setBackground(new Color(224, 207, 225));
		add(Unmarried);
		
		Others2 = new JRadioButton("Others");
		Others2.setFont(new Font("arial", Font.BOLD, 14));
		Others2.setBounds(500, 440, 110, 30);
		Others2.setBackground(new Color(224, 207, 225));
		add(Others2);
		
		ButtonGroup buttonGroup1 = new ButtonGroup();
		buttonGroup1.add(Married);
		buttonGroup1.add(Unmarried);
		buttonGroup1.add(Others2);
		
		JLabel Address = new JLabel("Address ");
		Address.setBounds(100, 490, 200, 30);
		Address.setFont(new Font("arial", Font.BOLD,20));
		add(Address);
		
		textAddress = new JTextField();
		textAddress.setFont(new Font("arial", Font.BOLD, 14));
		textAddress.setBounds(300, 490, 400, 30);
		add(textAddress);
		
		JLabel State = new JLabel("State ");
		State.setBounds(100, 540, 200, 30);
		State.setFont(new Font("arial", Font.BOLD,20));
		add(State);
		
		textState = new JTextField();
		textState.setFont(new Font("arial", Font.BOLD, 14));
		textState.setBounds(300, 540, 400, 30);
		add(textState);
		
		JLabel City = new JLabel("City ");
		City.setBounds(100, 590, 200, 30);
		City.setFont(new Font("arial", Font.BOLD,20));
		add(City);
		
		textCity = new JTextField();
		textCity.setFont(new Font("arial", Font.BOLD, 14));
		textCity.setBounds(300, 590, 400, 30);
		add(textCity);
		
		JLabel Pincode = new JLabel("Pincode ");
		Pincode.setBounds(100, 640, 200, 30);
		Pincode.setFont(new Font("arial", Font.BOLD,20));
		add(Pincode);
		
		textPincode = new JTextField();
		textPincode.setFont(new Font("arial", Font.BOLD, 14));
		textPincode.setBounds(300, 640, 400, 30);

		Pincode.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent ee) {
				String value1 = textPincode.getText();
				int l = value1.length();
				
				if(l>=5) {
					JOptionPane.showMessageDialog(null, "Length of password should not exceed 4.");

				}
				if(ee.getKeyChar() >= '0' && ee.getKeyChar() <= '9')
				{
					if(l>=5) {
						textPincode.setEditable(false);
					}else {
						textPincode.setEditable(true);
					}
					
				}else {
					textPincode.setEditable(false);
					JOptionPane.showMessageDialog(null, "Enter the correct PIN.");
				}
			}
		});
		
		add(textPincode);
		
		next = new JButton("Next");
		next.setFont(new Font("arial", Font.BOLD, 14));
		next.setBackground(Color.black);
		next.setForeground(Color.white);
		next.setBounds(620, 710, 80, 30);
		next.addActionListener(this);
		add(next);
				
		getContentPane().setBackground(new Color(224, 207, 225));
		setLayout(null);
		setSize(850, 800);
		setLocation(360, 40);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String formNo = appNo;
		String name = textfieldName.getText();
		String fatherName = textfieldFatherName.getText();
		String gender = null;
		if(male.isSelected()) {
			gender = "Male";
		}
		else if(female.isSelected()) {
			gender = "Female";
		}
		else if(others.isSelected()) {
			gender = "Others";
		}
		String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
		
		
		String email = textEmailAddress.getText();
		String maritalStatus = null;
		if(Married.isSelected()) {
			 maritalStatus = "Married";
		}
		else if(Unmarried.isSelected()) {
			maritalStatus = "Unmarried";
		}
		else if(Others2.isSelected()) {
			maritalStatus = "Others";
		}
		
		String address = textAddress.getText();
		String state = textState.getText();
		String city = textCity.getText();
		String pincode = textPincode.getText();
		
		try {
			if(name.isEmpty() || fatherName.isEmpty() || email.isEmpty() || address.isEmpty() || state.isEmpty() || city.isEmpty() || pincode.isEmpty() || dob.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Fill all the fields");
			}
			else {
				ConnectingDatabase connectingDatabase1 = new ConnectingDatabase();
				String q = "Insert into signup values('"+formNo+"', '"+name+"', '"+fatherName+"', '"+gender+"','"+dob+"', '"+email+"', '"+maritalStatus+"', '"+address+"', '"+state+"', '"+city+"', '"+pincode+"')";
				connectingDatabase1.statement.executeUpdate(q);
				new SignUp2(appNo);
				setVisible(false);
			}
			
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
			JOptionPane.showMessageDialog(null, "An error occurred while submitting the form. Please try again.");
		}
		
		
	}
	
	public static void main(String[] args) {
		new SignUp();
		
	}

}
