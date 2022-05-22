package model;

public class GasCar extends Car {
	
	private int gasCapacity;
	private int gasConsume;
	private GasType gasType;
	private int cylinder;
	
	public GasCar(String tradeMark, double sellPrice, double basePrice, int modelYear, int kilometers, String id,
			double discount, int cylinder, int cond,  int doors, boolean polarized, int type, int gasCapacity, int gasConsume, int gasType,
			Soat soat, Mech mech, PropertyCard card) {
		super(tradeMark, sellPrice, basePrice, modelYear, kilometers, id, discount, cond,  doors, polarized, type, soat, mech, card);
		this.gasCapacity = gasCapacity;
		this.gasConsume = gasConsume;
		this.setTotalPrice(calculatePrice(discount));
		this.cylinder = cylinder;

		switch(gasType) {
		
		case 1: 
			
			this.gasType = GasType.Regular;
			break;
			
		case 2: 
			
			this.gasType = GasType.Diesel;
			break;
			
		case 3: 
			
			this.gasType = GasType.Extra;
		
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
	public GasType getGasType() {
		return gasType;
	}
	public void setGasType(GasType gasType) {
		this.gasType = gasType;
	}
	@Override
	public String toString() {
		return super.toString() +  " \n Gas Capacity: " + gasCapacity + ", Gas Consume: " + gasConsume + ", Gas Type: " + gasType;
	}
	@Override
	public double calculatePrice(double discount) {
		double total = this.getSellPrice() - (this.getSellPrice() * discount);
		
		if ((this.getSoat().getYear() < 2022 || this.getMech().getYear() < 2022) ) {
			
			total = total + expired;
			
		}
		
		if (this.getCond() == Condition.USED) {
			
			total = total - (total* usedCar);
			
		}
		
		
		return total ;
	}

}
