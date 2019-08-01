package com.edugroupe.exerciceMaven.servlets;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.edugroupe.exerciceMaven.dao.LivreDao;
import com.edugroupe.exerciceMaven.metier.Livre;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class IndexServlet extends HttpServlet {
	
	private static Logger log = LogManager.getLogger(IndexServlet.class); 
	private static final long serialVersionUID = 1L;


		private LivreDao livreDAO;
		
		
		@Override
		public void init(ServletConfig config) throws ServletException {
			super.init(config);
			livreDAO = (LivreDao)getServletContext().getAttribute("livreDao");
		}

		
		public void doGet(HttpServletRequest request, HttpServletResponse response) 
	      throws IOException, ServletException {

			response.setContentType("application/json");
			

			List<Livre> livres = livreDAO.findAll();
			
			if(request.getParameter("search") != null) {
				livres = livreDAO.findByTitre(request.getParameter("search"));
			}
			else if (request.getParameter("filter") != null) {
				livres = livreDAO.findFilter(request.getParameter("filter"));
			}
			else {
				livres = livreDAO.findAll();
			}

					

			GsonBuilder builder = new GsonBuilder();
			Gson gson = builder.create();
			
			PrintWriter out = response.getWriter();
			
			out.print(gson.toJson(livres));
			
			out.close();

			
	   }

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			int id = Integer.parseInt(req.getParameter("id"));
			String titre = req.getParameter("titre");
			String isbn = req.getParameter("isbn");
			int nbPages = Integer.parseInt(req.getParameter("nbPages"));
			String auteur = req.getParameter("auteur");
			
			Livre l = new Livre(id,titre,isbn,nbPages,auteur);		
			int nbligne = livreDAO.save(l);
			
			
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
