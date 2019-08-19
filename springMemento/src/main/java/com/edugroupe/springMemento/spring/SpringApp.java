package com.edugroupe.springMemento.spring;

import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.edugroupe.springMemento.beans.IMathUtils;



public class SpringApp {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
        Scanner input = new Scanner(System.in);
        

        input.nextLine();
        System.out.println("-----------------FIBONACCI---------------------");
        IMathUtils mu = ctx.getBean("mathUtils", IMathUtils.class);
        while (true) {
			System.out.println("Valeur à calculer ( fibonacci)?");
			int n = Integer.parseInt(input.nextLine());
			if(n == 0) {
				break;
			}
			System.out.println("Résultat = " + mu.fibonacci(n));
			
		}
        



		System.out.println("done...");
	}





}
