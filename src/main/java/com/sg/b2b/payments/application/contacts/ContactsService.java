package com.sg.b2b.payments.application.contacts;

import com.sg.b2b.payments.bo.ContactCommand;
import com.sg.b2b.payments.infra.persistence.contacts.ContactDetailsRecord;
import com.sg.b2b.payments.infra.persistence.contacts.ContactRecord;
import com.sg.b2b.payments.infra.persistence.contacts.ContactsDetailsRepository;
import com.sg.b2b.payments.infra.persistence.contacts.ContactsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class ContactsService {
    private final ContactsDetailsRepository contactsDetailsRepository;
    private final ContactsRepository contactsRepository;

    public ContactDetailsRecord createContact(Long userId, ContactCommand command) {
        if (!command.getEmail().contains("@")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid email");
        }

        ContactDetailsRecord newContact = ContactDetailsRecord.translate(command).build();
        //TODO: verify duplicate records
        ContactDetailsRecord savedContact = contactsDetailsRepository.save(newContact);

        ContactRecord newContactRecord = ContactRecord.builder().ownerId(userId).contactId(savedContact.getId()).build();
        contactsRepository.save(newContactRecord);

        return savedContact;
    }

    public ContactDetailsRecord updateContact(Long id, ContactCommand command) {
        if (!command.getEmail().contains("@")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid email");
        }

        ContactDetailsRecord newContact =
                ContactDetailsRecord.translate(command)
                        .id(id)
                        .build();
        return contactsDetailsRepository.save(newContact);
    }

    public void deleteContact(Long userId, Long contactId) {

    }
}
