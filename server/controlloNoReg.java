import java.util.*;
import java.io.*;

class controlloNoReg
{
	
	String utente;
	String pass;
	Vector<ThreadServer> vett;
	public controlloNoReg(String utente, String pass,Vector<ThreadServer> vett)
	{
		this.utente = utente;
		this.pass = pass;
		this.vett=vett;
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
		
		//controllo utenti registrati
		try
		{
			lettura = fIN.readLine();
			while(lettura != null)
			{
				t = new StringTokenizer(lettura," / ");
				if(t.nextToken().equals(utente))
				{
					return true;
				}
				lettura = fIN.readLine();
			}
		}
		catch(IOException e)
		{
			
		}

		//controllo utenti connessi
		for(int i=0;i<vett.size();i++)
		{
			if(vett.elementAt(i).utente.equals(utente))
			{
				return true;
			}
		}

		return false;
	}
	
	
}