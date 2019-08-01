package com.edugroupe.exerciceMaven.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edugroupe.exerciceMaven.dao.LivreDao;
import com.edugroupe.exerciceMaven.metier.Livre;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class SupprServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	private LivreDao livreDAO;
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		livreDAO = (LivreDao)getServletContext().getAttribute("livreDao");
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException, ServletException {
	
   }

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
	
		int nbLigne = livreDAO.delete(id);
		
		Map<String, Object> result = new HashMap<>();
		result.put("nbLignesupprime", nbLigne);

		resp.setContentType("application/json");
		PrintWriter out = resp.getWriter();
		
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		out.print(gson.toJson(result));	
		out.close();
	}
}
