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
import ee.ut.math.tvt.salessystem.util.HibernateUtil;
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
    
    
    public void submitCurrentPurchase(List<SoldItem> goods) throws VerificationFailedException {

        // XXX - Save purchase
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

    public void endSession() {
        HibernateUtil.closeSession();
    }
    
    

}