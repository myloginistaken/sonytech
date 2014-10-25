package ee.ut.math.tvt.salessystem.domain.controller.impl;

import java.util.ArrayList;
import java.util.List;

import ee.ut.math.tvt.salessystem.domain.exception.VerificationFailedException;
import ee.ut.math.tvt.salessystem.domain.controller.SalesDomainController;
import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.domain.data.StockItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


import org.apache.log4j.Logger;


/**
 * Implementation of the sales domain controller.
 */
public class SalesDomainControllerImpl implements SalesDomainController {
    
        private static final Logger log = Logger.getLogger(SalesDomainControllerImpl.class);
        public static JTextField payment = new JTextField(5);
        public static JTextField change = new JTextField(5);
        
	public void submitCurrentPurchase(List<SoldItem> goods) throws VerificationFailedException {
            
            double final_price = 0;
            
            
            for (SoldItem item : goods){
                final_price += item.getSum();

            }            
            
            log.debug("Final price: " + final_price + "\n");
            
            JPanel panel = new JPanel();
            panel.add(new JLabel("Total price: " + final_price + "\n", SwingConstants.CENTER));
            panel.add(new JLabel("Payment amount: " + "\n"));
            panel.add(payment);
            panel.add(new JLabel("Change amount: " + "\n"));
            panel.add(change);
            
            int dialogResult = JOptionPane.showConfirmDialog (null, panel, "Confirmation", JOptionPane.YES_NO_OPTION);
            if(dialogResult == JOptionPane.YES_OPTION){
                //SAVE EVERYTHING
            }
            if(dialogResult == JOptionPane.NO_OPTION){
                throw new VerificationFailedException("Canceled");
                //BACK TO PREVIOUS STATE
            }

            //throw new VerificationFailedException("Underaged!");

		
		// XXX - Save purchase
	}

	public void cancelCurrentPurchase() throws VerificationFailedException {				
		// XXX - Cancel current purchase
	}
	

	public void startNewPurchase() throws VerificationFailedException {
		// XXX - Start new purchase
	}

	public List<StockItem> loadWarehouseState() {
		// XXX mock implementation
		List<StockItem> dataset = new ArrayList<StockItem>();

		StockItem chips = new StockItem(1l, "Lays chips", "Potato chips", 11.0, 5);
		StockItem chupaChups = new StockItem(2l, "Chupa-chups", "Sweets", 8.0, 8);
	    StockItem frankfurters = new StockItem(3l, "Frankfurters", "Beer sauseges", 15.0, 12);
	    StockItem beer = new StockItem(4l, "Free Beer", "Student's delight", 0.0, 100);

		dataset.add(chips);
		dataset.add(chupaChups);
		dataset.add(frankfurters);
		dataset.add(beer);
		
		return dataset;
	}
}
