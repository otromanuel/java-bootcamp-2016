package bootcamp.practice.two;

import java.util.Collection;

public interface DAO<T> {

	public T findById(int id);

	public Collection<T> findAll();

	public void delete(T entity);

	public void save(T entity);

}
