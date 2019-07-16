package javasqlbasique;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		//chargé la class driver mysql
		//forName et new intance permettent de récupérer une instance de Class à partir du nom complet d'une classe
		try {
			//driver mysql s'enregistre a son chargement auprés du driverManager
			Class.forName("com.mysql.jdbc.Driver");
			//ouvrir une connexion à la base
			Connection base = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/base_java1", 
					"root", 
					"");
			//dans base j'ai une mysqlConnection
			//cet objet permet, entre autre de gerer la connection à la base
			// et de recuperer des statement permet de requeter la base
			System.out.println("nous somme connecté à la base");
			
			//requetteur
			//Statement query2 = base.createStatement();
			
			//une requete de modifiction(insert, update, delete) ne renvoi
			// pas a proprement parler de donnée, cela renvoie juste une informatio
			// a savoir le nombre de ligne affecté
			// ca ne renvoie pas un resulset
			// ce n'est pas le meme méthode
			
			
			Scanner reader = new Scanner(System.in);
			
			
			//----------------SUPPRIMER UNE LIGNE-----------------
			PreparedStatement query4 = base.prepareStatement("DELETE FROM `contact` WHERE `id`=? ");
			
			System.out.println("id de l'acteur à supprimer?");
			
			//parseInt convertie les chaine en nombre
			int id = Integer.parseInt(reader.nextLine());
			query4.setInt(1,id);
			
			int nbrows = query4.executeUpdate();
			System.out.println("nombre de ligne affectées: " + nbrows);
			
			
			//---------MODIFIER UNE LIGNE-------------
			
			/*PreparedStatement query3 = base.prepareStatement("UPDATE `contact` SET `email` = ? ,`nom` = ? WHERE `id` = ?");
			
			System.out.println("id de l'acteur à modifier?");
			
			// Definir avec l'utilisateur les modification
			int id = Integer.parseInt(reader.nextLine());
			System.out.println("nouveau nom?"); 
			String nom = reader.nextLine();
			System.out.println("nouveau email ?"); 
			String email = reader.nextLine();
			
			//attribuer un objet au ?
			query3.setString(1, email);
			query3.setString(2, nom);
			query3.setInt(3,id);
			
			
			int nbrows = query3.executeUpdate();
			System.out.println("nombre de ligne affectées: " + nbrows);*/
			
			
			
			//----------- INSERER UNE LIGNE ----------------
			/*
			System.out.println("Nom de l'acteur?");
			String nom = reader.nextLine();
			System.out.println("Prenom de l'acteur?");
			String prenom = reader.nextLine();
			System.out.println("Emai de l'acteur?");
			String email = reader.nextLine();
			
			
			System.out.println("\n");
			System.out.println("-----------INSERER LIGNE------------");
			// statement signifie déclaration
			PreparedStatement query2 = base.prepareStatement("INSERT INTO `contact`(`nom`,`prenom`,`email`)"
					+ "VALUES(?,?,?)");
			
			query2.setString(1, nom);
			query2.setString(2, prenom);
			query2.setString(3, email);
			
			int nbrows = query2.executeUpdate();
			System.out.println("nombre de ligne affectées: " + nbrows);
			*/
			
			
			
			
			/*System.out.println("\n");
			System.out.println("-----------INSERER LIGNE query 2------------");
			// inseré des données
			String insertsql =
					"INSERT INTO `contact`(`nom`,`prenom`,`email`) VALUES ('"+ nom + "', '"+ prenom + "','"+ email + "');";
					
					
			System.out.println(insertsql);
			
			// c'est execute  update pour insert, update ou delete
			//int nbrows = query2.executeUpdate(insertsql);
			
			System.out.println("nombre de lignes affecté " + nbrows);
			
			
			System.out.println("\n");
			//requetteur pret à l'emploie
			Statement query1 = base.createStatement();
			
			
			//executer une requete
			//comme la requete est : SELECT `id`,`nom`,`prenom`,`email` FROM `contact`
			// c'est une select , cela re,voi des données sous forme de tableau
			// il nous faut un resultset pour parcourir les résultat
			
			ResultSet rs1 = query1.executeQuery("SELECT `id`,`nom`,`prenom`,`email` FROM `contact`");
			
			System.out.println("-----------Résultat nom------------");
			
			//le resulSet est en quelque sorte un curseur sur les données renvoyées par la requete
			//next positionne le curseur sur la ligne suivante
			while(rs1.next()) {
				System.out.println(rs1.getString("nom"));
			}
			rs1.close();*/

			// fermeture de la connexion
			base.close();
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
