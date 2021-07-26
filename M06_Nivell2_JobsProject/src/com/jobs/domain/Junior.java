package com.jobs.domain;

/**
 * 
 * @author Carles Falgueras - 21/07/2021
 *
 */
public class Junior extends Employee {

	private static double SOU_A_COBRAR_MIN =900;
	private static double SOU_A_COBRAR_MAX =1600;
	
	public Junior(String name, String address, String phone, double salaryPerMonth, IPaymentRate paymentRate)
			throws Exception {
		super(name, address, phone, salaryPerMonth, paymentRate);

		try {
			//per validar el sou total fem
			this.pay();
			if(this.totalPaid<SOU_A_COBRAR_MIN || this.totalPaid>SOU_A_COBRAR_MAX) {
				throw new SouException("Junior: Ha de cobrar més de 900 però menys de 1600€"+ " ("+this.totalPaid+"€)");
			}
		} catch (SouException e) {
			System.out.println(e.getMessage());
		}

		
		
		 
	}

	@Override
	public String toString() {
		return "Junior    [name="+this.name+", address="+this.address+", phone="+this.phone
				+ ", salaryPerMonth="+this.salaryPerMonth + ", total=" + this.totalPaid +"]";
	}

}
