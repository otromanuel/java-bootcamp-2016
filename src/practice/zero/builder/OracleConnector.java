package practice.zero.builder;

public class OracleConnector implements DatabaseConnector {

	@Override
	public String connect(String user, String password) {
		return "Connect to a ORACLE database";
	}

}
