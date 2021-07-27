package com.jobs.domain;

public class Employee extends AbsStaffMember {

	protected double salaryPerMonth;
	protected IPaymentRate paymentRate;	
	
	//[CFV - 27/07/2021] - Nivell 3
	protected double salaryPerMonthGross;
	protected double salaryPerMonthNet;
	protected double salaryPerYearGross;
	protected double salaryPerYearNet;
	
	
	

	public Employee(String name, String address, String phone, double salaryPerMonth,IPaymentRate paymentRate) throws Exception {
		super(name, address, phone);		
		if(salaryPerMonth<0) throw new Exception();
		if(paymentRate==null) throw new Exception();
				
		this.salaryPerMonth=salaryPerMonth;
		this.paymentRate=paymentRate;
	}

	
	@Override
	public void pay() {
		totalPaid=paymentRate.pay(salaryPerMonth);
	}
	
	//Has de crear una funció que permeti emetre un bonus a tota la plantilla. Aquest bonus és un 10% del sou anual de cada empleat. Els volunteers no reben aquest bonus. 
	public void payBonus() {
		bonus=salaryPerYearGross * 10 /100;
	}


	//Sobrescribim el m�tode toString pq ens torni el text
	@Override
	public String toString() {
		
		// TODO Auto-generated method stub
		//return super.toString();
		return "Employee  [name="+this.name+", address="+this.address+", phone="+this.phone
				+ ", salaryPerMonth="+this.salaryPerMonth + ", total=" + this.totalPaid +"]";
	}

	
	
}
