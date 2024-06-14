package com.ekotomitl.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ekotomitl.models.SellerPayment;
import com.ekotomitl.repositories.SellerPaymentRepository;

@Service
public class SellerPaymentService {
	@Autowired
	private SellerPaymentRepository sellerpaymentRepository;
	
	//GET ALL
			public List<SellerPayment>findAllSellerPayment(){
				return sellerpaymentRepository.findAll();
			}
			
	//GET one 
	public Optional<SellerPayment>findSellerPaymentById(Long id){
		return sellerpaymentRepository.findById(id);
	}
		
	//POST
	public SellerPayment saveSellerPayment(SellerPayment sellerpayment) {
		return sellerpaymentRepository.save(sellerpayment);
	}
		
	//PUT
	public SellerPayment replaceSellerPayment(SellerPayment newSellerPayment, Long id) {
		return sellerpaymentRepository.findById(id)
				.map(sellerpayment ->{
					sellerpayment.setPaymentDate(newSellerPayment.getPaymentDate());
					sellerpayment.setAmount(newSellerPayment.getAmount());
					sellerpayment.setStatus(newSellerPayment.getStatus());
					return sellerpaymentRepository.save(sellerpayment);
				})
				.orElseGet(()->{
					return sellerpaymentRepository.save(newSellerPayment);
				});
	}
		
	//DELETE
	public void deleteSellerPaymentById(Long id) {
		sellerpaymentRepository.deleteById(id);
	}


}
