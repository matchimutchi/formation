 package com.edugroupe.springjdbc.beans;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import com.edugroupe.springjdbc.metier.Produit;

public class MementoAdvice implements MethodInterceptor{

	private Map<Integer, Produit> cache;
		
	public MementoAdvice() {
		this.cache = new HashMap<Integer, Produit>();
	}
	
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("Appel  de " + invocation.getMethod().getName());
		System.out.println(" de la classe " + invocation.getThis().getClass().getName());
		System.out.println("le numero de l'ID " + Arrays.toString(invocation.getArguments()) );
		if(cache.containsKey(invocation.getArguments()[0])) {
			System.out.println("Déjà en cache");
			return cache.get(invocation.getArguments()[0]);
		}else {
			System.out.println("Non, on appele la méthode originale");
			Object returnValue = invocation.proceed();
			cache.put((int)invocation.getArguments()[0],(Produit)returnValue);
			return returnValue;
		}
		
	}

	
}
