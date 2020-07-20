package jack.swagger.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Description for the Contact representation model")
public class Contact {

	@ApiModelProperty(notes = "id of the person")
	private String id;
	@ApiModelProperty(notes = "name of the person")
	private String name;
	@ApiModelProperty(notes = "phone number of the person")
	private String phone;
	public Contact() {

	}
	public Contact(String id, String name, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
