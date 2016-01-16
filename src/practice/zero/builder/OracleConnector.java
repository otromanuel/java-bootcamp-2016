package practice.zero.builder;

public class OracleConnector implements AbstractConnector {

	@Override
	public void registerDriver() {

		System.out.println("Class.forName(\"oracle.jdbc.driver.OracleDriver\").newInstance();");

	}

	@Override
	public String getConnection(String url, String user, String pass) {

		return "Connect to ORACLE DB @ host " + url + " with user:" + user + " and pass:" + pass;

	}	

}
