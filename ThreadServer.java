import java.net.*;
import java.io.*;
import java.util.*;

class ThreadServer implements Runnable
{
	Socket s;
	BufferedReader myInput = null;
	PrintWriter myOutput = null;
	controllaUtente ut = null;
	public ThreadServer (Socket s,Vector<ThreadServer> vett)
	{
		this.s = s;
		this.vett=vett();
		this.start();
		
	}
	
	public void run ()
	{
		myInput = new BufferedReader(new InputStreamReader(s.getInputStream()));
		myOutput = new PrintWriter(s.getOutputStream());
		String input;
		String messaggio=myInput.readLine();
		String utente = myInput.readLine();
		String pass = myInput.readLine();
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
				scriviRegistrazioni(user,pass);
			}
		}
		if(messaggio.equals("login"))
		{
			ut = new controllaUtente(utente,pass);
			if(ut.accesso() == true)
			{
				myOutput.println("connesso");
				myOutput.flush();
				//invio dei messaggi ad altri client
				getMsg();
			}
			else()
			{
				myOutput.println("non connesso");
				myOutput.flush();
			}
			
		}
		
		if(messaggio.equals("noReg"))
		{
			ut = new controlloNoReg(utente,pass); 
			if(ut.accesso()==true)
			{	
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
					input = myInput.ReadLine();
					if(!input.equals(""))
					{
						for(i=0;i<vett.size();i++)
						{
							vett[i].stampaMessaggio(input,utente);
						}						
					}
				}
	}
	
	public void stampaMessaggio(String input,String utente)
	{
		myOutput.println(utente + " : " + input);
		myOutput.flush();
	}

	public void scriviRegistrazioni(String user,String pass)
	{
		FileWriter fReg =new FileWriter fReg("registrazioni.txt",true);
		PrintWriter fOUT = new PrintWriter(f);
		try
		{
			fOUT.println(user+" / "+pass+"\n");
			fOUT.flush();
		}
		catch(Exception e)
		{
			System.out.println("Errore nella scrittura della registrazione");
		}
	}
}