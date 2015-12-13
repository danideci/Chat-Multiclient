import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;

public class changeFont implements ActionListener
{
	private JTextArea taChat;
	private JFrame f;
	private String newFont = "Calibri";
	public changeFont(JTextArea taChat) 
	{
		
		this.taChat = taChat;
		//declarations
		
		JFrame f = new JFrame("Edit your font");
		f.setSize(290, 160);
		f.setLocationRelativeTo(null);
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		//f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel p = new JPanel();
		f.add(p);
		p.setLayout(null);
		Container c = f.getContentPane();
		c.add(p);
		
		//Create title

		JLabel lTitle = new JLabel("Enter a font to display");
		lTitle.setBounds(10,10,250,25);
		p.add(lTitle);

		//Create font label
		
		JLabel lFont = new JLabel("Font name");
		lFont.setBounds(10, 50, 110, 25);
		p.add(lFont);
		
		//Create font textfield
		
		JTextField fFont = new JTextField();		
		fFont.setBounds(110, 50, 160, 25);
		p.add(fFont);

		//Create confirm button 
		
		JButton b = new JButton("Confirm");
		b.setBounds(190,90,80,25);
		p.add(b);
			
		//b.addActionListener(new editFontListener(f1));
			
		f.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String confirm = e.getActionCommand();
		String cancel = e.getActionCommand();
		
		if(confirm.equals("Confirm"))
		{
			taChat.setFont(new Font(newFont, Font.PLAIN, 24));
			f.setVisible(false);
		}
		/*if(cancel.equals("Cancel"))
		{				
			f.setVisible(false);
		}*/
	}
}