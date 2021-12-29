package com.bridgelabz.addressbookapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;

@Service
public class AddressBookService implements IAddressBookService {

	@Override
	public List<AddressBookData> getAddressBookData() {
		List<AddressBookData> addressBookList = new ArrayList<>();
		addressBookList
				.add(new AddressBookData(1, new AddressBookDTO("Suraj", "Khomane", "Baramati", "Pune", 98787898)));
		return addressBookList;
	}

	@Override
	public AddressBookData getAddressBookDataById(int id) {
		AddressBookData contactData = null;
		contactData = new AddressBookData(id, new AddressBookDTO("Suraj", "Khomane", "Baramati", "Pune", 98787898));
		return contactData;
	}

	@Override
	public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO) {
		AddressBookData contactData = null;
		contactData = new AddressBookData(1, addressBookDTO);
		return contactData;
	}

	@Override
	public AddressBookData updateAddressBookDta(int id, AddressBookDTO addressBookDTO) {
		AddressBookData contactData = null;
		contactData = new AddressBookData(id, addressBookDTO);
		return contactData;
	}

	@Override
	public void deleteAddressBookDataint(int id) {

	}

}
