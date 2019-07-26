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

public class GenreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private FilmDao filmDao;
	
	
    public GenreServlet() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		this.filmDao = (FilmDao)getServletContext().getAttribute("filmDao");
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("path = " + request.getPathInfo());
		String pathinfo = request.getPathInfo();	
		List<Film> films = filmDao.requeteAll(pathinfo.substring(1));
		request.setAttribute("films", films);
		getServletContext().getRequestDispatcher("/film/genre.jsp").forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}


}
