package object.dataobjects;

public class MarketObject {
	public int marketID;
	public String marketName;
	
	public MarketObject(int marketID, String marketName){
		this.marketID=marketID;
		this.marketName=marketName;
	}
	
	public int getMarketID() {
		return marketID;
	}
	public void setMarketID(int marketID) {
		this.marketID = marketID;
	}
	public String getMarketName() {
		return marketName;
	}
	public void setMarketName(String marketName) {
		this.marketName = marketName;
	}
	
	
	
}
