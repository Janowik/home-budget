package com.bellacode.homebudget.Entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "amount")
    private double amount;

    @Column(name = "data_operation")
    private LocalDate dataOperation;

    @Column(name = "comment")
    private String comment;

    @Column(name = "type_transaction")
    @Enumerated(EnumType.STRING)
    private TypeTransaction typeTransaction;

    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    private Category category;

    @ManyToOne
    private User user;

    public Transaction() {
    }

    public Transaction(double amount, LocalDate dataOperation, String comment, TypeTransaction typeTransaction, Category category, User user) {
        this.amount = amount;
        this.dataOperation = dataOperation;
        this.comment = comment;
        this.typeTransaction = typeTransaction;
        this.category = category;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDataOperation() {
        return dataOperation;
    }

    public void setDataOperation(LocalDate dataOperation) {
        this.dataOperation = dataOperation;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public TypeTransaction getTypeTransaction() {
        return typeTransaction;
    }

    public void setTypeTransaction(TypeTransaction typeTransaction) {
        this.typeTransaction = typeTransaction;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
