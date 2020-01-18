package com.sg.b2b.payments.infra.persistence.contacts;

import com.sg.b2b.payments.bo.ContactCommand;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name="Contacts")
public class ContactDetailsRecord {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column
    private String name;
    @Column
    private String accountNumber;
    @Column
    private String bank;
    @Column
    private String ifsc;
    @Column
    private String gstin;
    @Column
    private String email;

    public static ContactDetailsRecord.ContactDetailsRecordBuilder translate(ContactCommand command) {
        return ContactDetailsRecord.builder()
                .name(command.getName())
                .email(command.getEmail())
                .accountNumber(command.getAccountNumber())
                .bank(command.getBank())
                .gstin(command.getGstin())
                .ifsc(command.getIfsc());
    }
}
