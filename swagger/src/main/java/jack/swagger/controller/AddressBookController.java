package jack.swagger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import jack.swagger.model.Contact;
import jack.swagger.resource.ContactRepository;

@RestController
@RequestMapping("/contact") // localhost:8080/contact
public class AddressBookController {

	@Autowired
	private ContactRepository repo;
	
	@GetMapping("/")
	@ApiOperation(	value = "retrieve all contact objects",
					notes = " no note available")
	public List<Contact> getContacts() {
		return repo.getContacts();
	}
	
	@GetMapping("/{id}")
	@ApiOperation(	value = "retrieve a single contact object",
					notes = " Provide the id in the uri to look up a specific contact from the address book",
					response = Contact.class)
	public Contact getContactById(
			
			@ApiParam(value = "Id value for the contact you need to retrieve")
			@PathVariable String id) {
		return repo.getContact(id);
	}
	
	@PostMapping("/")
	@ApiOperation(	value = "add a new contact object",
					notes = " no note available")
	public void AddContact(
			
			@RequestBody Contact contact) {
		repo.addContact(contact);
	}
}
