/**
 * 
 */
package com.grocery.store.services.impl;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Set;

import javax.print.attribute.standard.DateTimeAtCompleted;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.grocery.store.entity.Invoice;
import com.grocery.store.entity.Item;
import com.grocery.store.entity.SiteUser;
import com.grocery.store.entity.UserType;
import com.grocery.store.enums.UserTypeEnum;
import com.grocery.store.repository.InvoiceRepository;
import com.grocery.store.repository.UserTypeDiscountRepository;
import com.grocery.store.services.InvoiceService;

/**
 * @author Mumtaz
 *
 */
@Service
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	private InvoiceRepository invoiceRepository;

	@Autowired
	private UserTypeDiscountRepository userDiscountRepository;

	@Value("${discount.every.hundred}")
	private double discontEveryHundred; 
	
	@Value("${discount.joining.years}")
	double discountYears;
	
	@Override
	public double getNetPayableAmount(String invoiceNumber) {
		
		Invoice invoice = invoiceRepository.findByInvoiceNumber(invoiceNumber);		
		return processDiscount(invoice.getUser(), invoice.getItems());
	}
	
	private double processDiscount(SiteUser user, Set<Item> items) {
		
		double totalAmount = 0 ;
		double userDiscount = getUserDiscountPercent(user);
		
		for(Item item : items) {
			if(! item.getIsGrocery()) {
				totalAmount += (item.getItemPrice() - 
									(item.getItemPrice() * userDiscount / 100));
			} else {
				totalAmount += item.getItemPrice();
			}
		}		
		
		if(totalAmount >= 100 ) {
			int numOfHundreds = (int) (totalAmount / 100);
			double discountOnHundreds = numOfHundreds * discontEveryHundred;
			return totalAmount - discountOnHundreds;
		}
		return totalAmount;
	}
	
	private double getUserDiscountPercent(SiteUser user)
	{
		String type = user.getUserType().name();
		
		if(user.getUserType() == UserTypeEnum.EXISTINGUSER)
		{
			long yearDiff = ChronoUnit.YEARS.between(user.getJoiningDate(), LocalDateTime.now());
			
			if(yearDiff >= 2) {
				return discountYears;
			}
		}
		
		UserType userType = userDiscountRepository.findByUserType(type);
		
		if(userType != null) {
			
			return userType.getDiscount();
		}
		
		return 0;
	}

	@Override
	public Invoice addInvoice(Invoice invoice) {
		return invoiceRepository.save(invoice);
		
	}
		
}
