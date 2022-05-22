package model;
import java.util.Random;

public abstract class VehicleDocs {

	private double price;
	
	private int year;
	protected int[][] image;
	
	public VehicleDocs(double price, int year) {
		super();
		this.price = price;
		this.year = year;
		this.image = generateMatrix();
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int[][] getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = generateMatrix();
	}
	
	public int[][] generateMatrix() {
		
		Random rnd = new Random();
		
		int[][] finalMatrix = new int[4][4];
		
		for (int i = 0; i < 4; i++) {
			
			for (int a = 0; a < 4; a++) {
				
				finalMatrix[i][a] = rnd.nextInt(10);
				
			}
			
		}
		
		return finalMatrix;
	
	}
	
	private String printImage(int[][] image) {
		String print = "\n";
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				print += image[i][j] + " ";
			}
			print += "\n";
		}
		return print;
	}
	
	@Override
	public String toString() {
		return " \n  Price: " + price + ", Expedition Year: " + year + "\n Image: " + printImage(image);
	}
	
}
