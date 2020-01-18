package com.sg.b2b.payments.bo;

import com.sg.b2b.payments.domain.transaction.TransactionStatus;

public class TransactionCommand {

    private LoginCommand from;
    private LoginCommand to;
    private Double amount;
    private TransactionStatus transactionStatus;

}
