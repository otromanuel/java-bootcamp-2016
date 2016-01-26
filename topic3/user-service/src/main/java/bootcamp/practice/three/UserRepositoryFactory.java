package bootcamp.practice.three;

/**
 * A factory to get the right User Repository implementation.
 */
public class UserRepositoryFactory {

	private UserRepositoryFactory() {
	};

	/**
	 * Get a local User Repository implementation.
	 * @return A UserRespositoryImp instance 
	 */
	public static UserRepositoryService getLocalUserRespository() {
		return new UserRepositoryProxy(new UserRepositoryImp());
	}
	
	/**
	 * Get a web service client for the User Repository implementation.
	 * @return A UserRespositoryWebServiceClient instance 
	 */	
	public static UserRepositoryService getUserRepositoryWebService() {
		return new UserRepositoryProxy(new UserRespositoryWebServiceClient());
	}

}
