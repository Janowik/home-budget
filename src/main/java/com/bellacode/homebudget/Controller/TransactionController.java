package com.bellacode.homebudget.Controller;

import com.bellacode.homebudget.Model.Transaction;
import com.bellacode.homebudget.Repository.TransactionRepository;
import com.bellacode.homebudget.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("transactions")
public class TransactionController {

    final
    TransactionRepository transactionRepository;

    final
    TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionRepository transactionRepository, TransactionService transactionService) {
        this.transactionRepository = transactionRepository;
        this.transactionService = transactionService;
    }

    @GetMapping
    public List<Transaction> getAllTransactions(){
        return transactionRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Transaction> getUserById(@PathVariable("id") long id){
        return transactionRepository.findById(id);
    }

    @PostMapping
    public void saveTransaction(Transaction transaction){
        transactionService.saveTransaction(transaction);
    }

    @DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable("id") long id){
        transactionService.deleteTransaction(id);
    }

    @PutMapping("/{id}")
    public void updateTransaction(@PathVariable("id") long id, Transaction transaction){
        transactionService.updateTransaction(id, transaction);
    }
}
