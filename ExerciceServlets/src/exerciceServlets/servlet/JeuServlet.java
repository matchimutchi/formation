package exerciceServlets.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exerciceServlets.dao.JeuDao;
import exerciceServlets.metier.Jeux;



public class JeuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	private JeuDao jeuDao;
	
    public JeuServlet() {
        super();
    }


	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		this.jeuDao = (JeuDao)getServletContext().getAttribute("JeuDao");
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("path = " + request.getPathInfo());
		String pathinfo = request.getPathInfo();
		if(pathinfo != null && pathinfo.length() > 1) {
			try {
				int id = Integer.parseInt(pathinfo.substring(1));
				if(id > 0) {

				request.setAttribute("jeu", jeuDao.findOne(id));
				}
				else {
					request.setAttribute("jeu", new Jeux());
				}

				
				getServletContext().getRequestDispatcher("/jeu/edit.jsp").forward(request, response);
				
				return;
			}
			catch(NumberFormatException ex){ex.printStackTrace();}
		}
		
		List<Jeux> jeux = jeuDao.findAll();
		request.setAttribute("jeux", jeux);
		getServletContext().getRequestDispatcher("/jeu/liste.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String titre = request.getParameter("titre");
		String description = request.getParameter("description");		
		String plateforme = request.getParameter("plateforme");
		int anneeSortie = Integer.parseInt(request.getParameter("anneeSortie"));
		

		Jeux f = new Jeux(id,titre,description,plateforme,anneeSortie);
		
		jeuDao.save(f);
		
		jeuDao.delete(id);
		response.sendRedirect("/ExerciceServlets/");
	}

}
