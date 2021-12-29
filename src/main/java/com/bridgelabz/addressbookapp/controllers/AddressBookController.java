package com.bridgelabz.addressbookapp.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.dto.ResponseDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;
import com.bridgelabz.addressbookapp.service.IAddressBookService;

/**
 * @RestController
 * @RequestMapping
 */
@RestController
@RequestMapping("/AddressBook")
public class AddressBookController {

	@Autowired
	private IAddressBookService addressBookService;
	/**
	 * @RequestMapping
	 * @return : ResponseEntity<String>
	 */
	@RequestMapping("/getAll")
	public ResponseEntity<ResponseDTO> getAllAddressBookData() {
		List<AddressBookData> addressBookList = null;
		addressBookList = addressBookService.getAddressBookData();
		ResponseDTO respDTO = new ResponseDTO("Get call success",addressBookList);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	/**
	 * @GetMapping
	 * @param id
	 * @return : ResponseEntity<String>
	 */
	@GetMapping("/get/{ContactId}")
	public ResponseEntity<ResponseDTO> getAddressBookData(@PathVariable("ContactId") int ContactId) {
		AddressBookData contactDetails = null;
		contactDetails = addressBookService.getAddressBookDataById(ContactId);
		ResponseDTO respDTO = new ResponseDTO("Get call success for id:"+ ContactId,contactDetails);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	/**
	 * @PostMapping
	 * @param addressBookDTO
	 * @return : addressBookDTO and HttpStatus
	 */
	@PostMapping("/Create")
	public ResponseEntity<ResponseDTO> createAddressBookData(@RequestBody AddressBookDTO addressBookDTO) {
		AddressBookData contactDetails = null;
		contactDetails = addressBookService.createAddressBookData(addressBookDTO);
		ResponseDTO respDTO = new ResponseDTO("created address book data successfully",contactDetails);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	/**
	 * @PutMapping
	 * @param addressBookDTO
	 * @return : addressBookDTO and HttpStatus
	 */
	@PutMapping("/Update/{ContactId}")
	public ResponseEntity<ResponseDTO> updateAddressBookData(@PathVariable("ContactId") int ContactId,@RequestBody AddressBookDTO addressBookDTO) {
		AddressBookData contactDetails = null;
		contactDetails = addressBookService.updateAddressBookDta(ContactId, addressBookDTO);
		ResponseDTO respDTO = new ResponseDTO("updated address book data successfully",contactDetails);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	/**
	 * @DeleteMapping
	 * @param id
	 * @return : ResponseEntity<String>
	 */
	@DeleteMapping("/Delete/{id}")
	public ResponseEntity<ResponseDTO> deleteAddressBookData(@PathVariable("id") int id) {
		ResponseDTO respDTO = new ResponseDTO("Deleted AddressBook data Successfully", "Deleted id : " + id);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
}