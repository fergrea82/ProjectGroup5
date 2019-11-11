package project.businesslogic;

import java.util.LinkedList;

import objects.dataobjects.StockObject;
import yahooFeed.Feed;

public class TwoMovingAvg {

	private static final int QUANTITY = 15000;
	private static final int VALUESHORTAVERAGE = 4;
	private static final int VALUELONGAVERAGE = 20;
	static double shortMovingAverage = 0;
	static double longMovingAverage = 0;
	static double pricePaid = 0;
	static double priceGot = 0;
	static double runningTotal = 0;
	static double profitMarginOfInvestment = 3000;
	static double lossMarginOfInvestment = -3000;
	static boolean bought = false;
	static boolean sold = false;
	
	
	
	static LinkedList<Double> shortlist = new LinkedList<>();
	static LinkedList<Double> longlist = new LinkedList<>();
	static LinkedList<Double> differenceLongShort = new LinkedList<>();
	
	static StockObject stock = new StockObject();
	public static void main(String[] args) throws Exception{
		 
		TwoMovingAverage("AAPL");
			
	}	
	public static void TwoMovingAverage(String compSymbol){
	while(true){
		
			stock = Feed.feedConnection(compSymbol);

			if (shortlist.size() == VALUESHORTAVERAGE) {
				shortlist.removeFirst();
				shortlist.add((stock.getAskPrice() + stock.getBidPrice())/2);
				shortMovingAverage = calcShortMovingAverage(shortlist);
			}
			else{
				shortlist.add((stock.getAskPrice() + stock.getBidPrice())/2);
			}
			if (longlist.size() == VALUELONGAVERAGE) {
				longlist.removeFirst();
				longlist.add((stock.getAskPrice() + stock.getBidPrice())/2);
				longMovingAverage = calcLongMovingAverage(longlist);
			}
			else{
				longlist.add((stock.getAskPrice() + stock.getBidPrice())/2);
			}
			
			//start of the profit loss
			
			differenceLongShort.add((longMovingAverage - shortMovingAverage));
			
			if(differenceLongShort.size() == 2){
				// difference was pos now neg.. e.g was above now below SELL
				if(differenceLongShort.get(0) > 0 && differenceLongShort.get(1) < 0){
					if(sold == false){
						System.out.println("SELLLINGGGGGG");
						sold = true;
						priceGot = stock.getBidPrice() * QUANTITY;
					}
					
				}
				// difference was neg now pos.. e.g was below now above BUY
				else if(differenceLongShort.get(0) < 0 && differenceLongShort.get(1) > 0){
					if(bought == false){
						System.out.println("BUYYYYYINGGGGGG");
						bought = true;
						pricePaid = stock.getAskPrice() * QUANTITY;
					}				
				}
				differenceLongShort.remove(0);
			}
			
			if(bought == true && sold == true){
				runningTotal += (pricePaid - priceGot);
				bought = false;
				sold = false;
				System.out.println("Running Total = " + runningTotal);
				
				if(runningTotal <= lossMarginOfInvestment || runningTotal >= profitMarginOfInvestment)
					break;
			}
			
			}
		}
	
	public static double calcLongMovingAverage(LinkedList<Double> lList){
		double av = 0, total = 0;
		for(int i = 0;i<lList.size();i++)
		{
			total += lList.get(i);
		}
		av = total/VALUELONGAVERAGE;
        return av;
	}
	
	public static double calcShortMovingAverage(LinkedList<Double> sList){
		double av = 0, total = 0;
		for(int i = 0;i<sList.size();i++)
		{
			total += sList.get(i);
		}
		av = total/VALUESHORTAVERAGE;
        return av;
	}

}

