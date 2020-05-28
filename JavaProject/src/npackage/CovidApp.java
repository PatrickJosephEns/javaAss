package npackage;

import java.util.ArrayList;

public class CovidApp {

	/** Creates a new instance of CovidApp */
	public static void main(String[] args) {
	ArrayList<Dhb> dhb = new ArrayList<Dhb>();
	Utilities.load(dhb);
	
	ProjectFrame gui = new ProjectFrame (dhb);
	gui.setVisible(true);

	}

}
