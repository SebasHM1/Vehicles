package model;

public class ElectricCar extends Car{
	
	private boolean fastCharger;
	private double batteryConsume;
	private double batteryDuration;
	
	public ElectricCar(String tradeMark, double sellPrice, double basePrice, int modelYear, int kilometers, String id, double discount,
			int cond, int doors, boolean polarized, int type,  boolean fastCharger, double batteryConsume,
			double batteryDuration, Soat soat, Mech mech, PropertyCard card) {
		super(tradeMark, sellPrice, basePrice, modelYear, kilometers, id, discount, cond, doors, polarized, type,  soat, mech, card);
		this.fastCharger = fastCharger;
		this.batteryConsume = batteryConsume;
		this.batteryDuration = batteryDuration;
		this.setTotalPrice(calculatePrice(discount));
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
	public double getBatteryDuration() {
		return batteryDuration;
	}
	public void setBatteryDuration(double batteryDuration) {
		this.batteryDuration = batteryDuration;
	}
	@Override
	public String toString() {
		return super.toString() + "\n FastCharger: " + fastCharger + ", Battery Consume: " + batteryConsume + ", Battery Duration: "
				+ batteryDuration;
	}
	@Override
	public double calculatePrice(double discount) {
		
		double total = this.getSellPrice() - (this.getSellPrice() * (discount/100));
		
		total = total + (total * electric);
		
		if ((this.getSoat().getYear() < 2022 || this.getMech().getYear() < 2022) ) {
			
			total = total + expired;
			
		}
		
		if (this.getCond() == Condition.USED) {
			
			total = total - (total * usedCar);
			
		}
		
		return total ;
		
	}
	

}
