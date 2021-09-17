package m10_N1_F1_Lambdas;

/**
 * Fase 1
 * Tenint una llista de cadenes de noms propis, escriu un mètode que retorne una
 * llista de totes les cadenes que comencen amb la lletra 'a' (mayuscula) i
 * tenen exactament 3 lletres. Imprimeix el resultat.
 * 
 * Escriu un mètode que retorne una cadena separada per comes basada en una
 * llista d’Integers. Cada element hauria d'anar precedit per la lletra "e" si
 * el nombre és parell, i precedit de la lletra "o" si el nombre és imparell.
 * Per exemple, si la llista d'entrada és (3,44), la sortida hauria de ser "o3,
 * e44". Imprimeix el resultat.
 * 
 * Tenint una llista de Strings, escriu un mètode que retorne una llista de
 * totes les cadenes que continguen la lletra ‘o’ i imprimeix el resultat.
 * 
 * Has de fer el mateix que en el punt anterior, però retornant una llista que
 * incloga els elements amb més de 5 lletres. Imprimeix el resultat.
 * 
 * Crea una llista amb els nombs dels mesos de l’any. Imprimeix tots els
 * elements de la llista amb una lambda.
 * 
 * Has de fer la mateixa impressió del punt anterior però fent-ho mitjançant
 * method reference.
 * 
 * 
 * @author Carles
 *
 */

public class Main {

	Llistes llista = new Llistes();
	Lambdes clambdes = new Lambdes();

	public static void main(String[] args) {
		Main m = new Main();

		m.ex1();
		m.ex2();
		m.ex3();
		m.ex4();
		m.ex5();
		m.ex6();

	}

	/**
	 * Tenint una llista de cadenes de noms propis, escriu un mètode que retorne una
	 * llista de totes les cadenes que comencen amb la lletra 'a' (mayuscula) i
	 * tenen exactament 3 lletres. Imprimeix el resultat.
	 */
	private void ex1() {

		System.out.println("--- Ex01 ---");
		clambdes.getNomsStartA3(llista.LlistaNomPropis, "A", 3).forEach(System.out::println);

	}

	/**
	 * Escriu un mètode que retorne una cadena separada per comes basada en una
	 * llista d’Integers. Cada element hauria d'anar precedit per la lletra "e" si
	 * el nombre és parell, i precedit de la lletra "o" si el nombre és imparell.
	 * Per exemple, si la llista d'entrada és (3,44), la sortida hauria de ser "o3,
	 * e44". Imprimeix el resultat.
	 * 
	 */
	private void ex2() {
		System.out.println("--- Ex02 ---");
		System.out.println(clambdes.getNumToString(llista.LlistaNumeros, 2, " - "));
	}

	/**
	 * 
	 * Tenint una llista de Strings, escriu un mètode que retorne una llista de
	 * totes les cadenes que continguen la lletra ‘o’ i imprimeix el resultat.
	 * 
	 */
	private void ex3() {

		System.out.println("--- Ex03 ---");
		clambdes.getNomsWithO(llista.LlistaNomPropis, "o").forEach(System.out::println);

	}

	/**
	 * 
	 * Has de fer el mateix que en el punt anterior, però retornant una llista que
	 * incloga els elements amb més de 5 lletres. Imprimeix el resultat.
	 * 
	 */
	private void ex4() {

		System.out.println("--- Ex04 ---");
		clambdes.getNomsWithOWith5(llista.LlistaNomPropis, "o", 5).forEach(System.out::println);

	}

	/**
	 * 
	 * Crea una llista amb els nombs dels mesos de l’any. Imprimeix tots els
	 * elements de la llista amb una lambda.
	 * 
	 * Has de fer la mateixa impressió del punt anterior però fent-ho mitjançant
	 * method reference.
	 */
	private void ex5() {
		
		System.out.println("--- Ex05 ---");
		clambdes.getAllMesos(llista.LlistaMesos).forEach(v -> System.out.println(v));

	}
	
	
	private void ex6() {
		
		System.out.println("--- Ex06 ---");
		clambdes.getAllMesos(llista.LlistaMesos).forEach(System.out::println);

	}
}
