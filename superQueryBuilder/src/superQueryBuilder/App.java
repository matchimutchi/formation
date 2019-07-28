package superQueryBuilder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import superQueryBuilder.QueryBuilder.TypeWhere;


public class App {

	public static void main(String[] args) {
		
		Scanner lecteur = new Scanner(System.in);
		
		System.out.println("id ?");
		String saisieId = lecteur.nextLine();
		
		int nbId = Integer.parseInt(saisieId);
		
		
		
		
//		System.out.println("Comment s'appel votre film?");
//		String saisieTitre = lecteur.nextLine();
//		
//		System.out.println("Longueur ?");
//		String saisieLongueur = lecteur.nextLine();
//		
//		int nbLongueur = Integer.parseInt(saisieLongueur);
//		
//		System.out.println("Ann�e ?");
//		String saisieAnnee = lecteur.nextLine();
//		
//		int nbAnnee = Integer.parseInt(saisieAnnee);
//		
//		System.out.println("Le genre?");
//		String saisieGenre = lecteur.nextLine();
		
		
    	//connection a la base de donn�e
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection base = DriverManager.getConnection("jdbc:mysql://localhost:3306/base_web1", "root", "");
			
			QueryBuilder builder = new QueryBuilder("films", base);
			
			/*----------------------------DELETE---------------------*/
			PreparedStatement deleteStat = builder.addField("id").delete().build();
											
			deleteStat.setInt(1, nbId);
			deleteStat.executeUpdate();
			
//			System.out.println(nbId);
			
			/*ResultSet rs = deleteStat.executeQuery();*/
			/*----------------------------UPDATE---------------------*/
			/*PreparedStatement updateStat = builder.addField("longueur")
										.addField("titre")
										.update()
										.addWhere("id", TypeWhere.EQUAL, 1)
										.build();
			updateStat.setInt(1, 180);
			updateStat.setString(2, "Blade runner");
			updateStat.setInt(3, 2);
			updateStat.executeUpdate();*/
			
			/*--------------------------INSERT---------------------------------*/
		
			/*PreparedStatement insertStat = builder.addField("titre")
												.addField("longueur")
												.addField("annee")
												.addField("genre")
												.insert()
												.build();	
			
				insertStat.setString(1, saisieTitre);
				insertStat.setInt(2, nbLongueur);
				insertStat.setInt(3, nbAnnee);
				insertStat.setString(4, saisieGenre);
				insertStat.executeUpdate();
			
				
			ResultSet rs = insertStat.executeQuery();*/
			 
			
				
			//construis moi le select avec les options id, titre et annee
			/*---------------------------SELECT-------------------------*/
			/*PreparedStatement selectStat = builder.addField("id")
												.addField("titre")
												.addField("annee")
												.addField("longueur")
												.addWhere("annee", TypeWhere.LESS, 1)
												.addWhere("longueur", TypeWhere.MORE, 2)
												.select()
												.build();
			
			
			selectStat.setInt(1, 2019);
			selectStat.setInt(2, 155);
			
			
			ResultSet rs = selectStat.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getInt("id") + " - " + rs.getString("titre") + " - " + rs.getInt("annee"));
			}
			
			rs.close();*/
			base.close();
			
		} catch (ClassNotFoundException e) {e.printStackTrace();} 
    	catch (SQLException e) {e.printStackTrace();}
    	

	}

}
