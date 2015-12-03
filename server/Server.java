// Opera di Zambe (Client-Server)
// Versione 1.0

import java.io.*;
import java.net.*;
import java.util.*;

public class Server
{
	public static void main(String []a)
	{	
		try
		{
			Vector<ThreadServer> vett = new Vector<ThreadServer>();
			ServerSocket ss = new ServerSocket(1234);
			Socket s = null;
			ThreadServer th = null;
			while(true)
			{
				s = ss.accept();
				System.out.println("ok");
				th = new ThreadServer(s,vett);
				vett.add(th);
			}
			
			//MyOutput.close();
			//s.close();
			
		}
		catch(Exception e) {}
	}
}