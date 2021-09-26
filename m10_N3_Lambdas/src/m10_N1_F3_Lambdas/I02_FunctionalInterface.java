package m10_N1_F3_Lambdas;

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
@FunctionalInterface
public interface I02_FunctionalInterface {

	String reverse(String inString);
}
