package m10_N3;

import java.util.ArrayList;
import java.util.List;

public class MainN3 {
	static List<Alumne> Alumnes;

	public static void main(String[] args) {

		MainN3 c03 = new MainN3();

		Alumnes = new ArrayList<Alumne>();
		// Omple la llista amb 10 alu
		Alumnes.add(new Alumne(1, "Alumne1", 17, "Java", 1));
		Alumnes.add(new Alumne(2, "BAlumne1", 22, "JSON", 2));
		Alumnes.add(new Alumne(3, "CAlumne1", 23, "Angular", 3));
		Alumnes.add(new Alumne(4, "DAlumne1", 24, "React", 4));
		Alumnes.add(new Alumne(5, "EAlumne1", 25, "Vue", 5));
		Alumnes.add(new Alumne(6, "FAlumne1", 26, "Java", 6));
		Alumnes.add(new Alumne(7, "GAlumne1", 27, "PHP", 7));
		Alumnes.add(new Alumne(8, "HAlumne1", 28, "NodeJS", 8));
		Alumnes.add(new Alumne(9, "IAlumne1", 29, "Java", 9));
		Alumnes.add(new Alumne(10, "AAlumne1", 30, "DataScience", 10));

//		Mostra per pantalla el nom i l’edat de cada alumne. 
		c03.Ex01();

//		Filtra la llista per tots els alumnes que el nom comensi per “a”, asigna-ho a un altre llista y mostra per pantalla la nova llista (tot amb lambdas) 
		c03.Ex02();

		// Filtra y mostra per pantalla els alumnes que tinguin un 5 o mes de nota.
		c03.Ex03();

//		Filtra y mostra per pantalla els alumnes que tinguin un 5 o mes de nota y que no siguin de PHP. 
		c03.Ex04();

//		Mostra tots els alumnes que facin JAVA i siguin majors d’edat. 
		c03.Ex05();

	}

//	Mostra per pantalla el nom i l’edat de cada alumne.
	private void Ex01() {
		System.out.println("-- M10 N3 - Ex1 ------");
		Alumnes.stream().forEach(v -> System.out.println("Nom=" + v.getNom() + " - Edat= " + v.getEdat()));

	}

//	Filtra la llista per tots els alumnes que el nom comensi per “a”, asigna-ho a un altre llista y mostra per pantalla la nova llista (tot amb lambdas)
	private void Ex02() {
		System.out.println("-- M10 N3 - Ex2 ------");

		Alumnes.stream().filter(l -> (l.getNom().startsWith("a") || l.getNom().startsWith("A")))
				.forEach(v -> System.out.println("Nom=" + v.getNom()));

	}

	// Filtra y mostra per pantalla els alumnes que tinguin un 5 o mes de nota.
	private void Ex03() {
		System.out.println("-- M10 N3 - Ex3 ------");
		Alumnes.stream().filter(l -> l.getNota() >= 5).forEach(v -> System.out.println(v.toString()));

	}

//	Filtra y mostra per pantalla els alumnes que tinguin un 5 o mes de nota y que no siguin de PHP.
	private void Ex04() {
		System.out.println("-- M10 N3 - Ex4 ------");
		Alumnes.stream().filter(l -> (l.getNota() >= 5 && l.getCurs() != "PHP"))
				.forEach(v -> System.out.println(v.toString()));
	}

//	Mostra tots els alumnes que facin JAVA i siguin majors d’edat. 
	private void Ex05() {
		System.out.println("-- M10 N3 - Ex5 ------");
		Alumnes.stream()
			.filter(l -> l.getCurs().equals("Java") && l.getEdat() >=18)
			.forEach(System.out::println);
		

	}

}
