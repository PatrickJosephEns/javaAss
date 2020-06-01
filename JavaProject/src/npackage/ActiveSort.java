package npackage;

import java.util.Comparator;

/**
 * 
 * @author Patrick
 * Compares the active cases in the data
 */
public class ActiveSort implements Comparator<Dhb> {
	
	@Override
	public int compare(Dhb c1, Dhb c2) {
		
		return c2.getActive() -c1.getActive();
	}

}
