package practice.zero.builder;

public class MySQLConnector implements AbstractConnector {

	@Override
	public void registerDriver() {

		System.out.println("Class.forName(\"com.mysql.jdbc.Driver\").newInstance();");

	}

	@Override
	public String getConnection(String url, String user, String pass) {

		return "Connect to MYSQL DB @ host " + url + " with user:" + user + " and pass:" + pass;

	}

}
