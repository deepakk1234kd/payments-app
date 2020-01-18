package com.sg.b2b.payments.bo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ContactCommand {
    private String name;
    private String accountNumber;
    private String bank;
    private String ifsc;
    private String gstin;
    private String email;
}
