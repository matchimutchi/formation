package superQueryBuilder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import superQueryBuilder.QueryBuilder.TypeWhere;


public class App {

	public static void main(String[] args) {
    	//connection a la base de donnée
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection base = DriverManager.getConnection("jdbc:mysql://localhost:3306/base_web1", "root", "");
			
			QueryBuilder builder = new QueryBuilder("films", base);
			
			/*PreparedStatement updateStat = builder.addField("longueur")
										.addField("titre")
										.update()
										.addWhere("id", TypeWhere.EQUAL, 1)
										.build();
			updateStat.setInt(1, 180);
			updateStat.setString(2, "Blade runner");
			updateStat.setInt(3, 2);
			updateStat.executeUpdate();*/
			
			
			//construis moi le select avec les options id, titre et annee
			PreparedStatement selectStat = builder.addField("id")
												.addField("titre")
												.addField("annee")
												.addField("longueur")
												.addWhere("annee", TypeWhere.LESS, 1)
												.addWhere("longueur", TypeWhere.MORE, 2)
												.select()
												.build();
			
			
			selectStat.setInt(1, 1990);
			selectStat.setInt(2, 130);
			ResultSet rs = selectStat.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getInt("id") + " - " + rs.getString("titre") + " - " + rs.getInt("annee"));
			}
			
			rs.close();
			base.close();
			
		} catch (ClassNotFoundException e) {e.printStackTrace();} 
    	catch (SQLException e) {e.printStackTrace();}
    	

	}

}
