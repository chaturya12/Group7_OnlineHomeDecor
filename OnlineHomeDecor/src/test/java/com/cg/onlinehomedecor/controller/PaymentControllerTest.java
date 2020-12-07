package com.cg.onlinehomedecor.controller;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cg.onlinehomedecor.domain.Payment;
import com.cg.onlinehomedecor.service.PaymentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class PaymentControllerTest {
	@Autowired
    private MockMvc mockMvc;
	
	  @MockBean
	  private PaymentService paymentService;
	  
	  @Test
	  void testAddPayment() throws Exception{
		  String uri="/api/v2/Payment";
		  Payment payment=new Payment();
		 
			payment.setId(1);
			payment.setPaymentMode("creditCard");
			payment.setCardNumber("12345678");
			payment.setCardHolderName("chatu");
			payment.setExpiryDate("12/12/2020");
			payment.setCvv(198);
			payment.setOtp(9033);
			payment.setPaymentStatus("success");
			String jsonInput=this.converttoJson(payment);
			MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(uri)
	                  .accept(MediaType.APPLICATION_JSON)
	                  .content(jsonInput)
	                  .contentType(MediaType.APPLICATION_JSON))
	                  .andReturn();
			Assert.assertEquals(HttpStatus.CREATED.value(),mvcResult.getResponse().getStatus());
		     
		 
	  }
	  @Test
	  void testDeletePayment() throws Exception {
		  String uri="/api/v2/Payment/{paymentId}";
		  Payment payment=new Payment();
		  payment.setId(10);
			payment.setPaymentMode("DebitCard");
			payment.setCardNumber("120000678");
			payment.setCardHolderName("kaavi");
			payment.setExpiryDate("12/12/2023");
			payment.setCvv(198);
			payment.setOtp(9033);
			payment.setPaymentStatus("failed");
			int paymentId=payment.getId();
			String jsonInput=this.converttoJson(payment);
		Mockito.when(paymentService.viewPaymentDetailsById(paymentId)).thenReturn( payment);
			  Mockito.when(paymentService.deletePayment(paymentId)).thenReturn(payment);
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.delete(uri,10)
	                  .accept(MediaType.APPLICATION_JSON)
	                  .content(jsonInput)
	                  .contentType(MediaType.APPLICATION_JSON))
	                  .andReturn();
			Assert.assertEquals(HttpStatus.OK.value(),mvcResult.getResponse().getStatus());
		     
	  }
	  @Test
	  void testViewPayment() throws Exception {
		  String uri="/api/v2/Payment/{paymentId}";
		  Payment payment=new Payment();
		  payment.setId(10);
			payment.setPaymentMode("giftCard");
			payment.setCardNumber("10000342");
			payment.setCardHolderName("poori");
			payment.setExpiryDate("12/01/2021");
			payment.setCvv(033);
			payment.setOtp(8921);
			payment.setPaymentStatus("success");
			String jsonInput=this.converttoJson(payment);
			MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(uri,10)
	                  .accept(MediaType.APPLICATION_JSON)
	                  .content(jsonInput)
	                  .contentType(MediaType.APPLICATION_JSON))
	                  .andReturn();
			Assert.assertEquals(HttpStatus.OK.value(),mvcResult.getResponse().getStatus());
		  
	  }

	private String converttoJson(Payment payment) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(payment);
		
	}

}

