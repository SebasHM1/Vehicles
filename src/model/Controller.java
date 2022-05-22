package model;
import java.util.ArrayList;

public class Controller {
	
	ArrayList<Vehicle> vehicleList;
	private Vehicle [][] parking;
	
	public Controller () {
		
		this.vehicleList = new ArrayList<Vehicle>();
		parking = new Vehicle [10][5];
		
		
	}
	
	public ArrayList <Vehicle> getvehicleList () {
		
		return vehicleList;
		
	}
	
	public void setvehicleList (ArrayList<Vehicle>vehicleList) {
		
		this.vehicleList = vehicleList;
		
	}
	
	/**
	 * <pre>
	 *<strong>Description:</strong> This method create a GasCar object
	 *pre: vehicleList and parking should be declared and initialized 
	 *pos: parking is modificated
	 * </pre>
	 * @param basePrice double Contains the base price
	 * @param sellprice double Contains the sell price before calculate the total
	 * @param tradeMark String Contains the trade mark of the vehicle 
	 * @param modelyear int Contains the fabrication year of the vehicle
	 * @param id String Contains the unique id 
	 * @param discount double Contains the additional discount for selling 
	 * @param cylinder int contains the cylinder capacity
	 * @param optCond int contains the option for the vehicles condition
	 * @param mechyear int contains the year of technomechanics revision
	 * @param contamination double contains the CO2 grams by kilometer
	 * @param soatyear int contains the year of soat insure
	 * @param soatprice double contains the value of soat card
	 * @param insurance double contains the full insurance coverage
	 * @param carGasCap int containg the gas capacity of the car
	 * @param carGasCons int contains the calculated gas consume
	 * @param gasOpt int contains the gas option
	 * @param propyear intcontains the expedition year of property card
	 * @param proprice double contains the price of property card
	 * @param kilometers int contains the amount of kilometers rolled by the vehicle
	 * @param doors int contains the amount of doors
	 * @param polarized boolean contains the option of car polarized
	 * @param type int contains the Type of car
	 * @return done boolean with the result 
	 */
	
	public boolean createGasCar (double basePrice, double sellprice, String tradeMark, int modelyear, String id, double discount, int cylinder, 
			int optCond, int mechyear, double mechprice, double contamination, int soatyear, double soatprice, double insurance, int carGasCap, 
			int carGasCons, int gasOpt, int propyear, double proprice, int kilometers, int doors, boolean polarized, int type) {
		
		boolean done = false;
		
		Soat soat = new Soat(soatprice, soatyear, insurance);
		Mech mech = new Mech(mechprice, mechyear, contamination);
		PropertyCard card = null;
		
		if (optCond == 2) {
			
			 card = new PropertyCard(proprice, propyear);
			
		}
		
		GasCar temp1 = new GasCar(tradeMark, sellprice, basePrice, modelyear, kilometers, id, discount, cylinder, optCond , doors, polarized, type, carGasCap, carGasCons, gasOpt, soat, mech, card);
		
		done = vehicleList.add(temp1);
		
		parking(temp1);
		
		return done;
		
	}

	/**
	 * <pre>
	 *<strong>Description:</strong> This method create a ElectricCar object
	 *pre: vehicleList and parking should be declared and initialized 
	 *pos: parking is modificated
	 * </pre>
	 * @param basePrice double Contains the base price
	 * @param sellprice double Contains the sell price before calculate the total
	 * @param tradeMark String Contains the trade mark of the vehicle 
	 * @param modelyear int Contains the fabrication year of the vehicle
	 * @param id String Contains the unique id 
	 * @param discount double Contains the additional discount for selling 
	 * @param optCond int contains the option for the vehicles condition
	 * @param mechyear int contains the year of technomechanics revision
	 * @param contamination double contains the CO2 grams by kilometer
	 * @param soatyear int contains the year of soat insure
	 * @param soatprice double contains the value of soat card
	 * @param insurance double contains the full insurance coverage
	 * @param propyear intcontains the expedition year of property card
	 * @param proprice double contains the price of property card
	 * @param kilometers int contains the amount of kilometers rolled by the vehicle
	 * @param doors int contains the amount of doors
	 * @param polarized boolean contains the option of car polarized
	 * @param type int contains the Type of car
	 * @param fastChar boolean contains the option of fast Charger 
	 * @param carBatCons double contains the calculated battery consume
	 * @param carBatDur double contains the battery duration by kilometers 
	 * @return done boolean with the result 
	 */
	
	public boolean createElectricCar (double basePrice, double sellprice, String tradeMark, int modelyear, String id, double discount, int optCond, int mechyear, double mechprice, double contamination,
			int soatyear, double soatprice, double insurance, boolean fastChar, double carBatCons, double carBatDur, int propyear, double proprice, int kilometers, int doors, boolean polarized, int type) {
		
		Soat soat = new Soat(soatprice, soatyear, insurance);
		Mech mech = new Mech(mechprice, mechyear, contamination);
		PropertyCard card = null;
		
		if (optCond == 2) {
			
			 card = new PropertyCard(proprice, propyear);
			
		}
		
		ElectricCar temp1 = new ElectricCar(tradeMark, sellprice, basePrice, modelyear, kilometers, id, discount, optCond , doors, polarized, type, fastChar, carBatCons, carBatDur, soat, mech, card);
		
		boolean done = false;
		
		done = vehicleList.add(temp1);
		
		parking(temp1);
		
		return done;
		
	}
	
	/**
	 * <pre>
	 *<strong>Description:</strong> This method create a HybridCar object
	 *pre: vehicleList and parking should be declared and initialized 
	 *pos: parking is modificated
	 * </pre>
	 * @param basePrice double Contains the base price
	 * @param sellprice double Contains the sell price before calculate the total
	 * @param tradeMark String Contains the trade mark of the vehicle 
	 * @param modelyear int Contains the fabrication year of the vehicle
	 * @param id String Contains the unique id 
	 * @param discount double Contains the additional discount for selling 
	 * @param optCond int contains the option for the vehicles condition
	 * @param mechyear int contains the year of technomechanics revision
	 * @param contamination double contains the CO2 grams by kilometer
	 * @param soatyear int contains the year of soat insure
	 * @param soatprice double contains the value of soat card
	 * @param insurance double contains the full insurance coverage
	 * @param propyear intcontains the expedition year of property card
	 * @param proprice double contains the price of property card
	 * @param kilometers int contains the amount of kilometers rolled by the vehicle
	 * @param doors int contains the amount of doors
	 * @param polarized boolean contains the option of car polarized
	 * @param type int contains the Type of car
	 * @param fastChar boolean contains the option of fast Charger 
	 * @param carBatCons double contains the calculated battery consume
	 * @param carBatDur double contains the battery duration by kilometers 
	 * @param carGasCap int containg the gas capacity of the car
	 * @param carGasCons int contains the calculated gas consume
	 * @param gasOpt int contains the gas option
	 * @return done boolean with the result 
	 */
	
	public boolean createHybridCar (double basePrice, double sellprice, String tradeMark, int modelyear, String id, double discount, int cylinder,int optCond, int mechyear, double mechprice, double contamination,
			int soatyear, double soatprice, double insurance, boolean fastChar, double carBatCons, double carBatDur, int propyear, double proprice, int kilometers, int doors, boolean polarized, int type,
			int carGasCap, int carGasCons, int gasOpt) {
		
		Soat soat = new Soat(soatprice, soatyear, insurance);
		Mech mech = new Mech(mechprice, mechyear, contamination);
		PropertyCard card = null;
		
		if (optCond == 2) {
			
			 card = new PropertyCard(proprice, propyear);
			
		}
		
		HybridCar temp1 = new HybridCar(tradeMark, sellprice, basePrice, modelyear, kilometers, id, discount, cylinder, optCond, doors, polarized, type, fastChar, carBatCons, carGasCap, carGasCons, carBatDur, gasOpt, soat, mech, card);
		
		boolean done = false;
		
		done = vehicleList.add(temp1);
		
		parking(temp1);
		
		return done;
		
	}

	/**
	 * <pre>
	 *<strong>Description:</strong> This method create a Bike object
	 *pre: vehicleList and parking should be declared and initialized 
	 *pos: parking is modificated
	 * </pre>
	 * @param basePrice double Contains the base price
	 * @param sellPrice double Contains the sell price before calculate the total
	 * @param tradeMark String Contains the trade mark of the vehicle 
	 * @param modelYear int Contains the fabrication year of the vehicle
	 * @param id String Contains the unique id 
	 * @param discount double Contains the additional discount for selling 
	 * @param optCond int contains the option for the vehicles condition
	 * @param mechyear int contains the year of technomechanics revision
	 * @param contamination double contains the CO2 grams by kilometer
	 * @param soatyear int contains the year of soat insure
	 * @param soatprice double contains the value of soat card
	 * @param insurance double contains the full insurance coverage
	 * @param propyear intcontains the expedition year of property card
	 * @param proprice double contains the price of property card
	 * @param kilometers int contains the amount of kilometers rolled by the vehicle
	 * @param cylinder int contains the cylinder capacity
	 * @param bikeGasCap int contains the gas capacity of the bike
	 * @param bikeGasCons int contains the calculated gas consume of the bike
	 * @param optBikeType int contains the bike type option
	 * @return done boolean with the result 
	 */
	
	public boolean createBike(double basePrice, double sellPrice, String tradeMark, int modelYear, String id, double discount, int cylinder, int optCond,
			int mechyear, double mechprice, double contamination, int soatyear, double soatprice, double insurance, int bikeGasCap, int bikeGasCons, int optBikeType, int propyear, double proprice, int kilometers) {
		
		boolean done = false;
		
		Soat soat = new Soat(soatprice, soatyear, insurance);
		Mech mech = new Mech(mechprice, mechyear, contamination);
		PropertyCard card = null;
		
		if (optCond == 2) {
			
			 card = new PropertyCard(proprice, propyear);
			
		}
		
		Bike temp = new Bike(tradeMark, sellPrice, basePrice, modelYear, kilometers, id, discount, cylinder, optCond, bikeGasCap, bikeGasCons, optBikeType, soat, mech, card);
		
		done = vehicleList.add(temp);
		
		parking(temp);
		
		return done;
		
	}
	
	/**
	 * <pre>
	 *<strong>Description:</strong>  This method shows the actual vehicles created
	 *pre: vehicleList and parking should be declared and initialized 
	 *pos: No
	 * </pre>
	 * @return msg String, A variable with the vehicles
	 */
	
	public String showVehicles () {
		
		String msg = "";
		
		for (int i = 1; i <= vehicleList.size() ; i++) {
			
			msg += vehicleList.toString();
			
		}
		
		return msg;
		
	}
	
	/**
	 * <pre>
	 *<strong>Description:</strong> This method calculated the total value of each vehicle
	 *pre: vehicleList and parking should be declared and initialized 
	 *pos: No
	 * </pre>
	 * @param id String contains the id of the vehicle searched
	 * @return msg with the price 
	 */
	
	public String calculateValue (String id) {
		
		double totalPrice = 0;
		
		for (int i = 0; i < vehicleList.size() ; i++) {
			
			Vehicle search = vehicleList.get(i);
			
			if (search.getId().equalsIgnoreCase(id)) {
				
				totalPrice = search.calculatePrice(i);		
			}
			
		}
		
		return "" + totalPrice;
		
	}
	
	/**
	 * <pre>
	 *<strong>Description:</strong> This method shows to the user, a document actual state
	 *pre: vehicleList and parking should be declared and initialized 
	 *pos: No
	 * </pre>
	 * @param id String contains the id of the vehicle searched
	 * @return msg String contains the documents of the vehicle selected
	 */
	
	public String documentsState (String id) {
		
		String msg = "";
		
		for (int i = 0; i < vehicleList.size(); i ++) {
			
			Vehicle search = vehicleList.get(i);
			
			if (search.getId().equalsIgnoreCase(id)) {
				
				msg = search.searchDocuments(id);	
			}
			
		}
				
		return msg;		
		
	}
	
	/**
	 * <pre>
	 *<strong>Description:</strong> This method shows a list of vehicles based on their type
	 *pre: vehicleList and parking should be declared and initialized 
	 *pos: No
	 * </pre>
	 * @param vehicleType contains the type option
	 * @return msg String Contains the vehicles selected
	 */
	
	public String searchVehicleByType (int vehicleType) {
		
		String msg = "";
		
		CarType search = null;
		
		
		switch(vehicleType) {
		
		case 1: 
			search = CarType.SEDAN;
			break;
			
		case 2: 
			search = CarType.TRUCK;
			break;
		
		}
		
		for (int i = 0; i < vehicleList.size(); i++) {
			
			Vehicle t = vehicleList.get(i);
			
			System.out.println("Entra Type control");
			
			msg += t.findVehicleCar(t, search);
			
		}
		
		return msg;
		
	}
	
	/**
	 * <pre>
	 *<strong>Description:</strong>  This method shows a list of vehicles based on their gas type
	 *pre: vehicleList and parking should be declared and initialized 
	 *pos: No
	 * </pre>
	 * @param gasType int contains the gas Option 
	 * @return msg String Contains the vehicles selected
	 */
	
	public String searchVehicleByGas (int gasType) {
		
		String msg = "";
		
		GasType search = null;
		
		
		switch(gasType) {
		
		case 1: 
			search = GasType.Regular;
			break;
			
		case 2: 
			search = GasType.Diesel;
			break;
			
		case 3: 
			search = GasType.Extra;
			break;
		
		}
		
		for (int i = 0; i < vehicleList.size(); i++) {
			
			Vehicle t = vehicleList.get(i);
			
			msg += t.findVehicleGas(t, search);
			
		}
		
		return msg;
		
	}
	
	/**
	 * <pre>
	 *<strong>Description:</strong> This method shows a list of vehicles based on their condition
	 *pre: vehicleList and parking should be declared and initialized 
	 *pos: No
	 * </pre>
	 * @param condition int contains the condition option
	 * @return msg String Contains the vehicles selected
	 */
	
	public String searchVehicleByCond (int condition) {
		
		String msg = "";
		
		Condition search = null;
		
		
		switch(condition) {
		
		case 1: 
			search = Condition.NEW;
			break;
			
		case 2: 
			search = Condition.USED;
			break;
		
		}
		
		for (int i = 0; i < vehicleList.size(); i++) {
			
			Vehicle t = vehicleList.get(i);
			
			System.out.println("Entra condicion control");
			
			msg += t.findVehicleCond(search);
			
		}
		
		return msg;
		
	}
	
	/**
	 * <pre>
	 *<strong>Description:</strong> This method modify the parking matrix, if the objects meet the conditions
	 *pre: vehicleList and parking should be declared 
	 *pos: parking matrix is modificated
	 * </pre>
	 * @param t Vehicle contains the object evaluated
	 */
	
	public void parking (Vehicle t) {
		
		boolean stop = false;
		
		for (int i = 0; i < vehicleList.size() && !stop; i ++) {
			
			if ((t.getModelYear() < 2015) && (t.getCond() == Condition.USED) && !stop) {
				
				if (t.getModelYear() == 2014 && !stop) {
					
					for (int a = 0; a < parking[0].length && !stop ; a++) {
						
						if (parking[a][0] == null) {
							
							parking[a][0] = t;
							
							stop = true;
							
						}
						
					}
					
				}
				
				if (t.getModelYear() == 2013 && !stop ) {
					
					for (int a = 0; a < parking[1].length && !stop ; a++) {
						
						if (parking[a][1] == null) {
							
							parking[a][1] = t;
							
							stop = true;
							
						}
						
					}
					
				}
				
				if (t.getModelYear() == 2012 && !stop ) {
					
					for (int a = 0; a < parking[2].length && !stop ; a++) {
						
						if (parking[a][2] == null) {
							
							parking[a][2] = t;
							
							stop = true;
							
						}
						
					}
					
				}
				
				if (t.getModelYear() == 2011 && !stop) {
					
					for (int a = 0; a < parking[3].length && !stop ; a++) {
						
						if (parking[a][3] == null) {
							
							parking[a][3] = t;
							
							stop = true;
							
						}
						
					}
					
				}
				
				if (t.getModelYear() < 2011 && !stop) {
					
					for (int a = 0; a < parking[4].length && !stop ; a++) {
						
						if (parking[a][4] == null) {
							
							parking[a][4] = t;
							
							stop = true;
							
						}
						
					}
					
				}
				
			}
			
		}
				
	}
		
	/**
	 * <pre>
	 *<strong>Description:</strong> This method shows the parking occupation
	 *pre: vehicleList and parking should be declared and initialized 
	 *pos: No
	 * </pre>
	 * @return msg String Contains the parking matrix with empty and full positions
	 */
	
	public String printParking () {
		String print = "\n";
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 5; j++) {
				
				if (parking[i][j] != null) {
					
					print += "[" + parking[i][j].getCond() + " " + parking[i][j].getTradeMark() + " " + parking[i][j].getId() + "]";
					
				} else if (parking[i][j] == null) {
					
					print += "[       Empty       ]";
					
				}
				
			}
			print += "\n";
		}
		return print;
	}
	
	/**
	 * <pre>
	 *<strong>Description:</strong> This method shows the vehicles at the parking based on a year range
	 *pre: vehicleList and parking should be declared and initialized 
	 *pos: No
	 * </pre>
	 * @param newest contains the lower year
	 * @param old contains the highest year
	 * @return shows Contains the vehicles selected
	 */
	
	public String searchParkingYears (int newest, int old) {
		
		String msg = "";
		
		for (int i = 0; i < 10; i++) {
			
			for (int a = 0; a < 5; a++) {
				
				if (parking [i][a] != null) {
					
					if (old < parking[i][a].getModelYear() && parking[i][a].getModelYear() < newest) {
						
						msg += "[" + parking[i][a].getCond() + " " + parking[i][a].getTradeMark() + " " + parking[i][a].getId() + " " + parking[i][a].getModelYear() + "]";
						
					}
					
				}
				
			}
			
		}
		
		return msg;
		
	}
	
	/**
	 * <pre>
	 *<strong>Description:</strong> This method shows the older and newer vehicles at parking 
	 *pre: vehicleList and parking should be declared and initialized 
	 *pos: No
	 * </pre>
	 * @return msg String Contains the vehicles selected
	 */
	
	public String searchParkingOldNew ( ) {
		
		int oldVeh = 1000000;
		int newVeh = 0;
		int oldPosi = 0;
		int oldPosa = 0;
		int newPosi = 0;
		int newPosa = 0;
		
		for (int i=0; i < parking.length; i++) {
			
			  for (int a = 0 ; a < parking[i].length ; a++) {
				  
			    if (parking [i][a] != null && parking[i][a].getModelYear() >= newVeh) {
			    	
			    	newVeh = parking[i][a].getModelYear();
			      
			      newPosi = i;
			      newPosa = a;
			      
			    }
			    
			    if (parking [i][a] != null && parking[i][a].getModelYear() <= oldVeh) {
			    	
			    	oldVeh = parking[i][a].getModelYear();
			      
			      oldPosi = i;
			      oldPosa = a;
			      
			    }
			    
			  }   
			  
			}
		
		return "Newest: [" + parking[newPosi][newPosa].getCond() + " " + parking[newPosi][newPosa].getTradeMark() + " " + parking[newPosi][newPosa].getId() + " " + parking[newPosi][newPosa].getModelYear() + "] \n" +
		"Oldest: [" + parking[oldPosi][oldPosa].getCond() + " " + parking[oldPosi][oldPosa].getTradeMark() + " " + parking[oldPosi][oldPosa].getId() + " " + parking[oldPosi][oldPosa].getModelYear() + "]" ;
		
	}
	
	/**
	 * <pre>
	 *<strong>Description:</strong> This method shows the occupation percentage of the parking
	 *pre: vehicleList and parking should be declared and initialized 
	 *pos: No
	 * </pre>
	 * @return contains the percentage of occupation
	 */
	
	public String parkingOcupation () {
		
		int contador = 0;
		
		for (int i = 0; i < parking.length; i++) {
			
			for (int a = 0; a < parking[i].length; a++) {
				
				if (parking[i][a] != null) {
					
					contador++;
					
				}
				
			}
			
		}
		
		double totalpercentage = ((contador*100)/50);
		
		return "The occupation percetage is: " + totalpercentage;
		
	}

}