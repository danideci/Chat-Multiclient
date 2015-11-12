import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;

public class MultiChat
{
	public MultiChat()
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
		Label l3 = new Label(serversays+"");
			l3.setBounds(10,10,250,25);
			p.add(l3);

		Label l1 = new Label("IP address");
			l1.setBounds(10, 50, 80, 25);
			p.add(l1);
		
		TextField f1 = new TextField();		
			f1.setBounds(100, 50, 160, 25);
			p.add(f1);
		
		//grafic port
		
		Label l2 = new Label("Port");
			l2.setBounds(10, 80, 80, 25);
			p.add(l2);
			
		TextField f2 = new TextField();
			f2.setBounds(100, 80, 160, 25);
			p.add(f2);
		
		//enter button and server message
		
		Button b = new Button("Enter");
			b.setBounds(180,120,80,25);
			p.add(b);
			
			b.addActionListener(new MultiChatListener(f1,f2,l3));
			
			f.setVisible(true);
	}
	public static void main(String[] args) 
	{
		 new MultiChat();
	}
}