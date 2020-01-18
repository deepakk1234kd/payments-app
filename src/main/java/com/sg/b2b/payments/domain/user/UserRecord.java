package com.sg.b2b.payments.domain.user;

import com.sg.b2b.payments.bo.User;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
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

	public static UserRecord translate(User user) {
		return UserRecord.builder().username(user.getUsername()).password(user.getPassword()).build();
	}
	
}
