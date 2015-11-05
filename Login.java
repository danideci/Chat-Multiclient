import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;

public class Login
{
	public static void main(String args[])
	{
		//prova
		//declarations
		
		JFrame f = new JFrame("Login");
		f.setSize(230,250);
		f.setLocation(250,250);
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel p = new JPanel();
		f.add(p);
		p.setLayout(null);
		Container c = f.getContentPane();
		c.add(p);
		
		String userLogin;
		String passLogin;
		
		//setting graphics
		
		JLabel l0 = new JLabel("MultiChat");
		l0.setFont(l0.getFont().deriveFont(23.0f));
		l0.setBounds(57,10,250,25);
		p.add(l0);
		
		JLabel l1 = new JLabel("Username");
		l1.setBounds(10, 50, 80, 25);
		p.add(l1);
		
		JTextField f1 = new JTextField();		
		f1.setBounds(80, 50, 135, 25);
		p.add(f1);
		
		JLabel l2 = new JLabel("Password");
		l2.setBounds(10, 85, 60, 25);
		p.add(l2);
		
		TextField f2 = new TextField();	
		f2.setEchoChar('*');		
		f2.setBounds(80, 85, 135, 25);
		p.add(f2);
		
		JButton b = new JButton("Login");
		b.setBounds(133,120,80,25);
		p.add(b);
		//b.addActionListener(new LoginListener(f1,f2));
		
		JButton b1 = new JButton();
		b1.setText("<HTML><FONT color=\"#000099\"><U>Aren't you subscribed? Click here!</U></FONT></HTML>");
		b1.setBounds(-18,150,250,25);
		p.add(b1);
		b1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		b1.setBorderPainted(false);
		b1.setOpaque(false);
		b1.setBackground(Color.WHITE);
		b1.addActionListener(new Subscribe());

		JButton b2 = new JButton();
		b2.setText("<HTML><FONT color=\"#000099\"><U>Enter without subscribe</A></U></FONT></HTML>");
		b2.setBounds(-33,180,220,25);
		p.add(b2);
		b2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		b2.setBorderPainted(false);
		b2.setOpaque(false);
		b2.setBackground(Color.WHITE);
		b2.addActionListener(new setNickname());
		
		
		
		f.setVisible(true);
	}
}
		
