package bankManagementSystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JComboBox;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JRadioButton;
//import javax.swing.JTextField;

public class SignUp2 extends JFrame implements ActionListener {
	
	JComboBox comboBoxReligion, comboBoxCategory, comboBoxIncome, comboBoxEducation, comboBoxOccupation;
	
	JRadioButton yes, no;
	
	JTextField textPanNo, textAadharNo, textExistingAccountNo, textPhoneNo, textAlternatePhoneNo;
	String appNo;
	
	JButton next;
	
	SignUp2(String appNo){
		
		super("Application form");
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images/bankLogo.png"));
		Image i2 = i1.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(150,0,100, 100);
		add(image);
		
		this.appNo = appNo;
		
		JLabel l1 = new JLabel("Page 2 : ");
		l1.setFont(new Font("arial", Font.BOLD, 22));
		l1.setBounds(300, 30, 600, 40);
		add(l1);
		
		JLabel l2 = new JLabel("Additional Details of Customer ");
		l2.setFont(new Font("arial", Font.BOLD, 22));
		l2.setBounds(300, 60, 600, 40);
		add(l2);
		
		JLabel l3 = new JLabel("Religion: ");
		l3.setFont(new Font("arial", Font.BOLD, 18));
		l3.setBounds(100, 120, 100, 30);
		add(l3);
		
		String religion[] = {"Buddhism", "Christianity", "Confucianism", "Hinduism", "Islam", "Jainism", "Judaism", "Shinto", "Sikhism", "Taoism", "Zoroastrianism"};
		comboBoxReligion = new JComboBox(religion);
		comboBoxReligion.setBackground(new Color(224, 207, 225));
		comboBoxReligion.setFont(new Font("arial", Font.BOLD, 14));
		comboBoxReligion.setBounds(350, 120, 320, 30);
		add(comboBoxReligion);
		
		JLabel l4 = new JLabel("Category: ");
		l4.setFont(new Font("arial", Font.BOLD, 18));
		l4.setBounds(100, 170, 100, 30);
		add(l4);
		
		String category[] = {"General", "SC", "ST", "OBC", "Others"};
		comboBoxCategory = new JComboBox(category);
		comboBoxCategory.setBackground(new Color(224, 207, 225));
		comboBoxCategory.setFont(new Font("arial", Font.BOLD, 14));
		comboBoxCategory.setBounds(350, 170, 320, 30);
		add(comboBoxCategory);
		
		JLabel l5 = new JLabel("Income: ");
		l5.setFont(new Font("arial", Font.BOLD, 18));
		l5.setBounds(100, 220, 100, 30);
		add(l5);
		
		String Income[] = {"Null", "<1,00,000", "<5,00,000", "<10,00,000", "<15,00,000", "<20,00,000", ">20,00,000"};
		comboBoxIncome = new JComboBox(Income);
		comboBoxIncome.setBackground(new Color(224, 207, 225));
		comboBoxIncome.setFont(new Font("arial", Font.BOLD, 14));
		comboBoxIncome.setBounds(350, 220, 320, 30);
		add(comboBoxIncome);
		
		JLabel l6 = new JLabel("Education: ");
		l6.setFont(new Font("arial", Font.BOLD, 18));
		l6.setBounds(100, 270, 200, 30);
		add(l6);
		
		String education[] = {"10th pass", "12th pass", "Diploma",  "Graduation", "Post Graduation", "Doctorate", "Other"};
		comboBoxEducation = new JComboBox(education);
		comboBoxEducation.setBackground(new Color(224, 207, 225));
		comboBoxEducation.setFont(new Font("arial", Font.BOLD, 14));
		comboBoxEducation.setBounds(350, 270, 320, 30);
		add(comboBoxEducation);
		
		JLabel l7 = new JLabel("Occupation: ");
		l7.setFont(new Font("arial", Font.BOLD, 18));
		l7.setBounds(100, 320, 200, 30);
		add(l7);
		
		String occupation[] = {"Govt. Job", "Private Job", "Servicemen",  "Buisness", "Self-employed", "Student", "Un-employed"};
		comboBoxOccupation = new JComboBox(occupation);
		comboBoxOccupation.setBackground(new Color(224, 207, 225));
		comboBoxOccupation.setFont(new Font("arial", Font.BOLD, 14));
		comboBoxOccupation.setBounds(350, 320, 320, 30);
		add(comboBoxOccupation);
		
		JLabel l8 = new JLabel("Pan Number: *");
		l8.setFont(new Font("arial", Font.BOLD, 18));
		l8.setBounds(100, 370, 200, 30);
		add(l8);
		
		textPanNo = new JTextField();
		textPanNo.setFont(new Font("arial", Font.BOLD, 18));
		textPanNo.setBounds(350, 370, 320, 30);
		add(textPanNo);
		
		JLabel l9 = new JLabel("Aadhar Number: *");
		l9.setFont(new Font("arial", Font.BOLD, 18));
		l9.setBounds(100, 420, 200, 30);
		add(l9);
		
		textAadharNo = new JTextField();
		textAadharNo.setFont(new Font("arial", Font.BOLD, 18));
		textAadharNo.setBounds(350, 420, 400, 30);
		add(textAadharNo);
		
		JLabel l10 = new JLabel("Existing Account ? ");
		l10.setFont(new Font("arial", Font.BOLD, 18));
		l10.setBounds(100, 470, 250, 30);
		add(l10);
		
		yes = new JRadioButton("Yes");
		yes.setFont(new Font("arial", Font.BOLD, 14));
		yes.setBounds(350, 470, 80, 30);
		yes.setBackground(new Color(224, 207, 225));
		add(yes);
		
		no = new JRadioButton("No");
		no.setFont(new Font("arial", Font.BOLD, 14));
		no.setBounds(450, 470, 90, 30);
		no.setBackground(new Color(224, 207, 225));
		add(no);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(yes);
		buttonGroup.add(no);
		
		JLabel l11 = new JLabel("Existing Account no.");
		l11.setFont(new Font("arial", Font.BOLD, 18));
		l11.setBounds(100, 520, 250, 30);
		add(l11);
		
		textExistingAccountNo = new JTextField();
		textExistingAccountNo.setFont(new Font("arial", Font.BOLD, 18));
		textExistingAccountNo.setBounds(350, 520, 320, 30);
		add(textExistingAccountNo);
		
		JLabel l12 = new JLabel("Phone Number *");
		l12.setFont(new Font("arial", Font.BOLD, 18));
		l12.setBounds(100, 570, 250, 30);
		add(l12);
		
		textPhoneNo = new JTextField();
		textPhoneNo.setFont(new Font("arial", Font.BOLD, 18));
		textPhoneNo.setBounds(350, 570, 320, 30);
		add(textPhoneNo);
		
		JLabel l13 = new JLabel("Alternate Phone Number");
		l13.setFont(new Font("arial", Font.BOLD, 18));
		l13.setBounds(100, 620, 250, 30);
		add(l13);
		
		textAlternatePhoneNo = new JTextField();
		textAlternatePhoneNo.setFont(new Font("arial", Font.BOLD, 18));
		textAlternatePhoneNo.setBounds(350, 620, 320, 30);
		add(textAlternatePhoneNo);
		
		JLabel l14 = new JLabel("Form no: ");
		l14.setFont(new Font("arial", Font.BOLD, 18));
		l14.setBounds(690, 10, 90, 30);
		add(l14);
		
		JLabel l15 = new JLabel(appNo);
		l15.setFont(new Font("arial", Font.BOLD, 18));
		l15.setBounds(770, 10, 90, 30);
		add(l15);
		
		next = new JButton("Next");
		next.setFont(new Font("arial", Font.BOLD, 14));
		next.setForeground(Color.white);
		next.setBackground(Color.black);
		next.setBounds(570, 670, 100, 30);
		next.addActionListener(this);		
		add(next);
		
		setLayout(null);
		setSize(850,750);
		setLocation(450, 80);
		getContentPane().setBackground(new Color(224, 207, 225));
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String religion = (String)comboBoxReligion.getSelectedItem();
		String Category = (String)comboBoxCategory.getSelectedItem();
		String Income = (String)comboBoxIncome.getSelectedItem();
		String Education = (String)comboBoxEducation.getSelectedItem();
		String Occupation = (String)comboBoxOccupation.getSelectedItem();
		String Pan = textPanNo.getText();
		String Aadhar = textAadharNo.getText();
		
		String ExistingAccount = null;
		if(yes.isSelected()) {
			ExistingAccount = "Yes";
		}
		else if(no.isSelected()) {
			ExistingAccount = "No";
		}
	
		String ExistingAccountNo = textExistingAccountNo.getText();
		String Phone = textPhoneNo.getText();
		String AlternatePhone = textAlternatePhoneNo.getText();
		
		try {
			if(Aadhar.isEmpty() || Pan.isEmpty() || Phone.isEmpty() ) {
				JOptionPane.showMessageDialog(null, "Fill all the required fields");
			}
			else {
				ConnectingDatabase connectingDatabase2 = new ConnectingDatabase();
				String q = "Insert into signup2 values('"+appNo+"', '"+religion+"', '"+Category+"','"+Income+"','"+Education+"', '"+Occupation+"','"+Pan+"', '"+Aadhar+"', '"+ExistingAccount+"', '"+ExistingAccountNo+"', '"+Phone+"', '"+AlternatePhone+"')";
				connectingDatabase2.statement.executeUpdate(q);
				new SignUp3(appNo);
				setVisible(false);
			}
			
		} catch (Exception e3) {
			// TODO: handle exception
			e3.printStackTrace();
			JOptionPane.showMessageDialog(null, "An error occurred while submitting the form. Please try again.");
		}
	}
	
	public static void main(String[] args) {
		new SignUp2(" ");
		
	}

}
