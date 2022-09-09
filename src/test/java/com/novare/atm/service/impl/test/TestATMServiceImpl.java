package com.novare.atm.service.impl.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.novare.atm.model.User;
import com.novare.atm.service.IAccountService;
import com.novare.atm.service.impl.AccountServiceImpl;
import com.novare.atm.util.ServiceUtil;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * 
 */
@TestMethodOrder(OrderAnnotation.class)
class TestATMServiceImpl {

	private static IAccountService accountService;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		accountService = new AccountServiceImpl();

	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		accountService = null;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	@Order(1)
	@Test
	public void testCreateUser() throws Exception {
		User test = new User();
		test.setUserName("kumar");
		test.setPassWord(ServiceUtil.encrypt("test"));

		// User already exist, return true
		assertEquals(true, accountService.isValidUser(test));

		test.setUserName("test");
		// User doesn't exist, return false
		assertEquals(false, accountService.isValidUser(test));

		// User Created Successfully, SignUp
		User validUser = accountService.createUser(test);
		assertEquals(ServiceUtil.encrypt("test"), validUser.getPassWord());
	}

	@Order(2)
	@Test
	public void testLogin() throws Exception {
		User test = new User();
		test.setUserName("test");
		test.setPassWord("test");
		User validUser = accountService.login(test);
		assertEquals(null, validUser);

		test.setPassWord(ServiceUtil.encrypt("test"));
		validUser = accountService.login(test);
		assertNotEquals(null, validUser);

	}

	@Order(3)
	@Test
	public void testDeleteUser() throws Exception {
		User test = new User();
		test.setUserName("test");
		test.setPassWord("test");

		// User deleted successfully, return true
		assertEquals(true, accountService.deleteUser(test) != null);
	}

	@Order(4)
	@Test
	public void testIsValidUser() throws Exception {
		User test = new User();
		test.setUserName("test");
		test.setPassWord(ServiceUtil.encrypt("test"));

		// User doesn't exist, return false
		assertEquals(false, accountService.isValidUser(test));
	}

	@Test
	public void testViewBalnce() {
	}

	@Test
	public void testTransfer() {
	}

	@Test
	public void testDeposit() {
	}

	@Test
	public void testWithdraw() {
	}

	@Test
	public void testFindByUserName() {
	}

	@Test
	public void testUpdateUser() {
	}

	@Test
	public void testUpdatePassword() {
	}

}
