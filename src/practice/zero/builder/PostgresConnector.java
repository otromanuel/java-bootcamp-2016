package practice.zero.builder;

public class PostgresConnector implements DatabaseConnector {

	@Override
	public String connect(String user, String password) {
		return "Connect to a Postgres database";
	}

}
