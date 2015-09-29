package object.dataobjects;

public class StockObject {
	
	public int stockID;
	public int marketID;
	public String stockSymbol;
	public double bidPrice;
	public double askPrice;
	public String dateTime;
	
	public StockObject(int stockID, int marketID, String stockSymbol, double bidPrice, double askPrice, String dateTime){
		this.stockID=stockID;
		this.marketID=marketID;
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
	public int getMarketID() {
		return marketID;
	}
	public void setMarketID(int marketID) {
		this.marketID = marketID;
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
