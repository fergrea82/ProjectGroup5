package object.dataobjects;

public class TradeHistoryObject {
	public int tradeID;
	public int userID;
	public int stockID;
	public String tradeTime;
	
	public TradeHistoryObject(int tradeID, int userID, int stockID, String tradeTime){
		this.tradeID=tradeID;
		this.userID=userID;
		this.stockID=stockID;
		this.tradeTime=tradeTime;
	}
	
	public int getTradeID() {
		return tradeID;
	}
	public void setTradeID(int tradeID) {
		this.tradeID = tradeID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getStockID() {
		return stockID;
	}
	public void setStockID(int stockID) {
		this.stockID = stockID;
	}
	public String getTradeTime() {
		return tradeTime;
	}
	public void setTradeTime(String tradeTime) {
		this.tradeTime = tradeTime;
	}
	
	

}
