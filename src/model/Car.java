package model;

public abstract class Car extends Vehicle{
	
	private int doors;
	private boolean polarized;
	private CarType type;
	
	public Car(String tradeMark, double sellPrice, double basePrice, int modelYear, int kilometers, String id,
			double discount, int cond, int doors, boolean polarized, int type,  Soat soat, Mech mech, PropertyCard card) {
		super(tradeMark, sellPrice, basePrice, modelYear, kilometers, id, discount, cond, soat, mech, card);
		this.doors = doors;
		this.polarized = polarized;
		switch(type) {
		
		case 1: 
			this.type = CarType.SEDAN;
			break;
			
		case 2: 
			this.type = CarType.TRUCK;
			break;
		
		}
	}

	

	public int getDoors() {
		return doors;
	}

	public void setDoors(int doors) {
		this.doors = doors;
	}

	public boolean isPolarized() {
		return polarized;
	}

	public void setPolarized(boolean polarized) {
		this.polarized = polarized;
	}

	public CarType getType() {
		return type;
	}

	public void setType(CarType type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\n Doors amount: " + doors + " Polarized: " + polarized + " Type: " + type;
	}
	
	

}
