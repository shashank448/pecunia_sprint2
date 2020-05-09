package com.capgemini.transactionmgt.dao;


import com.capgemini.transactionmgt.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ITransactionDao{
	
	Account getAccountById(String id);
	double getBalance(Account account);
	boolean updateBalance(Account account);
	int generateChequeId(Cheque cheque);
	int generateTransactionId(Transaction transaction);
}
