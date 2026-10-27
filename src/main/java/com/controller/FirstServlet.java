package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.InsertDB;

public class FirstServlet extends HttpServlet {
	// This is the class that we are extending with an abstract class HttpServlet
	// So that we are creating our own Servlet. So from frontend this servlet is called, 
	// then this class's methods are called
	
	/* Methods provided my Servlet Interface
	 * 
	 * init() 					-> void init(ServletConfig config) throws ServletException;
	 * 
	 * service()				->  void service(ServletRequest req, ServletResponse res) 
	  											throws ServletException, IOException;
	  											
	 * destroy()				-> void destroy();
	 * 
	 * getServletConfig()		-> ServletConfig getServletConfig();
	 * 
	 * getServletInfo()			-> String getServletInfo();
	 */
	
	/*
	 * Servlet (interface)
		       │
		       │ implements
		       ▼
	GenericServlet (abstract class)
		       │
		       │ extends
		       ▼
	HttpServlet (abstract class)
		       │
		       │ extends
		       ▼
	MyServlet (your class)
	
	
	So Servlet defines the contract, GenericServlet implements that contract, 
	HttpServlet builds HTTP-specific behavior on top of it, and your servlet usually only 
	overrides doGet()/doPost() as needed.
	 */
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// The below is the URL that carries the data and also the Servlet name, this is for the Get method
		//http://localhost:8080/Servlet_1/FirstServlet?emp_name=Bhavesh+Bhadane&password=12345&emp_salary=1500
					
		String empName = request.getParameter("emp_name");
		String password = request.getParameter("password");
		int empSalary = Integer.parseInt(request.getParameter("emp_salary"));
		
		InsertDB.insertData(empName, password, empSalary);
		// We pass this values to the InsertDB's static insertData() method to insert in DB
		
	}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Using the Post Method, the URL will not carry the data in it.
		// The data is carried in the Request Body.
		// The URL will be like below
		//http://localhost:8080/Servlet_1/FirstServlet
		
		String empName = request.getParameter("emp_name");
		String password = request.getParameter("password");
		int empSalary = Integer.parseInt(request.getParameter("emp_salary"));
		
		InsertDB.insertData(empName, password, empSalary);
		
		// This is used to directly print on the browser using the response obj.
		// But this is not a good approach
//		PrintWriter writer = response.getWriter();
//		writer.print("<h2>Successfully Inserted Data</h2>");
		
		
		// This is used to Redirect the browser to different URL.
		// But in this the response obj is send with the URL and then the browser again generates a new Request to 
		// that URL. So this is a round trip.
		// This happens same with the Servlet also, rather than handing the control to the other servlet at the server
		// side. This gives the other servlet in the response to the browser and then the browser generates a new
		// Request to that Servlet
		response.sendRedirect("home.html");
		
	}
	
}
