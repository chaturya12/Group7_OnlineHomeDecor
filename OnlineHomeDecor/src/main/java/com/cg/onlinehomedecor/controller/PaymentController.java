package com.cg.onlinehomedecor.controller;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinehomedecor.domain.Payment;
import com.cg.onlinehomedecor.exception.PaymentIdNotFoundException;
import com.cg.onlinehomedecor.service.MapValidationErrorService;
import com.cg.onlinehomedecor.service.PaymentService;



/**
 * Description: Controller for payment is provided
 * @author Chaturya
 *
 */
@RestController
@RequestMapping("/api/v2")
public class PaymentController {
	private static final Logger logger = LogManager.getLogger(PaymentController.class);
	@Autowired
	private PaymentService paymentService;
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	/**
	 * method to add payment
	 * @param payment
	 * @param result
	 * @return either errormap or payment
	 */
	@PostMapping("/Payment")
	public ResponseEntity<?> addPayment(@Valid @RequestBody Payment payment,BindingResult result){
		ResponseEntity<?> errorMap=mapValidationErrorService.mapValidationService(result);
		if(errorMap!=null) {
			return errorMap;
		}
		Payment newPayment=paymentService.addPayment(payment);
		logger.info(" Payment is added successfully...!");
		return new ResponseEntity<>(newPayment,HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/Payment/{paymentId}")
	public ResponseEntity<String> deletePayment(@PathVariable int paymentId){
		paymentService.deletePayment(paymentId);
		logger.info(" Product is deleted successfully...!");
		return new ResponseEntity<>("Payment with Id : "+paymentId+" id deleted.....", HttpStatus.OK);
		
	}
	@GetMapping("/Payment/{paymentId}")
	public ResponseEntity<Payment> viewPaymentById(@PathVariable int paymentId) throws PaymentIdNotFoundException{
		logger.info(" Retrieved payment by id successfully...!");
		return new ResponseEntity<>(paymentService.viewPaymentDetailsById(paymentId),HttpStatus.OK);
		
	}

}
