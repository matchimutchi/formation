package com.edugroupe.boutiqueMaven.servlets;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String titre = req.getParameter("titre");
		int annee = Integer.parseInt(req.getParameter("annee"));
		int longueur = Integer.parseInt(req.getParameter("longueur"));
		String genre = req.getParameter("genre");
		
		Film f = new Film(0,titre,longueur,annee,genre);		
		int nbligne = filmDAO.save(f);
		
		//infos sur la sauvegarde
		Map<String, Object> result = new HashMap<>();
		result.put("nblignesSauvees", nbligne);
		
		//preparation de la reponse
		resp.setContentType("application/json");
		PrintWriter out = resp.getWriter();
		
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		//reponse
		out.print(gson.toJson(result));
		
		out.close();
	}
	
	
	
	






}
