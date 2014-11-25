package ee.ut.math.tvt.salessystem.ui.model;

import ee.ut.math.tvt.salessystem.domain.controller.SalesDomainController;
import ee.ut.math.tvt.salessystem.domain.data.Client;
import ee.ut.math.tvt.salessystem.domain.data.Sale;
import ee.ut.math.tvt.salessystem.domain.data.StockItem;
import java.util.List;

/**
 * Main model. Holds all the other models.
 */
public class SalesSystemModel {

    // Warehouse model
    private StockTableModel warehouseTableModel;

    // Current shopping cart model
    private PurchaseInfoTableModel currentPurchaseTableModel;

    // Puchase history model
    private PurchaseHistoryTableModel purchaseHistoryTableModel;

    private ClientTableModel clientTableModel;

    private Client selectedClient;
    
    private Sale sale;

    /**
     * Construct application model.
     * @param domainController Sales domain controller.
     */
    public SalesSystemModel(SalesDomainController domainController) {

        warehouseTableModel = new StockTableModel();
        currentPurchaseTableModel = new PurchaseInfoTableModel(this);
        purchaseHistoryTableModel = new PurchaseHistoryTableModel();
        clientTableModel = new ClientTableModel();

        // Load data from the database

        List<StockItem> stockItems = domainController.getAllStockItems();
        for (StockItem s : stockItems){
            System.out.println("StockItems: " + s);         
        }
        System.out.println(stockItems);
        warehouseTableModel.populateWithData(stockItems);

        List<Client> clients = domainController.getAllClients();
        for (Client s : clients){
            System.out.println("Clients: " + s);         
        }
        System.out.println(clients);
        clientTableModel.populateWithData(clients);

        List<Sale> sales = domainController.getAllSales();
        for (Sale s : sales){
            System.out.println("Sales: " + s);         
        }
        System.out.println(sales);
        purchaseHistoryTableModel.populateWithData(sales);

    }

    public StockTableModel getWarehouseTableModel() {
        return warehouseTableModel;
    }

    public PurchaseInfoTableModel getCurrentPurchaseTableModel() {
        return currentPurchaseTableModel;
    }

    public PurchaseHistoryTableModel getPurchaseHistoryTableModel() {
        return purchaseHistoryTableModel;
    }

    public ClientTableModel getClientTableModel() {
        return clientTableModel;
    }

    public void setPurchaseHistoryTableModel(
            PurchaseHistoryTableModel purchaseHistoryTableModel) {
        this.purchaseHistoryTableModel = purchaseHistoryTableModel;
    }

    public Client getSelectedClient() {
        return selectedClient;
    }

    public void setSelectedClient(Client client) {
        this.selectedClient = client;
    }
    public Sale getSale() {
        return sale;
    }
    
    public void setSale(Sale sale) {
        this.sale = sale;
    }

}
