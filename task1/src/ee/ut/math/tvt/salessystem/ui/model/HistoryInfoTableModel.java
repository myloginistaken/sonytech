/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ee.ut.math.tvt.salessystem.ui.model;

import ee.ut.math.tvt.salessystem.domain.data.HistoryItem;
import org.apache.log4j.Logger;

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
public class HistoryInfoTableModel extends SalesSystemTableModel<HistoryItem>{

    private static final long serialVersionUID = 1L;

    private static final Logger log = Logger.getLogger(HistoryInfoTableModel.class);
    
    public HistoryInfoTableModel() {
        super(new String[] {"DateTime", "Total"});
    }
    
    @Override
    protected Object getColumnValue(HistoryItem item, int columnIndex) {
        switch (columnIndex){
            case 0:
                    return item.getDateTime();
            case 1:
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

            for (final HistoryItem item : rows) {
                    buffer.append(item.getDateTime() + "\t");
                    //buffer.append(item.getTime() + "\t");
                    buffer.append(item.getSum() + "\t");
                    buffer.append("\n");
            }

            return buffer.toString();
    }
	
    public void addItem(final HistoryItem item){
		rows.add(item);
        fireTableDataChanged();
    }
}
