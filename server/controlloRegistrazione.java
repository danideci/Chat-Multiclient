import java.util.*;
import java.io.*;

class controlloRegistrazione
{
	
	String utente;
	
	public controlloRegistrazione(String utente)
	{
		this.utente = utente;
	}
	
	public boolean accesso()
	{
		String lettura;
		BufferedReader fIN = null;
		StringTokenizer t;
		StringTokenizer ss;
		
		try
		{
			fIN = new BufferedReader(new FileReader("UtentiRegistrati.txt"));
		}
		catch(IOException e)
		{
			System.out.println("Errore lettura utenti registrati.");
		}
		
		try
		{
			t = new StringTokenizer(fIN.readLine(),"/");
			while(t.hasMoreTokens())
			{
				
				ss = new StringTokenizer(t.nextToken(),"+");
				if(ss.nextToken().equals(utente))
				{
					return(true);
				}
			}
		}
		catch(IOException e)
		{
			
		}
		return(false);
	}
	
	
}