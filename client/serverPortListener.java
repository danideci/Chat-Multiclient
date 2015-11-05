import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.net.*;




class serverPortListener 
{						

	private InputStreamReader sIn = new InputStreamReader(System.in);
	private BufferedReader ServerInput = new BufferedReader(sIn);								
	private	int Port;
	private	String IP = null;
	
	public serverPortListener(JTextField fi, JTextField fi2)
	{
		//Converto in intero il contenuto del campo JTextField
		Port = Integer.parseInt(fi2.getText());
		//Converto in testo il contenuto del campo JTextField
		IP = fi.getText();
	}
	
	public void actionPerformed(ActionEvent e)
	{
		try
		{
			//Creazione socket
	
			Socket s = new Socket(IP,Port);
			PrintWriter ServerOutput = new PrintWriter(s.getOutputStream());
			ServerOutput.println(IP);
			ServerOutput.flush();	
			ServerOutput.println(Port);
			ServerOutput.flush();
		}
		catch(Exception ex){}
	}
	
	while (!(ServerInput.readLine() == "corretto" || ServerInput.readLine() == "non corretto"))

	{
  
	}
   
	if(ServerInput.readLine() == "corretto")

   	{
    
   
		 login.main();
  
	}

  	else
	{
  
	//comando per pulire i campi
	}
}
