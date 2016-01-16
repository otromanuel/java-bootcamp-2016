package practice.zero.proxy;

public class DatabaseClient {

	public static void main(String[] args) {
		DatabaseOperation operation;
		operation = new ProxyOperation();
		
		String result = operation.selectFromTable("Person", "age>65");
		System.out.println(result);
		
		result = operation.deleteFromTable("Animals", "kind=reptile");
		System.out.println(result);
		
		result = operation.updateTable("Cars", "tm='toyota' OR tm='suzuki'", "madein=japan");
		System.out.println(result);

	}

}
