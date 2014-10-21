package ee.ut.math.tvt.sonytech;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import ee.ut.math.tvt.salessystem.domain.controller.SalesDomainController;
import ee.ut.math.tvt.salessystem.domain.controller.impl.SalesDomainControllerImpl;
import ee.ut.math.tvt.salessystem.ui.ConsoleUI;
import ee.ut.math.tvt.salessystem.ui.SalesSystemUI;

public class Intro {
	
	// igaksjuhuks ei kustutanud veel Logger loggerit-t ära
	final static Logger logger = Logger.getLogger(Intro.class);
	private static final String MODE = "console";
	private static final Logger log = Logger.getLogger(Intro.class);
	
	public static void main(String[] args) {
		
		final SalesDomainController domainController = new SalesDomainControllerImpl();
		PropertyConfigurator.configure("log4j.properties");		
		//IntroUI introUI = new IntroUI();
		//introUI.logi("Ran");

		if (args.length == 1 && args[0].equals(MODE)) {
			log.debug("Mode: " + MODE);

			ConsoleUI cui = new ConsoleUI(domainController);
			cui.run();
		} else {

			// PS! kommenteerisin siit välja asjad, mis mul erroris eclipses olid
			IntroUI introUI = new IntroUI();
			//introUI.setVisible(true);
			//introUI.setAlwaysOnTop(true);

			final SalesSystemUI ui = new SalesSystemUI(domainController);
			ui.setVisible(true);

			//introUI.setAlwaysOnTop(false);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//introUI.setVisible(false);
		}
	}

}
