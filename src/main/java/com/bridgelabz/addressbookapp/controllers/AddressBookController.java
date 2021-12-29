package com.bridgelabz.addressbookapp.controllers;

import javax.websocket.server.PathParam;

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

/**
 * @RestController
 * @RequestMapping
 */
@RestController
@RequestMapping("/AddressBook")
public class AddressBookController {

	/**
	 * @RequestMapping
	 * @return : ResponseEntity<String>
	 */
	@RequestMapping("/getAll")
	public ResponseEntity<ResponseDTO> getAllAddressBookData() {
		AddressBookData contactDetails = null;
		contactDetails = new AddressBookData(1, new AddressBookDTO("Suraj", "Khomane", "Baramati", "pune", 888888777));
		ResponseDTO respDTO = new ResponseDTO("Get call success",contactDetails);
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
		contactDetails = new AddressBookData(ContactId, new AddressBookDTO("Suraj", "Khomane", "Baramati", "pune", 888888777));
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
		contactDetails = new AddressBookData(1, addressBookDTO);
		ResponseDTO respDTO = new ResponseDTO("created address book data successfully",contactDetails);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	/**
	 * @PutMapping
	 * @param addressBookDTO
	 * @return : addressBookDTO and HttpStatus
	 */
	@PutMapping("/Update")
	public ResponseEntity<ResponseDTO> updateAddressBookData(@RequestBody AddressBookDTO addressBookDTO) {
		AddressBookData contactDetails = null;
		contactDetails = new AddressBookData(1, addressBookDTO);
		ResponseDTO respDTO = new ResponseDTO("created address book data successfully",contactDetails);
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