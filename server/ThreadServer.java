import java.net.*;
import java.io.*;
import java.util.*;

class ThreadServer extends Thread
{
	Socket s;
	BufferedReader myInput = null;
	PrintWriter myOutput = null;
	controlloRegistrazione ut = null;
	controlloNoReg nr = null;
	controllaUtente cu =null;
	FileElencoAccessi fea = null;
	String messaggio=null;
	String input;
	String utente;
	String pass;
	Vector<ThreadServer> vett;
	public ThreadServer (Socket s,Vector<ThreadServer> vett)
	{
		this.s = s;
		this.vett=vett;
		this.start();
	}
	
	public void run ()
	{
		try
		{
		fea = new FileElencoAccessi();
		myInput = new BufferedReader(new InputStreamReader(s.getInputStream()));
		myOutput = new PrintWriter(s.getOutputStream());
		
		messaggio=myInput.readLine();
		myOutput.println("benvenuto");
		myOutput.flush();
		messaggio = myInput.readLine();
		utente = myInput.readLine();
		pass = myInput.readLine();
		} catch(Exception e){
		System.out.println("Errore 1");
		}
		if(messaggio.equals("registra"))
		{	
			ut = new controlloRegistrazione(utente,pass);
			if(ut.accesso()==true)
			{
				myOutput.println("non registrato");
				myOutput.flush();
			}
			else
			{
				myOutput.println("registrato");
				myOutput.flush();
				scriviRegistrazioni(utente,pass);
			}
		}
		if(messaggio.equals("login"))
		{
			cu = new controllaUtente(utente,pass);
			if(cu.accesso())
			{
				fea.scriviCon(utente);
				myOutput.println("connesso");
				myOutput.flush();
				//invio dei messaggi ad altri client
				getMsg();
			}
			else
			{
				myOutput.println("non connesso");
				myOutput.flush();
			}
			
		}
		
		if(messaggio.equals("noReg"))
		{
			nr = new controlloNoReg(utente,pass,vett); 
			if(nr.accesso()==false)
			{	
				fea.scriviCon(utente);
				myOutput.println("corretto");
				myOutput.flush();
				getMsg();
			}
			else	
			{
				myOutput.println("non corretto");
				myOutput.flush();

			}
		}
		
	}
	public void getMsg()
	{
		while(true)
				{
					try
					{
					input = myInput.readLine();
					if(!input.equals(""))
					{
						for(int i=0;i<vett.size();i++)
						{
							vett.elementAt(i).stampaMessaggio(input,utente);
						}						
					}
					}catch (Exception e){
					System.out.println("Errore 2");
					}
				}
	}
	
	public void stampaMessaggio(String input,String utente)
	{
		myOutput.println(utente + " : " + input);
		myOutput.flush();
		try
		{
		FileWriter fConv =new FileWriter ("conversazioni.txt",true);
		PrintWriter fOUT = new PrintWriter(fConv);
		GregorianCalendar gc = new GregorianCalendar();
		
			fOUT.println(gc.get(Calendar.DATE)+"-"+gc.get(Calendar.MONTH)+"-"+gc.get(Calendar.YEAR)+"  "+gc.get(Calendar.HOUR_OF_DAY)+":"+gc.get(Calendar.MINUTE)+"    "+utente+" : " +input);
			fOUT.flush();
		}
		catch(Exception e)
		{
			System.out.println("Errore nella scrittura delle conversazioni");
		}
	}

	public void scriviRegistrazioni(String user,String pass)
	{
		try
		{
		FileWriter fReg =new FileWriter("registrazioni.txt",true);
		PrintWriter fOUT = new PrintWriter(fReg);
		
			fOUT.println(user+" / "+pass+"\n");
			fOUT.flush();
		}
		catch(Exception e)
		{
			System.out.println("Errore nella scrittura della registrazione");
		}
	}
}