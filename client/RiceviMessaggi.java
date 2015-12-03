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

public class RiceviMessaggi extends Thread
{
	Socket s;
	JTextArea taWrite;
	public RiceviMessaggi(Socket s, JTextArea taWrite)
	{
		this.taWrite = taWrite;
		this.s = s;
	}
	
	public void run()
	{
		try
		{
			InputStreamReader sIn = new InputStreamReader(s.getInputStream());					
			BufferedReader ServerInput = new BufferedReader(sIn);	
			while(true)
			{
				taWrite.append(ServerInput.readLine());
			}
		}catch(Exception e){}
	}
}