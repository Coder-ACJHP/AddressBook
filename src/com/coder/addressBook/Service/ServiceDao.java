package com.coder.addressBook.Service;

import java.util.List;

import com.coder.addressBook.entity.Address;

public interface ServiceDao {

	public Address findAddressByName(String name);

	public List<Address> findAllAddresses();

	public Address findAddressById(int id);

	public void save(Address address);

	public void deleteAddressById(int id);

	public List<Address> findAddressByAnyText(String wordText);
}
