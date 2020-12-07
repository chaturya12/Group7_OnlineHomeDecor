package com.cg.onlinehomedecor.service;

import com.cg.onlinehomedecor.domain.Payment;
import com.cg.onlinehomedecor.exception.PaymentIdNotFoundException;

/**
 * 
 * @author Chaturya
 * Description : interface of payment service is provided
 * to perform the crud operations on the payment
 */
public interface IPaymentService {
	/**
	 * This method will add the payment
	 * @param payment
	 * @return payment
	 */
	public Payment addPayment(Payment payment);
	/**
	 * this method will delete the payment
	 * @param paymentId
	 */
	public Payment deletePayment(int paymentId);
	/**
	 * this method will provide payment details
	 * @param paymentId
	 * @return
	 * @throws PaymentIdNotFoundException
	 */
	
	public Payment viewPaymentDetailsById(int paymentId) throws PaymentIdNotFoundException;
	

}
