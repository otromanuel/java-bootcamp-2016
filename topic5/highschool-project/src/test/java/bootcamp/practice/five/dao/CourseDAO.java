package bootcamp.practice.five.dao;

import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;

import com.mongodb.MongoClient;

import bootcamp.practice.five.entity.Course;

/**
 * Used to query the Course collection.
 *
 */
public class CourseDAO extends BasicDAO<Course, String> {

	public CourseDAO(MongoClient mongoClient, Morphia morphia, String dbName) {
		super(mongoClient, morphia, dbName);
		// TODO Auto-generated constructor stub
	}
	

}
