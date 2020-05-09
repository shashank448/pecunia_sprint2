package com.capgemini.transactionmgt.controller;

import com.capgemini.transactionmgt.entities.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.capgemini.transactionmgt.service.ITransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
	
	
	@Autowired
	private ITransactionService service;
	
    public ResponseEntity<Transaction> creditUsingCheque(@RequestBody RequestChequeDto requestCheque) {
    	
    }

	
}
