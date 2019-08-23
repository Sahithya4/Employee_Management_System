package com.bank.Emp_bank;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.bank.entity.Employee;
import com.bank.entity.Leave;
import com.bank.entity.Login;
import com.employee.repository.AcceptLeave;
import com.employee.repository.AddRepository;
import com.employee.repository.ApplyRepository;
import com.employee.repository.DeleteRepository;
import com.employee.repository.ListOfDepartments;
import com.employee.repository.ListOfEmployee;
import com.employee.repository.ListReportingManager;
import com.employee.repository.ListSalary;
import com.employee.repository.PfCalculation;
import com.employee.repository.RejectLeave;
import com.employee.repository.Validation;
import com.employee.repository.ViewLeave;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to the
	 * client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 */
	@Context
	HttpServletResponse response;
	@Context
	HttpSession session;
	@Context
	HttpServletRequest request;
	
	//For login validation
	@Path("login")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String getIt(Login login) {

		Validation validation = new Validation();
		String status = validation.checkValidate(login);

		if (status.equals("admin"))
			return "AdminOperations.jsp";
		else if (status.equals("user"))
			return "UserOperations.jsp";
		else if (status.equals("manager"))
			return "ManagerOperations.jsp";
		else
			return "error";

	}
	
	//Adding Employee into employee
	@Path("add")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String addIt(Employee employee) {
		AddRepository add = new AddRepository();
		String status = add.addRepository(employee);
		return status;
	}
	
	//Applying for leave by employee
	@Path("apply")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String apply(Leave leave) {
		ApplyRepository add = new ApplyRepository();
		String status = add.applyRepository(leave);
		return status;
	}
	
	//Adding Employee into login and generating password
	@Path("addlogin")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String addlogin(Login login) {
		AddRepository add = new AddRepository();
		String status = add.addRepository(login);
		return status;
	}
	
	//Deleting Employee
	@Path("delete")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String deleteIt(Employee employee) {
		DeleteRepository delete = new DeleteRepository();
		String status = delete.deleteRepository(employee);
		return status;
	}
	
	//Deleting employee's login credentials
	@Path("deletelogin")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String deletelogin(Login login) {
		DeleteRepository delete = new DeleteRepository();
		String status = delete.deleteRepository(login);
		return status;
	}
	
	//Getting list of employees
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ArrayList<Employee> getIt() {
		ListOfEmployee listemployee = new ListOfEmployee();
		ArrayList<Employee> list = listemployee.listOfEmployee();
		return list;
	}

	//Getting list if departments
	@Path("department")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ArrayList<String> ListDepartments() {
		System.out.println("Entered");
		ListOfDepartments listdepartment = new ListOfDepartments();
		ArrayList<String> list = listdepartment.listOfDepartments();
		return list;
	}

	//Getting employees reporting to specific manager
	@Path("reporting")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ArrayList<String> ListManager(Employee employee) {
		ListReportingManager listReportingManager = new ListReportingManager();
		ArrayList<String> list = listReportingManager.listReportingManager(employee);
		return list;
	}

	//Getting list of employees whose salary between 10000 to 20000
	@Path("salary")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ArrayList<Employee> getSalary() {
		ListSalary listsalary = new ListSalary();
		ArrayList<Employee> list = listsalary.listSalary();
		return list;
	}

	//Calculating employees pf
	@Path("pf")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ArrayList<Employee> getpf() {
		PfCalculation pfcalculation = new PfCalculation();
		ArrayList<Employee> list = pfcalculation.pfCalculation();
		return list;
	}
	
	//Manager viewing leaves by his/her employees
	@Path("leave")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ArrayList<String> viewleave(Login login) {
		String name = login.getName();
		System.out.println(name);
		ViewLeave viewLeave = new ViewLeave();
		return viewLeave.viewLeave(name);
	}

	//Accepting leave
	@Path("accept")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String accept(Leave leave) {
		AcceptLeave acceptLeave = new AcceptLeave();
		return acceptLeave.acceptLeave(leave);
	}

	//Rejecting leave
	@Path("reject")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String reject(Leave leave) {
		RejectLeave rejectLeave = new RejectLeave();
		return rejectLeave.rejectLeave(leave);
	}
}
