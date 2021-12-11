package com.revature.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.exception.UnauthorizedException;
import com.revature.model.User;

public class AuthorizationServiceTest {

	private AuthorizationService authService;
	
	@BeforeEach
	public void setup() {
		this.authService = new AuthorizationService();
	}
	
	/****************
	 * AuthorizeTester
	 */
	@Test
	public void authorizeManager_negativeTest_userAssociateButRequireManagerPermission() throws UnauthorizedException {
		User user = new User(1,"Bema","sd34","Smith","Sam","bema@gmail.com","employee");
		
		Assertions.assertThrows(UnauthorizedException.class, () -> {
			this.authService.authorizeManager(user);
		});
	}
	
	@Test
	public void authorizedManager_negativeTest_userIsNull() {
		Assertions.assertThrows(UnauthorizedException.class, () -> {
			this.authService.authorizeManager(null);
		});
	}
	
	@Test
	public void authorizedManager_positiveTest_userIsManager() throws UnauthorizedException {
		User user = new User(1, "rjm","sdf234#", "Maurice","Rakotoarimanana","rjm@gmail.com","manager");
		
		this.authService.authorizeManager(user);
	}
	
	/*************
	 * AuthorizeAssociate
	 */
	@Test
	public void authorizeAssociate_negativeTest_userIsManagerButRequiresAssociateRole() throws UnauthorizedException {
		User user = new User(1, "rjm","sdf234#", "Maurice","Rakotoarimanana","rjm@gmail.com","manager");
		Assertions.assertThrows(UnauthorizedException.class, () -> {
			this.authService.authorizeAssociate(user);
		});
	}
	
	@Test
	public void authorizedAssociate_negativeTest_userIsNull() {
		Assertions.assertThrows(UnauthorizedException.class, () -> {
			this.authService.authorizeAssociate(null);
		});
	}
	
	@Test
	public void authorizedAssociate_positiveTest_userIsAnAssociate() throws UnauthorizedException {
		User user = new User(1, "rjm","sdf234#", "Maurice","Rakotoarimanana","rjm@gmail.com","employee");
		this.authService.authorizeAssociate(user);		
	}
	
	@Test
	public void authorizeAssociateAndManager_positiveTest_userIsAssociate() throws UnauthorizedException {
		User user = new User(1, "rjm","sdf234#", "Maurice","Rakotoarimanana","rjm@gmail.com","qc");
		
		Assertions.assertThrows(UnauthorizedException.class, () -> {
			this.authService.authorizeRegularAndManager(user);	
		});		
	}
	
	@Test
	public void authorizedAssociateAndManager_negativeTest_userIsNull() {
		Assertions.assertThrows(UnauthorizedException.class, () -> {
			this.authService.authorizeRegularAndManager(null);	
		});		
	}
	
	@Test
	public void authorizedAssociateAndManager_positiveTest_userIsAssociate() throws UnauthorizedException {
		User user = new User(1,"Bema","sd34","Smith","Sam","bema@gmail.com","employee");
		this.authService.authorizeRegularAndManager(user);
	}
	
	@Test
	public void authorizedAssociateAndManager_positiveTest_userIsManager() throws UnauthorizedException {
		User user = new User(1,"Bema","sd34","Smith","Sam","bema@gmail.com","manager");
		this.authService.authorizeRegularAndManager(user);
	}
}
