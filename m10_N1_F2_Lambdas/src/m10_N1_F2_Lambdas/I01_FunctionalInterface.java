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

@FunctionalInterface
public interface I01_FunctionalInterface {

	double getPiValue();
}
