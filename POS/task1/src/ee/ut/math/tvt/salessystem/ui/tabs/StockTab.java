package ee.ut.math.tvt.salessystem.ui.tabs;

import ee.ut.math.tvt.salessystem.domain.data.StockItem;
import ee.ut.math.tvt.salessystem.ui.model.SalesSystemModel;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.JTableHeader;


public class StockTab {

  private JButton addItem;

  private SalesSystemModel model;
  public static JTextField price = new JTextField(5);
  public static JTextField name = new JTextField(5);
  public static JTextField quantity = new JTextField(5);

  public StockTab(SalesSystemModel model) {
    this.model = model;
  }

  // warehouse stock tab - consists of a menu and a table
  public Component draw() {
    JPanel panel = new JPanel();
    panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

    GridBagLayout gb = new GridBagLayout();
    GridBagConstraints gc = new GridBagConstraints();
    panel.setLayout(gb);

    gc.fill = GridBagConstraints.HORIZONTAL;
    gc.anchor = GridBagConstraints.NORTH;
    gc.gridwidth = GridBagConstraints.REMAINDER;
    gc.weightx = 1.0d;
    gc.weighty = 0d;

    panel.add(drawStockMenuPane(), gc);

    gc.weighty = 1.0;
    gc.fill = GridBagConstraints.BOTH;
    panel.add(drawStockMainPane(), gc);
    return panel;
  }

  // warehouse menu
  private Component drawStockMenuPane() {
    JPanel panel = new JPanel();

    GridBagConstraints gc = new GridBagConstraints();
    GridBagLayout gb = new GridBagLayout();

    panel.setLayout(gb);

    gc.anchor = GridBagConstraints.NORTHWEST;
    gc.weightx = 0;

    addItem = new JButton("Add");
    addItem.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		
    		JPanel addProductPanel = new JPanel();
    		addProductPanel.setVisible(true);
    		addProductPanel.add(new JLabel("Product name: "));
    		addProductPanel.add(name);
    		addProductPanel.add(new JLabel("Price: "));
    		addProductPanel.add(price);
    		addProductPanel.add(new JLabel("Quantity: "));
    		addProductPanel.add(quantity);
             
            int dialogResult = JOptionPane.showConfirmDialog (null, addProductPanel, "Confirmation", JOptionPane.OK_CANCEL_OPTION);

            if (dialogResult == JOptionPane.OK_OPTION) {
            	StockItem item = new StockItem();
            	String productName = name.getText();
            	double productPrice = Double.parseDouble(price.getText());
            	int productQuantity = Integer.parseInt(quantity.getText());
            	
            	if(productName.isEmpty()) {
        			JOptionPane.showMessageDialog(null, "Name cannot be empty","Attention",JOptionPane.ERROR_MESSAGE);
        		}
        		else if(productPrice<0) {
        			JOptionPane.showMessageDialog(null, "Price can't be less than 0","Attention",JOptionPane.ERROR_MESSAGE);
        		}
        		else if(productQuantity<1) {
        			JOptionPane.showMessageDialog(null, "Quantity can't be less than 1","Attention",JOptionPane.ERROR_MESSAGE);
        		}
        		else {
                	//get last item id for entering a new one 
        			int lastItemId = model.getWarehouseTableModel().getRowCount();
            		item.setId((long) lastItemId + 1);
            		item.setName(name.getText());
            		item.setPrice(Double.parseDouble(price.getText()));
            		item.setQuantity(Integer.parseInt(quantity.getText()));
        			model.getWarehouseTableModel().addItem(item);
        		}
            }
            else {
            	addProductPanel.setVisible(false);
            }
    	}
    });
    gc.gridwidth = GridBagConstraints.RELATIVE;
    gc.weightx = 1.0;
    panel.add(addItem, gc);

    panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    return panel;
  }


  // table of the wareshouse stock
  private Component drawStockMainPane() {
    JPanel panel = new JPanel();

    JTable table = new JTable(model.getWarehouseTableModel());

    JTableHeader header = table.getTableHeader();
    header.setReorderingAllowed(false);

    JScrollPane scrollPane = new JScrollPane(table);

    GridBagConstraints gc = new GridBagConstraints();
    GridBagLayout gb = new GridBagLayout();
    gc.fill = GridBagConstraints.BOTH;
    gc.weightx = 1.0;
    gc.weighty = 1.0;

    panel.setLayout(gb);
    panel.add(scrollPane, gc);

    panel.setBorder(BorderFactory.createTitledBorder("Warehouse status"));
    return panel;
  }

}
