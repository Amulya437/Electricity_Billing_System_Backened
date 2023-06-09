package com.electricity.api.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.electricity.api.data.BillRepository;

import com.electricity.api.data.PaymentRepository;
import com.electricity.api.exception.PaymentNotFoundException;
import com.electricity.api.model.Bill;
import com.electricity.api.model.Customer;
import com.electricity.api.model.Payment;


import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class PaymentService extends Exception{

	@Autowired

	private PaymentRepository paymentRepository;

	@Autowired

	private BillRepository billRepository;

	public double latePaidAmount(Payment payment) {

		double finePerDay = 13;

		long days = ChronoUnit.DAYS.between(payment.getPaymentDate(), payment.getBill().getDueDate());

		double fineAmount = Math.abs(days * finePerDay);

		return fineAmount;

	}

	public void assign(Payment payment) {

		// TODO Auto-generated method stub

		payment.setTotalAmount(payment.getBill().getAmount() + latePaidAmount(payment));

		paymentRepository.save(payment);

	}

	public void deletePaymentById(int id) throws PaymentNotFoundException{
		Optional<Payment> payment = paymentRepository.findById(id);
		if (!payment.isPresent()) {
			throw new PaymentNotFoundException("Payment not found with ID: " + id);
		}
		

		paymentRepository.deleteById(id);

	}

	public List<Payment> getAllPaymentRecords() {
		// TODO Auto-generated method stub
		return paymentRepository.findAll();
	}

	public Optional<Payment> getPaymentById(int id) throws PaymentNotFoundException{
		// TODO Auto-generated method stub
		Optional<Payment> payment = paymentRepository.findById(id);
		if (!payment.isPresent()) {
			throw new PaymentNotFoundException("Payment not found with ID: " + id);
		}
		return payment;
	}

	// Get payment by customer ID
	public List<Payment> getPaymentByCustomerId(int cid) throws PaymentNotFoundException{
		// Fetch all payments from the DB
		List<Payment> list = paymentRepository.findAll();

		List<Payment> filteredList = list.stream().filter(e -> e.getCustomer().getId() == cid)
				.collect(Collectors.toList());
		
		return filteredList;
	}

}
