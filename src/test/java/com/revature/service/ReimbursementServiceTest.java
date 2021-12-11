package com.revature.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.revature.dao.ReimbursementDAO;
import com.revature.dao.UserDAO;
import com.revature.exception.ReimbursementNotFound;
import com.revature.model.Reimbursement;
import com.revature.model.User;

public class ReimbursementServiceTest {
	
	private ReimbursementService reimbService;
	
	private UserService userService;
	
//	
//	@Test
//	public void testGetAllReimbursementPositive() throws SQLException, ReimbursementNotFound {
//		
//		UserDAO mockuserDao = mock(UserDAO.class);
//		ReimbursementDAO mockreimbDao = mock(ReimbursementDAO.class);
//		
//		User currentlyLoggedUser = new User(2,"Chris","chri23","Patrick","Steve","chri@gmail.com","employee");
//		
//		Reimbursement reimbursement = new Reimbursement(2, 420, "2021-02-11","2021-03-11","approved","Food","Expense","",0,0);
//		
//		List<Reimbursement>reimbursementsFromDao = new ArrayList<>();
//		reimbursementsFromDao.add(reimbursement);
//		
//		when(mockreimbDao.getAllReimbursement()).thenReturn(reimbursementsFromDao);
//		
//		ReimbursementService reimbursementService = new ReimbursementService(mockreimbDao,mockuserDao);
//		
//		List<Reimbursement> actual = reimbursementService.getReimbursement(currentlyLoggedUser);
//		
//		//ASSERT
//		List<Reimbursement> expected = new ArrayList<>();
//		expected.add( new Reimbursement(2, 420, "2021-02-11","2021-03-11","approved","Food","Expense","",0,0));
//		
//		Assertions.assertEquals(expected, actual);
//	}

//	@Test
//	public void updateReimbursementPositive() {
//		ReimbursementDAO
//	}
}
