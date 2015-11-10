import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.net.*;

 

class SubscribeListener implements ActionListener
{						

	private InputStreamReader sIn = new InputStreamReader(System.in);
	private BufferedReader ServerInput = new BufferedReader(sIn);								
	private	String Username;
	private	String Password;
	private	String Nickname;
	
	public SubscribeListener(TextField fi, TextField fi2, TextField fi3)
	{
		//Converto in testo il contenuto del campo JTextField
		Username = fi.getText();
		//Converto in testo il contenuto del campo JTextField
		Password = fi2.getText();
		//Converto in testo il contenuto del campo JTextField
		Nickname = fi3.getText();
	}
	
	public void actionPerformed(ActionEvent e)
	{
		try
		{
			//Creazione socket
			Socket s = new Socket("localhost",1234);
			PrintWriter ServerOutput = new PrintWriter(s.getOutputStream());
			//Creazione Stringa di Controllo per Server
			String Controllo = "registra";
			//Invio di dati
			ServerOutput.println(Controllo);
			ServerOutput.flush();
			ServerOutput.println(Username);
			ServerOutput.flush();
			ServerOutput.println(Password);
			ServerOutput.flush();
			ServerOutput.println(Nickname);
			ServerOutput.flush();
			try
			{
			while (!(ServerInput.readLine() == "registrato" || ServerInput.readLine() == "non registrato"))
			{
			}
			if(ServerInput.readLine() == "registrato")
			{
				JOptionPane.showMessageDialog(null, "Registrazione effettuata.", "Registrazione Confermata",JOptionPane.INFORMATION_MESSAGE);
				login.main();
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Errore", "Accesso negato",JOptionPane.ERROR_MESSAGE);
				//Comando per pulire i campi
			}
			}catch(Exception ex2){}
		}
		catch(Exception ex){}
	}
}