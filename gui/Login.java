import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;

public class Login implements ActionListener, KeyListener
{
	
	private Socket s;
	private JFrame f;
	private TextField fUser;
	private TextField fPass;
	
	public Login(Socket s)
	{
		
		//declarations
		
		this.s=s;
		f = new JFrame("Login");
		f.setSize(230,250);
		f.setLocation(250,250);
		f.setLocationRelativeTo(null);
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel p = new JPanel();
		f.add(p);
		p.setLayout(null);
		Container c = f.getContentPane();
		c.add(p);
		
		//Create title label
		
		JLabel lTitle = new JLabel("MultiChat");
		lTitle.setFont(lTitle.getFont().deriveFont(23.0f));
		lTitle.setBounds(57,10,250,25);
		p.add(lTitle);
		
		//Create user label
		
		JLabel lUser = new JLabel("Username");
		lUser.setBounds(10, 50, 60, 25);
		p.add(lUser);
		
		//Create user textfield
		
		fUser = new TextField();		
		fUser.setBounds(80, 50, 135, 25);
		fUser.addKeyListener(this);
		p.add(fUser);
		
		//Create password label
		
		JLabel lPass = new JLabel("Password");
		lPass.setBounds(10, 85, 60, 25);
		p.add(lPass);
		
		//Create password textfield
		
		fPass = new TextField();	
		fPass.setEchoChar('*');		
		fPass.setBounds(80, 85, 135, 25);
		fPass.addKeyListener(this);
		p.add(fPass);
		
		//Create login button
		
		JButton bLogin = new JButton("Login");
		bLogin.setBounds(133,120,80,25);
		bLogin.addKeyListener(this);
		p.add(bLogin);
		
		//Create message label
		
		String LoginMessage = "<html><i>Insert your data</i></html>";
		JLabel lMessage = new JLabel(LoginMessage);
		lMessage.setBounds(10,120,250,25);
		p.add(lMessage);
		bLogin.addActionListener(this);
		
		//Create subscribe button
		
		JButton bSub = new JButton("Subscribe");
		bSub.setText("<HTML><FONT color=\"#000099\"><U>Aren't you subscribed? Click here!</U></FONT></HTML>");
		bSub.setBounds(-18,150,250,25);
		p.add(bSub);
		bSub.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bSub.setBorderPainted(false);
		bSub.setOpaque(false);
		bSub.setBackground(Color.WHITE);
		//bSub.addActionListener(this);
		bSub.addActionListener(this);

		//Create button to enter without subscribe
		
		JButton bNoSub = new JButton("UnkownUser");
		bNoSub.setText("<HTML><FONT color=\"#000099\"><U>Enter without subscribe</A></U></FONT></HTML>");
		bNoSub.setBounds(-33,180,220,25);
		p.add(bNoSub);
		bNoSub.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bNoSub.setBorderPainted(false);
		bNoSub.setOpaque(false);
		bNoSub.setBackground(Color.WHITE);
		//bNoSub.addActionListener(this);
		bNoSub.addActionListener(this);
		
		f.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String pulsante = e.getActionCommand();
		
		if(pulsante.equals("Login"))
		{
			if(!(fUser.getText().equals("")||fPass.getText().equals("")))
			{
				LoginListener log = new LoginListener(fUser,fPass,s,f);
			}

		}
		else if(pulsante.equals("<HTML><FONT color=\"#000099\"><U>Aren't you subscribed? Click here!</U></FONT></HTML>"))
		{	
			Subscribe sub = new Subscribe(s,f);
			f.setVisible(false);

		}
		else if(pulsante.equals("<HTML><FONT color=\"#000099\"><U>Enter without subscribe</A></U></FONT></HTML>"))
		{
			setNickname unk = new setNickname(s);
			f.setVisible(false);
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
		
		if(pulsante==KeyEvent.VK_ENTER)
		{
			if (fPass.getText().equals(""))
			{
				fPass.requestFocus();
			}
			else
			{
				LoginListener log = new LoginListener(fUser,fPass,s,f);
			}
		}
	}
	
}