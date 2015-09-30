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
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		InitialContext context;
		try {
			context = new InitialContext();
		
		TradesBeanLocal bean = (TradesBeanLocal)context.lookup("java:comp/env/ejb/TradesBean");
		
		for(int i = 1;i <= 10;i++) {
			StockObject stock = new StockObject();
			ArrayList<StockObject> stocks = yahooFeed.Feed.feedConnection(request.getParameter("company"));
			System.out.println(stocks.get(0).getstockSymbol());
			bean.addStock(stock);
		}
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
