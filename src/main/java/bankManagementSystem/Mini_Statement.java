package bankManagementSystem;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.*;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Mini_Statement extends JFrame implements ActionListener{
	
	JLabel labelTotalBalance, labelTransactions, top11;
	
	String pinNo;
	
	JButton buttonBack;
	
//	String accNo = null;
	
	Mini_Statement(String pinNo){
		
		this.pinNo = pinNo;
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1550, 830,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,1540, 830);
		add(image);
		
		JLabel top1 = new JLabel("MINI STATEMENT:");
	    top1.setFont(new Font("System", Font.BOLD,16));
	    top1.setForeground(Color.white);
	    top1.setBounds(300,170,400,35);
	    image.add(top1);
	    
	    top11 = new JLabel();
	    top11.setFont(new Font("System", Font.BOLD,13));
	    top11.setForeground(Color.white);
	    top11.setBounds(300,190,400,35);
	    image.add(top11);
	    
//	    JLabel top2 = new JLabel();
//	    top2.setFont(new Font("System", Font.BOLD,15));
//	    top2.setBounds(150,20,200,20);
//	    top1.setForeground(Color.white);
//	    image.add(top2);
	    
	    labelTransactions = new JLabel();
        labelTransactions.setFont(new Font("System", Font.PLAIN, 12));
        labelTransactions.setBounds(300, 110, 400, 400);
        labelTransactions.setForeground(Color.white);
        image.add(labelTransactions);

        labelTotalBalance = new JLabel();
        labelTotalBalance.setBounds(300,410,400,20);
        labelTotalBalance.setFont(new Font("System", Font.BOLD, 15));
        labelTotalBalance.setForeground(Color.white);
        image.add(labelTotalBalance);
		
		buttonBack = new JButton("BACK");
		buttonBack.setBounds(738, 445, 150, 33);
		buttonBack.setBackground(new Color(65,125,128));
		buttonBack.setForeground(Color.white);
		buttonBack.addActionListener(this);
		image.add(buttonBack);
		
		try {
			 int balance =0;
	            ConnectingDatabase c = new ConnectingDatabase();
	            ResultSet resultSet = c.statement.executeQuery("select * from loginDetails where Pin = '"+pinNo+"'");
	            while (resultSet.next()){
	                top11.setText("Card Number: XXXXXXXXXXXX" + resultSet.getString("Card_no").substring(12,16));
	            }
		} catch (Exception e2) {
			e2.printStackTrace();
			
		}
		
		setLayout(null);
		setSize(1570, 1000);
		setLocation(0, 0);
		setVisible(true);
		
		displayMiniStatement();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource()==buttonBack) {
			new Main_class(pinNo);
			setVisible(false);
		}	
		
	}
	
	private void displayMiniStatement() {
        try {
            int balance = 0;
            ConnectingDatabase c = new ConnectingDatabase();
            String query = "SELECT * FROM bank WHERE Pin_no = ? ORDER BY Date DESC LIMIT 5";
            PreparedStatement statement = c.connection.prepareStatement(query);
            statement.setString(1, pinNo);
            ResultSet resultSet = statement.executeQuery();

            StringBuilder statementHtml = new StringBuilder("<html>");
            while (resultSet.next()) {
            	String date = resultSet.getString("Date");
                String type = resultSet.getString("Type");
                String amount = resultSet.getString("Amount");

                statementHtml.append("<tr>")
                             .append("<td>").append(date).append("</td>")
                             .append("<td>").append(type).append("</td>")
                             .append("<td>").append(amount).append("</td>")
                             .append("</tr>");

                if (type.equals("deposit")) {
                    balance += Integer.parseInt(amount);
                } else {
                    balance -= Integer.parseInt(amount);
                }
            }
            statementHtml.append("</table></html>");
            labelTransactions.setText(statementHtml.toString());
            labelTotalBalance.setText("Your Total Balance is Rs " + balance);

            resultSet.close();
            statement.close();
            c.connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	public static void main(String[] args) {
		
		new Mini_Statement("");
	}

}
