package com.sg.b2b.payments.infra.persistence.contacts;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name="AddressBook")
@IdClass(ContactRecordId.class)
public class ContactRecord {
    @Id
    private Long ownerId;
    @Id
    private Long contactId;
}
