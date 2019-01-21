package com.bellacode.homebudget.Controller;

import com.bellacode.homebudget.ErrorResponse.NotFoundException;
import com.bellacode.homebudget.Model.Transaction;
import com.bellacode.homebudget.Repository.TransactionRepository;
import com.bellacode.homebudget.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/transactions")
public class TransactionController {

    private final TransactionRepository transactionRepository;

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionRepository transactionRepository, TransactionService transactionService) {
        this.transactionRepository = transactionRepository;
        this.transactionService = transactionService;
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions(){
        List<Transaction> transactions = transactionRepository.findAll();
        if (transactions.isEmpty()){
            throw new NotFoundException("Not found any transactions");
        } else{
            return new ResponseEntity<>(transactions, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity saveTransaction(@Valid Transaction transaction){
        if (transaction != null){
            transaction.setDataOperation(LocalDate.now());
            transactionService.saveTransaction(transaction);
        }else {
            throw new NullPointerException("Transaction is empty");
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Transaction>> getTransactionById(@PathVariable("id") long id){
        Optional<Transaction> transaction = transactionRepository.findById(id);
        if (transaction.isPresent()){
            return new ResponseEntity<>(transaction, HttpStatus.OK);
        }else {
            throw new NotFoundException("No found transaction with ID: " + id);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTransaction(@PathVariable("id") long id){
        Optional<Transaction> transactionExist = transactionRepository.findById(id);
        if (transactionExist.isPresent()){
            transactionRepository.deleteById(id);
        }else {
            throw new NotFoundException("Not found transaction with ID: " + id);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateTransaction(@PathVariable("id") long id, Transaction transaction){
        Optional<Transaction> updateTransaction = transactionRepository.findById(id);
        if (updateTransaction.isPresent()){
            transactionService.updateTransaction(id, transaction);
        }else{
            throw new NotFoundException("Not found transaction with ID: " + id);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}