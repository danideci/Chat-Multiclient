import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

class SilenziaUtenteClient
{
	private FileReader fRead;
	private FileWriter fWrite;
	private BufferedReader fIN;
	private PrintWriter pWrite;
	private String s;
	private	boolean flag;
	
	public SilenziaUtenteClient(String utente)
	{
		//Opens the txt file where the names of the silenced users are written 
		try
		{
		fWrite = new FileWriter("UtentiSilenziati.txt",true);
		fRead = new FileReader("UtentiSilenziati.txt");
		fIN = new BufferedReader(fRead);
		pWrite = new PrintWriter(fWrite);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		//Checks if the user is already silenced
		do
		{
			try
			{
				s = fIN.readLine();
				if (s.equals(utente))
				{
					flag = true;
					break;
				}
				else
					flag = false;
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		} while (s != null);
		
		if (flag == false)
		{
			try
			{
				//If the user has not been silenced before, it adds his username to the file 
				pWrite.println(utente);
				//Cleans and closes the stream 
				pWrite.flush();
				fRead.close();		
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}