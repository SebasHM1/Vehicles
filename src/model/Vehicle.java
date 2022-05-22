package model;

public abstract class Vehicle implements Price{
	
	private String tradeMark;
	private double sellPrice;
	private double basePrice;
	private int modelYear;
	private int kilometers;
	private String id;
	private Condition cond;
	private Soat soat;
	private Mech mech;
	private PropertyCard card;
	private double totalPrice;
	private double discount;

	
	public Vehicle(String tradeMark, double sellPrice, double basePrice, int modelYear, int kilometers, String id, double discount,
			int optCond, Soat soat, Mech mech, PropertyCard card) {
		super();
		this.tradeMark = tradeMark;
		this.sellPrice = sellPrice;
		this.basePrice = basePrice;
		this.modelYear = modelYear;
		this.kilometers = kilometers;
		this.id = id;
		this.totalPrice = 0;
		this.discount = discount;
		
		switch(optCond) {
		
		case 1: 
			
			this.cond = Condition.NEW;
			break;
			
		case 2: 
			
			this.cond = Condition.USED;
			break;
		
		}
		
		this.soat = soat;
		this.mech = mech;
		this.card = card;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public Soat getSoat() {
		return soat;
	}

	public void setSoat(Soat soat) {
		this.soat = soat;
	}

	public Mech getMech() {
		return mech;
	}

	public void setMech(Mech mech) {
		this.mech = mech;
	}

	public PropertyCard getCard() {
		return card;
	}

	public void setCard(PropertyCard card) {
		this.card = card;
	}

	public String getTradeMark() {
		return tradeMark;
	}

	public void setTradeMark(String tradeMark) {
		this.tradeMark = tradeMark;
	}

	public double getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(double sellPrice) {
		this.sellPrice = sellPrice;
	}

	public double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	public int getModelYear() {
		return modelYear;
	}

	public void setModelYear(int modelYear) {
		this.modelYear = modelYear;
	}

	public int getKilometers() {
		return kilometers;
	}

	public void setKilometers(int kilometers) {
		this.kilometers = kilometers;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Condition getCond() {
		return cond;
	}

	public void setCond(Condition cond) {
		this.cond = cond;
	}
	
	

	@Override
	public String toString() {
		return "Vehicle: "  + id + "\nTrade mark: " + tradeMark + ", Sell price: " + sellPrice + ", basePrice: " + basePrice
				+ ", Year: " + modelYear + ", Kilometers: " + kilometers + ", Condition: " + cond
				+ "\n Soat Data: \n" + soat + "\n Technomechanics data: \n" + mech + "\n Property card data: \n" + card;
	}
	
	/**
	 * <pre>
	 *<strong>Description:</strong> This method find the documents for the user
	 *pre: vehicleList and parking should be declared and initialized 
	 *pos: No
	 * </pre>
	 * @param id String contains the id of the vehicle searched
	 * @return msg String contains the documents of the vehicle selected
	 */
	
	public String searchDocuments (String id) {
		
		String msg = this.soat.toString() + "\n" + this.mech.toString();
		
		if (this.card != null) {
			
			msg = this.soat.toString() + "\n" + this.mech.toString() + "\n" + this.card.toString();
			
		}
		
		return msg;
		
	}
	
	/**
	 * <pre>
	 *<strong>Description:</strong> This method search the documents of the given vehicle
	 *pre: vehicleList and parking should be declared and initialized 
	 *pos: No
	 * </pre>
	 * @param searchCar CarType contains the type option of CarType selected
	 * @param search Vehicle contains the car searched
	 * @return msg String Contains the vehicles selected
	 */
	
	public String findVehicleCar (Vehicle search, CarType searchCar) {
		
		String msg = "";
		
		if (search instanceof Car) {
			 
			if (((Car) search).getType() == searchCar) {
				
				msg += "\n" + ((Car) search).getType() + " " + search.getModelYear() + " " + search.getId();				
			}
			
		}
		
		return msg;
		
	}
	
	/**
	 * <pre>
	 *<strong>Description:</strong>  This method search the vehicles based on their type
	 *pre: vehicleList and parking should be declared and initialized 
	 *pos: No
	 * </pre>
	 * @param searchCar GasType contains the GasType option
	 * @param search Vehicle contains the car searched
	 * @return msg String Contains the vehicles selected
	 */
	
	public String findVehicleGas (Vehicle search, GasType searchCar) {
		
		String msg = "";
		
		if (search instanceof Car) {
			
			if (search instanceof GasCar || search instanceof HybridCar) {
				
				if (((GasCar) search).getGasType() == searchCar || ((HybridCar) search).getGasType() == searchCar) {
					
					msg += "\n" + ((Car) search).getType() + " " + search.getModelYear() + " " + ((GasCar) search).getGasType() + " " + search.getId();				
				}
				
			}
			 
			
			
		}
		
		return msg;
		
	}
	
	/**
	 * <pre>
	 *<strong>Description:</strong> This method search the vehicle condition 
	 *pre: vehicleList and parking should be declared and initialized 
	 *pos: No
	 * </pre>
	 * @param searchCar Condition contains the Condition option
	 * @return msg String Contains the data of vehicles selected
	 */
	
	public String findVehicleCond (Condition searchCar) {
		
		String msg = "";
			 
			if (this.getCond() == searchCar) {
				
				msg += "\n" + this.getModelYear() + " " + this.getId() + " " + this.getCond();				
			}
		
		return msg;
		
	}
	
	
	
}
