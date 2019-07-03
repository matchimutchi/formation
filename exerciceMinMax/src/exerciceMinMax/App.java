package exerciceMinMax;

import java.util.Arrays;

public class App {

	public static void main(String[] args) {
		
		
		valMinMax(15,25,98,65,12,36);
		findMinMax(-15,125,298,65,-142,36);
	

	}
	
	public static void valMinMax(double ... values) {
		double valMin = Double.POSITIVE_INFINITY;
		double valMax = Double.NEGATIVE_INFINITY;

	
		for(int i = 0; i < values.length; i++) {
			if(values[i] > valMax) {
				valMax = values[i];
			}
			if(values[i] < valMin) {
				valMin = values[i];
			}
		}
		System.out.println(valMin);
		System.out.println(valMax);
		

	}
	
	public static void findMinMax(double ...data ) {
		double min = Double.POSITIVE_INFINITY;
		double max = Double.NEGATIVE_INFINITY;
		
		for(double d : data) {
			if(d < min) {
				min = d;
			}
			if(d > max) {
				max = d;
			}
		}
	System.out.println("maximum " + max);
	System.out.println("minimum " + min);
		
		

	}

}
