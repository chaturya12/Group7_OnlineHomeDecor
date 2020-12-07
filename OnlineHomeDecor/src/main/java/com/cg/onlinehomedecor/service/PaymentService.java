package com.cg.onlinehomedecor.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.cg.onlinehomedecor.domain.Payment;
import com.cg.onlinehomedecor.exception.PaymentIdNotFoundException;
import com.cg.onlinehomedecor.repository.PaymentRepository;


/**
 * 
 * @author Chaturya
 *Description: Payment service is implemented
 */
@Service
public class PaymentService implements IPaymentService{
	/**
	 * autowired the payment repository instead of using new keyword 
	 */
	@Autowired
	private PaymentRepository paymentRepository;

	/**
	 * overriden the add payment method
	 * 
	 */
	@Override
	public Payment addPayment(Payment payment) {
		
		return paymentRepository.save(payment);
	}

	/**
	 * overriden the delete payment method
	 */

	@Override
	public Payment deletePayment(int paymentId) {
		Payment payment=paymentRepository.findByPaymentId(paymentId);
		paymentRepository.deleteById(paymentId);
		return payment;
			}

	/**
	 * overriden the view payment details by id
	 */
	@Override
	public Payment viewPaymentDetailsById(int paymentId)throws PaymentIdNotFoundException {
		return paymentRepository.findByPaymentId(paymentId);
		
	}

}

