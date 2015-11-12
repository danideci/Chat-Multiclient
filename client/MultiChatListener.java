import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.net.*;




class MultiChatListener implements ActionListener
{						

	private InputStreamReader sIn = new InputStreamReader(System.in);
	private BufferedReader ServerInput = new BufferedReader(sIn);								
	private	TextField IP;
	private TextField Port;
	private Label message;
	
	public MultiChatListener(TextField fi,TextField fi2,Label l3)
	{
		//Acquisisco le textfield e il label passato dalla GUI
		IP = fi;
		Port = fi2;
		message = l3;

	}
	
	public void actionPerformed(ActionEvent e)
	{
		
		try
		{
			String socketIP = IP.getText();
			int socketPort=Integer.parseInt(Port.getText());
			//Creazione socket
			Socket s = new Socket(socketIP,socketPort);
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
  
				message.setForeground(Color.RED);
				message.setText("");
				IP.setText("");
				Port.setText("");
	
			}
		}
		catch(Exception ex)
		{
			System.out.println("Errore!");
		}
	}
	

}
