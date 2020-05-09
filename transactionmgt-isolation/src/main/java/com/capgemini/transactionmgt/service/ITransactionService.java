
package com.capgemini.transactionmgt.service;
import com.capgemini.transactionmgt.entities.Cheque;
import com.capgemini.transactionmgt.entities.Transaction;





public interface ITransactionService {
	double getBalance(Account account);
	boolean updateBalance(Account account);
	int creditUsingSlip(Transaction transaction);
	int debitUsingSlip(Transaction transaction);
	int creditUsingCheque(Transaction trnasaction,Cheque cheque);
	int debitUsingCheque(Transaction trnasaction,Cheque cheque);
	
}
