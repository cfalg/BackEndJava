package m10_N1_F2_Lambdas;

/**
 * Crea una Functional Interface que continga un mètode abstracte getPiValue (),
 * que retorna un valor double; en una altra classe, instancie la interfície i
 * assigneu-li mitjançant una lambda el valor 3.1415. Invoca el mètode
 * getPiValue de la instància d'interfície i imprimeix el resultat
 * 
 * @author Carles
 *
 */
public class MainN1F2 {

	public static void main(String[] args) {


		//aqui definim que farà la funció lambda que ens ha de tornar un double
		I01_FunctionalInterface i01 = () -> 3.1415;
		
		
		//aqui la cridem
		System.out.println("El valor de la Functional Inteface getPiValue es "+ i01.getPiValue());


	}

}
