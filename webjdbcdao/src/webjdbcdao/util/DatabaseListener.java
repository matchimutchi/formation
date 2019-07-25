package webjdbcdao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import webjdbcdao.dao.FilmDao;

public class DatabaseListener implements ServletContextListener {


    public DatabaseListener() {
    }

    public void contextDestroyed(ServletContextEvent ctxEvt)  { 
    }

    //ctxEvt = contexte evenement
    public void contextInitialized(ServletContextEvent ctxEvt)  { 
    	
    	//connection a la base de donnée
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection base = DriverManager.getConnection("jdbc:mysql://localhost:3306/base_web1", "root", "");
			
			// instanciation du dao des film
			FilmDao dao = new FilmDao(base);
			
			//mise a disposition de celui-ci pour les services
			ctxEvt.getServletContext().setAttribute("filmDao", dao);
			
			
		} catch (ClassNotFoundException e) {e.printStackTrace();} 
    	catch (SQLException e) {e.printStackTrace();}
    	
    	
    }
	
}
