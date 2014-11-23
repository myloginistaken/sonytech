/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ee.ut.math.tvt.salessystem.domain.exception;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JComponent;

/**
 *
 * @author sander
 */
public class NotEnoughInStockException extends Exception{
    public NotEnoughInStockException(){
        JPanel topFrame = new JPanel();
        //JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        JOptionPane.showMessageDialog(null, "Cannot order, not enough resources in stock!",  "Out of stock!", JOptionPane.ERROR_MESSAGE);
}
}