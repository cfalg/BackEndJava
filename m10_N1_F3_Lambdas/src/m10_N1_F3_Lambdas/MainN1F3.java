package m10_N1_F3_Lambdas;

import m10_N1_F2_Lambdas.I01_FunctionalInterface;

/**
 * Crea una Functional Interface que continga un mètode abstracte reverse (),
 * que retorne un valor String; en una altra classe, injecta a la interfície
 * creada mitjançant una lambda el cos del mètode, de manera que torne la
 * mateixa cadena que rep com a paràmetre però a l'inrevés. Invoca la instància
 * de la interfície passant-li una cadena i comprovant el resultat.
 * 
 * @author Carles
 *
 */
public class MainN1F3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		I02_FunctionalInterface i02 = (v) -> {return new StringBuilder(v).reverse().toString();};
		
		System.out.println("El valor de la Functional Inteface reverse es  = ----> ("+ i02.reverse("Text a retornar invers")+")");
		
		
	}

}
