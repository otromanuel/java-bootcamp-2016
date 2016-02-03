package bootcamp.practice.five.dao;

import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;

import com.mongodb.MongoClient;

import bootcamp.practice.five.entity.Student;

/**
 * Used to query the Student collection.
 */
public class StudentDAO extends BasicDAO<Student, String> {

	public StudentDAO(MongoClient mongoClient, Morphia morphia, String dbName) {
		super(mongoClient, morphia, dbName);
		// TODO Auto-generated constructor stub
	}

}
