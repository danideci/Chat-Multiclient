import java.util.*;
import java.io.*;

class controllaUtente
{
	
	String utente;
	String pass;
	
	public controllaUtente(String utente, String pass)
	{
		this.utente = utente;
		this.pass = pass;
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
				if(ss.nextToken().equals(utente) && ss.nextToken().equals(pass))
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