import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;

public class Subscribe implements ActionListener, KeyListener
{
	private Socket s;
	private JFrame frameLog;
	private JFrame f;
	private TextField fUser;
	private TextField fPass;
	private TextField fConf;
	
	public Subscribe(Socket s, JFrame fLog)
	{
		this.s=s;
		frameLog=fLog;
		//declarations
		
		f = new JFrame("Subscribe");
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
		
		fUser = new TextField();		
		fUser.setBounds(100, 45, 170, 25);
		fUser.addKeyListener(this);
		p.add(fUser);
		
		JLabel lPass = new JLabel("Password");
		lPass.setBounds(10, 80, 60, 25);
		p.add(lPass);
		
		fPass = new TextField();
        fPass.setEchoChar('*');		
		fPass.setBounds(100, 80, 170, 25);
		fPass.addKeyListener(this);
		p.add(fPass);
		
		JLabel lConf = new JLabel("<html>Confirm<br>password</html>");
		lConf.setBounds(10, 115, 60, 30);
		p.add(lConf);
		
		fConf = new TextField();
        fConf.setEchoChar('*');		
		fConf.setBounds(100, 115, 170, 25);
		fConf.addKeyListener(this);
		p.add(fConf);
		
		JButton bSub = new JButton("Subscribe");
		bSub.setBounds(160,185,110,25);
		p.add(bSub);
		

		bSub.addActionListener(this);
		bSub.addKeyListener(this);

		
		f.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String pss = fPass.getText();
		String pss2 = fConf.getText();
		String uss = fUser.getText();
		if(pss.equals(pss2)&&!(fPass.getText().equals("")))
		{
			SubscribeListener sub = new SubscribeListener(uss,pss,s);
			if(sub.controlReg())
			{
				frameLog.setVisible(true);
				f.setVisible(false);
			}
			else
			{
				
			}
		}
		else
		{
			fPass.setText("");
			fConf.setText("");
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
		String pss = fPass.getText();
		String pss2 = fConf.getText();
		String uss = fUser.getText();
		
		if(pulsante==KeyEvent.VK_ENTER)
		{
			
			if(pss.equals(pss2)&&!(fPass.getText().equals("")))
			{
				SubscribeListener sub = new SubscribeListener(uss,pss,s);
				if(sub.controlReg())
				{
					frameLog.setVisible(true);
					f.setVisible(false);
				}
				else
				{
					
				}
			}
			else
			{
				if(fUser.getText().equals(""))
				{
					fUser.requestFocus();
				}
				else
				{
					if(fPass.getText().equals(""))
					{
						fPass.requestFocus();
					}
					else
					{
						if(fConf.getText().equals(""))
						{
							fConf.requestFocus();
						}
						else
						{
							fPass.setText("");
							fConf.setText("");
							fPass.requestFocus();
						}
					}
				}
			}
		}
	}
	
	
	
}
			
			
			