import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
import java.awt.Color.*;
import javax.swing.border.*;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class ChatPrivate extends JFrame implements ActionListener, KeyListener
{
	private static final long serialVersionUID = 1L;
	private JTextArea taWrite;
	private JScrollPane spWrite;
	private JTextArea taChat;
	private JScrollPane spChat;
	private Socket s;
	private GestioneMessaggi mess;
	private String lTitle0 = "PROVAVAVAVAVAV";
	private String lTitle = "<html><h2>Private chat with: "+lTitle0;
	
	public ChatPrivate() 
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
			JMenu color = new JMenu("Choose color");
			JMenuItem color1 = new JMenuItem("Color1");
			JMenuItem color2 = new JMenuItem("Color2");
			file.add(color);
			color.add(color1);
			color.add(color2);
			
			JMenu theme = new JMenu("Choose Theme");
			JMenuItem theme1 = new JMenuItem("Theme1");
			JMenuItem theme2 = new JMenuItem("Theme2");
			file.add(theme);
			theme.add(theme1);
			theme.add(theme2);
				
			JMenuItem font = new JMenuItem("Choose font");
			file.add(font);
				
			JMenuItem nickname = new JMenuItem("Change nickname");
			file.add(nickname);
				
			JMenuItem delete = new JMenuItem("Delete chat");
			file.add(delete);
				
			file.addSeparator();
				
			JMenuItem logout = new JMenuItem("Logout");
			file.add(logout);
		
		//Create panelUser
		
		/*JPanel pUser = new JPanel();
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
        pUser.add(taUser, gbcUser);									*/
				
		//Create panelChat
		
		JPanel pChat = new JPanel();
		//pChat.setBorder(BorderFactory.createTitledBorder(eBorder));
		gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 100;
		gbc.weighty = 100;
		gbc.insets = new Insets(5,5,5,5);
        add(pChat, gbc);
		
		pChat.setLayout(new GridBagLayout());
		GridBagConstraints gbcChat = new GridBagConstraints();
		
		//Create title
		
		
		JLabel lTitle2 = new JLabel(lTitle);
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
        pChat.add(lTitle2, gbcChat);
		
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
		
		taWrite = new JTextArea("");
		spWrite = new JScrollPane(taWrite);
		spWrite.setPreferredSize(new Dimension(pChat.getWidth()*(4/6), 15));
		spWrite.setMinimumSize(new Dimension(pChat.getWidth()*(4/6), 15));
		taWrite.setLineWrap(true);
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
		
		
		RiceviMessaggi rc = new RiceviMessaggi(s,taChat);
		rc.start();
		
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String pulsante = e.getActionCommand();
		
		if(pulsante.equals("Enter"))
		{
			if(!(taWrite.getText().equals("")))
			{
				mess.sendMessage(taWrite.getText(), taWrite);
			}
			else
			{
				
			}
		}
	}
	
	
	/*public static void main(String[] args) 
	{
        javax.swing.SwingUtilities.invokeLater(new Runnable() 
		{ 
			@Override
            public void run() 
			{
                Chat chat = new Chat(null);
            }
        });
    }
	*/
	
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
			}
			else
			{
				taWrite.requestFocus();
			}
		}
	}
	
	public static void main(String[] args) 
	{
		 new ChatPrivate();
	}
}