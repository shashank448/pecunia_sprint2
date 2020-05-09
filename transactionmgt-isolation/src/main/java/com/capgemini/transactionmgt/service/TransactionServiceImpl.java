package com.capgemini.transactionmgt.service;

import java.util.*;


public class TransactionServiceImpl implements ITransactionService {

	private ITransactionDao dao;

	public TransactionServiceImpl(ITransactionDao dao) {
		this.dao = dao;
	}

	@Override
	public double getBalance(Account a) {
		return dao.getBalance(a);

	}

	@Override
	public boolean updateBalance(Account a) {
		return dao.updateBalance(a);
	}

	public int generateChequeId(Cheque cheque) {
		return dao.generateChequeId(cheque);
	}

	@Override
	public int creditUsingSlip(Transaction transaction) {
		ValidateAccount.validateCreditSlip(transaction);
		String accountId = transaction.getTransAccountId();
		double amount = transaction.getTransAmount();
		Account account = UserMgtStore.accountStore.get(accountId);
		double balance = account.getAccountBalance();
		double newBalance = balance + amount;
		account.setAccountBalance(newBalance);
		dao.updateBalance(account);
		transaction.setTranstype("CR");
		TransactionMgmtStore.transactionStore.put(transaction.getTransId(), transaction);
		return 0;
	}

	@Override
	public int debitUsingSlip(Transaction transaction) {
		ValidateAccount.validateDebitSlip(transaction);
		String accountId = transaction.getTransAccountId();
		double amount = transaction.getTransAmount();
		Account account = UserMgtStore.accountStore.get(accountId);
		double balance = account.getAccountBalance();
		double newBalance = balance - amount;
		account.setAccountBalance(newBalance);
		dao.updateBalance(account);
		transaction.setTranstype("DB");
		TransactionMgmtStore.transactionStore.put(transaction.getTransId(), transaction);
		return 0;
	}

	/**
	 * Transection from AccountId1 to AccountId2
	 */
	@Override
	public int creditUsingCheque(Transaction transaction, Cheque cheque) {
		ValidateAccount.validateCheque(cheque, transaction);
		double amount = transaction.getTransAmount();
		Account beneficiaryAccount = UserMgtStore.accountStore.get(transaction.getTransTo());
		Account payeeAccount = UserMgtStore.accountStore.get(transaction.getTransFrom());
		payeeAccount.setAccountBalance(payeeAccount.getAccountBalance() - amount);
		beneficiaryAccount.setAccountBalance(beneficiaryAccount.getAccountBalance() + amount);
		dao.updateBalance(beneficiaryAccount);
		dao.updateBalance(payeeAccount);
		transaction.setTranstype("CR");
		TransactionMgmtStore.transactionStore.put(transaction.getTransId(), transaction);
		return 0;
	}

	@Override
	public int debitUsingCheque(Transaction transaction, Cheque cheque) {
		ValidateAccount.validateCheque(cheque, transaction);
		double amount = transaction.getTransAmount();
		Account beneficiaryAccount = UserMgtStore.accountStore.get(transaction.getTransTo());
		Account payeeAccount = UserMgtStore.accountStore.get(transaction.getTransFrom());
		beneficiaryAccount.setAccountBalance(beneficiaryAccount.getAccountBalance() +amount);
		payeeAccount.setAccountBalance(payeeAccount.getAccountBalance() - amount);
		dao.updateBalance(beneficiaryAccount);
		dao.updateBalance(payeeAccount);
		transaction.setTranstype("DB");
		TransactionMgmtStore.transactionStore.put(transaction.getTransId(), transaction);
		return 0;
	}
}
