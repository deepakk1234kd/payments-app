package com.sg.b2b.payments.infra.persistence.contacts;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactsDetailsRepository extends CrudRepository<ContactDetailsRecord, Long> {}
