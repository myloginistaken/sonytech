/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ee.ut.math.tvt.salessystem.ui.model;

import org.apache.log4j.Logger;

import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.domain.exception.SalesSystemException;
import ee.ut.math.tvt.salessystem.ui.SalesSystemUI;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JComponent;

/**
 *
 * @author Sander
 */
public class HistoryInfoTableModel extends SalesSystemTableModel<SoldItem>{

    private static final long serialVersionUID = 1L;

    private static final Logger log = Logger.getLogger(HistoryInfoTableModel.class);
    
    public HistoryInfoTableModel() {
        super(new String[] {"Date", "Time", "Total"});
    }
    
    @Override
    // NOT CORRECT DOWN BELOW. DOES NOT POPULATE WITH DATA PROPERLY.
    protected Object getColumnValue(SoldItem item, int columnIndex) {
        switch (columnIndex){
            case 0:
                    return item;//.getId(); //TODO
            case 1:
                    return item;//.getName(); //TODO
            case 2:
                    return item.getSum();
        }
        throw new IllegalArgumentException("Column index out of range");
    }
    
    @Override
    public String toString() {
            final StringBuffer buffer = new StringBuffer();

            for (int i = 0; i < headers.length; i++)
                    buffer.append(headers[i] + "\t");
            buffer.append("\n");

            for (final SoldItem item : rows) {
                    buffer.append(item.getId() + "\t");
                    buffer.append(item.getName() + "\t");
                    buffer.append(item.getSum() + "\t");
                    buffer.append("\n");
            }

            return buffer.toString();
    }
	
    
    public void addItem(final SoldItem item) throws SalesSystemException{
        /**
         * XXX In case such stockItem already exists increase the quantity of the
         * existing stock.
         */
        rows.add(item);
        log.debug("Added " + item.getName() + " quantity of " + item.getQuantity());
        fireTableDataChanged();
               
    }
}
