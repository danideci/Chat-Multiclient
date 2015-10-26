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
		//dichiarazioni
		JFrame f = new JFrame("Benvenuto in the MultiChat");
			f.setSize(300, 180);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel p = new JPanel();
			f.add(p);
			p.setLayout(null);
			Container c = f.getContentPane();
			c.add(p);
		String ip;
		String port;
		//grafic server ip address
		JLabel l1 = new JLabel("IP address");
			l1.setBounds(10, 10, 80, 25);
			p.add(l1);
		
		JTextField f1 = new JTextField();		
			f1.setBounds(100, 10, 160, 25);
			p.add(f1);
		//grafic port
		JLabel l2 = new JLabel("Port");
			l2.setBounds(10, 40, 80, 25);
			p.add(l2);
			
		JTextField f2 = new JTextField();
			f2.setBounds(100, 40, 160, 25);
			p.add(f2);
		//enter button and server message
		JButton b = new JButton("Enter");
			b.setBounds(180,80,80,25);
			p.add(b);
			
		String serversays = "Please insert Server's IP and Port";
		JLabel l3 = new JLabel(serversays+"");
			l3.setBounds(10,120,250,25);
			p.add(l3);
			
			//b.addActionListener(new LoginListener(f1,f2,l3));
			
			f.setVisible(true);
	}
}