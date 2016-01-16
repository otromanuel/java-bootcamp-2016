package practice.zero.builder;

public class ConnectionDirector {

	protected AbstractConnector connector;

	public ConnectionDirector(AbstractConnector connector) {

		this.connector = connector;

	}

	public void setConnector(AbstractConnector connector) {

		this.connector = connector;

	}

	public String connect(String url, String user, String pass) {

		connector.registerDriver();
		return connector.getConnection(url, user, pass);

	}

}
