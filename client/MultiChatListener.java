import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.net.*;




class MultiChatListener
{						

	
	private BufferedReader ServerInput;							
	private	TextField IP;
	private TextField Port;
	private Label message;
	private Socket s;
	private JFrame f;
	
	public MultiChatListener(TextField fi,TextField fi2,Label l3,JFrame f)
	{
		//Acquisisco le textfield e il label passato dalla GUI
		IP = fi;
		Port = fi2;
		message = l3;
		this.f=f;
		try
		{
			String socketIP = IP.getText();
			int socketPort=Integer.parseInt(Port.getText());
			//Creazione socket
			
			s = new Socket(socketIP,socketPort);
			BufferedReader ServerInput = new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintWriter ServerOutput = new PrintWriter(s.getOutputStream());
			if(ServerInput.readLine().equals("benvenuto"))
			{
				Login log = new Login(s);
				f.setVisible(false);
			}
			else
			{
				message.setForeground(Color.RED);
				message.setText("Hai sbagliato");
				IP.setText("");
				Port.setText("");
			}				
				


		}
		catch(Exception ex)
		{
			message.setForeground(Color.RED);
			message.setText("Hai sbagliato");
			IP.setText("");
			Port.setText("");
		}

	}
	
	

}
