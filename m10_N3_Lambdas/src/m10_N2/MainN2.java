package m10_N2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Nivell 2
 * 
 * 
 * 
 * 
 * Feu una matriu que contingui algunes cadenes de text y numeros. Ordeneu-lo
 * per:
 * 
 * longitud (de més curta a més llarga)
 * longitud inversa (de més llarga a més curta)
 * alfabèticament pel primer caràcter (Nota: charAt (0) retorna el codi numèric
 * del primer caràcter)
 * Les cadenes que contenen "e" primer, tota la resta en segon lloc. De moment,
 * poseu el codi directament a la lambda.
 * Modifica tots els elements de la matriu per canviar els caracters “a” a “4”
 * Mostra només els elements que siguin 100% numerics. (tot i que estigui
 * guardats com strings)
 * 
 * 
 * Crea una Functional Interface que continga un mètode abstracte operacio (),
 * que retorne un valor float; injecta a la interfície creada mitjançant una
 * lambda el cos del mètode, de manera que pugis transformar la operació a una
 * suma, resta, multiplicació i divisio.
 * 
 * @author Carles
 *
 */
public class MainN2 {

	static String[] cadenas = { "texte1", "1", "texte22", "2", "texte333", "3", "texte4444", "4", "texte55555", "5",
			"texte666666", "6", "texte7777777", "7", "texte88888888", "8","eTexte9", "taxta10","taxta11","9" };

	public static void main(String[] args) {

		MainN2 c02 = new MainN2();

		c02.ex01(cadenas);
		c02.ex02(cadenas);
		c02.ex03(cadenas);
		c02.ex04(cadenas);
		c02.ex05(cadenas);
		c02.ex06(cadenas);

	}

	/**
	 * longitud (de més curta a més llarga)
	 * 
	 */
	private void ex01(String[] cadena) {

		System.out.println("-- M10 N2 - Ex1 ------");

		List<String> list = new ArrayList<>(Arrays.asList(cadena));
		list.stream().sorted(Comparator.comparing(v -> v.length())).forEach(System.out::println);
	}

	/**
	 * longitud inversa (de més llarga a més curta)
	 * 
	 */
	private void ex02(String[] cadena) {

		System.out.println("-- M10 N2 - Ex2 ------");

		List<String> list = new ArrayList<>(Arrays.asList(cadena));
		list.stream().sorted(Comparator.comparing(v -> ((String) v).length()).reversed()).forEach(System.out::println);

	}

	/**
	 * alfabèticament pel primer caràcter (Nota: charAt (0) retorna el codi numèric
	 * del primer caràcter)
	 * 
	 */
	private void ex03(String[] cadena) {

		System.out.println("-- M10 N2 - Ex3 ------");

		List<String> list = new ArrayList<>(Arrays.asList(cadena));
		list.stream().sorted(Comparator.comparing(v -> v.charAt(0))).forEach(System.out::println);

	}

	/**
	 * Les cadenes que contenen "e" primer, tota la resta en segon lloc. De moment,
	 * poseu el codi directament a la lambda.
	 * 
	 */
	private void ex04(String[] cadena) {

		System.out.println("-- M10 N2 - Ex4 ------");

		List<String> list = new ArrayList<>(Arrays.asList(cadena));
		list.stream()
			.filter(l -> l.startsWith("e"))
			.forEach(System.out::println);

//		List<String> sortedList = list.stream()
//				.collect(Collectors.toList());
//
//		sortedList.forEach(System.out::println);

	}

	
	/**
	 * Modifica tots els elements de la matriu per canviar els caracters “a” a “4” 
	 * 
	 */
	private void ex05(String[] cadena) {

		System.out.println("-- M10 N2 - Ex5 ------");

		List<String> list = new ArrayList<>(Arrays.asList(cadena));
		list.stream()
			.map(v -> v.replace("a","4"))
			.forEach(System.out::println);
	}	
	
	
  
	/**
	 * 	Mostra només els elements que siguin 100% numerics. (tot i que estigui guardats com strings) 
	 * 
	 */
	private void ex06(String[] cadena) {

		System.out.println("-- M10 N2 - Ex6 ------");
		String exprNumeros = "[0-9]+";

		List<String> list = new ArrayList<>(Arrays.asList(cadena));
		list.stream()
			.filter(v -> v.matches(exprNumeros))
			.forEach(System.out::println);
		
	}	
	

	
	
	
}
