import java.net.*;
import java.io.*;
import java.util.*;

class ThreadServer extends Thread
{
	Socket s;
	BufferedReader myInput = null;
	PrintWriter myOutput = null;
	controlloRegistrazione ut = null;
	controlloRegistrazione nr = null;
	controllaUtente cu =null;
	FileElencoAccessi fea = null;
	String messaggio = null;
	String input;
	String utente;
	String pass;
	String utenteConf = "";
	Vector<ThreadServer> vett;
	int i;
	int risp1;
	private boolean control = false;
	private boolean acc = true;
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
			risp1= Integer.parseInt(messaggio);
			} catch(Exception e){
			System.out.println("Errore 1");
			}
			switch(risp1)
			{
				case 1:				//login
				{
					cu = new controllaUtente(utente,pass);
					if(cu.accesso())
					{
						
						for(int i=0;i<vett.size();i++)
						{
							if(vett.elementAt(i).utenteConf.equals(utente))
							{
								myOutput.println("non connesso");
								myOutput.flush();
								acc = false;

								
							}

							
						}
						if(acc)
						{
							utenteConf = utente;
							fea.scriviCon(utenteConf);
							myOutput.println("connesso");
							myOutput.flush();
							control = true;
						}
						acc = true;
					}
					else
					{
						myOutput.println("non connesso");
						myOutput.flush();
					}
					break;
				}
				
				
				
				case 2:			//reg
				{
					ut = new controlloRegistrazione(utente);
					if(ut.accesso())
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
					break;
				}
				
				
				
				
				case 3:    //noreg
				{
					nr = new controlloRegistrazione(utente); 
					if(nr.accesso())
					{	
						myOutput.println("non corretto");
						myOutput.flush();
						
					}
					else	
					{
						utenteConf=utente;
						fea.scriviCon(utenteConf);
						myOutput.println("corretto");
						myOutput.flush();
						control = true;

					}
					break;
				}
			}	
		}
		getMsg();
	}
	public void getMsg()
	{
		for(int m=0; m<vett.size(); m++)
		{
			vett.elementAt(m).myOutput.println("1");
			vett.elementAt(m).myOutput.flush();
			for(int k=0; k<vett.size(); k++)
			{
			
				vett.elementAt(m).myOutput.println(vett.elementAt(k).utenteConf);
				vett.elementAt(m).myOutput.flush();
			}
			vett.elementAt(m).myOutput.println("!!!");
			vett.elementAt(m).myOutput.flush();
		}
		
		
		
		while(true)
				{
					try
					{
						input = myInput.readLine();
						int risp= Integer.parseInt(input);
						switch(risp)
						{
							case 1:  //messaggio normale
							{
								input = myInput.readLine();
								try
											{
											FileWriter fConv =new FileWriter ("conversazioni.txt",true);
											PrintWriter fOUT = new PrintWriter(fConv);
											GregorianCalendar gc = new GregorianCalendar();							
											fOUT.println(gc.get(Calendar.DATE)+"-"+(gc.get(Calendar.MONTH)+1)+"-"+gc.get(Calendar.YEAR)+"  "+gc.get(Calendar.HOUR_OF_DAY)+":"+gc.get(Calendar.MINUTE)+"    "+utente+" : " +input);
											fOUT.flush();
											}
											catch(Exception e)
											{
												System.out.println("Errore nella scrittura delle conversazioni");
											}
										
										for(int i=0;i<vett.size();i++)
										{
											
											vett.elementAt(i).stampaMessaggio(input,utenteConf);
										}
								break;
							}
							case 2: //messaggio privato 
							{
								input = myInput.readLine();
								StringTokenizer st2 = new StringTokenizer(input,"+");
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
								break;
							}
							case 3 : //allegato
							{
								String nomefile = myInput.readLine();
								// send file
								File myFile = new File (nomefile);
								//Array di bytes lungo quanto il mio file
								byte [] mybytearray  = new byte [(int)myFile.length()];
								//Stream di input dl file per leggere il contenuto
								FileInputStream fis = new FileInputStream(myFile);
								BufferedInputStream bis = new BufferedInputStream(fis);
								//Leggo il contenuto e lo inserisco nell'array di byte
								bis.read(mybytearray,0,mybytearray.length);
								//creo gli stream per inviare i dati
								OutputStream out = s.getOutputStream();
								//invio il file
								out.write(mybytearray,0,mybytearray.length);
								out.flush(); // <- Forzo il trasferimento!!
								//Chiudo lo stream 				
								out.close();	
								break;
							}
							case 4 : //logout
							{
								for(i=0;i<vett.size();i++)
								{
									if(utenteConf.equals(vett.elementAt(i).utenteConf))
									{
										vett.remove(i);
										i=vett.size();
									}
								}
								fea.scriviDiscon(utente);
								for(int j=0; j<vett.size(); j++)
								{
									vett.elementAt(j).myOutput.println("1");
									vett.elementAt(j).myOutput.flush();
									for(int h=0; h<vett.size(); h++)
									{
									
										vett.elementAt(j).myOutput.println(vett.elementAt(h).utenteConf);
										vett.elementAt(j).myOutput.flush();
									}
									vett.elementAt(j).myOutput.println("!!!");
									vett.elementAt(j).myOutput.flush();
								}
								break;
							}
						}
					}
					catch (Exception e){
					System.out.println("Errore 2");
					}
				}
				
	}
	
	public void stampaMessaggio(String input,String utenteConf)
	{
		myOutput.println("2");
		myOutput.flush();
		myOutput.println(utenteConf + " : " + input);
		myOutput.flush();
		
		

	}

	public void scriviRegistrazioni(String user,String pass)
	{
		try
		{
		FileWriter fReg =new FileWriter("UtentiRegistrati.txt",true);
		PrintWriter fOUT = new PrintWriter(fReg);
		
			fOUT.print("/"+user+"+"+pass);
			fOUT.flush();
		}
		catch(Exception e)
		{
			System.out.println("Errore nella scrittura della registrazione");
		}
	}
}