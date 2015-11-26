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
			lettura = fIN.readLine();
			while(lettura != null)
			{
				t = new StringTokenizer(lettura," / ");
				if(t.nextToken().equals(utente) && t.nextToken().equals(pass))
				{
					return(true);
				}
				else
				{
				lettura = fIN.readLine();
				}
			}
		}
		catch(IOException e)
		{
			
		}
		return(false);
	}
	
	
}