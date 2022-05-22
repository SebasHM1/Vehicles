package ui;
import java.util.Scanner;
import model.Controller;

public class Manager {
	
	public static Scanner sc; 
	public static Controller controller;
	
	public static void main (String args[]) {
		
		init();
		menu();
		
	}
	
	/**
	 <pre>
	 *<strong>Description:</strong> This method initializes the global variables
	 *pre: sc and controller should be declared 
	 *pos: sc and controller are initialized 
	 </pre>
	 */
	
	public static void init () {
		
		sc = new Scanner(System.in);
		controller = new Controller();
		
	}
	
	/**
	 * <pre>
	 *<strong>Description:</strong>  This method shows the program's menu 
	 *pre: global variables should be initialized
	 *pos: no
	 * </pre>
	 */
	
	public static void menu () {
		
		System.out.println("Welcome to main menu");
		
		boolean fin = false;
		int opt = 0; 
		
		while (!fin) {
			
			System.out.println("Type and option");
			System.out.println("1) Register a Vehicle " );
			System.out.println("2) Calculate a vehicle's price");
			System.out.println("3) Show a list of vehicles");
			System.out.println("4) Search documents");
			System.out.println("5) Show parking ");
			System.out.println("6) Show parking ocupation");
			System.out.println("7) Exit");
			
			opt = sc.nextInt();
			
			switch (opt) {
			
			case 1: 
				
				registerVehicle();
				
				break;
				
			case 2: 
				
				calculate();
				
				break;
				
			case 3: 
				
				showVehicles();
				
				break;
				
			case 4: 
				
				searchDocs();
				
				break;
				
			case 5: 
				
				parking();
				
				break;
				
			case 6: 
				
				parkingOcupation();
				
				break;
				
			case 7: 
				
				System.out.println("thanks for using ");
				fin = true;
				
				break;
				
			default: 
				
				System.out.println("Pleas type a valid option");
				break;
			
			}
			
		}
		
		
		
		
	}
	
	/**
	 * <pre>
	 *<strong>Description:</strong> This method allows the user to create a object by showing a menu.
	 *pre: global variables sould be inicialiced
	 *pos: Call the method createGasCar, createElectricCar, createHybridCar or createBike at Controller
	 * </pre>
	 */
	
	private static void registerVehicle() {
		
		int kilometers = 0;
		double proprice = 0;
		int propyear = 0;
		
		System.out.println("Type the base price");
		double basePrice = sc.nextDouble();
		
		System.out.println("Type the sell price");
		double sellPrice = sc.nextDouble();
		
		System.out.println("Type a trade mark");
		String tradeMark = sc.next();
		
		System.out.println("Type the vehicle's model");
		int modelYear = sc.nextInt();
		
		System.out.println("Type the vehicle's id");
		String id = sc.next();
		
		System.out.println("Type the adicional discount");
		double discount = sc.nextDouble();
		
		System.out.println("type the cylinder capacity of the vehicle");
		int cylinder = sc.nextInt();
		
		System.out.println("Is it new? \n 1) yes \n 2) no ");
		int optCond = sc.nextInt();
		
		if (optCond == 2) {
			
			System.out.println("How many kilometers does it have?");
			kilometers = sc.nextInt();
			
			System.out.println("Type the data of tha property card");
			System.out.println("What's the expedition year?");
			propyear = sc.nextInt();
			
			System.out.println("What's the value of the card?");
			proprice = sc.nextDouble();
			
			
		}
		
		System.out.println("Type the data of technomechanics");
		System.out.println("What's the expedition year?");
		int mechyear = sc.nextInt();
		
		System.out.println("What's the value of the card?");
		double mechprice = sc.nextDouble();
		
		System.out.println("Type the contamination of the vehicle");
		double contamination = sc.nextDouble();
		
		System.out.println("Type the data of SOAT");
		System.out.println("What's the expedition year?");
		int soatyear = sc.nextInt();
		
		System.out.println("What's the value of the card?");
		double soatprice = sc.nextDouble();
		
		System.out.println("Type the insurange coverage");
		double insurance = sc.nextDouble();
		
		System.out.println("Is it a bike type 1, if its a car type 2");
		int optVehicle = sc.nextInt();
		
		if (optVehicle == 1) {
			
			System.out.println("type the gas capacity of the bike");
			int bikeGasCap = sc.nextInt();
			
			int bikeGasCons = bikeGasCap*(cylinder/75);
			
			System.out.println("Type the bike type: \n 1) Standard \n 2) Sport \n 3) Scooter \n 4) Cross");
			int optBikeType = sc.nextInt();
			
			if (controller.createBike(basePrice, sellPrice, tradeMark, modelYear, id, discount, cylinder, optCond, mechyear, mechprice, contamination, soatyear, soatprice, insurance, bikeGasCap, bikeGasCons, optBikeType, propyear, proprice, kilometers)) {
				
				System.out.println("Success");
				
			} else {
				
				System.out.println("Fail");
				
			}
			
		} else if (optVehicle == 2) {
			
			System.out.println("Type the amount of doors");
			int doors = sc.nextInt();
			
			System.out.println("Type 1 if its polarized, else type 2");
			int optPol = sc.nextInt();
			
			boolean polarized = false;
			if (optPol == 1) {
				
				polarized = true;
				
			}
			
			System.out.println("Type the car type \n 1) Truck \n 2) Sedan"); 
			int carType = sc.nextInt();
			
			System.out.println("Type the car \n 1) Gas car \n 2) Electric car \n 3) Hybrid car");
			int carOpt = sc.nextInt();
			
			switch (carOpt) {
			
			case 1: 
				
				System.out.println("type the gas capacity of the car");
				int carGasCap = sc.nextInt();
				
				int carGasCons = carGasCap*(cylinder/150);
				
				System.out.println("Type the gas type of the car \n 1) Regular \n 2) Diesel \n 3) Extra");
				int gasOpt = sc.nextInt();
				
				if (controller.createGasCar(basePrice, sellPrice, tradeMark, modelYear, id, discount, cylinder, optCond, mechyear, mechprice, contamination, soatyear, soatprice, insurance, carGasCap, carGasCons, gasOpt, propyear, proprice, kilometers, doors, polarized, carOpt)) {
					
					System.out.println("Car registered");
					
				} else {
					
					System.out.println("Car not registered");
					
				}
				
				break;
				
			case 2: 
				
				System.out.println("It has a fast charger? (Type 1 for yes or 2 for not)");
				int fastChargerOpt = sc.nextInt();
				
				System.out.println("type the battery duration of the car");
				double carBatDur = sc.nextDouble();
				
				double carBatCons;
				
				boolean fastChar = false;
				if ( fastChargerOpt == 1) {
					
					fastChar = true;
					carBatCons = (carBatDur + 13) * (cylinder/100);				
				} else {
					
					carBatCons = (carBatDur + 18) * (cylinder/100);	
					
				}
			
				
				
				
				
				if (controller.createElectricCar(basePrice, sellPrice, tradeMark, modelYear, id, discount, optCond, mechyear, mechprice, contamination, soatyear, soatprice, insurance, fastChar, carBatCons, carBatDur, propyear, proprice, kilometers, doors, polarized, carType)) {
					
					System.out.println("Success");
					
				} else {
					
					System.out.println("Fail");
					
				}
				
				break;
				
			case 3: 
				
				System.out.println("type the gas capacity of the car");
				int carGasCapH = sc.nextInt();
			
				int carGasConsH = carGasCapH * (cylinder*150);
				
				System.out.println("Type the gas type of the car \n 1) Regular \n 2) Diesel \n 3) Extra");
				int gasOptH = sc.nextInt();
				
				System.out.println("It has a fast charger? (Type 1 for yes or 2 for not)");
				int fastChargerOptH = sc.nextInt();
				
				System.out.println("type the battery duration of the car");
				double carBatDurH = sc.nextDouble();
				
				double carBatConsH;
				
				boolean fastCharH = false;
				if ( fastChargerOptH == 1) {
					
					fastCharH = true;
					carBatConsH = (carBatDurH) * (cylinder/100);				
				} else {
					
					carBatConsH = (carBatDurH + 7) * (cylinder/200);	
					
				}
			
				
				
				
				if (controller.createHybridCar(basePrice, sellPrice, tradeMark, modelYear, id, discount, cylinder, optCond, mechyear, mechprice, contamination, soatyear, soatprice, insurance, fastCharH, carBatConsH, carBatDurH, propyear, proprice, kilometers, doors, polarized, carType, carGasCapH, carGasConsH, gasOptH)) {
					
					System.out.println("Success");
					
				} else {
					
					System.out.println("Fail");
					
				}
			
			}
			
		}
		
		
		
	}

	/**
	 * <pre>
	 *<strong>Description:</strong> This method show the user all requested information
	 *pre: No
	 *pos: Show the result of methods searchParkingYears, searchParkingOldNew or parkingOcupation at controller
	 * </pre>
	 */
	
	private static void parkingOcupation() {
		
		System.out.println("Type an option: \n1) Search at parking for a year range \n2) Search at parking the newest and older vehicle \n3) percentage of parking ocupation");
		int optSearchPark = sc.nextInt();
		
		switch (optSearchPark) {
		
		case 1: 
			
			System.out.println("Type the older year");
			int old = sc.nextInt();
			
			System.out.println("Type the newest year");
			int newest = sc.nextInt();
			
			if (controller.searchParkingYears(newest, old) != "") {
				
				System.out.println("Vehicles are: " + controller.searchParkingYears(newest, old));
				
			} else {
				
				System.out.println("No Vehicles founded");
				
			}
			
			
			break;
			
		case 2: 
			
			System.out.println(controller.searchParkingOldNew());
			break;
			
		case 3: 
			
			System.out.println("The parking ocupation is at: " + controller.parkingOcupation() + "%");
		
		}
		
	}

	/**
	 * <pre>
	 *<strong>Description:</strong> This method shows the user a parking image
	 *pre: Parking matrix at controller should be declared and initialized 
	 *pos: Show the method printMatrix at conntroller
	 * </pre>
	 */
	
	private static void parking() {
		System.out.println("Actual parking is: \n" + controller.printParking());
		
	}

	/**
	 * <pre>
	 *<strong>Description:</strong> This method shows to the user a documents information by a given id
	 *pre: No
	 *pos: Shows the objects mech, soat and card (if it have it) 
	 * </pre>
	 */
	
	private static void searchDocs() {
		System.out.println(controller.showVehicles());
		
		System.out.println("Type the vehicle ID that you want to know the price");
		String idSearch = sc.next();
		
		if (controller.documentsState(idSearch) != "") {
			
			System.out.println("The documents for that vehicle are: " + controller.documentsState(idSearch));
			
		} else {
			
			System.out.println("No Vehicles founded");
			
		}
	
	}

	/**
	 * <pre>
	 *<strong>Description:</strong> This method shows to the user a objects information by a given data
	 *pre: No
	 *pos: Shows the result of methods searchVehicleByType, searchVehicleByGas or searchVehicleByCond at controller
	 * </pre>
	 */
	
	private static void showVehicles() {
		
		System.out.println(controller.showVehicles());
		
		System.out.println("Wich vehicles do you want to search? \n1) Vehicle type\n2) Gas type\n3) New or used cars");
		int optVeh = sc.nextInt();
		
		switch(optVeh) {
		
		case 1: 
			
			System.out.println("Type the car type \n 1) Truck \n 2) Sedan"); 
			int carType = sc.nextInt();
			
			if (controller.searchVehicleByType(carType) != "") {
				
				System.out.println("Those cars are: " + controller.searchVehicleByType(carType)); 
				
			} else {
				
				System.out.println("No Vehicles founded");
				
			}
			
			break;
			
		case 2: 
			
			System.out.println("Type the gas type of the car \n 1) Regular \n 2) Diesel \n 3) Extra");
			int gasOpt = sc.nextInt();
			
			if (controller.searchVehicleByGas(gasOpt) != "") {
				
				System.out.println("Those cars are: " + controller.searchVehicleByGas(gasOpt));
				
			} else {
				
				System.out.println("No Vehicles founded");
				
			}
			
			
			
			
			
			break;
			
		case 3: 
			
			System.out.println("Is it new? \n 1) yes \n 2) no ");
			int optCond = sc.nextInt();
			
			if (controller.searchVehicleByCond(optCond) != "") {
				
				System.out.println("Those cars are: " + controller.searchVehicleByCond(optCond)); 
				
			} else {
				
				System.out.println("No Vehicles founded");
				
			}
			
			break;
		
		}
		
	}

	/**
	 * <pre>
	 *<strong>Description:</strong> This method calculate and shows to the user a complete vehicle's price
	 *pre: No
	 *pos: Shows the result of method calculate value at controller
	 * </pre>
	 */
	
	private static void calculate() {
		
		System.out.println(controller.showVehicles());
		
		System.out.println("Type the vehicle ID that you want to know the price");
		String idSearch = sc.next();
		
		if (controller.calculateValue(idSearch) != "") {
			
			System.out.println("The total price is: " + controller.calculateValue(idSearch)); 
			
		} else {
			
			System.out.println("No Vehicles founded");
			
		}
		
		
		
	}

}
