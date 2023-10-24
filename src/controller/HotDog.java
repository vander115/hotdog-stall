package controller;

public class HotDog {
	public String protein;
	public String cheese;
	public String drink;

	public boolean hasMayonnaise;
	public boolean hasKetchup;
	public boolean hasEgg;
	public boolean hasPotatoes;

	public HotDog(String protein, String cheese, String drink) {
		this.protein = protein;
		this.cheese = cheese;
		this.drink = drink;
	}

	public void setComplements(boolean hasMayonnaise, boolean hasKetchup, boolean hasEgg, boolean hasPotatoes) {
		this.hasMayonnaise = hasMayonnaise;
		this.hasKetchup = hasKetchup;
		this.hasEgg = hasEgg;
		this.hasPotatoes = hasPotatoes;
	}
}
