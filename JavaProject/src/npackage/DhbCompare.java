package npackage;

import java.util.Comparator;

public class DhbCompare implements Comparator<Dhb> {
	
	@Override
	public int compare(Dhb c1, Dhb c2) {
		
		return c2.getTotal() -c1.getTotal();
	}

}
