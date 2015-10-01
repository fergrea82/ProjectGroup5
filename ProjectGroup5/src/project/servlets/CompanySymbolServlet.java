package project.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.validator.internal.util.logging.Log;

import objects.dataobjects.StockObject;
import data.access.TradesBeanLocal;

/**
 * Servlet implementation class CompanySymbolServlet
 */
@WebServlet("/CompanySymbolServlet")
@EJB(name="ejb/TradesBean",beanInterface=TradesBeanLocal.class)
public class CompanySymbolServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    private static ArrayList<StockObject> stocks = new ArrayList<>();
    
    public ArrayList<StockObject> getStocks() {
		return stocks;
	}

	/**
     * @see HttpServlet#HttpServlet()
     */
    public CompanySymbolServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * servlet acts as go between for front end and yahoo feed and back end database
	 * could be deprecated to integrate with jquery
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		//PrintWriter out = response.getWriter();
		String company = request.getParameter("company");
		
		StockObject stock = continuousFeed(company);
		
		//return to main Index.jsp
		request.setAttribute("Stock", stock);
		request.setAttribute("Stocks", stocks);
		request.getRequestDispatcher("/Index.jsp").include(request, response);
	}
	
	private StockObject continuousFeed(String companySymbol) {
		/*
		 * Generic servlet which is called by jquery periodically 
		 * returns a stock object which is then passed back doPost
		 */
		StockObject stock = new StockObject();
		InitialContext context;
		try {
			context = new InitialContext();
		
			TradesBeanLocal bean = (TradesBeanLocal)context.lookup("java:comp/env/ejb/TradesBean");
		
			stock = yahooFeed.Feed.feedConnection(companySymbol);
			bean.addStock(stock);
			stocks.add(stock);
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return stock;
	}
}			

	
