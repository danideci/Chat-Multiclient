import java.net.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class LoginListener  
{
	private String getUsername;
	private String getPassword;
	private Socket s;
	private InputStreamReader sIn;
	private BufferedReader ServerInput;
	private PrintWriter ServerOutput;
	
	public LoginListener(TextField field1, TextField field2)
	{
		getUsername = field1.getText();
		getPassword = field2.getText();
		try
		{
			//Creation of the Socket to communicate with the server
			s = new Socket("LocalHost",1234);
		}
		catch (Exception e)
		{
			System.out.println("Errore nella creazione del socket");
		}
		try
		{
			//Creation of the server's input stream 
			sIn = new InputStreamReader(s.getInputStream());					
			ServerInput = new BufferedReader(sIn);		
			//Creation of the output stream to the server
			ServerOutput = new PrintWriter(s.getOutputStream());
		}
		catch(IOException e)
		{
			System.out.println("Errore nella creazione degli stream");
		}

	}
	
	public void actionPerformed(ActionEvent e)
	 {
		 ServerOutput.println("login");
		 ServerOutput.flush();
		 ServerOutput.println(getUsername);
		 ServerOutput.flush();
		 ServerOutput.println(getPassword);
		 ServerOutput.flush();
		 //Until the server sends the reply message, the client will enter an infinite cycle
		 try
		 {
			 while ( !(ServerInput.readLine() == "connesso" || ServerInput.readLine() == "non connesso") )
			 {}
		 		 if (ServerInput.readLine() == "connesso")
				{
					JOptionPane.showMessageDialog(null, "Autenticazione effettuata. Accesso alla chat.", "Accesso Confermato", JOptionPane.INFORMATION_MESSAGE);
					//Comando apertura interfaccia chat
				}
				 else
				{
					 JOptionPane.showMessageDialog(null, "Autenticazione fallita. I dati inseriti non sono corretti.", "Accesso negato", JOptionPane.WARNING_MESSAGE);
					 //Comando per ripulire i campi
				}
		 }
		 catch(IOException ex) 
		 {}

	 }
}