package com.coder.addressBook.ServiceDaoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coder.addressBook.Dao.AddressDao;
import com.coder.addressBook.Service.ServiceDao;
import com.coder.addressBook.entity.Address;

@Service
public class ServiceDaoImpl implements ServiceDao {

	@Autowired
	private AddressDao addressDao;
	
	@Override
	@Transactional
	public Address findAddressByName(String name) {
		return addressDao.findAddressByName(name);
	}

	@Override
	@Transactional
	public List<Address> findAllAddresses() {
		return addressDao.findAllAddresses();
	}

	@Override
	@Transactional
	public Address findAddressById(int id) {
		return addressDao.findAddressById(id);
	}

	@Override
	@Transactional
	public void save(Address address) {
		addressDao.save(address);
		
	}

	@Override
	@Transactional
	public void deleteAddressById(int id) {
		addressDao.delete(id);
		
	}

	@Override
	@Transactional
	public List<Address> searchAddress(String wordText) {
		return addressDao.searchAddress(wordText);
	}

}
