import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;

public class Subscribe implements ActionListener
{
	private JTextField f4;
	private JTextField f1;
	private TextField f2;
	
	public Subscribe()
	{
		
		//declarations
		
		JFrame f = new JFrame("Subscribe");
		f.setSize(287, 260);
		f.setResizable(false);
		JPanel p = new JPanel();
		f.add(p);
		p.setLayout(null);
		Container c = f.getContentPane();
		c.add(p);
		
		String userSubscribe;
		String passSubscribe = null;
        String confirmPassSubscribe = null;
        String nicknameSubscribe;
		
		//grafic server ip address

		JLabel l0 = new JLabel("Subscribe");
		l0.setFont(l0.getFont().deriveFont(23.0f));
		l0.setBounds(80,10,250,25);
		p.add(l0);

		JLabel l1 = new JLabel("Username");
		l1.setBounds(10, 45, 80, 25);
		p.add(l1);
		
		f1 = new JTextField();		
		f1.setBounds(100, 45, 170, 25);
		p.add(f1);
		
		JLabel l2 = new JLabel("Password");
		l2.setBounds(10, 80, 60, 25);
		p.add(l2);
		
		f2 = new TextField();
        f2.setEchoChar('*');		
		f2.setBounds(100, 80, 170, 25);
		p.add(f2);
		
		JLabel l3 = new JLabel("<html>Confirm<br>password</html>");
		l3.setBounds(10, 115, 60, 30);
		p.add(l3);
		
		TextField f3 = new TextField();
        f3.setEchoChar('*');		
		f3.setBounds(100, 115, 170, 25);
		p.add(f3);
		
		JLabel l4 = new JLabel("Nickname");
		l4.setBounds(10, 150, 80, 25);
		p.add(l4);
		
		f4 = new JTextField();		
		f4.setBounds(100, 150, 170, 25);
		p.add(f4);
		
		JButton b = new JButton("Subscribe");
		b.setBounds(160,185,110,25);
		p.add(b);
		
		
			b.addActionListener(this);

		
		f.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String pulsante = e.getActionCommand();
		if(pulsante.equals("Subscribe"))
		{
			SubscribeListener sub = new SubscribeListener(f1,f2,f4);
		}
	}
		
}
			
			