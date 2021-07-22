package com.jobs.domain;

public class Volunteer extends AbsStaffMember {

	protected String description;

	public Volunteer(String name, String address, String phone, String description) throws Exception {
		super(name, address, phone);
		this.description = description;
	}

	// Creem un constructor només amb els 3 parametres basics
	public Volunteer(String name, String address, String phone) throws Exception {
		super(name, address, phone);
		description = "No cobra!";

	}

	@Override
	public void pay() {
		//Com és voluntari no cobra
		totalPaid=0.0;

	}

	// Sobrescribim el métode toString pq ens torni el text
	@Override
	public String toString() {

		// return super.toString();
		return "Vol [name=" + this.name + ", address=" + this.address + ", phone=" + this.phone + ", descripcion="
				+ this.description + ", total=" + this.totalPaid + "]";
	}

}
