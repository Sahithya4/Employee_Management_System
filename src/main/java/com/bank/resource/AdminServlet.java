package com.bank.resource;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import com.bank.entity.Login;
import com.employee.repository.Validation;

/**
 * Servlet implementation class AdminServlet
 */
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		PrintWriter printWriter = response.getWriter();
		Employee employee =new Employee();
		Login login=new Login();
		String option = request.getParameter("varname");
		if (option.equals("add"))
			response.sendRedirect("Add_Employee.jsp");
		else if(option.equals("adddetails"))
		{
			String salarys = request.getParameter("salary");
			float salary=Float.parseFloat(salarys);
			login.setName(request.getParameter("name"));
			login.setRole("user");
			String password=Validation.generatePassword();
			login.setPassword(password);
			employee.setEmployeename(request.getParameter("name"));
			employee.setEmail(request.getParameter("email"));
			employee.setDepartmentname(request.getParameter("deptname"));
			employee.setReportingmanager(request.getParameter("repmanager"));
			employee.setSalary(salary);
			
			Client client = ClientBuilder.newClient(new ClientConfig());
			WebTarget webTarget = client.target("http://localhost:8013/EmployeeManagementSystem/webapi/myresource/add");

			Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
			Response clientResponse = invocationBuilder.post(Entity.entity(employee, MediaType.APPLICATION_JSON));
			
			webTarget = client.target("http://localhost:8013/EmployeeManagementSystem/webapi/myresource/addlogin");
			invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
			clientResponse = invocationBuilder.post(Entity.entity(login, MediaType.APPLICATION_JSON));

			String status=clientResponse.readEntity(String.class);
			System.out.println(status);
			printWriter.println(status);
		//	response.sendRedirect("AdminOperations.jsp");
		}
		else if(option.equals("delete"))
			response.sendRedirect("Delete.jsp");
		else if(option.equals("deletedetails"))
		{
			String id = request.getParameter("id");
			int empid=Integer.parseInt(id);
			employee.setEmployeeid(empid);
			Client client = ClientBuilder.newClient(new ClientConfig());
			WebTarget webTarget = client.target("http://localhost:8013/EmployeeManagementSystem/webapi/myresource/delete");

			Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
			Response clientResponse = invocationBuilder.post(Entity.entity(employee, MediaType.APPLICATION_JSON));
			String employeename=clientResponse.readEntity(String.class);
			
			login.setName(employeename);
			webTarget = client.target("http://localhost:8013/EmployeeManagementSystem/webapi/myresource/deletelogin");
			invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
			clientResponse = invocationBuilder.post(Entity.entity(login, MediaType.APPLICATION_JSON));
   
			String status=clientResponse.readEntity(String.class);
			System.out.println(status);
			printWriter.println(status);
		    response.sendRedirect("AdminOperations.jsp");
		}
		else if(option.equals("employee"))
		{
			Client client = ClientBuilder.newClient(new ClientConfig());
			WebTarget webTarget = client.target("http://localhost:8013/EmployeeManagementSystem/webapi/myresource");

			Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
			Response  clientResponse = invocationBuilder.get();
			GenericType<ArrayList<Employee>> gType = new GenericType<ArrayList<Employee>>() {};
			ArrayList<Employee> list = clientResponse.readEntity(gType);
	
			RequestDispatcher dispatch = request.getRequestDispatcher("ListOfEmployees.jsp");
			//response.sendRedirect("ListOfEmployees.jsp");
			request.setAttribute("data", list);
			dispatch.forward(request, response);
		}
		else if(option.equals("empp"))
		{
			response.sendRedirect("ListOfEmployees.jsp");
		}
		else if(option.equals("department"))
		{
			Client client = ClientBuilder.newClient(new ClientConfig());
			WebTarget webTarget = client.target("http://localhost:8013/EmployeeManagementSystem/webapi/myresource/department");

			Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
			Response  clientResponse = invocationBuilder.get();
			GenericType<ArrayList<String>> gType = new GenericType<ArrayList<String>>() {};
			ArrayList<String> list = clientResponse.readEntity(gType);
	
			RequestDispatcher dispatch = request.getRequestDispatcher("ListOfDepartments.jsp");
			//response.sendRedirect("ListOfEmployees.jsp");
			request.setAttribute("department", list);
			dispatch.forward(request, response);
		}
		else if(option.equals("manager"))
		{
			response.sendRedirect("ListReportingTo.jsp");
		}
		else if(option.equals("listmanager"))
		{
			String reporting_To = request.getParameter("manager");
			employee.setReportingmanager(reporting_To);

			Client client = ClientBuilder.newClient(new ClientConfig());
			WebTarget webTarget = client.target("http://localhost:8013/EmployeeManagementSystem/webapi/myresource/reporting");

			Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
			Response clientResponse = invocationBuilder.post(Entity.entity(employee, MediaType.APPLICATION_JSON));
			   
			GenericType<ArrayList<String>> gType = new GenericType<ArrayList<String>>() {};
			ArrayList<String> list = clientResponse.readEntity(gType);
	
			RequestDispatcher dispatch = request.getRequestDispatcher("ListReportingManager.jsp");
			//response.sendRedirect("ListOfEmployees.jsp");
			request.setAttribute("manager", list);
			dispatch.forward(request, response);
		}
		else if(option.equals("salary"))
		{
			Client client = ClientBuilder.newClient(new ClientConfig());
			WebTarget webTarget = client.target("http://localhost:8013/EmployeeManagementSystem/webapi/myresource/salary");

			Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
			Response  clientResponse = invocationBuilder.get();
			GenericType<ArrayList<Employee>> gType = new GenericType<ArrayList<Employee>>() {};
			ArrayList<Employee> list = clientResponse.readEntity(gType);
	
			RequestDispatcher dispatch = request.getRequestDispatcher("ListSalary.jsp");
			//response.sendRedirect("ListOfEmployees.jsp");
			request.setAttribute("salary", list);
			dispatch.forward(request, response);
		}
		else if(option.equals("pf"))
		{
			Client client = ClientBuilder.newClient(new ClientConfig());
			WebTarget webTarget = client.target("http://localhost:8013/EmployeeManagementSystem/webapi/myresource/pf");

			Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
			Response  clientResponse = invocationBuilder.get();
			GenericType<ArrayList<Employee>> gType = new GenericType<ArrayList<Employee>>() {};
			ArrayList<Employee> list = clientResponse.readEntity(gType);
	
			RequestDispatcher dispatch = request.getRequestDispatcher("PfCalculation.jsp");
			//response.sendRedirect("ListOfEmployees.jsp");
			request.setAttribute("pf", list);
			dispatch.forward(request, response);
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
