package bootcamp.practice.two;

public class Blog {

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

	public void showRecentEntries() {
		for (int i = 0; i < 10; i++) {
			showEntry(entryDao.findAll().get(i));
		}
	}

	public void showEntry(BlogEntry entry) {
		System.out.println("Written " + entry.getDate().toString());
		System.out.println(entry.getTitle().toUpperCase());
		System.out.println(entry.getContent());
		System.out.println("");
	}
	
}
