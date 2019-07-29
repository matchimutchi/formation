package superQueryBuilder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class QueryBuilder {

	// preparer le prepareStatement	
	private final String tableName;
	private final Connection base;
	private TypeRequette type;
	private List<String> selectedFields;
	private List<WhereClause> whereClauses;
	private List<OrderBy> orderBy;
	

	
	
	//enumeration de tt les type de requete
	public enum TypeRequette{
		SELECT,
		UPDATE,
		INSERT,
		DELETE,
		FILTER
	}
	
	// tt les types de where
	public enum TypeWhere{
		LESS,
		MORE,
		EQUAL,
		NOT_EQUAL,
		LESS_OR_EQUAL,
		MORE_OR_EQUAL
	}

	//represente une condition du WHERE (class interne)
	public static class WhereClause{
		private final String fieldName;
		private final TypeWhere typeWhere;
		private final int position;
		
		// c'est un constructeur
		public WhereClause(String fieldName, TypeWhere typeWhere, int position) {
			this.fieldName = fieldName;
			this.typeWhere = typeWhere;
			this.position = position;
		}
		
			
		//getter setter
		public String getFieldName() { return fieldName; }
		public TypeWhere getTypeWhere() { return typeWhere; }
		public int getPosition() { return position; }


		//tostring
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder(" `");
			sb.append(fieldName).append("` ");
			switch (typeWhere) {
				case EQUAL: sb.append("=");break;
				case LESS: sb.append("<");break;
				case MORE: sb.append(">");break;
				case LESS_OR_EQUAL: sb.append("<=");break;
				case MORE_OR_EQUAL: sb.append(">=");break;
				case NOT_EQUAL : sb.append("<>");break;

			}
			sb.append("?");
			return sb.toString();
		}
					
	}

	
	public static class OrderBy{
		private final String fieldName;
		private final boolean direction;
		
		// c'est un constructeur
		public OrderBy(String fieldName, boolean direction) {
			this.fieldName = fieldName;
			this.direction = direction;
		}
		
			
		//getter setter
		public String getFieldName() { return fieldName; }


		//tostring
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder(" `");
			sb.append(fieldName).append("` ");
			if(direction) {
				sb.append(" ASC ");
			}else {
				sb.append(" DESC ");
			}
			return sb.toString();
		}
					
	}
	
	
	//--------------------------------------------------------
	
	
	//contructeur
	public QueryBuilder(String tableName, Connection base) {
		this.tableName = tableName;
		this.base = base;
		this.type = TypeRequette.SELECT;
		this.selectedFields = new ArrayList<String>();
		this.whereClauses = new ArrayList<>();
		this.orderBy = new ArrayList<>();
	}
	
	public QueryBuilder addField(String fieldName) {
		this.selectedFields.add(fieldName);
		return this;
	}
	
	//specifie la position des WHERE
	public QueryBuilder addWhere(String fieldName, TypeWhere type, int position) {
		this.whereClauses.add(new WhereClause(fieldName, type, position));
		
		return this;
	}
	
	public QueryBuilder addOrderBY(String fieldName, boolean direction) {
		this.orderBy.add(new OrderBy(fieldName, direction));		
		return this;
	}
	
	
	public QueryBuilder select() {
		this.type = TypeRequette.SELECT;
		return this;
	}
	
	public QueryBuilder insert() {
		this.type = TypeRequette.INSERT;
		return this;
	}
	public QueryBuilder update() {
		this.type = TypeRequette.UPDATE;
		return this;
	}
	public QueryBuilder delete() {
		this.type = TypeRequette.DELETE;
		return this;
	}
	
	public QueryBuilder filter() {
		this.type = TypeRequette.FILTER;
		return this;
	}
	//quelle type de requete est demandée
	public PreparedStatement build() {
		try {
			switch (type) {
				case SELECT:return buildSelect();
				case UPDATE:return buildUpdate();
				case INSERT:return buildInsert();
				case DELETE:return buildDelete();
				case FILTER:return buildFilter();
			} 
		}catch (SQLException e) {e.printStackTrace();}
		return null;
	}
	
	
	
	/*----------------------------SELECT--------------------------*/
	//CREATION de la requete select all
	private PreparedStatement buildSelect() throws SQLException {
		StringBuilder sb = new StringBuilder("SELECT ");
		if(selectedFields.isEmpty()) {
			sb.append("*");
		}
		else {
			sb.append('`')
			//String.join colle les champs entre eux. L'inverse du split
			.append(String.join("`,`", selectedFields))
			.append('`');
		}
		
		sb.append(" FROM `")
		.append(tableName)
		.append('`');
		
		if(!whereClauses.isEmpty()) {
			List<String> clauses = this.whereClauses.stream()
					.sorted((c1, c2) -> Integer.compare(c1.position, c2.position))
					.map(c -> c.toString()).collect(Collectors.toList());
		sb.append(" WHERE ").append(String.join( " AND ", clauses));
		}
		
		
		
		System.out.println("requette = " + sb.toString());
		return base.prepareStatement(sb.toString());
	}
	
	/*----------------------------UPDATE--------------------------*/
	private PreparedStatement buildUpdate() throws SQLException {
		StringBuilder sb = new StringBuilder("UPDATE ");
		if(this.selectedFields.isEmpty()) {
			throw new SQLException("can not update with no fields selected");
		}
		sb.append('`').append(tableName).append("` SET `");
		sb.append(String.join("` = ?, `", this.selectedFields))
						.append("` = ? ");
		
		//isEMpty si il y en a 
		if(!whereClauses.isEmpty()) {
			List<String> clauses = this.whereClauses.stream()
					.sorted((c1, c2) -> Integer.compare(c1.position, c2.position))
					.map(c -> c.toString()).collect(Collectors.toList());
		sb.append(" WHERE ").append(String.join( " AND ", clauses));
		}
		
		System.out.println("requette = " + sb.toString());
		return base.prepareStatement(sb.toString());

	}
	
	
	/*----------------------------INSERT--------------------------*/
	private PreparedStatement buildInsert() throws SQLException {
		StringBuilder sb = new StringBuilder("INSERT  INTO");
		if(this.selectedFields.isEmpty()) {
			throw new SQLException("can not update with no fields selected");
		}
		sb.append('`').append(tableName).append("` ( `");
		sb.append(String.join("` , `", this.selectedFields)).append("` ) ");
		sb.append(" VALUES").append(" ( ");
		sb.append(String.join(" , ", selectedFields.stream().map(c -> "?").collect(Collectors.toList()))).append(" ) ");	

		
		System.out.println("requette = " + sb.toString());
		return base.prepareStatement(sb.toString());

	}
	
	
	/*----------------------------DELETE--------------------------*/
	private PreparedStatement buildDelete() throws SQLException {
		StringBuilder sb = new StringBuilder(" DELETE FROM ");
		if(this.selectedFields.isEmpty()) {
			throw new SQLException("can not update with no fields selected");
		}
		sb.append('`').append(tableName).append('`');
		sb.append(" WHERE ").append("`").append("id`").append(" =? ");
		
		
		//isEMpty si il y en a 
		if(!whereClauses.isEmpty()) {
			List<String> clauses = this.whereClauses.stream()
					.sorted((c1, c2) -> Integer.compare(c1.position, c2.position))
					.map(c -> c.toString()).collect(Collectors.toList());
		sb.append(String.join( " AND ", clauses));
		}
		
		
		System.out.println("requette = " + sb.toString());
		return base.prepareStatement(sb.toString());

	}
	
	/*-------------------FILTRER----------------*/
	private PreparedStatement buildFilter() throws SQLException {

		StringBuilder sb = new StringBuilder("SELECT ");
		if(selectedFields.isEmpty()) {
			sb.append("*");
		}
		else {
			sb.append('`')
			.append(String.join("`,`", selectedFields))
			.append('`');
		}
		
		sb.append(" FROM `")
		.append(tableName)
		.append('`').append(" ORDER BY ").append(String.join(",", this.orderBy.stream().map(c -> c.toString()).collect(Collectors.toList())));
		

		System.out.println("requette = " + sb.toString());
		return base.prepareStatement(sb.toString());
	}
	
}
