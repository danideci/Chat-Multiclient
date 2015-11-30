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
	int i;
	private boolean control = false;
	public ThreadServer (Socket s,Vector<ThreadServer> vett)
	{
		this.s = s;
		this.vett=vett;
		this.start();
	}
	
	public void run ()
	{
		try{
		myInput = new BufferedReader(new InputStreamReader(s.getInputStream()));
		myOutput = new PrintWriter(s.getOutputStream());
		
		myOutput.println("benvenuto");
		myOutput.flush();
		
		fea = new FileElencoAccessi();
		}catch(Exception e){}
		
		while(!control)
		{
			try
			{

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
					control = true;
					myOutput.println("****user "+utente + " si è connesso");
					myOutput.flush();
					myOutput.println(utente + " si è connesso");
					myOutput.flush();
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
					control = true;
					myOutput.println("****user "+utente + " si è connesso");
					myOutput.flush();
					myOutput.println(utente + " si è connesso");
					myOutput.flush();
				}
				else	
				{
					myOutput.println("non corretto");
					myOutput.flush();
					
				}
			}

		}
		getMsg();
	}
	public void getMsg()
	{
		while(true)
				{
					try
					{
					input = myInput.readLine();
					StringTokenizer st2= new StringTokenizer(input,"+");
					if(st2.nextToken().equals("@"))  //Stringa da decidere
					{
						String controllo;
						String mexPriv;
						controllo = st2.nextToken();    //utente a cui mandare il messaggio
						mexPriv = st2.nextToken();
						for(i=0;i<vett.size();i++)
						{
							if(controllo.equals(vett.elementAt(i).utente))
							{
								vett.elementAt(i).stampaMessaggio(mexPriv,utente);
							}
						}
					}
					else if(st2.nextToken().equals("logout")) //Stringa da decidere 
						{
						  for(int i=0;i<vett.size();i++)
							{
								this.logout(utente);
							}	
						}
					else if(st2.nextToken().equals("cambiaNome"))
					{
						//Implementazione
						
					}
					
					else if(!input.equals(""))
						{
							for(int i=0;i<vett.size();i++)
							{
								vett.elementAt(i).stampaMessaggio(input,utente);
							}						
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
	public void logout(String utente)
	{
		myOutput.println("****user "+utente + " si è disconnesso");
		myOutput.flush();
		myOutput.println(utente + "si è disconnesso");
		myOutput.flush();
	}
}