package model;

public class Soat extends VehicleDocs{
	
	private double insurance;
	private String soatCode;
	
	public Soat(double price, int year,  double insurance) {
		super(price, year);
		this.insurance = insurance;
		this.soatCode = generateCode();
	}
	
	public String getSoatCode() {
		return soatCode;
	}
	public void setSoatCode(String soatCode) {
		this.soatCode = soatCode;
	}	
	
	public double getInsurance() {
		return insurance;
	}
	public void setInsurance(double insurance) {
		this.insurance = insurance;
	}
	
	private String generateCode() {
		
		String msg = "";

		for (int i = 0; i < 3 ; i++) {
			
			msg += image[i][0];
			
		}
		
		for (int i = 0; i < 4; i++) {
			
			msg += image[3][i];
			
		} 
		
		return msg;
	}

	@Override
	public String toString() {
		return super.toString() + " \n Soat [insurance=" + insurance + ", soatCode=" + soatCode + "]";
	}
	
	

}
