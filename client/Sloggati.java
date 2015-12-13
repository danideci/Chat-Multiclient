import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
import java.awt.Color.*;
import javax.swing.border.*;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class Sloggati extends AbstractAction
{
	private Socket s;
	private JFrame f;
	private PrintWriter ouut = null;
	
	public Sloggati(Socket s)
	{
		
		super("Logout");
		try{
		this.s=s;
		this.f=f;
		ouut = new PrintWriter(s.getOutputStream());
		}catch(Exception e){}
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		ouut.println("4");
	}
}