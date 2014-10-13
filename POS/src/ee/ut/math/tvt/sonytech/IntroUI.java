package ee.ut.math.tvt.sonytech;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import javax.imageio.ImageIO;

import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class IntroUI {
	
	private JFrame frame;
	private JPanel panel;
	Properties applicationProp;
	Properties versionProp;
	ImageIcon logo = null;
	
	public IntroUI() {
		
	    static Logger logger = Logger.getLogger(IntroUI.class);
		
	    frame = new JFrame("Sonytech");
	    panel = new JPanel();
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setResizable(false);

	    applicationProp = new Properties();
	    versionProp = new Properties();
		
		try {
			applicationProp.load(new FileInputStream("application.properties"));
			versionProp.load(new FileInputStream("version.properties"));
	    } catch (IOException e){
	    	e.printStackTrace();
	    }
		
		
		logo = new ImageIcon(applicationProp.getProperty("logo"));
		
		panel.add(new JLabel(logo));
		panel.add(new JLabel("Team name: "+ applicationProp.getProperty("name")));
		panel.add(new JLabel("Team leader: "+ applicationProp.getProperty("leader")));
		panel.add(new JLabel("Team leader email: " + applicationProp.getProperty("leaderEmail")));
		panel.add(new JLabel("Team members: " + applicationProp.getProperty("members")));
	//	panel.add(new JLabel("Version: " + versionProp.getProperty("build.number")));
		
		frame.add(panel,BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
	}
	
	public void logi(String string) {
		logger.info("Ran!");
		
	}
}
