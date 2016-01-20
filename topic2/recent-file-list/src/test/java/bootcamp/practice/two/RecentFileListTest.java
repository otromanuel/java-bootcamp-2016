package bootcamp.practice.two;

import org.junit.Assert;
import org.junit.Test;

public class RecentFileListTest {

	RecentFileList rflist = new RecentFileList();

	@Test
	public void whenFirstRunThenListIsEmpty() {

		Assert.assertEquals(0, rflist.size());
	}

	@Test
	public void whenFileFirstTimeOpenedThenAddToList() {
		String file = "Document.pdf";
		rflist.addFile(file);
		Assert.assertTrue(rflist.contains(file));
	}

	@Test
	public void whenExistingFileOpenedThenBumpToTopOfList() {
		String file = "Tutorial.pdf";
		rflist.addFile(file);
		Assert.assertEquals(file, rflist.getFirst());
	}

	@Test
	public void whenExistingFileOpenedThenNotDuplicateInList() {
		String file = "Tutorial.pdf";
		rflist.addFile(file);
		rflist.addFile(file);
		rflist.removeFile(file);
		Assert.assertFalse(rflist.contains(file));
	}
	
	/*
	 * Max number of items is 15
	 */
	@Test
	public void whenAddFileToFullListThenOldestItemIsRemoved() {
		rflist.removeAllFiles();
		rflist.addFile("1");
		rflist.addFile("2");
		rflist.addFile("3");
		rflist.addFile("4");
		rflist.addFile("5");
		rflist.addFile("6");
		rflist.addFile("7");
		rflist.addFile("8");
		rflist.addFile("9");
		rflist.addFile("10");
		rflist.addFile("11");
		rflist.addFile("12");
		rflist.addFile("13");
		rflist.addFile("14");
		rflist.addFile("15");
		rflist.addFile("16");
		Assert.assertEquals(15,rflist.size());
		Assert.assertEquals("2", rflist.getLast());
	}

}
