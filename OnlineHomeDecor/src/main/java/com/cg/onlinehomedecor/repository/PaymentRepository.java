package com.cg.onlinehomedecor.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlinehomedecor.domain.Payment;


/**
 * The payment repository is created which extends the CrudRepository 
 * @author Chaturya
 *
 */
@Repository
public interface PaymentRepository extends CrudRepository<Payment,Integer> {

	Payment findByPaymentId(int paymentId);

	
}

