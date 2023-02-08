package bank.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// Use of Parameterized helps in this case, since multiple runs of same test are required

class WithdrawalTest {
	FeesCalculator calculator = new FeesCalculator();

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	// Withdrawal Tests

	@Test
	void withdrawalStudentWeekdayTest() {
		for (int i = 2; i < 7; i++) {
			assertEquals(0.0, calculator.calculateWithdrawalFee(200, 1000, true, i));
		}
	}

	@Test
	void withdrawalStudentWeekendTest() {
		assertEquals(0.001, calculator.calculateWithdrawalFee(200, 1000, true, 1));
		assertEquals(0.001, calculator.calculateWithdrawalFee(200, 1000, true, 7));
	}

	@Test
	void withdrawalNotStudentLowBalanceTest() {
		assertEquals(0.003, calculator.calculateWithdrawalFee(200, 500, false, 1));
	}

	@Test
	void withdrawalNotStudentMidBalanceTest() {
		assertEquals(0.001, calculator.calculateWithdrawalFee(200, 1000, false, 1));
	}

	@Test
	void withdrawalNotStudentHighBalanceTest() {
		assertEquals(0.0, calculator.calculateWithdrawalFee(200, 10000, false, 1));
	}

}

class DepositTest {
	FeesCalculator calculator = new FeesCalculator();

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void depositStudentAboveFiftyHighBalanceTest() {
		assertEquals(0.005, calculator.calculateDepositInterest(100, 600, true));
	}

	@Test
	void depositStudentAboveFiftyLowBalanceTest() {
		assertEquals(0.0025, calculator.calculateDepositInterest(100, 500, true));
	}

	@Test
	void depositStudentBelowFiftyHighBalanceTest() {
		assertEquals(0.005, calculator.calculateDepositInterest(25, 5100, true));
	}

	@Test
	void depositStudentBelowFiftyLowBalanceTest() {
		assertEquals(0.0, calculator.calculateDepositInterest(25, 5000, true));
	}

	@Test
	void depositNotStudentAboveTwoFiftyHighBalanceTest() {
		assertEquals(0.008, calculator.calculateDepositInterest(300, 3000, false));
	}

	@Test
	void depositNotStudentAboveTwoFiftyLowBalanceTest() {
		assertEquals(0.004, calculator.calculateDepositInterest(300, 2500, false));
	}

	@Test
	void depositNotStudentBelowTwoFiftyHighBalanceTest() {
		assertEquals(0.0, calculator.calculateDepositInterest(250, 12000, false));
	}

	@Test
	void depositNotStudentBelowTwoFiftyLowBalanceTest() {
		assertEquals(0.001, calculator.calculateDepositInterest(250, 10000, false));
	}

}
