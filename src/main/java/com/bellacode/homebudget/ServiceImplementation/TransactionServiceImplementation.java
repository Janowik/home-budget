package com.bellacode.homebudget.ServiceImplementation;

import com.bellacode.homebudget.Model.Transaction;
import com.bellacode.homebudget.Repository.TransactionRepository;
import com.bellacode.homebudget.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service("transactionService")
public class TransactionServiceImplementation implements TransactionService {

    final
    TransactionRepository transactionRepository;

    @Autowired
    public TransactionServiceImplementation(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void saveTransaction(Transaction transaction) {
        transaction.setDataOperation(LocalDate.now());
        transactionRepository.save(transaction);
    }

    @Override
    public void deleteTransaction(long id) {
        transactionRepository.deleteById(id);
    }

    @Override
    public void updateTransaction(long id, Transaction transaction) {
        Transaction updateTransaction = Transaction.builder()
                .id(id)
                .amount(transaction.getAmount())
                .category(transaction.getCategory())
                .comment(transaction.getComment())
                .dataOperation(LocalDate.now())
                .typeTransaction(transaction.getTypeTransaction())
                .user(transaction.getUser())
                .build();
        transactionRepository.save(updateTransaction);
    }
}
