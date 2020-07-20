package com.grocery.store.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.grocery.store.entity.Invoice;

@Repository
public interface InvoiceRepository  extends CrudRepository<Invoice, Long>{

	public Invoice findByInvoiceNumber(String invoiceNumber);
	
}
