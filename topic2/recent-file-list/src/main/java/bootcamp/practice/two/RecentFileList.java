package bootcamp.practice.two;

import java.util.ArrayList;

public class RecentFileList {

	private final int LIST_CAPACITY = 15;

	protected ArrayList<String> list;

	public RecentFileList() {
		this.list = new ArrayList<String>();
	}

	public int size() {
		return list.size();
	}

	public void addFile(String file) {
		if (!this.contains(file)) {
			if (this.list.size() == LIST_CAPACITY)
				this.list.remove(this.getLast());
			list.add(0, file);
		}
	}

	public void removeFile(String file) {
		list.remove(file);
	}

	public boolean contains(String file) {
		return list.contains(file);
	}

	public String getFirst() {
		return list.get(0);
	}

	public void removeAllFiles() {
		list.removeAll(list);
	}

	public Object getLast() {
		return list.get(list.size() - 1);
	}

}
