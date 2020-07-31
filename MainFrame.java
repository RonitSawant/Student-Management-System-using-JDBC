import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;
import javax.sound.sampled.*;
import java.net.URL;

class MainFrame extends JFrame
{
Container c;
JLabel lblUn , lblPw;
JButton btnsub , btnsignup;
JTextField txtUn , txtPw;

MainFrame()
{
c = getContentPane();
c.setLayout(new FlowLayout());
lblUn = new JLabel("UserName :");
txtUn = new JTextField(10);
lblPw = new JLabel("Password :");
txtPw = new JPasswordField(10);
btnsub = new JButton("Sign in");
btnsignup = new JButton("Sign up");

c.add(lblUn);
c.add(txtUn);
c.add(lblPw);
c.add(txtPw);
c.add(btnsub);
c.add(btnsignup);

ActionListener a1 = (ae) -> {
String s1 = txtUn.getText();
String s2 = txtPw.getText();

Connection con = null;
try
{
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Your username","Password");

Statement st = con.createStatement();
String sql = "select * from TABLE_NAME";
ResultSet rs = st.executeQuery(sql);

int flag=0 , i=0;
while(rs.next())
{
if(rs.getString(1).equals(s1) && rs.getString(2).equals(s2))
	flag=flag+1;
}
if(!(flag==i))
{
new music().login();
JOptionPane.showMessageDialog(c , "Login Successful");
OptFrame opt = new OptFrame();
dispose();
}
else
{
	JOptionPane.showMessageDialog(c , "Invalid Username and Password");
	txtUn.setText("");
	txtPw.setText("");
	txtUn.requestFocus();
}
rs.close();
st.close();
}
catch(SQLException e)
{
JOptionPane.showMessageDialog(new JDialog() , " ERROR!!!....While viewing data");
}

finally
{
try
{
if(con!=null)
con.close();
}
catch(SQLException e)
{
JOptionPane.showMessageDialog(new JDialog() , " ERROR!!!....In Closing Connection");
}
}
};
btnsub.addActionListener(a1);

//ACTION LISTENER FOR SIGN UP BUTTON
ActionListener a2 = (ae) -> {
SignupFrame a = new SignupFrame();
dispose();
};
btnsignup.addActionListener(a2);

setTitle("Log In");
setSize(250,300);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}


public static void main(String args[])
{
MainFrame mf = new MainFrame();
}
}


class DbHand
{
public void addStudent(int rno , String sname , int marks)
{
Connection con = null;
try{
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Your username","Password");

String sql = "Insert into table_name values(? , ? , ?)";
PreparedStatement ps = con.prepareStatement(sql);
ps.setInt(1 , rno);
ps.setString(2 , sname);
ps.setInt(3 , marks);
int result = ps.executeUpdate();
System.out.println(result + " records inserted");
new music().add();
JOptionPane.showMessageDialog(new JDialog() , "Student data Inserted");
ps.close();
}
catch(SQLException e)
{
JOptionPane.showMessageDialog(new JDialog() , " ERROR!!!....Student data already exists");
}

finally{
try{
if(con!=null)
con.close();
}
catch(SQLException e)
{
JOptionPane.showMessageDialog(new JDialog() , " ERROR!!!....In Closing Connection");
}
}
}

//VIEW STUDENT DATA
public String viewStudent()
{
Connection con = null;
StringBuffer sb = new StringBuffer();
try
{
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Your username","Password");

Statement st = con.createStatement();
String sql = "select * from table_name";
ResultSet rs = st.executeQuery(sql);

while(rs.next())
{
int rno  = rs.getInt(1);
String sname = rs.getString(2);
int marks = rs.getInt(3);
System.out.println("ROLL NO = " + rno + " SNAME = " + sname + " MARKS = " + marks );
sb.append("ROLL NO = " + rno + "     SNAME = " + sname + "     MARKS = " + marks + "\n");
}
rs.close();
st.close();
}
catch(SQLException e)
{
JOptionPane.showMessageDialog(new JDialog() , " ERROR!!!....While viewing data");
}

finally
{
try
{
if(con!=null)
con.close();
}
catch(SQLException e)
{
JOptionPane.showMessageDialog(new JDialog() , " ERROR!!!....In Closing Connection");
}
}
return sb.toString();
}

//DELETE STUDENT DATA
public void deleteStudent(int r1)
{
Connection con = null;
try{
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Your username","Password");

String sql = "delete from table_name where rno = ? ";
PreparedStatement ps = con.prepareStatement(sql);
ps.setInt(1 , r1);
int result = ps.executeUpdate();
System.out.println(result + " records deleted");
if(result == 0)
	JOptionPane.showMessageDialog(new JDialog() , "Record Does Not Exist");
else	
	JOptionPane.showMessageDialog(new JDialog() , "Student data Deleted");
ps.close();
}
catch(SQLException e)
{
JOptionPane.showMessageDialog(new JDialog() , " ERROR!!!....Student data not Deleted");
}

finally{
try{
if(con!=null)
con.close();
}
catch(SQLException e)
{
JOptionPane.showMessageDialog(new JDialog() , " ERROR!!!....In Closing Connection");
}
}
}

//UPDATE STUDENT DATA
public void updateStudent( String n1 , int m1 , int r1 )
{
Connection con = null;
try{
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Your username","Password");

String sql = "update table_name set sname = ? , marks = ? where rno = ? ";
PreparedStatement ps = con.prepareStatement(sql);
ps.setString(1 , n1);
ps.setInt(2 , m1);
ps.setInt(3 , r1);
int result = ps.executeUpdate();
System.out.println(result + " records updated");
if(result == 0)
	JOptionPane.showMessageDialog(new JDialog() , "Record Does Not Exist");
else
	JOptionPane.showMessageDialog(new JDialog() , "Student data Updated");
ps.close();
}
catch(SQLException e)
{
JOptionPane.showMessageDialog(new JDialog() , " ERROR!!!....Student data not Updated");
}

finally{
try{
if(con!=null)
con.close();
}
catch(SQLException e)
{
JOptionPane.showMessageDialog(new JDialog() , " ERROR!!!....In Closing Connection");
}
}
}

//ADD USER TO DATA
public void addUser(String username , String password )
{
Connection con = null;
try{
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Your username","Password");

String sql = "Insert into TABLE_NAME values(? , ? )";
PreparedStatement ps = con.prepareStatement(sql);
ps.setString(1 , username);
ps.setString(2 , password);
int result = ps.executeUpdate();
JOptionPane.showMessageDialog(new JDialog() , "User Added Successfully");
ps.close();
}
catch(SQLException e)
{
JOptionPane.showMessageDialog(new JDialog() , " ERROR!!!....User already exists");
}

finally{
try{
if(con!=null)
con.close();
}
catch(SQLException e)
{
JOptionPane.showMessageDialog(new JDialog() , " ERROR!!!....In Closing Connection");
}
}
}
}
















