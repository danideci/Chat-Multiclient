import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;

public class setNickname implements ActionListener
{
	public void actionPerformed(ActionEvent e)  
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
		
		//Create title

		JLabel lTitle = new JLabel("Enter a Nickname to display");
		lTitle.setBounds(10,10,250,25);
		p.add(lTitle);

		//Create nickname label
		
		JLabel lNick = new JLabel("Nickname");
		lNick.setBounds(10, 50, 110, 25);
		p.add(lNick);
		
		//Create nickname textfield
		
		JTextField fNick = new JTextField();		
		fNick.setBounds(110, 50, 160, 25);
		p.add(fNick);

		//Create enter button 
		
		JButton b = new JButton("Enter");
		b.setBounds(190,90,80,25);
		p.add(b);
			
		//b.addActionListener(new editNicknameListener(f1));
			
		f.setVisible(true);
	}
}
