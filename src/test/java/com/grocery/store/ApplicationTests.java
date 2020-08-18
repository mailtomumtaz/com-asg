package com.grocery.store;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

import com.grocery.store.controllers.DiscountController;
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

	@Autowired
	DiscountController controller;

	//Test to verify staff discount
	@Test
	void testEmployeeDiscount(){
		double discount = Double.parseDouble(invoiceService.getNetPayableAmount("0001"));
		Assert.assertEquals(14, discount, 0.1);
	}

	// Test to verify affilicate discount
	@Test
	void testAffiliateDiscount(){
		double discount = Double.parseDouble(invoiceService.getNetPayableAmount("0002"));
		Assert.assertEquals(18, discount, 0.1);
	}

	// Test to verify new users have no discount
	@Test
	void testCustomerDiscount(){
		double discount = Double.parseDouble(invoiceService.getNetPayableAmount("0003"));
		Assert.assertEquals(20, discount, 0.1);
	}

	// Test to verify customer is more than 2 years old
	@Test
	void testLoyalCustomerDiscount(){
		double discount = Double.parseDouble(invoiceService.getNetPayableAmount("0004"));
		Assert.assertEquals(19, discount, 0.1);
	}

	// Test to verify no discount on grocery product
	// Test to verify discount for over bill 100
	@Test
	void testGroceryDiscount(){
		double discount = Double.parseDouble(invoiceService.getNetPayableAmount("0005"));
		Assert.assertEquals(95, discount, 0.1);
	}
}
