import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class OptFrame extends JFrame
{
Container c;
JButton btnAdd , btnView , btnUp , btnDel , btnLo ;

OptFrame()
{
c = getContentPane();
c.setLayout(new FlowLayout());
btnAdd = new JButton("Add"); 
btnView = new JButton("View");
btnUp = new JButton("Update");
btnDel = new JButton("Delete");
btnLo = new JButton("Log Out"); 

c.add(btnAdd);
c.add(btnView);
c.add(btnUp);
c.add(btnDel);
c.add(btnLo);

ActionListener a1 = (ae) -> {
AddFrame a = new AddFrame();
dispose();
};
btnAdd.addActionListener(a1);		//Add action listener

ActionListener a2 = (ae) -> {
System.exit(1);
dispose();
};
btnLo.addActionListener(a2);		//Logout action listener

ActionListener a3 = (ae) -> {
ViewFrame a = new ViewFrame();
dispose();
};
btnView.addActionListener(a3);		//View action listener

ActionListener a4 = (ae) -> {
DelFrame a = new DelFrame();
dispose();
};
btnDel.addActionListener(a4);		//Delete action listener

ActionListener a5 = (ae) -> {
UpdateFrame a = new UpdateFrame();
dispose();
};
btnUp.addActionListener(a5);		//Update action listener

setTitle("Options");
setSize(250,300);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}