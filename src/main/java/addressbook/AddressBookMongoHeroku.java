package addressbook;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class AddressBookMongoHeroku implements AddressBook {
	String host = "dbh56.mongolab.com";
	int port = 27567;
	String dbName = "sandy";
	String dbUser = "sandyman";
	String dbPassword = "sandyman8";

	public void addEntry(String firstName, String phoneNumber) {
		DBCollection addressCollection = getAddressCollection();
		addressCollection.insert(new BasicDBObject(firstName, phoneNumber));
	}

	private DBCollection getAddressCollection() {
		try {
			Mongo mongo = new Mongo(host, port);
			DB db = mongo.getDB(dbName);
			db.authenticate(dbUser, dbPassword.toCharArray());
			
			DBCollection addresses = db.getCollection("addresses");
			return addresses;
		} catch (UnknownHostException e) {
			throw new RuntimeException(e);
		} catch (MongoException e) {
			throw new RuntimeException(e);
		}
	}

	public int size() {
		DBCollection addressCollection = getAddressCollection();
		return (int) addressCollection.getCount();
	}

}
