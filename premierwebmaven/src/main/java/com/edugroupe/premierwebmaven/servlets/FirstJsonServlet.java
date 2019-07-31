package com.edugroupe.premierwebmaven.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class FirstJsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public FirstJsonServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recupérer la librairie(mvnrepositorie gson)
		//le builder permettent de serialiser/deserialiser du json
		GsonBuilder builder = new GsonBuilder();
		
		//le builder va nous permettent de construire
		Gson gson = builder.create();
		
		//cela signifie qu'il reçoit du json et pas du html
		response.setContentType("application/json");
		
		PrintWriter pw = response.getWriter();
		
		//serialisation de texte en json
		//pw.print(gson.toJson("Bonjour"));
		//pw.print(gson.toJson(42));
		//int[] nombre_premier = {1,2,3,5,7,11,13,17,19};
		//pw.print(gson.toJson(nombre_premier));
		double[][] matrice = {{1.5,2.6,-3.4},{3.4,0.9,-15.5},};
		pw.print(gson.toJson(matrice));
		
		pw.close();
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
