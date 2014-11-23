package ee.ut.math.tvt.salessystem.domain.controller.impl;

import java.util.Iterator;
import java.util.List;

import ee.ut.math.tvt.salessystem.domain.exception.VerificationFailedException;
import ee.ut.math.tvt.salessystem.domain.controller.SalesDomainController;
import ee.ut.math.tvt.salessystem.domain.data.HistoryItem;
import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.domain.data.StockItem;
import ee.ut.math.tvt.salessystem.util.HibernateUtil;

import org.hibernate.Session;

/**
 * Implementation of the sales domain controller.
 */
public class SalesDomainControllerImpl implements SalesDomainController {
	
	private Session session = HibernateUtil.currentSession();
    
    public void submitCurrentPurchase(List<SoldItem> goods) throws VerificationFailedException {

        // XXX - Save purchase
		
		Iterator<SoldItem> it = goods.iterator();
		SoldItem item;
		session.beginTransaction();
		
		try {
			HistoryItem newHistoryItem = new HistoryItem(HistoryItem.timeDate(), goods);
			session.save(newHistoryItem);
			
			while(it.hasNext()) {
				item = it.next();
				item.setSale(newHistoryItem);
				session.update(item.getStockItem());
				session.save(item);
			}
			
			session.getTransaction().commit();
			
		} catch(Throwable e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			throw new VerificationFailedException("DB Failure!");
		}
    }
    
    public void cancelCurrentPurchase() throws VerificationFailedException {
        throw new VerificationFailedException("Canceled");
        //this.endSale();
    }

    public void startNewPurchase() throws VerificationFailedException {
        // XXX - Start new purchase
    }

    @SuppressWarnings("unchecked")
	public List<StockItem> loadWarehouseState() {
		return (List<StockItem>)(session.createQuery("from StockItem").list());
    }

    @SuppressWarnings("unchecked")
	public List<HistoryItem> loadHistoryState() {
    	session.createQuery("from SoldItem").list();
		return (List<HistoryItem>)(session.createQuery("from HistoryItem").list());
	}

    public void endSession() {
        HibernateUtil.closeSession();
    }
    
    

}