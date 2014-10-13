package ee.ut.math.tvt.sonytech;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import javax.swing.*;

public class IntroUI {
	
	private JFrame frame;
	private JPanel panel;
	private JLabel header;
	Properties applicationProp;
	Properties versionProp;
	ImageIcon logo = null;
	
	public IntroUI() {
	    frame = new JFrame("Sonytech");
	    panel = new JPanel();
		header = new JLabel();
	    frame.setSize(400, 350); 
	    frame.setLocationRelativeTo(null);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setResizable(false);
	    frame.setVisible(true);

	    applicationProp = new Properties();
	    versionProp = new Properties();
		
		try {
			applicationProp.load(new FileInputStream("application.properties"));
			versionProp.load(new FileInputStream("version.properties"));
	    } catch (IOException e){
	    	e.printStackTrace();
	    }
		
		
		try {
			logo = new ImageIcon(new URL(applicationProp.getProperty("logo")));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		header.add(new JLabel(logo));
		panel.add(new JLabel("Team name: "+ applicationProp.getProperty("name")));
		panel.add(new JLabel("Team leader: "+ applicationProp.getProperty("leader")));
		panel.add(new JLabel("Team leader email: " + applicationProp.getProperty("leaderEmail")));
		panel.add(new JLabel("Team members: " + applicationProp.getProperty("members")));
	//	panel.add(new JLabel("Version: " + versionProp.getProperty("build.number")));
		
		frame.add(panel,BorderLayout.CENTER);
		frame.add(header, BorderLayout.NORTH); 
	}
}
