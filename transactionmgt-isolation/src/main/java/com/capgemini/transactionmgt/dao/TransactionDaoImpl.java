package com.capgemini.transactionmgt.dao;

import java.util.Map;


import com.capgemini.transactionmgt.entities.Cheque;
import com.capgemini.transactionmgt.entities.Transaction;

public class TransactionDaoImpl implements ITransactionDao{
	private static int generatedChequeId;
	private static int generatedTransactionId;

	@Override
	public Account getAccountById(String id) {
		Map<String,Account> accounts = UserMgtStore.accountStore;
		return accounts.get(id);
	}

	@Override
	public double getBalance(Account account) {
		Map<String,Account> accounts = UserMgtStore.accountStore;
		return accounts.get(account.getAccountId()).getAccountBalance();
	}

	@Override
	public boolean updateBalance(Account account) {
		 UserMgtStore.accountStore.put(account.getAccountId(), account);
			return true;
	}

	@Override
	public int generateChequeId(Cheque cheque) {
		++generatedChequeId;
		String idStr=String.valueOf(generatedChequeId);
		cheque.setChequeId(idStr);
		return generatedChequeId;
	}

	@Override
	public int generateTransactionId(Transaction transaction) {
		++generatedTransactionId;
		String transId=String.valueOf(generatedTransactionId);
		transaction.setTransId(transId);
		return generatedTransactionId;
	}

}
