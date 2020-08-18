/**
 * 
 */
package com.grocery.store.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grocery.store.services.InvoiceService;

/**
 * @author Mumtaz
 *
 */
@RestController
@RequestMapping("/discount")
public class DiscountController {

	@Autowired
	private InvoiceService invoiceService;
	
	@RequestMapping(value= {"/{invoiceNumber}"}, produces = "application/json")
	public ResponseEntity<?> getDiscount(@PathVariable(name="invoiceNumber") String invoiceNumber) {

		if(invoiceService != null) {
			return ResponseEntity.ok("" + invoiceService.getNetPayableAmount(invoiceNumber));
		}else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
