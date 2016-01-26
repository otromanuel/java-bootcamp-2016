package bootcamp.practice.two;

import java.util.ArrayList;

public class Blog {

	public static final int NUMBER_OF_RECENT_POSTS = 10;
	private EntryDAO entryDao;

	public Blog() {
		entryDao = new EntryDAO();
	}

	public Blog(EntryDAO entryDao) {
		this.entryDao = entryDao;
	}

	public void newEntry(BlogEntry entry) {
		entryDao.save(entry);
	}

	public BlogEntry getEntryByTitle(String title) {
		return entryDao.findByName(title);
	}

	public void deleteEntry(BlogEntry entry) {
		entryDao.delete(entry);
	}

	public ArrayList<BlogEntry> getRecentEntries() {
		ArrayList<BlogEntry> allposts = entryDao.findAll();
		ArrayList<BlogEntry> recent_posts = new ArrayList<BlogEntry>();
		for (int i = 0; i < NUMBER_OF_RECENT_POSTS; i++)
			recent_posts.add(allposts.get(i));
		return recent_posts;
	}
}
