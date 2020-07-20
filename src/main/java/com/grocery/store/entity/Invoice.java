/**
 * 
 */
package com.grocery.store.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

/**
 * @author Mumtaz
 *
 */
@Entity
public class Invoice {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "invoice_no")
	private String invoiceNumber;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@Column(name= "items")
	private List<Item> items;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName="id")
	private SiteUser user;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public SiteUser getUser() {
		return user;
	}

	public void setUser(SiteUser user) {
		this.user = user;
	}
	
	
	
}
