package practice.zero.builder;

public interface AbstractConnector {

	public void registerDriver();

	public String getConnection(String url, String user, String pass);
}
