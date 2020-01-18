package com.sg.b2b.payments.application.contacts;

import com.sg.b2b.payments.bo.ContactCommand;
import com.sg.b2b.payments.infra.persistence.contacts.ContactDetailsRecord;
import com.sg.b2b.payments.infra.persistence.contacts.ContactRecord;
import com.sg.b2b.payments.infra.persistence.contacts.ContactsDetailsRepository;
import com.sg.b2b.payments.infra.persistence.contacts.ContactsRepository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ContactsServiceTest {
    @Mock
    private ContactsDetailsRepository contactsDetailsRepository;
    @Mock
    private ContactsRepository contactsRepository;

    @InjectMocks
    private ContactsService contactsService;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private void mockContactRepo(ContactCommand command) {
        Mockito.when(contactsDetailsRepository.save(Mockito.any(ContactDetailsRecord.class))).thenReturn(
                ContactDetailsRecord.builder()
                        .id(1L)
                        .name(command.getName())
                        .email(command.getEmail())
                        .accountNumber(command.getAccountNumber())
                        .bank(command.getBank())
                        .gstin(command.getGstin())
                        .ifsc(command.getIfsc())
                        .build());
        Mockito.when(contactsRepository.save(Mockito.any(ContactRecord.class))).thenReturn(
                ContactRecord.builder()
                        .ownerId(10L)
                        .contactId(1L)
                        .build());
    }

    @Test
    public void testContactCreate() {
        ContactCommand command =
                ContactCommand.builder()
                        .name("testName")
                        .accountNumber("123456")
                        .bank("My Bank")
                        .gstin("9876543")
                        .email("testing@gmail.com")
                        .ifsc("MBIN001234")
                        .build();

        mockContactRepo(command);

        ContactDetailsRecord newContact = contactsService.createContact(10L, command);

        assertEquals(newContact.getId().longValue(), 1L);
        assertEquals(newContact.getName(), command.getName());
    }

    @Test
    public void testInvalidEmailCreate() {
        thrown.expect(ResponseStatusException.class);
        thrown.expectMessage("Invalid email");
        thrown.expect(hasProperty("status", is(HttpStatus.BAD_REQUEST)));

        ContactCommand command =
                ContactCommand.builder()
                        .name("testName")
                        .accountNumber("123456")
                        .bank("My Bank")
                        .gstin("9876543")
                        .email("testing")
                        .ifsc("MBIN001234")
                        .build();

        mockContactRepo(command);

        contactsService.createContact(10L, command);
    }

    @Test
    public void testContactUpdate() {
        ContactCommand command =
                ContactCommand.builder()
                        .name("testName")
                        .accountNumber("123456")
                        .bank("My Bank")
                        .gstin("9876543")
                        .email("testing@gmail.com")
                        .ifsc("MBIN001234")
                        .build();

        mockContactRepo(command);

        ContactDetailsRecord newContact = contactsService.updateContact(1L, command);

        assertEquals(newContact.getId().longValue(), 1L);
        assertEquals(newContact.getName(), command.getName());
    }

    @Test
    public void testInvalidEmailUpdate() {
        thrown.expect(ResponseStatusException.class);
        thrown.expectMessage("Invalid email");
        thrown.expect(hasProperty("status", is(HttpStatus.BAD_REQUEST)));

        ContactCommand command =
                ContactCommand.builder()
                        .name("testName")
                        .accountNumber("123456")
                        .bank("My Bank")
                        .gstin("9876543")
                        .email("testing")
                        .ifsc("MBIN001234")
                        .build();

        mockContactRepo(command);

        contactsService.updateContact(1L, command);
    }
}
