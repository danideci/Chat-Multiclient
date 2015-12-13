import java.net.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GestioneMessaggi
{
	private String messaggio;
	private Socket s;
	private InputStreamReader sIn;
	private BufferedReader ServerInput;
	private PrintWriter ServerOutput;
	private JTextArea taWrite;
	
	public GestioneMessaggi(Socket s)
	{	
		this.s = s;
	}
	
	public void sendMessage(String messaggio, JTextArea taWrite)
	{
		this.messaggio=messaggio;
		this.taWrite = taWrite;
		try
		{
			//sIn = new InputStreamReader(s.getInputStream());					
			//ServerInput = new BufferedReader(sIn);		
			ServerOutput = new PrintWriter(s.getOutputStream());
			ServerOutput.println("1");
			ServerOutput.flush();
			ServerOutput.println(messaggio);
			ServerOutput.flush();
			taWrite.setText("");

		}
		catch(IOException e)
		{
			System.out.println("Errore nell invio del messaggio");
		}
	}	
}