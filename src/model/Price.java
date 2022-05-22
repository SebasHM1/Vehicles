package model;

public interface Price {
	
	final int expired = 500000;
	final double electric = 0.2;
	final double hybrid = 0.15;
	final double usedCar = 0.10;
	final double newBike = 0.04;
	final double usedBike = 0.02;
	
	public abstract double calculatePrice (double discount);

}
