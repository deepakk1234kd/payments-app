package com.sg.b2b.payments.application.login;

import com.sg.b2b.payments.bo.User;
import com.sg.b2b.payments.domain.user.UserRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRecordRepository userRecordRepository;

    public String login(User user) {
        if (userRecordRepository.existsUserRecordByUsername(user.getUsername())) {
            return Boolean.TRUE.toString();
        }
        return Boolean.FALSE.toString();
    }

}
