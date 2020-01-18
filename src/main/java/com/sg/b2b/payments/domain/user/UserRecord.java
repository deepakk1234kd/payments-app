package com.sg.b2b.payments.domain.user;

import com.sg.b2b.payments.bo.LoginCommand;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="User")
public class UserRecord {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;

	@Column(name="username")
	private String username;

	@Column(name="password")
	private String password;

	public static UserRecord translate(LoginCommand loginCommand) {
		return UserRecord.builder().username(loginCommand.getUsername()).password(loginCommand.getPassword()).build();
	}
	
}
