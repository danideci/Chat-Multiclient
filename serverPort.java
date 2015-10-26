import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;

public class serverPort
{
	public static void main(String[] args) 
	{
		//declarations
		
		JFrame f = new JFrame("Welcome in MultiChat");
			f.setSize(280, 190);
			f.setResizable(false);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel p = new JPanel();
			f.add(p);
			p.setLayout(null);
			Container c = f.getContentPane();
			c.add(p);
		String ip;
		String port;
		
		//graphic server ip address

		String serversays = "Please insert Server's IP and Port";
		JLabel l3 = new JLabel(serversays+"");
			l3.setBounds(10,10,250,25);
			p.add(l3);

		JLabel l1 = new JLabel("IP address");
			l1.setBounds(10, 50, 80, 25);
			p.add(l1);
		
		JTextField f1 = new JTextField();		
			f1.setBounds(100, 50, 160, 25);
			p.add(f1);
		
		//grafic port
		
		JLabel l2 = new JLabel("Port");
			l2.setBounds(10, 80, 80, 25);
			p.add(l2);
			
		JTextField f2 = new JTextField();
			f2.setBounds(100, 80, 160, 25);
			p.add(f2);
		
		//enter button and server message
		
		JButton b = new JButton("Enter");
			b.setBounds(180,120,80,25);
			p.add(b);
			
			//b.addActionListener(new serverPortListener(f1,f2,l3));
			
			f.setVisible(true);
	}
}
