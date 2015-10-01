package yahooFeed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;

import org.jboss.logging.*;
import objects.dataobjects.StockObject;

public class Feed {
	
	static Logger log = Logger.getLogger(Feed.class);
	
	public static StockObject feedConnection(String stock) {
		/*
		 * method which establishes connection with yahoo
		 * takes String parameter of stock symbol - string supplied by user 
		 * through front end jsp.
		 *  will create an array of string of each stock element these will be passed 
		 *  added to an array list and returned
		 */
		//ArrayList<StockObject> stocks = new ArrayList<>();
		
		StockObject stockObj = null;
		
		StringBuilder url = 
	            new StringBuilder("http://finance.yahoo.com/d/quotes.csv?s=");
            url.append(stock + "+");
        url.append("&f=sab&e=.csv");
        log.info("Company Added to the Yahoo Feed = " + stock);
        
        try {
        String theUrl = url.toString();
        URL obj;
		
			obj = new URL(theUrl);
		
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        int responseCode = con.getResponseCode();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        
        String inputLine;
        
        String[] fields = null;
        
        stockObj = new StockObject();
        
        while ((inputLine = in.readLine()) != null)
        	{
        		fields = inputLine.split(","); 
        	}
        for (int i =0; i<fields.length;i++) {
        	System.out.print(fields[i]+",");
        }
        
        System.out.println();
        //stockObj.setstockSymbol(fields[0]);
        stockObj.setAskPrice(Double.parseDouble(fields[1]));
        stockObj.setBidPrice(Double.parseDouble(fields[2]));
        
		}
        catch (MalformedURLException e) {
			// TODO Auto-generated catch block
        	log.error("MalformedURLException:" + e.getMessage());
			e.printStackTrace();
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			log.error("ProtocolException:" + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error("IOException:" + e.getMessage());
			e.printStackTrace();
		}
		return stockObj;
	}
}