package com.skilldistillery.jpavideostore.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Store {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne
	@JoinColumn(name = "address_id")
	private Address address;

	@OneToMany(mappedBy = "store")
	private List<Customer> customers;

	@OneToMany(mappedBy = "store")
	private List<Staff> staffs;
	
	@OneToOne
	@JoinColumn(name = "manager_id")
	private Staff manager;
	
	@OneToMany(mappedBy = "store")
	private List<InventoryItem> items;

	public Store() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public void addCustomer(Customer customer) {
		if (customers == null) {
			customers = new ArrayList<>();
		}
		if (!customers.contains(customer)) {
			customers.add(customer);
			customer.setStore(this);
		}
	}

	public void removeCustomer(Customer customer) {
		if (customers != null && customers.contains(customer)) {
			customers.remove(customer);
			customer.setStore(null);
		}
	}

	public List<Staff> getStaffs() {
		return staffs;
	}

	public void setStaffs(List<Staff> staffs) {
		this.staffs = staffs;
	}

	public void addStaff(Staff staff) {
		if (staffs == null) {
			staffs = new ArrayList<>();
		}
		if (!staffs.contains(staff)) {
			staffs.add(staff);
			staff.setStore(this);
		}
	}

	public void removeStaff(Staff staff) {
		if (staffs != null && staffs.contains(staff)) {
			staffs.remove(staff);
			staff.setStore(null);
		}
	}

	public Staff getManager() {
		return manager;
	}

	public void setManager(Staff manager) {
		this.manager = manager;
	}

	public List<InventoryItem> getItems() {
		return items;
	}

	public void setItems(List<InventoryItem> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Store [id=").append(id).append(", address=").append(address).append("]");
		return builder.toString();
	}

}
