package firstweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//methode
		//Cela permet d'écrire et de 
		
		PrintWriter pw = response.getWriter();
		
		
		//quel est le type qu'on va renvoyer
		response.setContentType("text/html");
		
		//on ecrit notre html

		pw.println("<html><head><title>Bonjour</title><link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\"></head>");
		pw.println("<body><nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\">\r\n" + 
				"    <a class=\"navbar-brand\" href=\"#\">JAVASCRIPT</a>\r\n" + 
				"    <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n" + 
				"      <span class=\"navbar-toggler-icon\"></span>\r\n" + 
				"    </button>\r\n" + 
				"\r\n" + 
				"    <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\r\n" + 
				"      <ul class=\"navbar-nav mr-auto\">\r\n" + 
				"        <li class=\"nav-item dropdown\">\r\n" + 
				"          <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\r\n" + 
				"            Navigation\r\n" + 
				"          </a>\r\n" + 
				"          <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\r\n" + 
				"            <a class=\"dropdown-item\" href=\"http://localhost:8080/firstweb/HelloServlet\">Servlets</a>\r\n" + 
				"            <div class=\"dropdown-divider\"></div>\r\n" + 
				"            <a class=\"dropdown-item\" href=\"http://localhost:8080/firstweb/jsp/hello.jsp\">JSP</a>\r\n" + 
				"          </div>\r\n" + 
				"        </li>\r\n" + 
				"      </ul>\r\n" + 
				"    </div>\r\n" + 
				"  </nav><h2>Bienvenue le " + LocalDateTime.now() + "</h2>");
		pw.println("<ul>");
		for(int i = 1; i <= 10; i++) {
			pw.println("<li>"+ i + "</li>");
		}
		pw.println("</ul>");
		pw.println("</body><script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\r\n" + 
				"    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\" integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\" crossorigin=\"anonymous\"></script>\r\n" + 
				"    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\" integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\" crossorigin=\"anonymous\"></script></html>");
		
		//on ferme l'ecriture
		pw.close();
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
