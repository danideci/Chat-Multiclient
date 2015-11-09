import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;

public class editNickname
{
	public static void main(String[] args) 
	{
		
		//declarations
		
		JFrame f = new JFrame("Edit your Nickname");
			f.setSize(290, 160);
			f.setResizable(false);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel p = new JPanel();
			f.add(p);
			p.setLayout(null);
			Container c = f.getContentPane();
			c.add(p);
		String newNickname;
		
		//graphic new nickname

		JLabel l3 = new JLabel("Enter a new Nickname to display");
			l3.setBounds(10,10,250,25);
			p.add(l3);

		JLabel l1 = new JLabel("New Nickname");
			l1.setBounds(10, 50, 110, 25);
			p.add(l1);
		
		JTextField f1 = new JTextField();		
			f1.setBounds(110, 50, 160, 25);
			p.add(f1);

		//enter button 
		
		JButton b = new JButton("Enter");
			b.setBounds(190,90,80,25);
			p.add(b);
			
			//b.addActionListener(new editNicknameListener(f1));
			
			f.setVisible(true);
	}
}