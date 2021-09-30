package com.apress.prospringmvc.bookstore.validation;

import com.apress.prospringmvc.bookstore.domain.Address;
import com.apress.prospringmvc.bookstore.domain.Orders;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class OrderValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return (Orders.class).isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		var order = (Orders) target;
		validateAddress(order.getShippingAddress(), errors, "shippingAddress");
		if (!order.isBillingSameAsShipping()) {
			validateAddress(order.getShippingAddress(), errors, "billingAddress");
		}

	}

	private void validateAddress(Address address, Errors errors, String type) {
		ValidationUtils.rejectIfEmpty(errors, type + ".street", "required", new Object[] { "Street" });
		ValidationUtils.rejectIfEmpty(errors, type + ".city", "required", new Object[] { "City" });
		ValidationUtils.rejectIfEmpty(errors, type + ".country", "required", new Object[] { "Country" });

	}

}
