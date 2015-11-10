import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.net.*;

//class connetti


class setNicknameListener implements ActionListener
{						

	private InputStreamReader sIn = new InputStreamReader(System.in);
	private BufferedReader ServerInput = new BufferedReader(sIn);								
	private	int Port;
	private	String IP = null;
	
	public serverPortListener(TextField fi,TextField fi2)
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
			ServerOutput.println("noReg");
			ServerOutput.flush();
			ServerOutput.println(IP);
			ServerOutput.flush();	
			ServerOutput.println(Port);
			ServerOutput.flush();
			
			while (!((ServerInput.readLine() == "corretto") || (ServerInput.readLine() == "non corretto")))
			{}
	   
			if(ServerInput.readLine() == "corretto")
			{
			
		   
				 JOptionPane.showMessageDialog(null, "Accesso alla chat.", "Accesso Confermato", JOptionPane.INFORMATION_MESSAGE);


				//comando aprire la chat
		  
			}
			else
			JOptionPane.showMessageDialog(null, "I dati inseriti non sono corretti.", "Accesso negato", JOptionPane.WARNING_MESSAGE);
				}
				catch(Exception ex){}
	}
	


	
	
}