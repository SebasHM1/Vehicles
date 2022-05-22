package model;

public class HybridCar extends Car {
	
	private boolean fastCharger;
	private double batteryConsume;
	private double batteryDuration;
	private int gasCapacity;
	private int gasConsume;
	private GasType gasType;
	private int cylinder;
	
	public HybridCar(String tradeMark, double sellPrice, double basePrice, int modelYear, int kilometers, String id, double discount, int cylinder,
			int cond, int doors, boolean polarized, int type, boolean fastCharger, double batteryConsume,
			int gasCapacity, int gasConsume, double batteryDuration, int gasType, Soat soat, Mech mech, PropertyCard card) {
		super(tradeMark, sellPrice, basePrice, modelYear, kilometers, id, discount, cond, doors, polarized, type, soat, mech, card);
		this.fastCharger = fastCharger;
		this.batteryConsume = batteryConsume;
		this.gasCapacity = gasCapacity;
		this.gasConsume = gasConsume;
		this.batteryDuration = batteryDuration;
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

	public boolean isFastCharger() {
		return fastCharger;
	}

	public void setFastCharger(boolean fastCharger) {
		this.fastCharger = fastCharger;
	}

	public double getBatteryConsume() {
		return batteryConsume;
	}

	public void setBatteryConsume(double batteryConsume) {
		this.batteryConsume = batteryConsume;
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

	public double getBatteryDuration() {
		return batteryDuration;
	}

	public void setBatteryDuration(double batteryDuration) {
		this.batteryDuration = batteryDuration;
	}

	public GasType getGasType() {
		return gasType;
	}

	public void setGasType(GasType gasType) {
		this.gasType = gasType;
	}

	@Override
	public String toString() {
		return super.toString() + "\n Fast Charger=" + fastCharger + ", Battery Consume: " + batteryConsume + ", Battery Duration: "
				+ batteryDuration + ", Gas Capacity: " + gasCapacity + ", Gas Consume: " + gasConsume + ", GasType: "
				+ gasType;
	}

	@Override
	public double calculatePrice(double discount) {
		double total = this.getSellPrice() - (this.getSellPrice() * discount);
		
		total = total + (total * hybrid);
		
		if ((this.getSoat().getYear() < 2022 || this.getMech().getYear() < 2022) ) {
			
			total = total + expired;
			
		}
		
		if (this.getCond() == Condition.USED) {
			
			total = total - (total * usedCar);
			
		}
		
		
		
		return total ;
	}


	public double calculateTotal (double discount) {
		
		double total = this.getSellPrice() - (this.getSellPrice() * discount);
		
		total = total + (total * hybrid);
		
		if ((this.getSoat().getYear() < 2022 || this.getMech().getYear() < 2022) ) {
			
			total = total + expired;
			
		}
		
		if (this.getCond() == Condition.USED) {
			
			total = total - (total * usedCar);
			
		}
		
		
		
		return total ;
	
	}
}
