package com.vehicles.project;

public class Conductor extends AbsPersona {

	private LLicenciaConduir llicenciaConduir;

	public Conductor(String nom, String cognoms, int dia, int mes, int any, LLicenciaConduir llicenciaConduir) throws Exception {
		super(nom, cognoms, dia, mes, any);
		this.llicenciaConduir = llicenciaConduir;

	}

	@Override
	public String toString() {
		return "Conductor [id=" + id + ", nom=" + nom + ", cognoms=" + cognoms + ", diaNaixament=" + diaNaixament
				+ ", mesNaixament=" + mesNaixament + ", anyNaixament=" + anyNaixament + ", llicenciaConduir="
				+ llicenciaConduir + "]";
	}

}
