package bootcamp.practice.two;

import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class BlogTest {

	// Post new entry
	@Test
	public void whenNewEntryThenBlogHasNewEntry() {
		Blog blog = new Blog();
		BlogEntry entry = new BlogEntry("TDD Best Practices", "RED. GREEN. REFACTOR. REPEAT");
		blog.newEntry(entry);
		Assert.assertNotNull(blog.getEntryByTitle("TDD Best Practices"));
	}

	// Delete existing entry
	@Test
	public void whenDeleteEntryThenBlogDeletesEntry() {
		Blog blog = new Blog();
		BlogEntry entry = new BlogEntry("TDD Best Practices II", "RED. GREEN. REFACTOR. REPEAT");
		blog.newEntry(entry);
		blog.deleteEntry(entry);
		Assert.assertNull(blog.getEntryByTitle("TDD Best Practices II"));
	}

	// Show 10 most recent entries
	@Test
	public void whenShowRecentthen10MoreRecent() {
//		Blog mockedBlog = mock(Blog.class);
//			
//		mockedBlog.newEntry(new BlogEntry("Tutorial 1", "bla bla bla 1"));
//		mockedBlog.newEntry(new BlogEntry("Tutorial 2", "bla bla bla 2"));
//		mockedBlog.newEntry(new BlogEntry("Tutorial 3", "bla bla bla 3"));
//		mockedBlog.newEntry(new BlogEntry("Tutorial 4", "bla bla bla 4"));
//		mockedBlog.newEntry(new BlogEntry("Tutorial 5", "bla bla bla 5"));
//		mockedBlog.newEntry(new BlogEntry("Tutorial 6", "bla bla bla 6"));
//		mockedBlog.newEntry(new BlogEntry("Tutorial 7", "bla bla bla 7"));
//		mockedBlog.newEntry(new BlogEntry("Tutorial 8", "bla bla bla 8"));
//		mockedBlog.newEntry(new BlogEntry("Tutorial 9", "bla bla bla 9"));
//		mockedBlog.newEntry(new BlogEntry("Tutorial 10", "bla bla bla 10"));
//		mockedBlog.newEntry(new BlogEntry("Tutorial 11", "bla bla bla 11"));
//		mockedBlog.showRecentEntries();
//		
//		verify(mockedBlog, times(10)).showEntry(any(BlogEntry.class));
	}

}
