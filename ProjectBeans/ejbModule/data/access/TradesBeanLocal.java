package data.access;

import javax.ejb.Local;

import objects.dataobjects.CompanyObject;
import objects.dataobjects.StockObject;

@Local
public interface TradesBeanLocal {

	void addStock(StockObject stock);

	CompanyObject getCompany(String symbol);

	void addCompany(CompanyObject company);

	Boolean companyCheck(CompanyObject comp);

}
