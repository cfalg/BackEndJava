package com.jobs.application;

import com.jobs.domain.AbsStaffMember;
import com.jobs.domain.Boss;
import com.jobs.domain.Employee;
import com.jobs.domain.Junior;
import com.jobs.domain.Manager;
import com.jobs.domain.Mid;
import com.jobs.domain.Senior;
import com.jobs.domain.Volunteer;
import com.jobs.persistence.EmployeeRepository;

public class JobsController {

	private EmployeeRepository repository;
	
	public JobsController(){
		//Creem el repository ja que no pot estar null
		repository= new EmployeeRepository();
	}
	
	public void createBossEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Boss boss = new Boss(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateBoss());
		repository.addMember(boss);
	}
	
	public void createEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee employee = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateEmployee());
		repository.addMember(employee);
	}

	public void createManagerEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{
		// [CFV-19/07/2021] Creem per crear un manager
		Manager manager = new Manager(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateManager());
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
	
	
	public void createJuniorEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{
		// [CFV-21/07/2021] Creem per crear un Junior
		Junior junior = new Junior(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateJunior());
		repository.addMember(junior);
		
	}
	
	public void createMidEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{
		// [CFV-25/07/2021] Creem per crear un Mid
		Mid mid = new Mid(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateMid());
		repository.addMember(mid);
		
	}	

	public void createSeniorEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{
		// [CFV-25/07/2021] Creem per crear un Senior
		Senior senior = new Senior(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateSenior());
		repository.addMember(senior);
		
	}	
	
	
	//Funció que pagará un bonus a tots els treballadors
	public void payBonusAllEmployeers() {
		
		for (AbsStaffMember e :repository.getAllMembers()) {
			e.payBonus();
			
		}
	}
	
	
}
