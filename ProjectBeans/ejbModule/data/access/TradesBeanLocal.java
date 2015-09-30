package data.access;

import javax.ejb.Local;

import objects.dataobjects.StockObject;

@Local
public interface TradesBeanLocal {

	void addStock(StockObject stock);

}
