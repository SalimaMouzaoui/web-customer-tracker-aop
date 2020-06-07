package dz.selma.springdemo.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dz.selma.springdemo.dao.CustomerDAO;
import dz.selma.springdemo.entities.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub

		// get the current session of hibernate
		Session currentSession = sessionFactory.getCurrentSession();

		// create query --- sort by last name
		Query<Customer> query = currentSession.createQuery("from Customer order by lastName", Customer.class);

		// execute query and get list of results
		List<Customer> listCustomers = query.getResultList();

		// return the result

		return listCustomers;
	}

	@Override
	
	public void saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		// get the current session of hibernate
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save the customer
		currentSession.saveOrUpdate(customer);
		
	}

	@Override
	public Customer getCustomer(int id) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.getCurrentSession();
		
		Customer customer = session.get(Customer.class, id);
		
		return customer;
	}

	@Override
	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.getCurrentSession();
		
		// Method 1
		
		Query query = session.createQuery("delete from Customer where id:=customerId");
		
		query.setParameter("customerId", id);
		
		query.executeUpdate();
		
		// Method 2
		
		// Customer customer = session.get(Customer.class, id);
		
	    // session.delete(customer);
		
	}
}
