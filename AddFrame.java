import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class AddFrame extends JFrame
{
Container c;
JLabel lblrno , lblsname , lblmarks;
JButton btnsave , btnback;
JTextField txtrno , txtsname , txtmarks;

AddFrame()
{
c = getContentPane();
c.setLayout(new FlowLayout());
lblrno = new JLabel("Enter rno :");
txtrno = new JTextField(10);
lblsname = new JLabel("Enter name :");
txtsname = new JTextField(10);
lblmarks = new JLabel("Enter marks :");
txtmarks = new JTextField(10);
btnsave = new JButton("Save");
btnback = new JButton("Back");

c.add(lblrno);
c.add(txtrno);
c.add(lblsname);
c.add(txtsname);
c.add(lblmarks);
c.add(txtmarks);
c.add(btnsave);
c.add(btnback);

ActionListener a1 = (ae) -> {
OptFrame a = new OptFrame();
dispose();
};
btnback.addActionListener(a1);

ActionListener a2 = (ae) -> {

if(txtrno.getText().length() == 0 && txtmarks.getText().length() == 0)
{
	JOptionPane.showMessageDialog(new JDialog() , "Empty Field");
	txtrno.setText("");
	txtmarks.setText("");
	txtrno.requestFocus();	
}

else{
 if(txtrno.getText().length() == 0)
{
	JOptionPane.showMessageDialog(new JDialog() , "Empty Field");
	txtrno.setText("");
	txtrno.requestFocus();
	return;
}

if(txtmarks.getText().length() == 0)
{
	JOptionPane.showMessageDialog(new JDialog() , "Empty Field");
	txtmarks.setText("");
	txtmarks.requestFocus();
	return;	
}

if(Integer.parseInt(txtrno.getText()) <=0 | Integer.parseInt(txtrno.getText()) >=1000)
{
	JOptionPane.showMessageDialog(new JDialog() , "Roll no should be within 1000");
	txtrno.setText("");
	txtrno.requestFocus();
	return;	
}

if(Integer.parseInt(txtmarks.getText()) <=0 | Integer.parseInt(txtmarks.getText()) >=100)
{
	JOptionPane.showMessageDialog(new JDialog() , "Marks should be within 100");
	txtmarks.setText("");
	txtmarks.requestFocus();
	return;	
}

}

try{
int rno = Integer.parseInt(txtrno.getText());
String sname =  txtsname.getText();
int marks =Integer.parseInt(txtmarks.getText());

if(rno < 0 && marks < 0)
{
	JOptionPane.showMessageDialog(new JDialog() , "Negative numbers not allowed");
	txtrno.setText("");
	txtmarks.setText("");
	txtrno.requestFocus();
}

else{
if(marks < 0 )
{
	JOptionPane.showMessageDialog(new JDialog() , "Negative numbers not allowed");
	txtmarks.setText("");
	txtmarks.requestFocus();
	return;
}

if(rno < 0 )
{
	JOptionPane.showMessageDialog(new JDialog() , "Negative numbers not allowed");
	txtrno.setText("");
	txtrno.requestFocus();
	return;
}
}


 if(sname.length()==0 ) 
	JOptionPane.showMessageDialog(new JDialog() , "Empty Field");
else
{
if(sname.matches("[A-Za-z]+"))
{
if(sname.length()>=2  &&  sname.length()<=20){
	marks = Integer.parseInt(txtmarks.getText());
	new DbHand().addStudent(rno , sname , marks);
	txtrno.setText("");
	txtmarks.setText("");
	txtsname.setText("");
	txtrno.requestFocus();
}
else
	JOptionPane.showMessageDialog(new JDialog() , "Plz Enter Valid name");
}
else
{
	JOptionPane.showMessageDialog(new JDialog() , "Only Strings Allowed");
	txtsname.setText("");
	txtsname.requestFocus();
}
}
}
catch(NumberFormatException nfe)
{
JOptionPane.showMessageDialog(new JDialog() , "Only  Positive Integers Allowed");
txtrno.setText("");
txtmarks.setText("");
txtrno.requestFocus();
}
};
btnsave.addActionListener(a2);

setTitle("Add Student");
setSize(250,300);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}

