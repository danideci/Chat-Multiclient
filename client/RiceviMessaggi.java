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
	private JTextArea taWrite;
	String in;
	private JTextArea taU;
	public RiceviMessaggi(Socket s, JTextArea taWrite, JTextArea taU)
	{
		this.taWrite = taWrite;
		this.s = s;
		this.taU = taU;
	}
	
	public void run()
	{
		try
		{
			InputStreamReader sIn = new InputStreamReader(s.getInputStream());					
			BufferedReader ServerInput = new BufferedReader(sIn);	
			while(true)
			{
				in = ServerInput.readLine();
				int ricezione = Integer.valueOf(in).intValue();
				switch(ricezione)
				{
					case 1:
					{
						in = ServerInput.readLine();
						String listaS = "";
						while(!(in.equals("!!!")))
						{
							
							listaS = listaS + in + "\n";
							in = ServerInput.readLine();
						}
						taU.setText(listaS);
						break;
					}	
					
					case 2:
					{
						in = ServerInput.readLine();
						taWrite.append(in+"\n");
						break;
					}
				}
			}
		}catch(Exception e){}
	}
}