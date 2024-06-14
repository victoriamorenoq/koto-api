package com.ekotomitl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ekotomitl.models.Payment;
import com.ekotomitl.services.PaymentService;

@RestController
@RequestMapping("/api/payment/")
public class PaymentController {
	@Autowired
	private PaymentService paymentService;
	
	//GET
		@GetMapping
		public List<Payment>getAllPayment(){
			return paymentService.findAllPayment();
		}
		
	//GET payment
	@GetMapping("{id}")
	public ResponseEntity<Payment>getPaymentById(@PathVariable Long id){
		return paymentService.findPaymentById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	//POST 
	@PostMapping
	public Payment createPayment(@RequestBody Payment payment) {
		return paymentService.savePayment(payment);
	}
	
	//PUT
	@PutMapping("{id}")
	public Payment updatePayment(@RequestBody Payment newPayment, @PathVariable Long id) {
		return paymentService.replacePayment(newPayment, id);
	}
	
	//DELETE
	@DeleteMapping("{id}")
	public ResponseEntity<Void>deletePayment(@PathVariable Long id){
		return paymentService.findPaymentById(id)
				.map(payment->{
					paymentService.deletePaymentById(id);
					return ResponseEntity.ok().<Void>build();
				})
				.orElse(ResponseEntity.notFound().build());
	}
	

}

