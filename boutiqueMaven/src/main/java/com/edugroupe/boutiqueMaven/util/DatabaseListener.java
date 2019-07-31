package com.edugroupe.boutiqueMaven.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.edugroupe.boutiqueMaven.dao.FilmDao;



public class DatabaseListener implements ServletContextListener {


    public DatabaseListener() {
    }

    public void contextDestroyed(ServletContextEvent ctxEvt)  { 
    }

    //ctxEvt = contexte evenement
    public void contextInitialized(ServletContextEvent ctxEvt)  { 
    	
    	//connection a la base de donnée(web.xml)
    	try {
			Class.forName(ctxEvt.getServletContext().getInitParameter("driverClass"));
			Connection base = DriverManager.getConnection(
			ctxEvt.getServletContext().getInitParameter("databaseUrl"),
			ctxEvt.getServletContext().getInitParameter("username"),
			ctxEvt.getServletContext().getInitParameter("password"));
		
			
			// instanciation du dao des film
			FilmDao dao = new FilmDao(base);
			
			//mise a disposition de celui-ci pour les services
			ctxEvt.getServletContext().setAttribute("filmDao", dao);
			
			
		} catch (ClassNotFoundException e) {e.printStackTrace();} 
    	catch (SQLException e) {e.printStackTrace();}
    	
    	
    }
	
}
