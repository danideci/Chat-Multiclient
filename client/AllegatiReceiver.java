import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.net.Socket;

 class AllegatiReceiver 
 {
	private JFileChooser allegato;
	private InputStream inStream;
	private	InputStreamReader inReader;
	private BufferedReader inBuffer;
	private FileOutputStream outFile;
	private BufferedOutputStream outFileStream;
	private byte [] mybytearray;
	private Socket s;
	
	public AllegatiReceiver(Socket s)
	{
		this.s = s;							
	}
	
    public void actionPerformed(ActionEvent e)
	{
		try
		{
			//Creates the input stream and gets the connection
			inStream = s.getInputStream();
			inReader = new InputStreamReader(inStream);
			inBuffer = new BufferedReader(inReader);
			
			//The first thing the server sends it's the file's size
			//Creates a byte array of needed size
			int sizeOfFile = Integer.parseInt(inBuffer.readLine());
			byte [] mybytearray  = new byte [sizeOfFile];
			
			
			allegato = new JFileChooser();
			int status = allegato.showSaveDialog(null);
			if (status == JFileChooser.APPROVE_OPTION) 
			{
				//The server sends the file's bytes that will be then stored into an array
				sizeOfFile = inStream.read(mybytearray,0,mybytearray.length);
				
				//Creates the output's stream to the file
				outFile = new FileOutputStream(allegato.getSelectedFile().getName());
				outFileStream = new BufferedOutputStream(outFile);	
				
				//Write the received byte on the file
				outFile.write(mybytearray, 0 , sizeOfFile);	
				outFileStream.flush();
				
				//Closes the stream and the connection
				inBuffer.close();
				s.close();				
			}
						
		}
			  catch (Exception ex)
	  {
		  ex.printStackTrace();
	  }
	}
 }
 
 
 
 
 