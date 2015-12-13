import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
import java.util.*;

class setNicknameListener
{						

	private	String user = null;
	private Socket s;
	private BufferedReader in = null;
	private PrintWriter out = null;
	private JFrame f;
	
	public setNicknameListener(String user, Socket s, JFrame f)
	{
		this.user = user;
		this.s = s;
		this.f=f;
		
		try
		{
			in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			out = new PrintWriter(s.getOutputStream());
			
			out.println("3");
			out.flush();
			out.println(user);
			out.flush();	
			out.println("password");
			out.flush();	
	   
			if(in.readLine().equals("corretto"))
			{
			
				Chat ch = new Chat(s);
				f.setVisible(false);
		  
			}
	
		}
		catch(Exception ex){}
	}
	


	
	
}