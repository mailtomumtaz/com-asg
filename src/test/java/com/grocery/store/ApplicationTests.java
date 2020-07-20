package com.grocery.store;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.boot.test.context.SpringBootTest;

import com.grocery.store.entity.Invoice;
import com.grocery.store.entity.Item;
import com.grocery.store.entity.SiteUser;
import com.grocery.store.enums.UserTypeEnum;
import com.grocery.store.services.InvoiceService;


@SpringBootTest(properties="spring.main.lazy-initialization=true")
class ApplicationTests {

	@Autowired
	InvoiceService invoiceService;

	void testGetDiscount() {
		
		SiteUser usr = new SiteUser();
		usr.setUserName("Staff");		
		usr.setUserType(UserTypeEnum.STAFF);
		usr.setJoiningDate(LocalDate.of(2019, Month.JANUARY, 1));
		Invoice invoice = new Invoice();
		invoice.setInvoiceNumber("0002");
		invoice.setUser(usr);
		invoice.getItems().add(new Item("P1", false, 10));
		invoice.getItems().add(new Item("P2", false, 50));
		invoice.getItems().add(new Item("P3", true, 2000));
		invoice.getItems().add(new Item("P4", false, 20));
		
		Invoice inv = invoiceService.addInvoice(invoice);
		//Assert.notNull(inv);
	}

	@Test
	void testEmployeeDiscount(){
		double discount = invoiceService.getNetPayableAmount("0001");
		Assert.assertEquals(14, discount, 0.1);
	}

	@Test
	void testAffiliateDiscount(){
		double discount = invoiceService.getNetPayableAmount("0002");
		Assert.assertEquals(18, discount, 0.1);
	}

	@Test
	void testCustomerDiscount(){
		double discount = invoiceService.getNetPayableAmount("0003");
		Assert.assertEquals(20, discount, 0.1);
	}

	@Test
	void testLoyalCustomerDiscount(){
		double discount = invoiceService.getNetPayableAmount("0004");
		Assert.assertEquals(19, discount, 0.1);
	}

	@Test
	void testGroceryDiscount(){
		double discount = invoiceService.getNetPayableAmount("0005");
		Assert.assertEquals(100, discount, 0.1);
	}
}
