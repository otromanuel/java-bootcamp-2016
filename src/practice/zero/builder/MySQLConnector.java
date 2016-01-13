package practice.zero.builder;

public class MySQLConnector implements DatabaseConnector {

	@Override
	public String connect(String user, String password) {
		return "Connect to a MySQL database";
	}

}
