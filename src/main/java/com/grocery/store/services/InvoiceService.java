/**
 * 
 */
package com.grocery.store.services;

import org.springframework.stereotype.Service;

import com.grocery.store.entity.Invoice;

/**
 * @author Mumtaz
 *
 */
public interface InvoiceService {

	public Invoice addInvoice(Invoice invoice);
	
	public String getNetPayableAmount(String invoiceNumber);
	
}
