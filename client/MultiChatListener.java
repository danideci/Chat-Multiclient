import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.net.*;




class MultiChatListener implements ActionListener
{						

	private InputStreamReader sIn = new InputStreamReader(System.in);
	private BufferedReader ServerInput = new BufferedReader(sIn);								
	private	int Port;
	private	String IP = null;
	
	public MultiChatListener(JTextField fi, JTextField fi2)
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

			while (!(ServerInput.readLine() == "corretto" || ServerInput.readLine() == "non corretto"))

			{
}
   
			if(ServerInput.readLine() == "corretto")

   			{
    
   
				 Login.main(null);
  
			}

  			else
			{
  
				//comando per pulire i campi
	
			}
		}
		catch(Exception ex){}
	}
	

}
