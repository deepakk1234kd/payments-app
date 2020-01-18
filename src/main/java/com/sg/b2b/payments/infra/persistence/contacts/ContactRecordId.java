package com.sg.b2b.payments.infra.persistence.contacts;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Builder
public class ContactRecordId implements Serializable {
    private Long ownerId;
    private Long contactId;
}
