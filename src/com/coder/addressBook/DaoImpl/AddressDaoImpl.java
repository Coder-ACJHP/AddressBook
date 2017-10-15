package com.coder.addressBook.DaoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coder.addressBook.Dao.AddressDao;
import com.coder.addressBook.entity.Address;

@Repository
public class AddressDaoImpl implements AddressDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Address findAddressByName(String name) {
		final Session session = sessionFactory.getCurrentSession();
		Query<Address> query = session.createQuery("from Address where firstName=:theName order by firstName", Address.class);
		query.setParameter("theName", name);
		Address resultAddress = query.getSingleResult();
		return resultAddress;
	}

	@Override
	public List<Address> findAllAddresses() {
		final Session session = sessionFactory.getCurrentSession();
		Query<Address> query = session.createQuery("from Address", Address.class);
		List<Address> addressList = query.getResultList();
		return addressList;
	}

	@Override
	public Address findAddressById(int id) {
		final Session session = sessionFactory.getCurrentSession();
		return session.find(Address.class, id);
	}

	@Override
	public void save(Address address) {
		final Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(address);
		
	}

	@Override
	public void delete(int id) {
		final Session session = sessionFactory.getCurrentSession();
		Address theAddress = session.load(Address.class, id);
		session.delete(theAddress);
		
	}

	@Override
	public List<Address> searchAddress(String wordText) {
		
		final Session session = sessionFactory.getCurrentSession();
		Query<Address> query  = null;
		
		if(wordText != null && wordText.trim().length() > 0) {
			query = session.createQuery("from Address where lower(firstName) like:theWord or lower(lastName) like:theWord", Address.class);
			query.setParameter("theWord", "%" +wordText.toLowerCase()+ "%");
		}
		
		else {
			query = session.createQuery("from Address", Address.class);
		}
		return query.getResultList();
	}

}
