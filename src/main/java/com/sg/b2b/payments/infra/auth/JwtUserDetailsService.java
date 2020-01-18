package com.sg.b2b.payments.infra.auth;

import com.sg.b2b.payments.infra.persistence.user.UserRecord;
import com.sg.b2b.payments.infra.persistence.user.UserRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {

    private final UserRecordRepository userRecordRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(userRecordRepository.existsUserRecordByUsername(username)) {
            UserRecord userRecord = userRecordRepository.findByUsername(username);
            return new User(userRecord.getUsername(), userRecord.getPasswordHash(),
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}