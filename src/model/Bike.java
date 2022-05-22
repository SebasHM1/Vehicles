package model;

public class Bike extends Vehicle{
	
	private int gasCapacity;
	private int gasConsume;
	private BikeType bikeType;
	private int cylinder;

	public Bike(String tradeMark, double sellPrice, double basePrice, int modelYear, int kilometers, String id, double discount, int cylinder,
			int cond, int gasCapacity, int gasConsume, int bikeType,  Soat soat, Mech mech, PropertyCard card) {
		super(tradeMark, sellPrice, basePrice, modelYear, kilometers, id, discount, cond, soat, mech, card);
		this.gasCapacity = gasCapacity;
		this.gasConsume = gasConsume;
		this.setTotalPrice(calculatePrice(discount));
		this.cylinder = cylinder;
		
		switch (bikeType) {
		
		case 1: this.bikeType = BikeType.Standard;
		break;
		
		case 2: this.bikeType = BikeType.Sport;
		break;
		
		case 3: this.bikeType = BikeType.Scooter;
		break;
		
		case 4: this.bikeType = BikeType.Cross;
		
		}
		
	}
	
	public int getCylinder() {
		return cylinder;
	}


	public void setCylinder(int cylinder) {
		this.cylinder = cylinder;
	}

	public int getGasCapacity() {
		return gasCapacity;
	}

	public void setGasCapacity(int gasCapacity) {
		this.gasCapacity = gasCapacity;
	}

	public int getGasConsume() {
		return gasConsume;
	}

	public void setGasConsume(int gasConsume) {
		this.gasConsume = gasConsume;
	}

	public BikeType getBikeType() {
		return bikeType;
	}

	public void setBikeType(BikeType bikeType) {
		this.bikeType = bikeType;
	}

	@Override
	public String toString() {
		return super.toString() + "\n Gas Capacity: " + gasCapacity + ", Gas consume: " + gasConsume + ", Bike type: " + bikeType;
	}

	@Override
	public double calculatePrice(double discount) {
		double total = this.getSellPrice() - (this.getSellPrice() * discount);
		
		total = total + (total * newBike);
		
		if ((this.getSoat().getYear() < 2022 || this.getMech().getYear() < 2022) ) {
			
			total = total + expired;
			
		}
		
		if (this.getCond() == Condition.USED) {
			
			total = total - (total * usedBike);
			
		}
		
		
		
		return total ;
	}
		
}
