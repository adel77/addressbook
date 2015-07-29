package addressbook;

import static org.junit.Assert.*;

import org.junit.Test;

public class AddressBookTest {

	@Test
	public void test() {
		AddressBook book = new AddressBook();
		
		assertEquals(0, book.size());
		book.addEntry("Tester",  "234234234");
		assertEquals(1, book.size());
	}

}
