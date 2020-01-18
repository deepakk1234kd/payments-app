package com.sg.b2b.payments.infra.persistence.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRecordRepository extends CrudRepository<UserRecord, Long> {
	
	public boolean existsUserRecordByUsername(String username);
	
}
