package npackage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
	    }
	
	public static Dhb Search(ArrayList<Dhb> districs, String dhbs) {
		Dhb match = null;
		boolean matched = false;
		for(int i = 0; i < 19; i++) {
			if(districs.get(i).getDhbs().toLowerCase().equals(dhbs.toLowerCase())) {
				
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
}

