package dz.selma.springdemo.service;

import java.util.List;

import dz.selma.springdemo.entities.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int id);

	public void deleteCustomer(int id);
}
