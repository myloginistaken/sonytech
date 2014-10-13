package ee.ut.math.tvt.sonytech;

import java.awt.*;

import javax.swing.*;

import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;

public class Intro {

	public static void main(String[] args) {
					
		IntroUI introUI = new IntroUI();

		try {
			//Thread.sleep(3000);
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}

}
