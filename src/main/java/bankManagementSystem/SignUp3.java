package bankManagementSystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Random;

import javax.swing.*;

public class SignUp3 extends JFrame implements ActionListener{
	
	JRadioButton radioSaving, radioFixedDeposit, radioCurrent, radioDeposited; 
	
	JCheckBox checkboxAtmCard, checkboxInternetBanking, checkboxMobileBanking, checkboxEmailAlert, checkboxChequeBook, checkboxEStatement,checkboxDeclaration ;
	String appNo;
	JButton buttonSubmit, buttonCancel;
	SignUp3(String appNo){
		
		this.appNo = appNo;
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images/bankLogo.png"));
		Image i2 = i1.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(150,0,100, 100);
		add(image);
		
		JLabel l1 = new JLabel("Page 3 ");
		l1.setBounds(280, 40, 400, 40);
		l1.setFont(new Font("arial", Font.BOLD, 22));
		add(l1);
		
		JLabel l2 = new JLabel("Account Details ");
		l2.setBounds(280, 70, 400, 40);
		l2.setFont(new Font("arial", Font.BOLD, 22));
		add(l2); 
		
		JLabel l3 = new JLabel("Account type ");
		l3.setBounds(100, 140, 400, 40);
		l3.setFont(new Font("arial", Font.BOLD, 18));
		add(l3); 
		
		radioSaving = new JRadioButton("Saving Account");
		radioSaving.setFont(new Font("arial", Font.BOLD, 14));
		radioSaving.setBounds(100, 180, 150, 30);
		radioSaving.setBackground(new Color(224, 207, 225));
		add(radioSaving);
		
		radioFixedDeposit = new JRadioButton("Fixed Deposit");
		radioFixedDeposit.setFont(new Font("arial", Font.BOLD, 14));
		radioFixedDeposit.setBounds(350, 180, 200, 30);
		radioFixedDeposit.setBackground(new Color(224, 207, 225));
		add(radioFixedDeposit);
		
		radioCurrent = new JRadioButton("Current Account");
		radioCurrent.setFont(new Font("arial", Font.BOLD, 14));
		radioCurrent.setBounds(100, 220, 200, 30);
		radioCurrent.setBackground(new Color(224, 207, 225));
		add(radioCurrent);
		
		radioDeposited = new JRadioButton("Recurring Deposit Account");
		radioDeposited.setFont(new Font("arial", Font.BOLD, 14));
		radioDeposited.setBounds(350, 220, 300, 30);
		radioDeposited.setBackground(new Color(224, 207, 225));
		add(radioDeposited);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(radioSaving);
		buttonGroup.add(radioFixedDeposit);
		buttonGroup.add(radioCurrent);
		buttonGroup.add(radioDeposited);
		
		JLabel l4 = new JLabel("Card Number: ");
		l4.setBounds(100, 300, 200, 30);
		l4.setFont(new Font("arial", Font.BOLD, 18));
		add(l4); 
		
		JLabel l5 = new JLabel("(Your 16-digit Card Number) ");
		l5.setBounds(100, 330, 200, 20);
		l5.setFont(new Font("arial", Font.BOLD, 12));
		add(l5);
		
		JLabel l6 = new JLabel("XXXX-XXXX-XXXX-1234");
		l6.setBounds(330, 300, 300, 30);
		l6.setFont(new Font("arial", Font.BOLD, 18));
		add(l6);
		
		JLabel l7 = new JLabel("(atm card/ cheque book/ statement) ");
		l7.setBounds(330, 330, 500, 20);
		l7.setFont(new Font("arial", Font.BOLD, 12));
		add(l7);
		
		JLabel l8 = new JLabel("PIN: ");
		l8.setBounds(100, 370, 500, 20);
		l8.setFont(new Font("arial", Font.BOLD, 18));
		add(l8);
		
		JLabel l9 = new JLabel("XXXX");
		l9.setBounds(330, 370, 200, 30);
		l9.setFont(new Font("arial", Font.BOLD, 18));
		add(l9);
		
		JLabel l10 = new JLabel("(Your 4-digit  Pin) ");
		l10.setBounds(100, 400, 200, 20);
		l10.setFont(new Font("arial", Font.BOLD, 12));
		add(l10);
		
		JLabel l11 = new JLabel("Services Required: ");
		l11.setBounds(100, 450, 500, 20);
		l11.setFont(new Font("arial", Font.BOLD, 18));
		add(l11);
		
		checkboxAtmCard = new JCheckBox("ATM Card");
		checkboxAtmCard.setBackground(new Color(224, 207, 225));
		checkboxAtmCard.setFont(new Font("arial", Font.BOLD, 16));
		checkboxAtmCard.setBounds(100, 490, 200, 30);
		add(checkboxAtmCard);
		
		checkboxInternetBanking = new JCheckBox("Internet Banking");
		checkboxInternetBanking.setBackground(new Color(224, 207, 225));
		checkboxInternetBanking.setFont(new Font("arial", Font.BOLD, 16));
		checkboxInternetBanking.setBounds(350, 490, 200, 30);
		add(checkboxInternetBanking);
		
		checkboxMobileBanking = new JCheckBox("Mobile Banking");
		checkboxMobileBanking.setBackground(new Color(224, 207, 225));
		checkboxMobileBanking.setFont(new Font("arial", Font.BOLD, 16));
		checkboxMobileBanking.setBounds(100, 540, 200, 30);
		add(checkboxMobileBanking);
		
		checkboxEmailAlert = new JCheckBox("Email Alert");
		checkboxEmailAlert.setBackground(new Color(224, 207, 225));
		checkboxEmailAlert.setFont(new Font("arial", Font.BOLD, 16));
		checkboxEmailAlert.setBounds(350, 540, 200, 30);
		add(checkboxEmailAlert);
		
		checkboxChequeBook = new JCheckBox("Cheque Book");
		checkboxChequeBook.setBackground(new Color(224, 207, 225));
		checkboxChequeBook.setFont(new Font("arial", Font.BOLD, 16));
		checkboxChequeBook.setBounds(100, 590, 200, 30);
		add(checkboxChequeBook);
		
		checkboxEStatement = new JCheckBox("E - Statement");
		checkboxEStatement.setBackground(new Color(224, 207, 225));
		checkboxEStatement.setFont(new Font("arial", Font.BOLD, 16));
		checkboxEStatement.setBounds(350, 590, 200, 30);
		add(checkboxEStatement);
		
		checkboxDeclaration = new JCheckBox("I, hereby declare that all the information submitted by me in the application form is correct, true and valid.", true);
		checkboxDeclaration.setBackground(new Color(224, 207, 225));
		checkboxDeclaration.setFont(new Font("arial", Font.BOLD, 12));
		checkboxDeclaration.setBounds(80, 635, 700, 20);
		add(checkboxDeclaration);
		
		JLabel l12 = new JLabel("Form no: ");
		l12.setFont(new Font("arial", Font.BOLD, 18));
		l12.setBounds(690, 10, 90, 30);
		add(l12);
		
		JLabel l13 = new JLabel(appNo);
		l13.setFont(new Font("arial", Font.BOLD, 18));
		l13.setBounds(770, 10, 90, 30);
		add(l13);
		
		buttonSubmit = new JButton("Submit");
		buttonSubmit.setFont(new Font("arial", Font.BOLD, 14));
		buttonSubmit.setBackground(Color.black);
		buttonSubmit.setForeground(Color.white);
		buttonSubmit.setBounds(250, 690, 100, 30);
		buttonSubmit.addActionListener(this);
		add(buttonSubmit);
		
		buttonCancel = new JButton("Cancel");
		buttonCancel.setFont(new Font("arial", Font.BOLD, 14));
		buttonCancel.setBackground(Color.black);
		buttonCancel.setForeground(Color.white);
		buttonCancel.setBounds(420, 690, 100, 30);
		buttonCancel.addActionListener(this);
		add(buttonCancel);
		
		setLayout(null);
		setSize(850,780);
		setLocation(450, 80);
		getContentPane().setBackground(new Color(224, 207, 225));
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String AccountType = null;
		
		if(radioSaving.isSelected()) {
			AccountType = "Saving Account";
		}
		else if(radioFixedDeposit.isSelected())
		{
			AccountType = "Fixed Deposit";
		}
		else if(radioCurrent.isSelected())
		{
			AccountType = "Current Account";
		}
		else if(radioDeposited.isSelected())
		{
			AccountType = "Recurring Deposit Account";
		}
		
		Random ran = new Random();
		long CardNo = (ran.nextLong() % 90000000L) + 1409963000000000L;
		String cardNo = ""+ Math.abs(CardNo);
		
		long PinNo = (ran.nextLong() % 9000L) + 1000L;
		String pinNo = ""+ Math.abs(PinNo);
		
		String facility = "";
		if(checkboxAtmCard.isSelected())
		{
			facility += "ATM Card";
		}
		else if(checkboxInternetBanking.isSelected())
		{
			facility += "InternetBanking";
		}
		else if(checkboxMobileBanking.isSelected())
		{
			facility += "MobileBanking";
		}
		else if(checkboxEmailAlert.isSelected())
		{
			facility += "Email Alert";
		}
		else if(checkboxChequeBook.isSelected())
		{
			facility += "Cheque Book";
		}
		else if(checkboxEStatement.isSelected())
		{
			facility += "E - Statement";
		}
		
		try {
			  if(e.getSource()==buttonSubmit) {
				  if (AccountType.isEmpty() || facility.isEmpty())
				  {
					  JOptionPane.showMessageDialog(null, "Fill all the fields");
				  }
				  else {
					  ConnectingDatabase cp1 = new ConnectingDatabase();
					  String q1 = "Insert into signup3 values('"+appNo+"', '"+AccountType+"', '"+cardNo+"','"+pinNo+"', '"+facility+"')";
					  String q2 = "Insert into loginDetails values('"+appNo+"', '"+cardNo+"', '"+pinNo+"')";
					  
					  cp1.statement.execute(q1);
					  cp1.statement.execute(q2);
					  JOptionPane.showMessageDialog(null, "Card Number: "+ cardNo +"\nPin: " + pinNo);
					  new Deposit(pinNo);
					  setVisible(false);
				  }
			  }
			  else if(e.getSource()==buttonCancel)
			  {
				  System.exit(0);
			  }
		}
			
//		} catch (Exception e4) {
//			// TODO: handle exception
//			e4.printStackTrace();
//			JOptionPane.showMessageDialog(null, "An error occurred while submitting the form. Please try again.");
//		}
		
		catch (SQLException sqle) {
		    sqle.printStackTrace();
		    JOptionPane.showMessageDialog(null, "An error occurred while submitting the form. Please try again.");
		} catch (Exception ex) {
		    ex.printStackTrace();
		    JOptionPane.showMessageDialog(null, "An unexpected error occurred. Please try again.");
		}
	}
	
	public static void main(String[] args) {
		
		new SignUp3(" ");
	}

}
