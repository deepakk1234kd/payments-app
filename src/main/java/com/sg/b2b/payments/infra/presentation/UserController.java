package com.sg.b2b.payments.infra.presentation;

import com.sg.b2b.payments.application.login.LoginService;
import com.sg.b2b.payments.bo.LoginCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class UserController {

	private final LoginService loginService;

	@PostMapping("/user/authenticate")
	public ResponseEntity<?> authenticate(@RequestBody LoginCommand loginCommand) throws Exception{
		return loginService.authenticate(loginCommand);
	}
	
}
