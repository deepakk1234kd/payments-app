//package com.sg.b2b.payments.infra;
//
//import static org.junit.Assert.assertEquals;
//
//import com.sg.b2b.payments.application.login.LoginService;
//import com.sg.b2b.payments.bo.User;
//import com.sg.b2b.payments.infra.persistence.user.User;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.MockitoJUnitRunner;
//
//@RunWith(MockitoJUnitRunner.class)
//public class UserControllerTest{
//
//	@Mock
//	private LoginService loginService;
//
//	@InjectMocks
//	private UserController userController;
//
//	@Test
//	public void testLoginSuccess() {
//		User user = User.builder().username("user1").password("pass1").build();
//
//		Mockito.when(loginService.login(Mockito.any(User.class))).thenReturn(Boolean.TRUE);
//		Boolean isLogin = userController.login(user);
//
//		assertEquals(Boolean.TRUE, isLogin);
//	}
//
//	@Test
//	public void testLoginFail() {
//		User user = User.builder().username("user1").password("pass2").build();
//
//		Mockito.when(loginService.login(Mockito.any(User.class))).thenReturn(Boolean.TRUE);
//		Boolean isLogin = userController.login(user);
//
//		assertEquals(Boolean.TRUE, isLogin);
//	}
//
//}
