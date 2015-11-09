class RegisterFile
{
	String user;
	String pass;
	public RegisterFile(String user,String pass)
	{
		this.user=user;
		this.pass=pass;
	}


 	public void ScriviRegistrazioni()
	{
		FileWriter fReg =new FileWriter ("registrazioni.txt",true);
		PrintWriter fOUT = new PrintWriter(fReg);
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