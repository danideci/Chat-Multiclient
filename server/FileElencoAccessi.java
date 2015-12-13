import java.net.*;
import java.io.*;
import java.util.*;


class FileElencoAccessi
{
	String utente;
	
	public FileElencoAccessi(){}
	
	public void scriviCon(String utente)
	{
		try
		{
			this.utente=utente;
			FileWriter fAcc =new FileWriter ("accessi.txt",true);
			PrintWriter fOUT = new PrintWriter(fAcc);
			GregorianCalendar gc = new GregorianCalendar();
		
			fOUT.println(gc.get(Calendar.DATE)+"-"+gc.get(Calendar.MONTH)+"-"+gc.get(Calendar.YEAR)+"  "+gc.get(Calendar.HOUR_OF_DAY)+":"+gc.get(Calendar.MINUTE)+"    "+utente+" ha effettuato l'accesso");
			fOUT.flush();
		}
		catch(Exception e)
		{
			System.out.println("Errore nella scrittura della registrazione");
		}
		
	}
	
	public void scriviDiscon(String utente)
	{
		
		this.utente= utente;
		try
		{
			FileWriter fAcc =new FileWriter ("accessi.txt",true);
			PrintWriter fOUT = new PrintWriter(fAcc);
			GregorianCalendar gc = new GregorianCalendar();
		
			fOUT.println(gc.get(Calendar.DATE)+"-"+gc.get(Calendar.MONTH)+"-"+gc.get(Calendar.YEAR)+"  "+gc.get(Calendar.HOUR_OF_DAY)+":"+gc.get(Calendar.MINUTE)+"    "+utente+" si è disconnesso");
			fOUT.flush();
		}
		catch(Exception e)
		{
			System.out.println("Errore nella scrittura della registrazione");
		}
		
	}
}