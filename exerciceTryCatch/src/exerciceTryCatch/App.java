package exerciceTryCatch;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		Scanner lecteur = new Scanner(System.in);
		System.out.println("Rentrer une temperature C°");
		int cel = Integer.parseInt(lecteur.nextLine());
		
		if(cel < -273.15) {
			System.out.println("La temperature est negatif");
		}else {
			
		}
		
		

	}

}
