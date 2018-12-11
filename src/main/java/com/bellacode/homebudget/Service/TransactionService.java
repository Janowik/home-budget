package com.bellacode.homebudget.Service;

import com.bellacode.homebudget.Model.Transaction;

public interface TransactionService{

    void saveTransaction(Transaction transaction);
    void deleteTransaction(long id);
    void updateTransaction(long id, Transaction transaction);

}
