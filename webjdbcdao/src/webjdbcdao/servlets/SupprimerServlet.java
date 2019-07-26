package webjdbcdao.servlets;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import webjdbcdao.dao.FilmDao;


public class SupprimerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private FilmDao filmDao;

    public SupprimerServlet() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.filmDao = (FilmDao)getServletContext().getAttribute("filmDao");
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("suprId"));
		filmDao.delete(id);
		response.sendRedirect("/webjdbcdao/");
	}

}
