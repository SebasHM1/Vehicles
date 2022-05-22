package model;

public class PropertyCard extends VehicleDocs{
	
	private String propCode;

	public PropertyCard(double price, int year) {
		super(price, year);
		this.propCode = createCode();
	}

	public String getPropCode() {
		return propCode;
	}

	public void setPropCode(String propCode) {
		this.propCode = propCode;
	}
	
	public String createCode () {
		
		String code = "";
		
		for (int i = 3; i > -1; i--) {
			
			for (int a = 3; a > -1; a--) {
				
				if (i+a != 0) {
					
					if ((i + a) % 2 == 0) {
						
						code += image[i][a] + "";
						
					}
					
				}
				
				
 				
			}
			
		}
		
		return code;
		
		
	}

	@Override
	public String toString() {
		return super.toString() + " \n PropertyCard code: " + propCode;
	}
	
	
	

}
