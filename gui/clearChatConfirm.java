import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;

public class clearChatConfirm implements ActionListener
{
	private JTextArea taChat;
	private JFrame f;
	
	public clearChatConfirm(JTextArea taChat) 
	{
		
		this.taChat = taChat;
		//declarations
		
		f = new JFrame("Warning!");
		f.setSize(275, 130);
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		//f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel p = new JPanel();
		f.add(p);
		p.setLayout(null);
		Container c = f.getContentPane();
		c.add(p);
		
		//text
		
		JLabel lDeclare = new JLabel("<html><h3><font color='#C80A0A'><b>You are going to clear all your chat: <u><i>are you sure?</i></b></u></h3></html>");
		lDeclare.setBounds(10,10,270,40);
		p.add(lDeclare);
			
		//enter buttons 
		
		JButton bCancel = new JButton("Cancel");
		bCancel.setBounds(90,70,80,25);
		p.add(bCancel);
		bCancel.addActionListener(this);
		
		JButton bConfirm = new JButton("Confirm");
		bConfirm.setBounds(180,70,80,25);
		p.add(bConfirm);
		bConfirm.addActionListener(this);
		
		f.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String confirm = e.getActionCommand();
		String cancel = e.getActionCommand();
		
		if(confirm.equals("Confirm"))
		{
			taChat.setText("");
			f.setVisible(false);
		}
		if(cancel.equals("Cancel"))
		{				
			f.setVisible(false);
		}
	}
}