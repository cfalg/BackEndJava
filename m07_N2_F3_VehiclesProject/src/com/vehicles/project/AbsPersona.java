package com.vehicles.project;


public abstract class AbsPersona {

	protected int id;
	protected String nom;
	protected String cognoms;
	protected int diaNaixament;
	protected int mesNaixament;
	protected int anyNaixament;
	
	private static int COUNTER_PERSONES = 1;
	
	
	

	
	public AbsPersona(String nom, String cognoms, int dia, int mes, int any) throws Exception {
		//GregorianCalendar dataNaixament = new GregorianCalendar(any, mes, dia);
		
		if (nom.equals(""))
			throw new Exception();
		if (cognoms.equals(""))
			throw new Exception();
//		if (dia.equals(null))
//			throw new Exception();
//		if (mes.equals(""))
//			throw new Exception();
//		if (any.equals(""))
//			throw new Exception();
		
		
		this.nom = nom;
		this.cognoms = cognoms;
		this.diaNaixament = dia;
		this.mesNaixament = mes;
		this.anyNaixament=any;
		
		id = COUNTER_PERSONES;
		COUNTER_PERSONES++;
	}
	

	//Creem el mètode toString per forçar que les subclasses la implementin
	public abstract String toString();


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getCognoms() {
		return cognoms;
	}


	public void setCognoms(String cognoms) {
		this.cognoms = cognoms;
	}


	public int getDiaNaixament() {
		return diaNaixament;
	}


	public void setDiaNaixament(int diaNaixament) {
		this.diaNaixament = diaNaixament;
	}


	public int getMesNaixament() {
		return mesNaixament;
	}


	public void setMesNaixament(int mesNaixament) {
		this.mesNaixament = mesNaixament;
	}


	public int getAnyNaixament() {
		return anyNaixament;
	}


	public void setAnyNaixament(int anyNaixament) {
		this.anyNaixament = anyNaixament;
	}
	
	
}
