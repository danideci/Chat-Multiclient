import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.net.*;

 

class SubscribeListener
{												
	private	String user;
	private	String pass;
	private Socket s;
	private PrintWriter out;
	private BufferedReader in;
	
	public SubscribeListener(String user, String pass, Socket s)
	{
		this.user=user;
		this.pass=pass;
		this.s=s;
		try
		{
			out = new PrintWriter(s.getOutputStream());
			in = new BufferedReader(new InputStreamReader(s.getInputStream()));
		}
		catch(Exception e){}
	}
	public boolean controlReg()
	{
			out.println("2");
			out.flush();
			out.println(user);
			out.flush();
			out.println(pass);
			out.flush();
			String ing = null;
			try
			{
				ing = in.readLine();
			}
			catch(Exception exxx){}

			if(ing.equals("registrato"))
			{
				return(true);
			}
			else
			{
				return(false);
			}

	}
}