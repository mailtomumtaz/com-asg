/**
 * 
 */
package com.grocery.store.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@RequestMapping(path="/{invoiceNumber}")
	public double getDiscount(@PathVariable("invoiceNumber") String invoiceNumber) {
		return invoiceService.getNetPayableAmount(invoiceNumber);
	}
}
