package com.capgemini.transactionmgt.exceptions;

public class InvalidTransactionAmountException extends RuntimeException {
	public InvalidTransactionAmountException(String msg) {
		super(msg);
	}
}
