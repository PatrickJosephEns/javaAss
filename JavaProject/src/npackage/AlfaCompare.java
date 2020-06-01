package npackage;

import java.util.Comparator;

/**
 * 
 * @author Patrick
 * Compares the names of the dhbs in the data
 */
public class AlfaCompare implements Comparator<Dhb> {
	
	@Override
	public int compare(Dhb c1, Dhb c2) {
		
		return c1.getDhbs().compareTo(c2.getDhbs());
	}
}
