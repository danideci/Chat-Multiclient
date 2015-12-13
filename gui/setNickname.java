import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;

public class setNickname implements ActionListener, KeyListener
{
	private Socket s;
	private TextField fNick;
	private JFrame f;
	private JButton b;

	
	public setNickname(Socket s)
	{
		this.s = s;

		
		//declarations
		
		f = new JFrame("Edit your Nickname");
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
		lNick.setBounds(10, 50, 95, 25);
		p.add(lNick);
		
		//Create nickname textfield
		
		fNick = new TextField();		
		fNick.setBounds(110, 50, 160, 25);
		fNick.addKeyListener(this);
		p.add(fNick);

		//Create enter button 
		
		b = new JButton("Enter");
		b.setBounds(190,90,80,25);
		p.add(b);
			
		b.addActionListener(this);
		b.addKeyListener(this);
			
		f.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String nick = fNick.getText();
		if(!(nick.equals("")))
		{
			setNicknameListener lnickname = new setNicknameListener(nick, s, f);
		}
	}
	
	public void keyTyped(KeyEvent ek)
	{
	}
	
	public void keyReleased(KeyEvent ek)
	{
	}
	
	public void keyPressed(KeyEvent ek)
	{
		int pulsante = ek.getKeyCode();
		String nick = fNick.getText();
		
		if(pulsante==KeyEvent.VK_ENTER)
		{
			if(!(nick.equals("")))
			{
				setNicknameListener lnickname = new setNicknameListener(nick, s, f);
			}
			else
			{
				
			}
		}
	}
	
}
