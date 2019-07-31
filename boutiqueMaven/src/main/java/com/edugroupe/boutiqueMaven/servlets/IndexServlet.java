package com.edugroupe.boutiqueMaven.servlets;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.edugroupe.boutiqueMaven.dao.FilmDao;
import com.edugroupe.boutiqueMaven.metier.Film;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class IndexServlet extends HttpServlet {
	
	private static Logger log = LogManager.getLogger(IndexServlet.class); 
	private static final long serialVersionUID = 1L;

	private FilmDao filmDAO;
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		filmDAO = (FilmDao)getServletContext().getAttribute("filmDao");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException, ServletException {
		//je renvoie du type de contenu json
		response.setContentType("application/json");
		
		//je recupere la liste des films
		List<Film> films = filmDAO.findAll();
		
		if(request.getParameter("search") != null) {
			films = filmDAO.findByTitre(request.getParameter("search"));
		}
		else {
			films = filmDAO.findAll();
		}

		
		//classe pour transformer mes objets
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		
		PrintWriter out = response.getWriter();
		
		out.print(gson.toJson(films));
		
		out.close();

		
   }






}
