package npackage;

import java.util.ArrayList;

public class Dhb {

	private String dhbs;
	private int active;
	private int recovered;
	private int deceased;
	private int total;
	private int lastDay;
	
	public Dhb(String dhbs, int active, int recovered, int deceased, int total, int lastDay) {
		super();
		this.dhbs = dhbs;
		this.active = active;
		this.recovered = recovered;
		this.deceased = deceased;
		this.total = total;
		this.lastDay = lastDay;
	}

	public String getDhbs() {
		return dhbs;
	}

	public void setDhbs(String dhbs) {
		this.dhbs = dhbs;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public int getRecovered() {
		return recovered;
	}

	public void setRecovered(int recovered) {
		this.recovered = recovered;
	}

	public int getDeceased() {
		return deceased;
	}

	public void setDeceased(int deceased) {
		this.deceased = deceased;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getLastDay() {
		return lastDay;
	}

	public void setLastDay(int lastDay) {
		this.lastDay = lastDay;
	}	
}
