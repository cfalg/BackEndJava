package com.itacademy.s0402_simpleHttpService.Model.Entities;

public class Empleat {

	//private static int ID_CONTADOR = 0;
	private int id;
	private String nom;
	private EnumFeines feina;
	private int salari;

	public Empleat() {
	}

	public Empleat(String nom, EnumFeines feina, int salari) {
		super();
//		this.id = ID_CONTADOR;
//		ID_CONTADOR++;
		this.nom = nom;
		this.feina = feina;
		this.salari = salari;
	}

	public Empleat(String nom, EnumFeines feina) {
		super();
//		this.id = ID_CONTADOR;
//		ID_CONTADOR++;
		this.nom = nom;
		this.feina = feina;
		this.setSalari(feina);
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public EnumFeines getFeina() {
		return feina;
	}

	public void setFeina(EnumFeines feina) {
		this.feina = feina;
	}

	public int getSalari() {
		return salari;
	}

	public void setSalari(EnumFeines feina) {
		int salari = 0;

		if (feina.equals(EnumFeines.ADMINISTRATIU)) {
			salari = 25000;
		} else if (feina.equals(EnumFeines.COMERCIAL)) {
			salari = 38000;
		} else if (feina.equals(EnumFeines.DIRECTIU)) {
			salari = 45000;
		} else if (feina.equals(EnumFeines.DISSENYADOR)) {
			salari = 30000;
		} else if (feina.equals(EnumFeines.OPERACIONS)) {
			salari = 27000;
		} else if (feina.equals(EnumFeines.PRODUCCIO)) {
			salari = 35000;
		} else {
			salari = 0;
		}

		this.salari = salari;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	


}
