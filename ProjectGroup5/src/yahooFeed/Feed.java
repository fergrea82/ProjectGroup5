package yahooFeed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import data.access.TradesBeanLocal;
import objects.dataobjects.CompanyObject;
import objects.dataobjects.StockObject;

public class Feed {
	

	public static void main(String[] args) throws Exception{
		 
	//	feedConnection();
		
	}

	public static StockObject feedConnection(String stock) throws NamingException {
		/*
		 * method which establishes connection with yahoo
		 * takes String parameter of stock symbol - string supplied by user 
		 * through front end jsp.
		 *  will create an array of string of each stock element these will be passed 
		 *  added to an array list and returned
		 */
		//ArrayList<StockObject> stocks = new ArrayList<>();
		
		DecimalFormat df = new DecimalFormat("0000.##");
		
		StockObject stockObj = null;
		InitialContext context = new InitialContext();
		TradesBeanLocal bean = (TradesBeanLocal)context.lookup("java:comp/env/ejb/TradesBean");
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
        
        stockObj = new StockObject();
        
        while ((inputLine = in.readLine()) != null)
        	{
        		fields = inputLine.split(","); 
        		
        	}
        for (int i =0; i<fields.length;i++) {
        System.out.print(fields[i]+", ");
        }
        System.out.println();
        
        //stockObj.setCompanyObject(bean.getCompany(fields[0]));
        if (!fields[1].equalsIgnoreCase("N/A")){
        	System.out.println(fields[1]);
        	stockObj.setAskPrice(Double.parseDouble(fields[1]));
        }
        if (!fields[2].equalsIgnoreCase("N/A")){
        	stockObj.setBidPrice(Double.parseDouble(fields[2]));
        }
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
		return stockObj;
	}
}