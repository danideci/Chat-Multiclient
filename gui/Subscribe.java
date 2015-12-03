import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;

public class Subscribe implements ActionListener
{
	public void actionPerformed(ActionEvent e) 
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

		JLabel lSub = new JLabel("Subscribe");
		lSub.setFont(lSub.getFont().deriveFont(23.0f));
		lSub.setBounds(80,10,250,25);
		p.add(lSub);

		JLabel lUser = new JLabel("Username");
		lUser.setBounds(10, 45, 80, 25);
		p.add(lUser);
		
		JTextField fUser = new JTextField();		
		fUser.setBounds(100, 45, 170, 25);
		p.add(fUser);
		
		JLabel lPass = new JLabel("Password");
		lPass.setBounds(10, 80, 60, 25);
		p.add(lPass);
		
		TextField fPass = new TextField();
        fPass.setEchoChar('*');		
		fPass.setBounds(100, 80, 170, 25);
		p.add(fPass);
		
		JLabel lConf = new JLabel("<html>Confirm<br>password</html>");
		lConf.setBounds(10, 115, 60, 30);
		p.add(lConf);
		
		TextField fConf = new TextField();
        fConf.setEchoChar('*');		
		fConf.setBounds(100, 115, 170, 25);
		p.add(fConf);
		
		JButton bSub = new JButton("Subscribe");
		bSub.setBounds(160,185,110,25);
		p.add(bSub);
		
		if(passSubscribe == confirmPassSubscribe)
		{
			//b.addActionListener(new SubscribeListener(fUser,fPass));
		}
		
		f.setVisible(true);
	}
}
			
			