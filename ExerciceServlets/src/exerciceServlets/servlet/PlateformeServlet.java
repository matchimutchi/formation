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


public class PlateformeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	private JeuDao jeuDao;
	
	
    public PlateformeServlet() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		this.jeuDao = (JeuDao)getServletContext().getAttribute("JeuDao");
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("path = " + request.getPathInfo());
		String pathinfo = request.getPathInfo();	
		List<Jeux> jeux = jeuDao.requeteAll(pathinfo.substring(1));
		request.setAttribute("jeux", jeux);
		getServletContext().getRequestDispatcher("/jeu/plateforme.jsp").forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
