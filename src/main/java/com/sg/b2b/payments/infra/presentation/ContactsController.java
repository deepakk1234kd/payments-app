package com.sg.b2b.payments.infra.presentation;

import com.sg.b2b.payments.application.contacts.ContactsService;
import com.sg.b2b.payments.bo.ContactCommand;
import com.sg.b2b.payments.infra.persistence.contacts.ContactDetailsRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ContactsController {
    private final ContactsService contactsService;

    @RequestMapping("/{userId}/contacts")
    public ContactDetailsRecord createContact(@PathVariable(name = "userId") Long userId,
                                              @RequestBody ContactCommand command) {
        return contactsService.createContact(userId, command);
    }

    @RequestMapping("/{userId}/contacts/{contactId}")
    public ContactDetailsRecord updateContact(@PathVariable(name = "userId") Long userId,
                                              @PathVariable(name = "contactId") Long contactId,
                                              @RequestBody ContactCommand command) {
        return contactsService.updateContact(userId, command);
    }

    @RequestMapping("/{userId}/contacts/{contactId}")
    public void deleteContact(@PathVariable(name = "userId") Long userId,
                                              @PathVariable(name = "contactId") Long contactId) {
        contactsService.deleteContact(userId, contactId);
    }
}
