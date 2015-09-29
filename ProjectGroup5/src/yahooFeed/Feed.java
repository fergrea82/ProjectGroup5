package yahooFeed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;

public class Feed {

	public ArrayList<String[]> feedConnection(String stock) {
		/*
		 * method which establishes connection with yahoo
		 * takes String parameter of stock symbol - string supplied by user 
		 * through front end jsp.
		 *  will create an array of string of each stock element these will be passed 
		 *  added to an array list and returned
		 */
		ArrayList<String[]> stocks = new ArrayList<>();
		
		StringBuilder url = 
	            new StringBuilder("http://finance.yahoo.com/d/quotes.csv?s=");
            url.append(stock + "+");
        url.append("&f=sab&e=.csv");
        
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
        
        while ((inputLine = in.readLine()) != null)
        	{

        		fields = inputLine.split(","); 
        	}
        
        stocks.add(fields);
        
		}
        catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stocks;
	}
}