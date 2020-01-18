package com.sg.b2b.payments.infra.persistence.user;

import com.sg.b2b.payments.bo.LoginCommand;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name="Users")
public class UserRecord {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;

	@Column
	private String username;
	@Column
	private String passwordHash;
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

	public static UserRecord translate(LoginCommand loginCommand) {
		return UserRecord.builder().username(loginCommand.getUsername()).passwordHash(loginCommand.getPassword()).build();
	}
	
}
