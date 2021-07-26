package com.jobs.domain;


/**
 * 
 * @author Carles Falgueras - 26/07/2021
 *
 */
public class Manager extends Employee {
	
	private static double SOU_A_COBRAR_MIN =3000;
	private static double SOU_A_COBRAR_MAX =5000;

	public Manager(String name, String address, String phone, double salaryPerMonth, IPaymentRate paymentRate)
			throws Exception {
		super(name, address, phone, salaryPerMonth, paymentRate);


		try {
			//per validar el sou total fem
			this.pay();
			if(this.totalPaid<SOU_A_COBRAR_MIN || this.totalPaid>SOU_A_COBRAR_MAX) {
				throw new SouException("Manager: Ha de cobrar més de 3000 però menys de 5000€"+ " ("+this.totalPaid+"€)");
			}
		} catch (SouException e) {
			System.out.println(e.getMessage());
		}
		
		
	}

	@Override
	public String toString() {
		return "Manager   [name="+this.name+", address="+this.address+", phone="+this.phone
				+ ", salaryPerMonth="+this.salaryPerMonth + ", total=" + this.totalPaid +"]";
	}

}
