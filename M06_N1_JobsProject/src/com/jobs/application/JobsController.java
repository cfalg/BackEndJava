package com.jobs.application;

import com.jobs.domain.AbsStaffMember;
import com.jobs.domain.Employee;
import com.jobs.domain.Volunteer;
import com.jobs.persistence.EmployeeRepository;

public class JobsController {

	private EmployeeRepository repository;
	
	public JobsController(){
		//Creem el repository ja que no pot estar null
		repository= new EmployeeRepository();
	}
	
	public void createBossEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee boss = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateBoss());
		repository.addMember(boss);
	}
	
	public void createEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee employee = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateEmployee());
		repository.addMember(employee);
	}

	public void createManagerEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{
		// [CFV-19/07/2021] Creem per crear un manager
		Employee manager = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateManager());
		repository.addMember(manager);
		
	}


	public void payAllEmployeers() {
				
		for (AbsStaffMember e :repository.getAllMembers()) {
			e.pay();
			
		}
	}

	public String getAllEmployees() {
		String allEmployees=" \n";
		
		//[CFV-19/07/2021] Recorrem tot el repository per reseguir un a un tots els treballadors
		for (AbsStaffMember e :repository.getAllMembers()) {
			//Employee empleado = (Employee) e;
			allEmployees += e.toString() + " \n";
		}
		

		return allEmployees;
	}

	public void createVolunteer(String name, String address, String phone) throws Exception {
		// Creem un nou voluntari
		Volunteer vol = new Volunteer(name, address, phone);
		repository.addMember(vol);
		
	}
	
	
	
}
