import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ViewFrame extends JFrame
{
Container c;
JTextArea taData;
JButton btnback;

ViewFrame()
{
c = getContentPane();
c.setLayout(new FlowLayout());
taData = new JTextArea(8 , 30);
btnback = new JButton("Back");

c.add(taData);
c.add(btnback);

String data = new DbHand().viewStudent();
taData.setText(data);
taData.setEditable(false);

ActionListener a1 = (ae) -> {
OptFrame a = new OptFrame();
dispose();
};
btnback.addActionListener(a1);

setTitle("View Student");
setSize(350,300);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}

