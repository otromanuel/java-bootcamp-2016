package bootcamp.practice.two;

import static org.mockito.Mockito.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BlogTest {

	Blog blog;

	@Before
	public void setUp() {
		blog = new Blog();
	}

	// Post new entry
	@Test
	public void whenNewEntryThenBlogHasNewEntry() {
		BlogEntry mockEntry = mock(BlogEntry.class);
		when(mockEntry.getTitle()).thenReturn("TDD Best Practices");
		blog.newEntry(mockEntry);
		Assert.assertNotNull(blog.getEntryByTitle("TDD Best Practices"));
	}

	// Delete existing entry
	@Test
	public void whenDeleteEntryThenBlogDeletesEntry() {
		
		BlogEntry mockEntry = mock(BlogEntry.class);
		when(mockEntry.getTitle()).thenReturn("TDD Best Practices II");
		blog.newEntry(mockEntry);
		blog.deleteEntry(mockEntry);
		Assert.assertNull(blog.getEntryByTitle("TDD Best Practices II"));
	}

	// Show 10 most recent entries
	@Test
	public void whenShowRecentthen10MoreRecent() {

		BlogEntry mockEntry;
		for (int i = 0; i < 15; i++) {
			mockEntry = mock(BlogEntry.class);
			when(mockEntry.getTitle()).thenReturn("Title " + i);
			blog.newEntry(mockEntry);
		}

		Assert.assertEquals(Blog.NUMBER_OF_RECENT_POSTS, blog.getRecentEntries().size());
		Assert.assertEquals("Title 14", blog.getRecentEntries().get(0).getTitle());
		Assert.assertEquals("Title 13", blog.getRecentEntries().get(1).getTitle());
		Assert.assertEquals("Title 12", blog.getRecentEntries().get(2).getTitle());
		Assert.assertEquals("Title 11", blog.getRecentEntries().get(3).getTitle());
		Assert.assertEquals("Title 10", blog.getRecentEntries().get(4).getTitle());
		Assert.assertEquals("Title 9", blog.getRecentEntries().get(5).getTitle());
		Assert.assertEquals("Title 8", blog.getRecentEntries().get(6).getTitle());
		Assert.assertEquals("Title 7", blog.getRecentEntries().get(7).getTitle());
		Assert.assertEquals("Title 6", blog.getRecentEntries().get(8).getTitle());
		Assert.assertEquals("Title 5", blog.getRecentEntries().get(9).getTitle());
		
	}
	

}
