package com.sg.b2b.payments.application.login;

import com.sg.b2b.payments.bo.LoginCommand;
import com.sg.b2b.payments.infra.persistence.user.UserRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRecordRepository userRecordRepository;

    public String login(LoginCommand loginCommand) {
        if (userRecordRepository.existsUserRecordByUsername(loginCommand.getUsername())) {
            return Boolean.TRUE.toString();
        }
        return Boolean.FALSE.toString();
    }

}
