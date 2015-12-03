import java.net.Socket;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.TextField;
import javax.swing.JFrame;
import java.awt.event.*;

class LoginListener 
{
	private String getUsername;
	private String getPassword;
	private Socket s;
	private InputStreamReader sIn;
	private BufferedReader ServerInput;
	private PrintWriter ServerOutput;
	private JFrame f;
	
	public LoginListener(TextField field1, TextField field2,Socket s, JFrame f)
	{
		this.f = f;
		getUsername = field1.getText();
		getPassword = field2.getText();
		try
		{
			//Creation of the server's input stream 
			sIn = new InputStreamReader(s.getInputStream());					
			ServerInput = new BufferedReader(sIn);		
			//Creation of the output stream to the server
			ServerOutput = new PrintWriter(s.getOutputStream());
			ServerOutput.println("login");
			 ServerOutput.flush();
			 ServerOutput.println(getUsername);
			 ServerOutput.flush();
			 ServerOutput.println(getPassword);
			 ServerOutput.flush();
			 String risposta = ServerInput.readLine();
			 if(risposta.equals("connesso"))
			 {
				 Chat ch = new Chat(s);
				 FileWriter file = new FileWriter("UtentiSilenziati.txt");
				 f.setVisible(false);
			 }
			 else
			 {
				field1.setText("");
				field2.setText("");
			 }
			 
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

	}
}