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

import com.ekotomitl.models.SellerPayment;
import com.ekotomitl.services.SellerPaymentService;


@RestController
@RequestMapping("/api/sellerpayment/")
public class SellerPaymentController {
	@Autowired
	private SellerPaymentService sellerpaymentService;
	
	//GET ALL
		@GetMapping
		public List<SellerPayment>getAllSellerPayment(){
			return sellerpaymentService.findAllSellerPayment();
		}
		
	//GET 
	@GetMapping("{id}")
	public ResponseEntity<SellerPayment>getSellerPaymentById(@PathVariable Long id){
		return sellerpaymentService.findSellerPaymentById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	//POST 
	@PostMapping
	public SellerPayment createSellerPayment(@RequestBody SellerPayment sellerpayment) {
		return sellerpaymentService.saveSellerPayment(sellerpayment);
	}
	
	//PUT
	@PutMapping("{id}")
	public SellerPayment updateSellerPayment(@RequestBody SellerPayment newSellerPayment, @PathVariable Long id) {
		return sellerpaymentService.replaceSellerPayment(newSellerPayment, id);
	}
	
	//DELETE
	@DeleteMapping("{id}")
	public ResponseEntity<Void>deleteSellerPayment(@PathVariable Long id){
		return sellerpaymentService.findSellerPaymentById(id)
				.map(sellerpayment->{
					sellerpaymentService.deleteSellerPaymentById(id);
					return ResponseEntity.ok().<Void>build();
				})
				.orElse(ResponseEntity.notFound().build());
	}
	

}

