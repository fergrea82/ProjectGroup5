package objects.dataobjects;
//@transient
//@notEmpty
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="stocks")
public class StockObject {
	
	@Id
	
	private int stockID;
	@ManyToOne(optional = false)
	@JoinColumn(name="MarketID", referencedColumnName="MarketID")
	MarketObject marketObj;
	private String stockSymbol;
	private double bidPrice;
	private double askPrice;
	private String StockTime;
	
	public StockObject() {
		//default constructor
	}
	
	public StockObject(int stockID, MarketObject marketObj, String stockSymbol, double bidPrice, double askPrice, String stockTime){
		this.stockID=stockID;
		this.marketObj=marketObj;
		this.stockSymbol=stockSymbol;
		this.bidPrice=bidPrice;
		this.askPrice=askPrice;
		this.StockTime=stockTime;
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

	public String getStockTime() {
		return StockTime;
	}

	public void setStockTime(String stockTime) {
		StockTime = stockTime;
	}
	

	
	
	

}
