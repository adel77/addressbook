package addressbook;

import java.util.HashMap;
import java.util.Map;

public class AddressBookInMemory implements AddressBook {

	private Map<String, String> addressMap = new HashMap<String, String>();	

	public void addEntry(String firstName, String phoneNumber) {
		addressMap.put(firstName,  phoneNumber);
	}

	public int size() {
		return addressMap.size();
	}

}
