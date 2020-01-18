package com.sg.b2b.payments.bo;

import com.sg.b2b.payments.bo.User;
import com.sg.b2b.payments.domain.transaction.TransactionType;

public class TransactionCommand {

    private User from;
    private User to;
    private Double amount;
    private TransactionType transactionType;

}
