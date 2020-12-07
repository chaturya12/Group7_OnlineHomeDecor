package com.cg.onlinehomedecor.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.onlinehomedecor.domain.Payment;
import com.cg.onlinehomedecor.exception.PaymentIdNotFoundException;
import com.cg.onlinehomedecor.repository.PaymentRepository;



@RunWith(SpringRunner.class)
@SpringBootTest
class PaymentServiceTest {
	@Autowired
	private PaymentService paymentService;
	@MockBean
	private PaymentRepository paymentRepository;
	@Test
	void addPayment() {
		Payment payment=new Payment();
		payment.setId(1);
		payment.setPaymentMode("creditCard");
		payment.setCardNumber("12345678");
		payment.setCardHolderName("chatu");
		payment.setExpiryDate("12/12/2020");
		payment.setCvv(198);
		payment.setOtp(9033);
		payment.setPaymentStatus("success");
		Mockito.when(paymentRepository.save(payment)).thenReturn(payment);
		assertThat(paymentService.addPayment(payment)).isEqualTo(payment);
			
		}
	@Test
	void deletePaymentTest()  {
		Payment payment=new Payment();
		payment.setId(4);
		payment.setPaymentMode("debitCard");
		payment.setCardNumber("12346528");
		payment.setCardHolderName("kavya");
		payment.setExpiryDate("12/07/2022");
		payment.setCvv(121);
		payment.setOtp(0033);
		payment.setPaymentStatus("success");
		int paymentId=payment.getId();
		Mockito.when(paymentRepository.findByPaymentId(paymentId)).thenReturn(payment);
			assertThat(paymentService.deletePayment(paymentId)).isEqualTo(payment);    
        			 
	}	
	@Test
	void viewPaymentById() throws PaymentIdNotFoundException {
		Payment payment=new Payment();
		payment.setId(2);
		payment.setPaymentMode("giftCard");
		payment.setCardNumber("12212348");
		payment.setCardHolderName("jayasree");
		payment.setExpiryDate("09/03/2022");
		payment.setCvv(321);
		payment.setOtp(1234);
		payment.setPaymentStatus("success");
		int paymentId=payment.getId();
		Mockito.when(paymentRepository.findByPaymentId(paymentId)).thenReturn(payment);
		assertThat(paymentService.viewPaymentDetailsById(paymentId)).isEqualTo(payment);
		
	}

}

