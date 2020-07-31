import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class SignupFrame extends JFrame
{
Container c;
JLabel lblun , lblpw , lblcpw;
JButton btnok ;
JTextField txtun , txtpw ;

SignupFrame()
{
c = getContentPane(); 
c.setLayout(new FlowLayout());
lblun = new JLabel("Enter username:");
txtun = new JTextField(10);
lblpw = new JLabel("Enter Password:");
txtpw = new JPasswordField(12);
btnok = new JButton("OK");

c.add(lblun);
c.add(txtun);
c.add(lblpw);
c.add(txtpw);
c.add(btnok);

ActionListener a2 = (ae) -> {
if(txtun.getText().length() == 0 && txtpw.getText().length() == 0)
{
	JOptionPane.showMessageDialog(new JDialog() , "Empty Field");
	txtun.setText("");
	txtpw.setText("");
	txtun.requestFocus();	
}

else{
 if(txtun.getText().length() == 0)
{
	JOptionPane.showMessageDialog(new JDialog() , "Empty Field");
	txtun.setText("");
	txtun.requestFocus();
	return;
}

if(txtpw.getText().length() == 0)
{
	JOptionPane.showMessageDialog(new JDialog() , "Empty Field");
	txtpw.setText("");
	txtpw.requestFocus();
	return;	
}

}

try{
if(txtun.getText().matches("[A-Za-z]+"))
{
if(txtun.getText().length()>=2 && txtun.getText().length()<=20)
{ }
else
	JOptionPane.showMessageDialog(new JDialog() , "Plz Enter Valid name");
}
else
{
	JOptionPane.showMessageDialog(new JDialog() , "Only Strings Allowed");
	txtun.setText("");
	txtun.requestFocus();
}

if(txtpw.getText().matches("[A-Za-z]+"))
{
if(txtpw.getText().length()>=2 && txtpw.getText().length()<=20)
{
String un = txtun.getText();
String pw = txtpw.getText();
new DbHand().addUser(un , pw);
MainFrame a = new MainFrame();
dispose();
}
else{
	JOptionPane.showMessageDialog(new JDialog() , "Increase password length");
	txtpw.setText("");
	txtpw.requestFocus();
}
}
else
{
	JOptionPane.showMessageDialog(new JDialog() , "Only Strings Allowed");
	txtpw.setText("");
	txtpw.requestFocus();
}
}

catch(NumberFormatException e)
{
JOptionPane.showMessageDialog(new JDialog() , "Only Strings Allowed");
txtun.setText("");
txtpw.setText("");
txtun.requestFocus();
}
};
btnok.addActionListener(a2);
setTitle("Sign Up");
setSize(300,300);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}