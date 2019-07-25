package exerciceServlets.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import exerciceServlets.dao.JeuDao;

public class DatabaseListener implements ServletContextListener {

	

    public DatabaseListener() {
    }

    public void contextDestroyed(ServletContextEvent ctxEvt)  { 
    }

    public void contextInitialized(ServletContextEvent ctxEvt)  { 
    	

    	try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection base = DriverManager.getConnection("jdbc:mysql://localhost:3306/base_web2", "root", "");
			
			JeuDao dao = new JeuDao(base);
			
			ctxEvt.getServletContext().setAttribute("JeuDao", dao);
			
			
		} catch (ClassNotFoundException e) {e.printStackTrace();} 
    	catch (SQLException e) {e.printStackTrace();}
    	
    	
    }
}
