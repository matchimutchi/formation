package exerciceServlets.servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exerciceServlets.dao.JeuDao;
import exerciceServlets.metier.Jeux;

public class SupprimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private JeuDao jeuDao;

    public SupprimeServlet() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		this.jeuDao = (JeuDao)getServletContext().getAttribute("JeuDao");
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("suprId"));
	
		jeuDao.delete(id);
		
		response.sendRedirect("/ExerciceServlets/");
	}

}
