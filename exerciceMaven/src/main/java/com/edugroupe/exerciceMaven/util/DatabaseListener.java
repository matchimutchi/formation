package com.edugroupe.exerciceMaven.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.edugroupe.exerciceMaven.dao.LivreDao;


public class DatabaseListener implements ServletContextListener {


    public DatabaseListener() {
    }

    public void contextDestroyed(ServletContextEvent ctxEvt)  { 
    }

    public void contextInitialized(ServletContextEvent ctxEvt)  { 
    	

    	try {
			Class.forName(ctxEvt.getServletContext().getInitParameter("driverClass"));
			Connection base = DriverManager.getConnection(
			ctxEvt.getServletContext().getInitParameter("databaseUrl"),
			ctxEvt.getServletContext().getInitParameter("username"),
			ctxEvt.getServletContext().getInitParameter("password"));
		
			

			LivreDao dao = new LivreDao(base);
			

			ctxEvt.getServletContext().setAttribute("livreDao", dao);
			
			
		} catch (ClassNotFoundException e) {e.printStackTrace();} 
    	catch (SQLException e) {e.printStackTrace();}
    	
    	
    }
	
}
