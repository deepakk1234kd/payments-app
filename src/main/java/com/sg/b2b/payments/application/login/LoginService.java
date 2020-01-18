package com.sg.b2b.payments.application.login;

import com.sg.b2b.payments.bo.LoginCommand;
import com.sg.b2b.payments.infra.auth.JwtResponse;
import com.sg.b2b.payments.infra.auth.JwtTokenUtil;
import com.sg.b2b.payments.infra.auth.JwtUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final AuthenticationManager authenticationManager;
    private final JwtUserDetailsService userDetailsService;
    private final JwtTokenUtil jwtTokenUtil;

    public ResponseEntity<?> authenticate(LoginCommand loginCommand) throws Exception {
        authenticate(loginCommand.getUsername(), loginCommand.getPassword());
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(loginCommand.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS" + e);
        }
    }

}
