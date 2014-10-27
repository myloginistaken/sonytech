package ee.ut.math.tvt.salessystem.domain.controller.impl;

import java.awt.event.KeyEvent;

import java.util.ArrayList;
import java.util.List;

import ee.ut.math.tvt.salessystem.domain.exception.VerificationFailedException;
import ee.ut.math.tvt.salessystem.domain.controller.SalesDomainController;
import ee.ut.math.tvt.salessystem.domain.data.HistoryItem;
import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.domain.data.StockItem;
import ee.ut.math.tvt.salessystem.domain.exception.SalesSystemException;
import ee.ut.math.tvt.salessystem.ui.model.HistoryInfoTableModel;
import ee.ut.math.tvt.salessystem.ui.model.SalesSystemModel;
import ee.ut.math.tvt.salessystem.ui.tabs.PurchaseTab;
import java.awt.event.KeyAdapter;

import java.util.Arrays;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.log4j.Logger;

/**
 * Implementation of the sales domain controller.
 */
public class SalesDomainControllerImpl implements SalesDomainController {
    
    private static final Logger log = Logger.getLogger(SalesDomainControllerImpl.class);
    public static JTextField payment = new JTextField(5);
    public static JTextField change = new JTextField(5);
    static double final_price;
    private static final List<Integer> ACCEPTED_KEYS = Arrays.asList(KeyEvent.VK_ENTER, KeyEvent.VK_BACK_SPACE, KeyEvent.VK_PERIOD, KeyEvent.VK_0, KeyEvent.VK_1, KeyEvent.VK_2, KeyEvent.VK_3, KeyEvent.VK_4, KeyEvent.VK_5, KeyEvent.VK_6, KeyEvent.VK_7, KeyEvent.VK_8, KeyEvent.VK_9);
    private SalesSystemModel model;
    
    
    public void submitCurrentPurchase(List<SoldItem> goods) throws VerificationFailedException {

        final_price = 0;
        payment.setText("");
        change.setText("");

        for (SoldItem item : goods) {
            final_price += item.getSum();

        }

        log.debug("Final price: " + final_price + "\n");

        payment.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent ke) {
                char c = ke.getKeyChar();
                if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != KeyEvent.VK_PERIOD)) {
                    ke.consume();  // ignore event
                }
            }

            @Override
            public void keyPressed(KeyEvent ke) {

            }

            @Override
            public void keyReleased(KeyEvent ke) {
                if (ACCEPTED_KEYS.contains(ke.getKeyCode())) {
                    try {
                        log.debug("KEYCODE: " + ke.getKeyChar() + "\n" + payment.getText() + "\n\n");
                        log.debug(Double.parseDouble(payment.getText()) - final_price);
                        change.setText(Double.toString(Double.parseDouble(payment.getText()) - final_price));
                    } catch (NumberFormatException e) {
                        change.setText(Double.toString(0.0));
                    }
                }
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Total price: " + final_price + "\n"));
        panel.add(new JLabel("Payment amount: " + "\n"));
        panel.add(payment);
        panel.add(new JLabel("Change amount: " + "\n"));
        change.setEditable(false);
        panel.add(change);

        inputValidation(panel, goods);
        
        //item.endSale();

        // XXX - Save purchase
    }

    public void inputValidation(JPanel panel, List<SoldItem> goods) throws VerificationFailedException {
        
        
        int dialogResult = JOptionPane.showConfirmDialog(null, panel, "Confirm payment", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {

            if (Double.parseDouble(change.getText()) >= 0) {
                JOptionPane.showMessageDialog(null, "Please return " + Double.parseDouble(change.getText()));
                
                    //k.addToStock(goods, final_price);
                
            } else {
                inputValidation(panel, goods);
            }
        }
        if (dialogResult == JOptionPane.NO_OPTION) {
            this.cancelCurrentPurchase();
            
            //BACK TO PREVIOUS STATE
        }

    }
    
    public void removeFromWarehouse(){
        
        
    }
    
    public void addToStock(List<SoldItem> goods) throws SalesSystemException{
        Date date = new Date();
        log.debug("\n\n\n");
        //log.debug(goods);
        //log.debug(date);
        //log.debug(final_price);
        HistoryItem h = new HistoryItem(final_price, date, goods);
        model.getHistoryTableModel().addItem(h);
        
        log.debug(h.toString());
    }

    public HistoryInfoTableModel getHistoryTableModel() {
        return model.getHistoryTableModel();
    }

    public void cancelCurrentPurchase() throws VerificationFailedException {
        throw new VerificationFailedException("Canceled");
        //this.endSale();
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

    public List<HistoryItem> loadHistoryState() {
        List<HistoryItem> dataset = new ArrayList<HistoryItem>();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return dataset;
    }
}
