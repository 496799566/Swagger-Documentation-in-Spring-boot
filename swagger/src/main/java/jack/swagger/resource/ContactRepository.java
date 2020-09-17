package jack.swagger.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.stereotype.Repository;

import jack.swagger.model.Contact;

@Repository
public class ContactRepository {

	private ConcurrentMap<String, Contact> contacts = new ConcurrentHashMap<String, Contact>();
	
	// add a contact
	public void addContact(Contact contact) {
		contacts.put( contact.getId() , contact);
	}
	
	// get a contact by id
	public Contact getContact(String id) {
		return contacts.get(id);
	}
	
	// get all the contacts
	public List<Contact> getContacts() {// <- good naming convention plural for list of object
		return new ArrayList<Contact>(contacts.values());
		
		// Java 8 stream 
		// contacts.values().stream().collect(Collectors.toList());
	}
	
	// concurrentMap can only be accessed by one thread -> thread safe
	
	// map can be access by multiple threads at the same time
	
}
