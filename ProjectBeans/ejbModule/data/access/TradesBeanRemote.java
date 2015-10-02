package data.access;

import javax.ejb.Remote;

import objects.dataobjects.CompanyObject;
import objects.dataobjects.StockObject;
@Remote
public interface TradesBeanRemote {
	void addStock(StockObject stock);
	CompanyObject getCompany(String symbol);
	void addCompany(CompanyObject company);
	Boolean companyCheck(CompanyObject comp);
}
