package com.edugroupe.premierwebmaven.servlets;

import java.util.Date;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class IndexServlet extends HttpServlet {
	
	private static Logger log = LogManager.getLogger(IndexServlet.class); 
	private static final long serialVersionUID = 1L;

	


	public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException, ServletException {

      response.setContentType("text/html");

      PrintWriter out = response.getWriter();
      
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Bonjour tomcat</title>");
      out.println("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">");
      out.println("</head>");
      out.println("<body>");
      out.println("<nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\">\r\n" + 
      		"  <a class=\"navbar-brand\" href=\"#\">JSON</a>\r\n" + 
      		"  <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n" + 
      		"    <span class=\"navbar-toggler-icon\"></span>\r\n" + 
      		"  </button>\r\n" + 
      		"  <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\r\n" + 
      		"    <ul class=\"navbar-nav mr-auto\">\r\n" + 
      		"      <li class=\"nav-item dropdown\">\r\n" + 
      		"        <a style =\"color:white\" class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\r\n" + 
      		"          Dropdown\r\n" + 
      		"        </a>\r\n" + 
      		"        <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\r\n" + 
      		"          <a class=\"dropdown-item\" href=\"#\">Action</a>\r\n" + 
      		"          <a class=\"dropdown-item\" href=\"http://localhost:8080/premierwebmaven/FirstJsonServlet\">First</a>\r\n" + 
      		"          <div class=\"dropdown-divider\"></div>\r\n" + 
      		"          <a class=\"dropdown-item\" href=\"#\">Something else here</a>\r\n" + 
      		"        </div>\r\n" + 
      		"      </li>\r\n" + 
      		"    </ul>\r\n" + 
      		"  </div>\r\n" + 
      		"</nav>");
      out.println("<div class=\"row\">");
      out.println("<div class=\"col-md-12 mx-auto\">");
      out.println("<h3>JSON</h3>");
      out.println("</div>");
      out.println("</div>");
      out.println("</body>");
      out.println("<script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>");
      out.println("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\" integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\" crossorigin=\"anonymous\"></script>");
      out.println("<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\" integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\" crossorigin=\"anonymous\"></script> ");
      out.println("</html>");
   }

}
