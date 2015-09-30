package objects.dataobjects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class StockObject {
	
	@Id
	private int stockID;
	@ManyToOne(optional = false)
	@JoinColumn(name="marketID", referencedColumnName="MarketID")
	MarketObject marketObj;
	private String stockSymbol;
	private double bidPrice;
	private double askPrice;
	private String dateTime;
	
	public StockObject() {
		//default constructor
	}
	
	public StockObject(int stockID, MarketObject marketObj, String stockSymbol, double bidPrice, double askPrice, String dateTime){
		this.stockID=stockID;
		this.marketObj=marketObj;
		this.stockSymbol=stockSymbol;
		this.bidPrice=bidPrice;
		this.askPrice=askPrice;
		this.dateTime=dateTime;
	}
	
	public int getStockID() {
		return stockID;
	}
	public void setStockID(int stockID) {
		this.stockID = stockID;
	}
	public MarketObject getMarket() {
		return marketObj;
	}
	public void setMarketID(MarketObject marketObj) {
		this.marketObj = marketObj;
	}
	public String getstockSymbol() {
		return stockSymbol;
	}
	public void setstockSymbol(String stockName) {
		this.stockSymbol = stockName;
	}
	public double getBidPrice() {
		return bidPrice;
	}
	public void setBidPrice(double bidPrice) {
		this.bidPrice = bidPrice;
	}
	public double getAskPrice() {
		return askPrice;
	}
	public void setAskPrice(double askPrice) {
		this.askPrice = askPrice;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	
	
	

}
