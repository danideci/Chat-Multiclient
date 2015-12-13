import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
import java.awt.Color.*;
import javax.swing.border.*;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class Chat extends JFrame implements ActionListener, KeyListener, MouseListener
{
	private static final long serialVersionUID = 1L;
	private JTextArea taWrite;
	private JScrollPane spWrite;
	private JTextArea taChat;
	private JScrollPane spChat;
	private Socket s;
	private GestioneMessaggi mess;
	private String strMessage;
	
	public Chat(Socket s) 
	{
		this.s=s;
		mess = new GestioneMessaggi(s);
		setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
		Border eBorder = BorderFactory.createEtchedBorder();
		
		//Create MenuBar
		
		JMenuBar mbMenu = new JMenuBar();
		setJMenuBar(mbMenu);
			
		JMenu file= new JMenu("Options");
		mbMenu.add(file);
			JMenu fontcolor = new JMenu("Choose font color");
			JMenuItem colorfontRED = new JMenuItem("<html>Font color: <font color='red'>RED</font></html>");
			JMenuItem colorfontYELLOW = new JMenuItem("<html>Font color: <font color='yellow'>YELLOW</font></html>");
			JMenuItem colorfontGREEN = new JMenuItem("<html>Font color: <font color='green'>GREEN</font></html>");
			JMenuItem colorfontBLUE	= new JMenuItem("<html>Font color: <font color='blue'>BLUE</font></html>");
			JMenuItem colorfontPINK = new JMenuItem("<html>Font color: <font color='#FFC7D5'>PINK</font></html>");
			JMenuItem colorfontWHITE = new JMenuItem("<html>Font color: <font color='white'>WHITE</font></html>");
			JMenuItem colorfontGRAY = new JMenuItem("<html>Font color: <font color='gray'>GRAY</font></html>");
			JMenuItem colorfontBLACK = new JMenuItem("<html>Font color: <font color='black'>BLACK</font></html>");
			
			JMenu bgcolor = new JMenu("Choose background color");
			JMenuItem colorbgRED = new JMenuItem("Background color: RED");
			JMenuItem colorbgYELLOW = new JMenuItem("Background color: YELLOW");
			JMenuItem colorbgGREEN = new JMenuItem("Background color: GREEN");
			JMenuItem colorbgBLUE = new JMenuItem("Background color: BLUE");
			JMenuItem colorbgPINK = new JMenuItem("Background color: PINK");
			JMenuItem colorbgWHITE = new JMenuItem("Background color: WHITE");
			JMenuItem colorbgGRAY = new JMenuItem("Background color: GRAY");
			JMenuItem colorbgBLACK = new JMenuItem("Background color: BLACK");
			
			colorfontRED.addActionListener(this);
			colorfontYELLOW.addActionListener(this);
			colorfontGREEN.addActionListener(this);
			colorfontBLUE.addActionListener(this);
			colorfontPINK.addActionListener(this);
			colorfontWHITE.addActionListener(this);
			colorfontGRAY.addActionListener(this);
			colorfontBLACK.addActionListener(this);
			
			colorbgRED.addActionListener(this);
			colorbgYELLOW.addActionListener(this);
			colorbgGREEN.addActionListener(this);
			colorbgBLUE.addActionListener(this);
			colorbgPINK.addActionListener(this);
			colorbgWHITE.addActionListener(this);
			colorbgGRAY.addActionListener(this);
			colorbgBLACK.addActionListener(this);
			
			colorbgRED.setBackground(Color.red);
			colorbgYELLOW.setBackground(Color.yellow);
			colorbgGREEN.setBackground(Color.green);
			colorbgBLUE.setBackground(Color.blue);		colorbgBLUE.setForeground(Color.white);
			colorbgPINK.setBackground(Color.pink);
			colorbgWHITE.setBackground(Color.white);
			colorbgGRAY.setBackground(Color.gray);
			colorbgBLACK.setBackground(Color.black);	colorbgBLACK.setForeground(Color.white);
			
			file.add(fontcolor);
			fontcolor.add(colorfontRED);
			fontcolor.add(colorfontYELLOW);
			fontcolor.add(colorfontGREEN);
			fontcolor.add(colorfontBLUE);
			fontcolor.add(colorfontPINK);
			fontcolor.add(colorfontWHITE);
			fontcolor.add(colorfontGRAY);
			fontcolor.add(colorfontBLACK);
			
			file.add(bgcolor);
			bgcolor.add(colorbgRED);
			bgcolor.add(colorbgYELLOW);
			bgcolor.add(colorbgGREEN);
			bgcolor.add(colorbgBLUE);
			bgcolor.add(colorbgPINK);
			bgcolor.add(colorbgWHITE);
			bgcolor.add(colorbgGRAY);
			bgcolor.add(colorbgBLACK);
			
			
			JMenu theme = new JMenu("Choose Theme");
			JMenuItem themelight = new JMenuItem("Theme light");
			JMenuItem themedark = new JMenuItem("Theme dark");
			themelight.addActionListener(this);	themelight.setBackground(Color.white);	themelight.setForeground(Color.black);
			themedark.addActionListener(this);	themedark.setBackground(Color.black);	themedark.setForeground(Color.white);
			file.add(theme);
			theme.add(themelight);
			theme.add(themedark);
				
			JMenu fontface = new JMenu("Change font style");
			JMenuItem fontsystemdefault = new JMenuItem("System default");
			JMenuItem fontsystemtnr = new JMenuItem("<html><font face='Times New Roman'>Times New Roman</font></html>");
			JMenuItem fontsystemarial = new JMenuItem("<html><font face='Arial'>Arial</font></html>");
			JMenuItem fontsystemcsms = new JMenuItem("<html><font face='Comic Sans MS'>Comic Sans MS</font></html>");
			JMenuItem fontsystempapyrus = new JMenuItem("<html><font face='Papyrus'>Papyrus</font></html>");
			JMenuItem fontsystemcourier = new JMenuItem("<html><font face='Courier'>Courier</font></html>");
			fontface.addActionListener(this);
			fontsystemdefault.addActionListener(this);
			fontsystemtnr.addActionListener(this);
			fontsystemarial.addActionListener(this);
			fontsystemcsms.addActionListener(this);
			fontsystempapyrus.addActionListener(this);
			fontsystemcourier.addActionListener(this);
			file.add(fontface);
			fontface.add(fontsystemdefault);
			fontface.add(fontsystemtnr);
			fontface.add(fontsystemarial);
			fontface.add(fontsystemcsms);
			fontface.add(fontsystempapyrus);
			fontface.add(fontsystemcourier);
			
			JMenu fontsize = new JMenu("Change font size");
			JMenuItem fontsizes = new JMenuItem("<html><h4>Small</h4></html>");
			JMenuItem fontsizen = new JMenuItem("<html><h3>Normal</h3></html>");
			JMenuItem fontsizem = new JMenuItem("<html><h2>Medium</h2></html>");
			JMenuItem fontsizeb = new JMenuItem("<html><h1>Big</h1></html>");
			fontsize.addActionListener(this);
			fontsizes.addActionListener(this);
			fontsizen.addActionListener(this);
			fontsizem.addActionListener(this);
			fontsizeb.addActionListener(this);
			file.add(fontsize);
			fontsize.add(fontsizes);
			fontsize.add(fontsizen);
			fontsize.add(fontsizem);
			fontsize.add(fontsizeb);
			
			JMenuItem delete = new JMenuItem("Clear chat");
			delete.addActionListener(this);
			file.add(delete);
				
			file.addSeparator();
				
			//JMenuItem logout = new JMenuItem("<html><font color='#C80A0A'>Logout</font></html>");
			JMenuItem logout = new JMenuItem("Logout");
			logout.addActionListener(this);
			file.add(logout);
		
		//Create panelUser
		
		JPanel pUser = new JPanel();
		//pUser.setBorder(BorderFactory.createTitledBorder(eBorder));
        gbc.gridx = 0;
		gbc.gridy = 0;
        gbc.gridwidth = 1;
		gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.weightx = 10;
		gbc.weighty = 100;
		gbc.insets = new Insets(5,5,5,5);
		//1_nord
		//2_ovest
		//3_sud
		//4_est
        add(pUser, gbc);
		
		pUser.setLayout(new GridBagLayout());
		GridBagConstraints gbcUser = new GridBagConstraints();
		
		//Create JLabel Connected User
	
		JLabel lConnected = new JLabel("<html><font size='5'>Connected User</font></html>");
		//lConnected.setBorder(BorderFactory.createTitledBorder(eBorder));
		gbcUser.gridx = 0;
		gbcUser.gridy = 0;
		gbc.gridwidth = 1;
        gbc.gridheight = 1;
		gbcUser.fill = GridBagConstraints.BOTH;
        gbcUser.anchor = GridBagConstraints.NORTHWEST;
        gbcUser.weightx = 100;
		gbcUser.weighty = 4;
		gbcUser.insets = new Insets(5,5,5,5);
        pUser.add(lConnected, gbcUser);
		
		//Create JTextArea Connected User
		
		JTextArea taUser = new JTextArea();
		//taUser.setBorder(BorderFactory.createTitledBorder(eBorder));
        gbcUser.gridx = 0;
        gbcUser.gridy = 1;
        gbcUser.weightx = 100;
		gbcUser.weighty = 96;
		taUser.setEditable(false);
		gbcUser.insets = new Insets(5,5,5,5);
        pUser.add(taUser, gbcUser);
				
		//Create panelChat
		
		JPanel pChat = new JPanel();
		//pChat.setBorder(BorderFactory.createTitledBorder(eBorder));
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 90;
		gbc.weighty = 100;
		gbc.insets = new Insets(5,5,5,5);
        add(pChat, gbc);
		
		pChat.setLayout(new GridBagLayout());
		GridBagConstraints gbcChat = new GridBagConstraints();
		
		//Create title
		
		JLabel lTitle = new JLabel("<html><font size='5'>MultiChat</font></html>");
		//lTitle.setBorder(BorderFactory.createTitledBorder(eBorder));
		gbcChat.gridx = 0;
		gbcChat.gridy = 0;
		gbcChat.gridwidth = 2;
        gbcChat.gridheight = 1;
		gbcChat.fill = GridBagConstraints.BOTH;
        gbcChat.anchor = GridBagConstraints.NORTHWEST;
		gbcChat.weightx = 90;
		gbcChat.weighty = 4;
		gbcChat.insets = new Insets(5,5,5,5);
        pChat.add(lTitle, gbcChat);
		
		//Create attached button
		
		JButton bAttached = new JButton("Attached");
		//bAttached.setBorder(BorderFactory.createTitledBorder(eBorder));
		bAttached.setMaximumSize(new Dimension(150,100));
		gbcChat.gridx = 2;
		gbcChat.gridy = 0;
		gbcChat.gridwidth = 1;
        gbcChat.gridheight = 1;
        gbcChat.weightx = 10;
		gbcChat.weighty = 4;
		gbcChat.insets = new Insets(5,5,5,5);
		bAttached.addActionListener(this);
        pChat.add(bAttached, gbcChat);
		
		//Create chat area
		
		taChat = new JTextArea("");
		spChat = new JScrollPane(taChat);
		spChat.setPreferredSize(new Dimension(pChat.getWidth(), 15));
		spChat.setMinimumSize(new Dimension(pChat.getWidth(), 15));
		taChat.setLineWrap(true);
		//taChat.setBorder(BorderFactory.createTitledBorder(eBorder));
		gbcChat.gridx = 0;
		gbcChat.gridy = 1;
		gbcChat.gridwidth = 3;
        gbcChat.gridheight = 1;
        gbcChat.weightx = 100;
		gbcChat.weighty = 89;
		gbcChat.insets = new Insets(5,5,5,5);
		taChat.setEditable(false);
        pChat.add(spChat, gbcChat);
		
		//Create emot button
		
		JButton bEmot = new JButton("Emot");
		//bEmot.setBorder(BorderFactory.createTitledBorder(eBorder));
		//bEmot.setPreferredSize(new Dimension(pChat.getWidth()/6, 15));
		//bEmot.setMinimumSize(new Dimension(pChat.getWidth()/6, 15));
/*
		strMessage = strMessage.replaceAll(":°)", Pianto.png);
		strMessage = strMessage.replaceAll(":0", Spavento.png);
		strMessage = strMessage.replaceAll(":)", Felice.png);
		strMessage = strMessage.replaceAll(":q", Ohh.png);
		strMessage = strMessage.replaceAll("b1", Figo.png);
		strMessage = strMessage.replaceAll(">:|", Ira.png);
		strMessage = strMessage.replaceAll(":|", Rabbia.png);
		strMessage = strMessage.replaceAll(";)", Occhiolino.png);
		strMessage = strMessage.replaceAll("<3", Amore.png);
		strMessage = strMessage.replaceAll("8p", Stupido.png);
		strMessage = strMessage.replaceAll(":]", Sorriso.png);
		strMessage = strMessage.replaceAll(":d", Denti.png);
		strMessage = strMessage.replaceAll(":p", Lingua.png);
		strMessage = strMessage.replaceAll(":>", Emozione.png);
		strMessage = strMessage.replaceAll(":(", Triste.png);
		strMessage = strMessage.replaceAll("8)", Strabico.png);
		strMessage = strMessage.replaceAll("&)", Confuso.png);
		strMessage = strMessage.replaceAll(":v", Scocciato.png);
		strMessage = strMessage.replaceAll(":*", Labbra.png);
		strMessage = strMessage.replaceAll(":x", Muto.png);
		strMessage = strMessage.replaceAll("<*", Party.png);
		strMessage = strMessage.replaceAll("->", Militare.png);
		strMessage = strMessage.replaceAll("8.", Secchione.png);
		strMessage = strMessage.replaceAll("<>", Diavolo.png);
		strMessage = strMessage.replaceAll("><", Angelo.png);
		strMessage = strMessage.replaceAll("*:", Bacio.png);
		strMessage = strMessage.replaceAll("$$", Soldi.png);
		strMessage = strMessage.replaceAll("@:", Sudore.png);
		strMessage = strMessage.replaceAll("#?", Musica.png);
		strMessage = strMessage.replaceAll("8o", Urla.png);
*/

		bEmot.setMaximumSize(new Dimension(150,100));
		gbcChat.gridx = 0;
		gbcChat.gridy = 2;
		gbcChat.gridwidth = 1;
        gbcChat.gridheight = 1;
        gbcChat.weightx = 10;
		gbcChat.weighty = 7;
		gbcChat.insets = new Insets(5,5,5,5);
		pChat.add(bEmot, gbcChat);
		
		//Create field of writing 
		
		taWrite = new JTextArea("Write...");
		spWrite = new JScrollPane(taWrite);
		spWrite.setPreferredSize(new Dimension(pChat.getWidth()*(4/6), 15));
		spWrite.setMinimumSize(new Dimension(pChat.getWidth()*(4/6), 15));
		taWrite.setLineWrap(true);
		taWrite.addMouseListener(this);
		//taWrite.setLineWrapWord(true);
		//spWrite.setBorder(BorderFactory.createTitledBorder(eBorder));
		gbcChat.gridx = 1;
		gbcChat.gridy = 2;
		gbcChat.gridwidth = 1;
        gbcChat.gridheight = 1;
        gbcChat.weightx = 80;
		gbcChat.weighty = 7;
		gbcChat.insets = new Insets(5,5,5,5);
		taWrite.addKeyListener(this);
        pChat.add(spWrite, gbcChat);
		
		//Create enter button
		
		JButton bEnter = new JButton("Enter");
		//bEnter.setPreferredSize(new Dimension(pChat.getWidth()/6, 15));
		//bEnter.setMinimumSize(new Dimension(pChat.getWidth()/6, 15));
		//bEnter.setBorder(BorderFactory.createTitledBorder(eBorder));
		bEnter.setMaximumSize(new Dimension(150,100));
		bEnter.addActionListener(this);
		gbcChat.gridx = 2;
		gbcChat.gridy = 2;
		gbcChat.gridwidth = 1;
        gbcChat.gridheight = 1;
        gbcChat.weightx = 10;
		gbcChat.weighty = 7;
		gbcChat.insets = new Insets(5,5,5,5);
        pChat.add(bEnter, gbcChat);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(1280, 720));
		setMaximumSize(new Dimension(1920, 1080));
		setMinimumSize(new Dimension(640, 480));
		setVisible(true);
        pack();
		
		
		RiceviMessaggi rc = new RiceviMessaggi(s,taChat,taUser);
		rc.start();
		
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String pulsante = e.getActionCommand();
		String clear = e.getActionCommand();
		String theme = e.getActionCommand();
		String fontclr = e.getActionCommand();
		String bgchat = e.getActionCommand();
		String cngfont = e.getActionCommand();
		String fontsz = e.getActionCommand();
		String attached = e.getActionCommand();
		String logout = e.getActionCommand();
		if(pulsante.equals("Enter"))
		{
			if(!(taWrite.getText().equals("")))
			{
				mess.sendMessage(taWrite.getText(), taWrite);
				//taChat.setText("\n");
			}
		}
		
		if(fontclr.equals("<html>Font color: <font color='red'>RED</font></html>"))
		{taChat.setForeground(Color.red);}	
		if(fontclr.equals("<html>Font color: <font color='yellow'>YELLOW</font></html>"))
		{taChat.setForeground(Color.yellow);}	
		if(fontclr.equals("<html>Font color: <font color='green'>GREEN</font></html>"))
		{taChat.setForeground(Color.green);}	
		if(fontclr.equals("<html>Font color: <font color='blue'>BLUE</font></html>"))
		{taChat.setForeground(Color.blue);}	
		if(fontclr.equals("<html>Font color: <font color='#FFC7D5'>PINK</font></html>"))
		{taChat.setForeground(Color.pink);}	
		if(fontclr.equals("<html>Font color: <font color='white'>WHITE</font></html>"))
		{taChat.setForeground(Color.white);}	
		if(fontclr.equals("<html>Font color: <font color='gray'>GRAY</font></html>"))
		{taChat.setForeground(Color.gray);}	
		if(fontclr.equals("<html>Font color: <font color='black'>BLACK</font></html>"))
		{taChat.setForeground(Color.black);}	
	
		if(bgchat.equals("Background color: RED"))
		{taChat.setBackground(Color.red);}	
		if(bgchat.equals("Background color: YELLOW"))
		{taChat.setBackground(Color.yellow);}	
		if(bgchat.equals("Background color: GREEN"))
		{taChat.setBackground(Color.green);}	
		if(bgchat.equals("Background color: BLUE"))
		{taChat.setBackground(Color.blue);}	
		if(bgchat.equals("Background color: PINK"))
		{taChat.setBackground(Color.pink);}	
		if(bgchat.equals("Background color: WHITE"))
		{taChat.setBackground(Color.white);}	
		if(bgchat.equals("Background color: GRAY"))
		{taChat.setBackground(Color.gray);}	
		if(bgchat.equals("Background color: BLACK"))
		{taChat.setBackground(Color.black);}	
		
		if(theme.equals("Theme light"))
		{
			taChat.setBackground(Color.white);
			taChat.setForeground(Color.black);
			//taUser.setBackground(Color.white);
			//taUser.setForeground(Color.black);
		}	
		if(theme.equals("Theme dark"))
		{
			taChat.setBackground(Color.black);
			taChat.setForeground(Color.white);
			//taUser.setBackground(Color.black);
			//taUser.setForeground(Color.white);
		}	
		/*if(cngfont.equals("Change font"))
		{
			changeFont cgFont = new changeFont(taChat);
		}*/
		
		if(cngfont.equals("System default"))
		{taChat.setFont(new Font(null, Font.ITALIC, 15));}
		if(cngfont.equals("<html><font face='Times New Roman'>Times New Roman</font></html>"))
		{taChat.setFont(new Font("Times New Roman", Font.ITALIC,15));}
		if(cngfont.equals("<html><font face='Arial'>Arial</font></html>"))
		{taChat.setFont(new Font("Arial", Font.ITALIC, 15));}
		if(cngfont.equals("<html><font face='Comic Sans MS'>Comic Sans MS</font></html>"))
		{taChat.setFont(new Font("Comic Sans MS", Font.ITALIC, 15));}
		if(cngfont.equals("<html><font face='Papyrus'>Papyrus</font></html>"))
		{taChat.setFont(new Font("Papyrus", Font.ITALIC, 15));}
		if(cngfont.equals("<html><font face='Courier'>Courier</font></html>"))
		{taChat.setFont(new Font("Courier New", Font.ITALIC, 15));}
	
		if(fontsz.equals("<html><h4>Small</h4></html>"))
		{taChat.setFont(new Font(null,Font.ITALIC, 12));}
		if(fontsz.equals("<html><h3>Normal</h3></html>"))
		{taChat.setFont(new Font(null,Font.ITALIC, 15));}
		if(fontsz.equals("<html><h2>Medium</h2></html>"))
		{taChat.setFont(new Font(null,Font.ITALIC, 20));}
		if(fontsz.equals("<html><h1>Big</h1></html>"))
		{taChat.setFont(new Font(null,Font.ITALIC, 26));}
		
		if(clear.equals("Clear chat"))
		{
			clearChatConfirm clChat = new clearChatConfirm(taChat);
		}
		if(attached.equals("Attached"))
		{
			PublicAllegati pAtt = new PublicAllegati(s);
		}	
		if(logout.equals("Logout"))
		{
			Sloggati slog = new Sloggati(s);
			System.exit(0);
		}
		
	}
	
	public void keyTyped(KeyEvent ek) 
	{
		
	}
	public void keyReleased(KeyEvent ek) 
	{
		
	}
	
	public void keyPressed(KeyEvent ek)
	{
		int pulsante = ek.getKeyCode();
		
		if(pulsante==KeyEvent.VK_ENTER)
		{
			if (!(taWrite.getText().equals("")))
			{
				mess.sendMessage(taWrite.getText(), taWrite);
				taWrite.setText("");
			}
			else
			{
				
			}
		}
	}
	
	public void mouseClicked(MouseEvent e)
	{
		if (taWrite.getText().equals("Write..."))
		{
			taWrite.setText("");
		}
	}
	public void mouseExited(MouseEvent arg0) {}
	public void mouseEntered(MouseEvent arg0) {}
	public void mousePressed(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {}
}