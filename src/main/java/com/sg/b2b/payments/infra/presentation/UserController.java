package com.sg.b2b.payments.infra.presentation;

import com.sg.b2b.payments.application.login.LoginService;
import com.sg.b2b.payments.bo.LoginCommand;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user")
@CrossOrigin
public class UserController {
	
	private final LoginService loginService;

	public UserController(LoginService loginService) {
		this.loginService = loginService;
	}

	@RequestMapping("/authenticate")
	public String login(@RequestBody LoginCommand loginCommand) {
		return loginService.login(loginCommand);
	}
	
}
