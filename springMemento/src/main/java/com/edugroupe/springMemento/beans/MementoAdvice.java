package com.edugroupe.springMemento.beans;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MementoAdvice implements MethodInterceptor {

	//Map<entrée,sortie>
	private Map<Integer, Integer> cache;
	
	public MementoAdvice() {
		//initialisation a vide
		this.cache = new HashMap<Integer, Integer>();
	}
	
	
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("Appel  de " + invocation.getMethod().getName());
		System.out.println(" de la classe " + invocation.getThis().getClass().getName());
		System.out.println("avec les arguments " + Arrays.toString(invocation.getArguments()) );
		//stocker les donnée en cache pour ne pas charger deux fois le meme nombre
		//ais je déjà appelé fibonacci avec cette valeur?
		if(cache.containsKey(invocation.getArguments()[0])) {
			//oui, renvoyer directement la valuer
			System.out.println(" Déjà en cache");
			return cache.get(invocation.getArguments()[0]);
		}else {
			System.out.println("Non, on appele la méthode originale");
			Object returnValue = invocation.proceed();
			cache.put((int)invocation.getArguments()[0],(int)returnValue);
			return returnValue;
		}
		//proceed = appel la methode originale
		//return invocation.proceed();
		
	}

}
