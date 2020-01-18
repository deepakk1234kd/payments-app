package com.sg.b2b.payments.infra.persistence.contacts;

import org.springframework.data.repository.CrudRepository;

public interface ContactsRepository extends CrudRepository<ContactRecord, Long> {}
