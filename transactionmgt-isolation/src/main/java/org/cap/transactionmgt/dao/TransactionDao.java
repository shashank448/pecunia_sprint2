package org.cap.transactionmgt.dao;


import org.cap.transactionmgt.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionDao extends JpaRepository<Transaction,Integer>{
	

}
