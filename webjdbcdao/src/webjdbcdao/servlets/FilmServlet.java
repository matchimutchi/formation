package webjdbcdao.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webjdbcdao.dao.FilmDao;
import webjdbcdao.metier.Film;


public class FilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private FilmDao filmDao;
	
	
    public FilmServlet() {
        super();
    }

    
    //a l'initialisation de la servlets
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		//je récupére la DAO initialisé par le DatabaseListener
		this.filmDao = (FilmDao)getServletContext().getAttribute("filmDao");
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recupere les film pour formater sous le format d'un tableau pour pouvoir les afficher
		System.out.println("path = " + request.getPathInfo());
		String pathinfo = request.getPathInfo();
		if(pathinfo != null && pathinfo.length() > 1) {
			try {
				int id = Integer.parseInt(pathinfo.substring(1));
				if(id > 0) {
				//je récupére le film grace a son id
				//filmDao est un objet
				request.setAttribute("film", filmDao.findOne(id));
				}
				else {
					//creation d'un objet film si l'id n'existe pas
					request.setAttribute("film", new Film());
				}

				
				getServletContext().getRequestDispatcher("/film/edit.jsp").forward(request, response);
				
				return;
			}
			catch(NumberFormatException ex){ex.printStackTrace();}
		}
		
		//afficher la liste des films
		List<Film> films = filmDao.findAll();
		request.setAttribute("films", films);
		getServletContext().getRequestDispatcher("/film/liste.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String titre = request.getParameter("titre");
		int longueur = Integer.parseInt(request.getParameter("longueur"));
		int annee = Integer.parseInt(request.getParameter("annee"));
		String genre = request.getParameter("genre");
		
		//creer une instance de film
		Film f = new Film(id,titre,longueur,annee,genre);
		
		//sauvegarde dans la method filmDao
		filmDao.save(f);
		
		filmDao.delete(id);
		
		//redirection
		response.sendRedirect("/webjdbcdao/");
		
	}

}
