import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;

public class Chat
{
	public static void main(String args[])
	{
		JFrame f = new JFrame("MultiChat");
			//f.setTitle();
			f.setSize(1024, 600);
			f.setLocation(100,100);
			f.setResizable(false);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		JPanel p = new JPanel();
			f.add(p);
			p.setLayout(null);
			Container c = f.getContentPane();
			c.add(p);
		

		JMenuBar mbMenu = new JMenuBar();
			f.setJMenuBar(mbMenu);
			
			JMenu file= new JMenu("Options");
			mbMenu.add(file);
			//mbMenu.setBounds(10,45,70,25);
			//p.add(mbMenu);
				JMenuItem color = new JMenuItem("Choose color");
				file.add(color);
			
				JMenuItem theme = new JMenuItem("Choose theme");
				file.add(theme);
				
				JMenuItem font = new JMenuItem("Choose font");
				file.add(font);
				
				JMenuItem nickname = new JMenuItem("Change nickname");
				file.add(nickname);
				
				JMenuItem delete = new JMenuItem("Delete chat");
				file.add(delete);
				
				file.addSeparator();
				
				JMenuItem logout = new JMenuItem("Logout");
				file.add(logout);
			
			
		/*JButton bLogout = new JButton("<html><h4><font color=#800000>Logout</font></h4></html>");
			bLogout.setBounds(10,10,70,25);
			p.add(bLogout);
			
		JButton bOptions = new JButton("<html><h4>Options</h4></html>");
			bOptions.setBounds(10,45,70,25);
			p.add(bOptions);*/
			
		JLabel lConnected = new JLabel("<html><b><h3>Connected User</h3></b></html>");
			lConnected.setBounds(40,10,180,25);
			//lConnected.setBounds(40,80,180,25);
			p.add(lConnected);
			
		JTextArea tConnectedArea = new JTextArea("");
			tConnectedArea.setBounds(25,45,150,475);
			tConnectedArea.setEditable(false);
			p.add(tConnectedArea);			
			
		JLabel lTitle = new JLabel("<html><b><h1>MultiChat</h1></b></html>");
			lTitle.setBounds(200,10,120,25);
			//lTitle.setFont(lTitle.getFont().deriveFont(23.0f));
			p.add(lTitle);
		
		JButton bAllegato = new JButton("<html><b><h3>Attached</h3></b></html>");
			bAllegato.setBounds(900,10,100,25);
			p.add(bAllegato);
			
		JTextArea tChatArea = new JTextArea("");
			tChatArea.setBounds(200,46,800,450);
			tChatArea.setEditable(false);
			p.add(tChatArea);			
			
		JButton bEmot = new JButton("<html><b><h3>Emot</h3></b></html>");
			bEmot.setBounds(200,506,75,25);
			p.add(bEmot);
			
		JTextField fChat = new JTextField(/*NOT IMPLEMENTED*/"");
			fChat.setBounds(285,506,625,25);
			//In case we want to clear the Field when mouse clicks on it
			//***NOT IMPLEMENTED BECAUSE DOES NOT WORK WITH TAB***
				/*	public void mouseClicked(MouseEvent e){fChat.setText("");}});	*/
			p.add(fChat);
			
		JButton bEnter = new JButton("<html><b><h3>Enter</h3></b></html>");
			bEnter.setBounds(925,506,75,25);
			p.add(bEnter);
			
		f.setVisible(true);
	}
}