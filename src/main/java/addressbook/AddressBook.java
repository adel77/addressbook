package addressbook;

public interface AddressBook {

	public abstract void addEntry(String firstName, String phoneNumber);

	public abstract int size();

}