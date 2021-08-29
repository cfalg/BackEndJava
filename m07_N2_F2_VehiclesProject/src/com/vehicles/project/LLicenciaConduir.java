package com.vehicles.project;

public class LLicenciaConduir {

	protected int id;
	protected String tipusLlicencia;
	protected String nomComplert;
	protected int diaCaducitat;
	protected int mesCaducitat;
	protected int anyCaducitat;
	
	private static int COUNTER_LLICENCIA_COUNDIR = 1;
	
	
	public LLicenciaConduir(String tipusLlicencia, String nomComplert, int diaCaducitat, int mesCaducitat,
			int anyCaducitat) {
		super();
		this.tipusLlicencia = tipusLlicencia;
		this.nomComplert = nomComplert;
		this.diaCaducitat = diaCaducitat;
		this.mesCaducitat = mesCaducitat;
		this.anyCaducitat = anyCaducitat;
		
		this.id = COUNTER_LLICENCIA_COUNDIR;
		COUNTER_LLICENCIA_COUNDIR++;
	}


	public String getTipusLlicencia() {
		return tipusLlicencia;
	}


	public void setTipusLlicencia(String tipusLlicencia) {
		this.tipusLlicencia = tipusLlicencia;
	}


	public String getNomComplert() {
		return nomComplert;
	}


	public void setNomComplert(String nomComplert) {
		this.nomComplert = nomComplert;
	}


	public int getDiaCaducitat() {
		return diaCaducitat;
	}


	public void setDiaCaducitat(int diaCaducitat) {
		this.diaCaducitat = diaCaducitat;
	}


	public int getMesCaducitat() {
		return mesCaducitat;
	}


	public void setMesCaducitat(int mesCaducitat) {
		this.mesCaducitat = mesCaducitat;
	}


	public int getAnyCaducitat() {
		return anyCaducitat;
	}


	public void setAnyCaducitat(int anyCaducitat) {
		this.anyCaducitat = anyCaducitat;
	}


	public int getId() {
		return id;
	}


	@Override
	public String toString() {
		return "LLicenciaConduir [id=" + id + ", tipusLlicencia=" + tipusLlicencia + ", nomComplert=" + nomComplert
				+ ", diaCaducitat=" + diaCaducitat + ", mesCaducitat=" + mesCaducitat + ", anyCaducitat=" + anyCaducitat
				+ "]";
	}
	
	
	
	

}
