package bootcamp.practice.two;

import java.util.ArrayList;

public class EntryDAO implements DAO<BlogEntry> {

	ArrayList<BlogEntry> entries;

	public EntryDAO() {
		this.entries = new ArrayList<BlogEntry>();
	}

	public BlogEntry findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<BlogEntry> findAll() {
		return entries;
	}

	public void delete(BlogEntry entity) {
		entries.remove(entity);

	}

	public void save(BlogEntry entity) {
		entries.add(0, entity);
	}

	public BlogEntry findByName(String name) {
		int i = 0;
		while ((i < entries.size()) && (entries.get(i).getTitle() != name))
			i++;
		if (i < entries.size())
			return entries.get(i);
		else
			return null;
	}

}
