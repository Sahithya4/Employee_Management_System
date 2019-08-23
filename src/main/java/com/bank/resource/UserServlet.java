package com.bank.resource;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

import com.bank.entity.Employee;
import com.bank.entity.Leave;
import com.bank.entity.Login;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter printWriter = response.getWriter();
		Login login=new Login();
		Leave leave =new Leave();
		String option = request.getParameter("varname");
		if (option.equals("applyleave"))
			response.sendRedirect("Apply_Leave.jsp");
		
		// View Leaves
		else if(option.equals("viewleave"))
		{
			HttpSession session=request.getSession();
			String name=(String) session.getAttribute("name");
			System.out.println(name);
			login.setName(name);
			Client client = ClientBuilder.newClient(new ClientConfig());
			WebTarget webTarget = client.target("http://localhost:8013/EmployeeManagementSystem/webapi/myresource/leave");
			Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
			Response clientResponse = invocationBuilder.post(Entity.entity(login, MediaType.APPLICATION_JSON));
			//GenericType<ArrayList<Leave>> gType = new GenericType<ArrayList<Leave>>() {};
			ArrayList<String> list = clientResponse.readEntity(ArrayList.class);
	
			RequestDispatcher dispatch = request.getRequestDispatcher("View_Leave.jsp");
		if(list.isEmpty()) {}
		else {
			request.setAttribute("leave", list);
			dispatch.forward(request, response);
		}
		}
		
		//Apply Leaves
		else if(option.equals("apply"))
		{
			HttpSession session=request.getSession();
			String name=(String) session.getAttribute("name");
			System.out.println(name);
			String startdate=request.getParameter("sd");
			String enddate = request.getParameter("ed");
			Date date;
			try {
				date = new SimpleDateFormat("yyyy-MM-dd").parse(startdate);
				leave.setStartdate(date);
				date = new SimpleDateFormat("yyyy-MM-dd").parse(enddate);
				leave.setEnddate(date);
				leave.setReason(request.getParameter("reason"));
				leave.setStatus("pending");
				System.out.println(name);
				leave.setName(name);
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			Client client = ClientBuilder.newClient(new ClientConfig());
			WebTarget webTarget = client.target("http://localhost:8013/EmployeeManagementSystem/webapi/myresource/apply");

			Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
			Response clientResponse = invocationBuilder.post(Entity.entity(leave, MediaType.APPLICATION_JSON));
			
			String status=clientResponse.readEntity(String.class);
			System.out.println(status);
			printWriter.println(status);
		}
		
		//Accepting leave
		else if(option.equals("accept"))
		{
			String id = request.getParameter("id");
			int leaveid=Integer.parseInt(id);
			printWriter.println(id);
			leave.setLeaveid(leaveid);
			Client client = ClientBuilder.newClient(new ClientConfig());
			WebTarget webTarget = client.target("http://localhost:8013/EmployeeManagementSystem/webapi/myresource/accept");

			Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
			Response clientResponse = invocationBuilder.post(Entity.entity(leave, MediaType.APPLICATION_JSON));
			
			String status=clientResponse.readEntity(String.class);
			System.out.println(status);
			printWriter.println(status);
			
		}
		
		//Rejecting leave
		else if(option.equals("reject"))
		{
			String id = request.getParameter("id");
			int leaveid=Integer.parseInt(id);
			printWriter.println(id);
			leave.setLeaveid(leaveid);
			Client client = ClientBuilder.newClient(new ClientConfig());
			WebTarget webTarget = client.target("http://localhost:8013/EmployeeManagementSystem/webapi/myresource/reject");

			Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
			Response clientResponse = invocationBuilder.post(Entity.entity(leave, MediaType.APPLICATION_JSON));
			
			String status=clientResponse.readEntity(String.class);
			System.out.println(status);
			printWriter.println(status);
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
