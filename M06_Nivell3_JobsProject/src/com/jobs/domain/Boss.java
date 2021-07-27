package com.jobs.domain;


/**
 * 
 * @author Carles Falgueras - 26/07/2021
 *
 */
public class Boss extends Employee {

	private static double SOU_A_COBRAR_MIN =8000;
	private static double IRPF = 32;
	
	
	public Boss(String name, String address, String phone, double salaryPerMonth, IPaymentRate paymentRate)
			throws Exception {
		super(name, address, phone, salaryPerMonth, paymentRate);
		
		try {
			//per validar el sou total fem
			this.pay();
			if(this.totalPaid<=SOU_A_COBRAR_MIN) {
				throw new SouException("Boss: Ha de cobrar més de 8000 € " + "("+this.totalPaid+"€)");
			}
		} catch (SouException e) {
			System.out.println(e.getMessage());
		}
		
		//CFV - Informem el sou net i brut
		this.salaryPerMonthGross=this.salaryPerMonth;
		this.salaryPerMonthNet=this.salaryPerMonthGross- (this.salaryPerMonthGross*IRPF/100); 
		this.salaryPerYearGross=this.salaryPerMonthGross *12;
		this.salaryPerYearNet=this.salaryPerMonthNet * 12;
		
	}


	
	
	@Override
	public String toString() {
		return "Boss      [name="+this.name+", address="+this.address+", phone="+this.phone
				+ ", salaryPerMonth="+this.salaryPerMonth + ", total=" + this.totalPaid 
				+ ", salaryPerMonthGross="+this.salaryPerMonthGross
				+ ", salaryPerMonthNet="+this.salaryPerMonthNet
				+ ", salaryPerYearGross="+this.salaryPerYearGross
				+ ", salaryPerYearNet="+this.salaryPerYearNet
				+ ", bonus="+this.bonus
				+"]";
	}

}
