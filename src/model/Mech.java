package model;

public class Mech extends VehicleDocs{
	
	

	private double contamination;
	private String mechCode;
	
	public Mech(double price, int year, double contamination) {
		super(price, year);
		this.mechCode = generateCode();
		this.contamination = contamination;
	}
	public String getMechCode() {
		return mechCode;
	}
	public void setMechCode(String mechCode) {
		this.mechCode = mechCode;
	}
	
	public double getcontamination() {
		return contamination;
	}
	public void setcontamination(double contamination) {
		this.contamination = contamination;
	}
	
	private String generateCode() {

		String msg = "";
		
		boolean fin = false;
		
		for (int i = 0; i < 3; i++) {
			
			msg += image[0][i];
			
		}
		
		for (int i = 0; i < 4 ; i++) {
			
			fin = false;
			
			
			
			for (int a = 3; a > -1 && !fin; a--) {
				
				a=a-i;
				
				msg += image[i][a] + "";
				
				fin = true;
				
			}
			
		}
		
		for (int i = 1; i < 4; i++) {
			
			msg += image[3][i];
			
		}

		return msg;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\n Contamination Gases by kilometer: " + contamination + ", Technomechanics Code: " + mechCode;
	}

}
