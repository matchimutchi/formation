package reflectionJava;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DynamicDao <T> {
	
	private PreparedStatement selectAllStatement;
	
	
	private Connection base;
	private Class clazz;
	private List<DescripteurChamp> champs;
	
	
	private static class DescripteurChamp{
		public String nomChamp;
		public Method getter;
		public Method setter;
		public Class typeChamp;
		
		public DescripteurChamp(String nomChamp, Method getter, Method setter, Class typeChamp) {
			super();
			this.nomChamp = nomChamp;
			this.getter = getter;
			this.setter = setter;
			this.typeChamp = typeChamp;
		}
		
		
		
	}
	
	
	//contructeur
	//la connection et le type de l'objet
	//clazz et la classe produit
	public DynamicDao(Connection base, Class clazz) throws NoSuchMethodException, SecurityException {
		this.base = base;
		this.clazz = clazz;
		
		initialiseChamps(clazz);
		initialiseRequete(clazz);
	}

	private void initialiseRequete(Class clazz) {
		QueryBuilder qb = new QueryBuilder(clazz.getSimpleName().toLowerCase(), base);
		for(DescripteurChamp d : champs) {
			qb.addField(d.nomChamp);			
		}
		selectAllStatement = qb.select().build();
	}
	
	
	private void initialiseChamps(Class clazz) throws NoSuchMethodException {
		champs = new ArrayList<>();
		for(Method m : clazz.getDeclaredMethods()) {
			
			
			if(!Modifier.isPublic(m.getModifiers())) {
				continue;
			}
			
			if(Modifier.isStatic(m.getModifiers())) {
				continue;
			}
			Class[] params = m.getParameterTypes();
			if(params.length != 1) {
				continue;
			}
			if(m.getName().startsWith("set")) {
				//position trois car set = s 0 ; e 2 ; t 3
				String nomChamp = m.getName().substring(3);
				nomChamp = nomChamp.substring(0,1).toLowerCase() + nomChamp.substring(1);
				
				Method setter = m;
				Method getter = clazz.getDeclaredMethod(m.getName().replaceFirst("set", "get"));
				
				Class type = m.getParameterTypes()[0];
				//un des champs de notre bean(objet metier)
				champs.add(new DescripteurChamp(nomChamp, getter, setter, type));
				
			}
		}
	}
	
	public List<T> findAll(){
		ArrayList<T> data = new ArrayList<>();
		try {
			ResultSet rs = selectAllStatement.executeQuery();
			while(rs.next()) {
				data.add(fetchRowFromResultSet(rs));
			}
			rs.close();
			
		} catch (SQLException e) {e.printStackTrace();}
		return data;
	}
	
	//renvoyer un objet metier a partir d'une ligne du resulset
	// le T est le type de retour ( acteur etc..)
	private T fetchRowFromResultSet(ResultSet rs) {
		//Instancier un objet vide

			try {
				Object instance = clazz.newInstance();
				for(DescripteurChamp d : champs) {
					if(d.typeChamp.equals(String.class)) {
						//exemple => setTitre (rs.getString("titre")
						d.setter.invoke(instance, rs.getString(d.nomChamp));
					}
					
					if(d.typeChamp.equals(int.class)) {
						//exemple => setId (rs.getInt("id")
						d.setter.invoke(instance, rs.getInt(d.nomChamp));
					}
					
					if(d.typeChamp.equals(double.class)) {
						//exemple => setPrix (rs.getDouble("prix")
						d.setter.invoke(instance, rs.getDouble(d.nomChamp));
					}
				}
				return (T)instance;
			} 
			catch (InstantiationException e) {e.printStackTrace();} 
			catch (IllegalAccessException e) {e.printStackTrace();} 
			catch (IllegalArgumentException e) {e.printStackTrace();} 
			catch (InvocationTargetException e) {e.printStackTrace();} 
			catch (SQLException e) {e.printStackTrace();}
			return null;

	}
	
	
}
