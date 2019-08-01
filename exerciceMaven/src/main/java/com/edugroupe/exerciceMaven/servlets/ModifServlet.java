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


public class ModifServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	private LivreDao livreDAO;
	
    public ModifServlet() {
        super();
    }
	
    
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		livreDAO = (LivreDao)getServletContext().getAttribute("livreDao");
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException, ServletException {

		response.setContentType("application/json");
		

		List<Livre> livres = livreDAO.findAll();
		
				


		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		
		PrintWriter out = response.getWriter();
		
		out.print(gson.toJson(livres));
		
		out.close();

		
   }

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
