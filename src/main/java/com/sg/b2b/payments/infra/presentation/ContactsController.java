package com.sg.b2b.payments.infra.presentation;

import com.sg.b2b.payments.application.contacts.ContactsService;
import com.sg.b2b.payments.bo.ContactCommand;
import com.sg.b2b.payments.infra.persistence.contacts.ContactDetailsRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ContactsController {
    private final ContactsService contactsService;

    @PostMapping("/{userId}/contacts")
    public ContactDetailsRecord createContact(@PathVariable(name = "userId") Long userId,
                                              @RequestBody ContactCommand command) {
        return contactsService.createContact(userId, command);
    }

    @PutMapping("/{userId}/contacts/{contactId}")
    public ContactDetailsRecord updateContact(@PathVariable(name = "userId") Long userId,
                                              @PathVariable(name = "contactId") Long contactId,
                                              @RequestBody ContactCommand command) {
        return contactsService.updateContact(userId, command);
    }

    @DeleteMapping("/{userId}/contacts/{contactId}")
    public void deleteContact(@PathVariable(name = "userId") Long userId,
                                              @PathVariable(name = "contactId") Long contactId) {
        contactsService.deleteContact(userId, contactId);
    }
}
