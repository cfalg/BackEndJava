package m10_N3;

/**
 * Crea una clase Alumne que tingui com a propietats: Nom, edat, curs i nota.
 * 
 * @author escfa01
 *
 */
public class Alumne {

	int id;
	String nom;
	int edat;
	String curs;
	int nota;

	public Alumne(int id, String nom, int edat, String curs, int nota) {
		super();
		this.id = id;
		this.nom = nom;
		this.edat = edat;
		this.curs = curs;
		this.nota = nota;
	}

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

	public int getEdat() {
		return edat;
	}

	public void setEdat(int edat) {
		this.edat = edat;
	}

	public String getCurs() {
		return curs;
	}

	public void setCurs(String curs) {
		this.curs = curs;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "Alumne [id=" + id + ", nom=" + nom + ", edat=" + edat + ", curs=" + curs + ", nota=" + nota + "]";
	}

}
