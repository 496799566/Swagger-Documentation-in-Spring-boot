package jack.swagger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jack.swagger.model.Contact;
import jack.swagger.resource.ContactRepository;

@RestController
@RequestMapping("contact") // localhost:8080/contact
public class AddressBookController {

	@Autowired
	private ContactRepository repo;
	
	@GetMapping("")
	public List<Contact> getContacts() {
		return repo.getContacts();
	}
	
	@GetMapping("{id}")
	public Contact getContactById(@PathVariable String id) {
		return repo.getContact(id);
	}
	
	@PostMapping("")
	public void AddContact(@RequestBody Contact contact) {
		repo.addContact(contact);
	}
}
