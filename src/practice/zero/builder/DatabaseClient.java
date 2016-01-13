package practice.zero.builder;

public class DatabaseClient {

	public static void main(String[] args) {
		// Example
		DatabaseConnector connector = new MySQLConnector();
		String result = connector.connect("root", "securePassword");
		System.out.println(result);

	}

}
