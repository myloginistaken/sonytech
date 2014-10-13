package ee.ut.math.tvt.sonytech;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Intro {
	
	final static Logger logger = Logger.getLogger(Intro.class);

	public static void main(String[] args) {
		
		PropertyConfigurator.configure("log4j.properties");		
		IntroUI introUI = new IntroUI();
		introUI.logi("Ran");
	}

}
