package npackage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

public class Utilities {

	public static void load(ArrayList<Dhb> districs) {
		String dhbs;
		String line;
		int active;
		int recovered;
		int deceased;
		int total;
		int lastDay;
		
		try {
			BufferedReader in = new BufferedReader (new FileReader ("DataProg.csv"));
			while ((line = in.readLine())!= null){
				String[] fields = line.split(",");
				dhbs = fields[0];
				active = Integer.parseInt(fields[1]);
				recovered = Integer.parseInt(fields[2]);
				deceased = Integer.parseInt(fields[3]);
				total = Integer.parseInt(fields[4]);
				lastDay = Integer.parseInt(fields[5]);
				districs.add(new Dhb(dhbs, active,recovered,deceased, total, lastDay));
	
			}
		}catch(IOException e) {
				System.out.println("File missing");
			}for (Dhb item: districs) {
				System.out.println(item);
			}
			
			Collections.sort(districs, new DhbCompare());	
	    }
	
	public static Dhb Search(ArrayList<Dhb> districs, String dhbs) {
		Dhb match = null;
		boolean matched = false;
		for(int i = 0; i < 19; i++) {
			if(districs.get(i).getDhbs().toLowerCase().contains(dhbs.toLowerCase())) {
				
				match = districs.get(i);
				matched = true;
			}
		}
		
		if(!matched){
			JOptionPane.showMessageDialog(null, "No match found", "ERROR", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		return match;	
	}
	
	public static int averageRecovered(ArrayList<Dhb> districs) {
		int total = 0;
		for(int i = 0; i < 19; i++) {
			total += districs.get(i).getRecovered();
		}		
		return total / 19;
	}
	
	public static int averageActive(ArrayList<Dhb> districs) {
		int total = 0;
		for(int i = 0; i < 19; i++) {
			total += districs.get(i).getActive();
		}		
		return total / 19;
	}
}

