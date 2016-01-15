package practice.zero.builder;

public class PostgresConnector implements AbstractConnector {

	@Override
	public void registerDriver() {

		System.out.println("Class.forName(\"com.postgresql.jdbc.Driver\").newInstance();");

	}

	@Override
	public String getConnection(String url, String user, String pass) {

		return "Connect to POSTGRES DB @ host " + url + " with user:" + user + " and pass:" + pass;

	}	

}
