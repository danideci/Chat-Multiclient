import java.io.File;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

 class PrivateAllegati
 {
	private JFileChooser allegato;
	private FileInputStream inFile;
	private BufferedInputStream inFileStream;
	private OutputStream outStream;
	private PrintWriter ServerOutput;
	private byte [] mybytearray;
	private String username;
	private File f;
	
	public PrivateAllegati(Socket s, String username)
	{
		this.username = username;
		
		try 
		{
			//Creates the output's streams to the server
			outStream = s.getOutputStream();
			ServerOutput = new PrintWriter(s.getOutputStream());
			
			allegato = new JFileChooser();
			setFilters();
			int status = allegato.showOpenDialog(null);
			if (status == JFileChooser.APPROVE_OPTION) 
			{
			  f = allegato.getSelectedFile();
			  //Creates a byte array of size dependant to size of the file to send
			  mybytearray = new byte [(int)f.length()];
			  
			  //Creates the input's streams from the file
			  inFile = new FileInputStream(f);
			  inFileStream = new BufferedInputStream(inFile);
			  
			  //Saves the file's bytes into the array
			  inFileStream.read(mybytearray,0,mybytearray.length);
			}			
		} 
      catch (Exception ex) 
	  {
		  ex.printStackTrace();
	  }
	  
	  try
	  {
		 //This code is to make the server know that a file is going to be sent
		 ServerOutput.println("3");
		 ServerOutput.flush();
		  
		 //Sends to the server the name of the user to send the file to and file's size
		 ServerOutput.println(username);
		 ServerOutput.println((int)(f.length()));
		 
		 //Cleans and closes the stream
		 ServerOutput.flush(); 
		 ServerOutput.close();		 
		 
		 //Sends to the server the file's bytes 
		 outStream.write(mybytearray,0,mybytearray.length);
		 
		 //Cleans and closes the stream 
		 outStream.flush();
		 outStream.close();
	  }
	  catch (Exception ex)
	  {
		  ex.printStackTrace();
	  }
	}

      
  private void setFilters()
  {
	 FileFilter filtro;
	 //This method is used to set the filters when searching for the file to send in the user's computer
     filtro = new FileNameExtensionFilter("File TXT", "txt");
     allegato.addChoosableFileFilter(filtro);
     filtro = new FileNameExtensionFilter("File JPG", "jpg");
     allegato.addChoosableFileFilter(filtro);
	 filtro = new FileNameExtensionFilter("File MP4", "mp4");
     allegato.addChoosableFileFilter(filtro);
  }
 }