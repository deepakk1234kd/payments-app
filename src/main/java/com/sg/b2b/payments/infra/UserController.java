package com.sg.b2b.payments.infra;

import com.sg.b2b.payments.application.login.LoginService;
import com.sg.b2b.payments.bo.LoginCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

	private final LoginService loginService;

	@PostMapping("/user/authenticate")
	public ResponseEntity<?> authenticate(@RequestBody LoginCommand loginCommand) throws Exception{
		return loginService.authenticate(loginCommand);
	}
	
}
