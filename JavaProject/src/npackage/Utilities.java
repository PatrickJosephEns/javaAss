package npackage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Utilities {

	public static void load(ArrayList<Dhb> dhb) {
		String dhbs;
		String line;
		String active;
		String recovered;
		String deceased;
		String total;
		String lastDay;
		
		try {
			BufferedReader in = new BufferedReader (new FileReader ("DataProg"));
			while ((line = in.readLine())!= null){
				String[] fields = line.split(",");
			}
		}
		
		
	}
}
