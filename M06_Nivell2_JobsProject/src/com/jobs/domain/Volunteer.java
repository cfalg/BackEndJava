package com.jobs.domain;

public class Volunteer extends AbsStaffMember {

	protected String description;

	public Volunteer(String name, String address, String phone, String description) throws Exception {
		super(name, address, phone);
		this.description = description;
		
		this.validaSou();
		
	}

	// Creem un constructor nom�s amb els 3 parametres basics
	public Volunteer(String name, String address, String phone) throws Exception {
		super(name, address, phone);
		description = "No cobra!";

		this.validaSou();
		
	}
	
	
	private void validaSou() {
		try {
			//per validar el sou total fem
			this.pay();
			if(this.totalPaid != 0) {
				throw new SouException("Volunteer: No pot cobrar ");
			}
		} catch (SouException e) {
			System.out.println(e.getMessage());
		}
	}
	

	@Override
	public void pay() {
		//Com �s voluntari no cobra
		totalPaid=0.0;

	}

	// Sobrescribim el m�tode toString pq ens torni el text
	@Override
	public String toString() {

		// return super.toString();
		return "Volunteer [name=" + this.name + ", address=" + this.address + ", phone=" + this.phone + ", descripcion="
				+ this.description + ", total=" + this.totalPaid + "]";
	}

}
