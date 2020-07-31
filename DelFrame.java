import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class DelFrame extends JFrame
{
Container c;
JLabel lblrno;
JButton btndel , btnback;
JTextField txtrno;

DelFrame()
{
c = getContentPane();
c.setLayout(new FlowLayout());
lblrno = new JLabel("Enter rno :");
txtrno = new JTextField(10);
btndel = new JButton("Delete");
btnback = new JButton("Back");

c.add(lblrno);
c.add(txtrno);
c.add(btndel);
c.add(btnback);

ActionListener a1 = (ae) -> {
OptFrame a = new OptFrame();
dispose();
};
btnback.addActionListener(a1);

ActionListener a2 = (ae) -> {

if(txtrno.getText().length()==0)
{
	JOptionPane.showMessageDialog(new JDialog() , "Empty Field");
	txtrno.setText("");
	txtrno.requestFocus();
	return;
}

try{
int r1 = Integer.parseInt(txtrno.getText());

int output = JOptionPane.showConfirmDialog(new JDialog() , "Do you want to delete ?");
if(output == JOptionPane.YES_OPTION)
{

new music().delete();
new DbHand().deleteStudent(r1);	
txtrno.setText("");
txtrno.requestFocus();
}
}

catch(NumberFormatException nfe)
{
JOptionPane.showMessageDialog(new JDialog() , "Only  Positive Integers Allowed");
txtrno.setText("");
txtrno.requestFocus();
}
};
btndel.addActionListener(a2);

setTitle("Delete Student");
setSize(250,300);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}

