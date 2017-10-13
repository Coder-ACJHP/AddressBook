package com.coder.addressBook.Dao;

import java.util.List;

import com.coder.addressBook.entity.Address;

public interface AddressDao {

	public Address findAddressByName(String name);

	public List<Address> findAllAddresses();

	public Address findAddressById(int id);

	public void save(Address address);

	public void delete(int id);

	public List<Address> findAddressesByAnyText(String wordText);
}
