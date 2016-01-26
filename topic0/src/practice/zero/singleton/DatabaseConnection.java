package practice.zero.singleton;

/*
 *  Singleton example
 */
public class DatabaseConnection {

	private static DatabaseConnection connection = null;

	private DatabaseConnection() {
		// Do the DB connection.
	}

	public DatabaseConnection getInstance() {
		if (connection == null)
			connection = new DatabaseConnection();
		return connection;
	}

	public String getStatus(){
		return "DB connection status: connected";
	}

}
