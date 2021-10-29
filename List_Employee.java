import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class List_Employee extends JFrame implements ActionListener {
    JTable j1;
    JButton b1;
    String h[] = {"Emp id","Name","Gender","Address","State","City","Email id","Phone"};
    String d[][] = new String[20][8];//2D array
int i = 0,j=0;
List_Employee(){
    super("View Employees");
    setSize(100,400);
    setLocation(450,200);
    try{
        String q= "select * from employee";
        conn c1 = new conn();
        ResultSet rs = c1.s.executeQuery(q);
        while(rs.next()){
            //Here i=0 & j=0
            d[i][j++]= rs.getString("id");
            d[i][j++]= rs.getString("name");
            d[i][j++]= rs.getString("gender");
            d[i][j++]= rs.getString("address");
            d[i][j++]= rs.getString("state");
            d[i][j++]= rs.getString("city");
            d[i][j++]= rs.getString("email");
            d[i][j++]= rs.getString("phone");
         i++;
         j=0;
        }
        j1 = new JTable(d,h);//2D array then 1d array
    }catch(Exception e){}
    
    b1 = new JButton("Print");
    add(b1,"South");
    JScrollPane s1 = new JScrollPane(j1);//For ScrollBar
    add(s1);
    b1.addActionListener(this);
    
}
public void actionPerformed(ActionEvent ae){
    try{
        j1.print();
    }catch(Exception e){}
}
public static void main(String[] args){
    new List_Employee().setVisible(true);
}
}
