package m10_N1_F1_Lambdas;

import java.util.List;
import java.util.stream.Collectors;

public class Lambdes {

	/**
	 * Fase 1
	 * 
	 * Tenint una llista de cadenes de noms propis, escriu un mètode que retorne una
	 * llista de totes les cadenes que comencen amb la lletra 'a' (mayuscula) i
	 * tenen exactament 3 lletres. Imprimeix el resultat.
	 * 
	 * 
	 */

	public List<String> getNomsStartA3(List<String> llista, String starts, int Long) {

		return llista.stream().filter(l -> l.startsWith(starts)).filter(l -> l.length() >= Long)
				.collect(Collectors.toList());
	}

	/**
	 * Escriu un mètode que retorne una cadena separada per comes basada en una
	 * llista d’Integers. Cada element hauria d'anar precedit per la lletra "e" si
	 * el nombre és parell, i precedit de la lletra "o" si el nombre és imparell.
	 * Per exemple, si la llista d'entrada és (3,44), la sortida hauria de ser "o3,
	 * e44". Imprimeix el resultat.
	 * 
	 */

	public String getNumToString(List<Integer> llista, int divisible, String separator) {
		return llista.stream().map(n -> (n % divisible == 0) ? "e" + n : "o" + n)
				.collect(Collectors.joining(separator));
	}

	/**
	 * 
	 * Tenint una llista de Strings, escriu un mètode que retorne una llista de
	 * totes les cadenes que continguen la lletra ‘o’ i imprimeix el resultat.
	 * 
	 */
	public List<String> getNomsWithO(List<String> llista, String contains) {
		return llista.stream().filter(l -> l.contains(contains)).collect(Collectors.toList());
	}

	/**
	 * 
	 * Has de fer el mateix que en el punt anterior, però retornant una llista que
	 * incloga els elements amb més de 5 lletres. Imprimeix el resultat.
	 * 
	 */
	public List<String> getNomsWithOWith5(List<String> llista, String contains, int minLong) {
		return llista.stream().filter(l -> l.contains(contains)).filter(l -> l.length() >= minLong).collect(Collectors.toList());
	}

	

	/**
	 * 
	 * Crea una llista amb els nombs dels mesos de l’any. Imprimeix tots els
	 * elements de la llista amb una lambda.
	 * 
	 * Has de fer la mateixa impressió del punt anterior però fent-ho mitjançant
	 * method reference.
	 */
	public List<String> getAllMesos(List<String> llista){
		return llista.stream().collect(Collectors.toList());
	}
	

	/**
	 * 
	 * Has de fer la mateixa impressió del punt anterior però fent-ho mitjançant
	 * method reference.
	 */

}
