package com.vehicles.project;

public class TitularVehicle extends AbsPersona {

	protected boolean siTeAsseguranca;
	protected boolean siTeGaratgePropi;
	private LLicenciaConduir llicenciaConduir;
	
	public TitularVehicle(String nom, String cognoms, int dia, int mes, int any, LLicenciaConduir llicenciaConduir, boolean siTeAsseguranca, boolean siTeGaratgePropi) throws Exception {
		super(nom, cognoms, dia, mes, any);
		this.llicenciaConduir = llicenciaConduir;
		this.siTeAsseguranca = siTeAsseguranca;
		this.siTeGaratgePropi = siTeGaratgePropi;
	}

	@Override
	public String toString() {
		return "TitularVehicle [id=" + id + ", nom=" + nom + ", cognoms=" + cognoms + ", diaNaixament=" + diaNaixament
				+ ", mesNaixament=" + mesNaixament + ", anyNaixament=" + anyNaixament + ", llicenciaConduir="
				+ llicenciaConduir + ", siTeAsseguranca=" + siTeAsseguranca + ", siTeGaratgePropi=" + siTeGaratgePropi
				+ "]";
	}

	
	
	public boolean isSiTeAsseguranca() {
		return siTeAsseguranca;
	}

	public void setSiTeAsseguranca(boolean siTeAsseguranca) {
		this.siTeAsseguranca = siTeAsseguranca;
	}

	public boolean isSiTeGaratgePropi() {
		return siTeGaratgePropi;
	}

	public void setSiTeGaratgePropi(boolean siTeGaratgePropi) {
		this.siTeGaratgePropi = siTeGaratgePropi;
	}

	public LLicenciaConduir getLlicenciaConduir() {
		return llicenciaConduir;
	}

	public void setLlicenciaConduir(LLicenciaConduir llicenciaConduir) {
		this.llicenciaConduir = llicenciaConduir;
	}

	
	
}
