package gg.cloud.user_service;

public class Studentdto {

	public Studentdto() {

	}

	public Studentdto(Integer id, String name, String address, String contact) {

		this.id = id;
		this.name = name;
		this.address = address;
		this.contact = contact;
	}

	private Integer id;

	private String name;
	private String address;

	private String contact;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "Studentdto [id=" + id + ", name=" + name + ", address=" + address + ", contact=" + contact + "]";
	}

}
