package practice.zero.builder;

public class DatabaseClient {

	public static void main(String[] args) {
		/*
		 * EXAMPLE
		 * 
		 * The connectors are the builders (abstract and concrete for each DBMS)
		 * 
		 * The product is a connection, represented in a String
		 * 
		 */
		AbstractConnector oracleConnector = new OracleConnector();
		ConnectionDirector director = new ConnectionDirector(oracleConnector);
		String connection = director.connect("192.168.1.1", "root", "blabla");
		System.out.println(connection);

		AbstractConnector mysqlConnector = new MySQLConnector();
		director.setConnector(mysqlConnector);
		connection = director.connect("192.168.1.2", "root", "blabla");
		System.out.println(connection);

		AbstractConnector postgresConnector = new PostgresConnector();
		director.setConnector(postgresConnector);
		connection = director.connect("192.168.1.2", "root", "blabla");
		System.out.println(connection);
	}

}
