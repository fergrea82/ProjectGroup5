package data.access;

import javax.ejb.Remote;

import objects.dataobjects.StockObject;
@Remote
public interface TradesBeanRemote {
	void addStock(StockObject stock);
}
