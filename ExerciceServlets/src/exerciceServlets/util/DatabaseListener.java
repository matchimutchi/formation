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

    //au demarrage de la webapp
    public void contextInitialized(ServletContextEvent ctxEvt)  { 
    	

    	try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection base = DriverManager.getConnection("jdbc:mysql://localhost:3306/base_web2", "root", "");
			
			//instanciation du dao des jeux
			//en donnant la connection a la base de donnée en parametre
			JeuDao dao = new JeuDao(base);
			
			//mise a disposition sous le nom "JeuDao" pour  le dao
			ctxEvt.getServletContext().setAttribute("JeuDao", dao);
			
			
		} catch (ClassNotFoundException e) {e.printStackTrace();} 
    	catch (SQLException e) {e.printStackTrace();}
    	
    	
    }
}
