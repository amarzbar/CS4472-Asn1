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

class TransferTest {
	
	FeesCalculator calculator = new FeesCalculator();

	@BeforeEach
	void setUp() throws Exception {
		// Client Type	Amount Transferred	Balance(From)	Balance(To)	Fee
	}

	@AfterEach
	void tearDown() throws Exception {
	}
		
	@Test
	void transferStudentLow1() {
		// Student	< $200	< $2,000	< $1,000	0.1%
		double transferAmt = 190;
		double fromAmt = 1990;
		double toAmt = 990;
		double expectedfee = (0.1 * transferAmt)/100;
		assertEquals(expectedfee, calculator.calculateTransferFee(0, 0, 0, true));
	}
	
	@Test
	void transferStudentLow2() {
		// Student	< $200	< $2,000	>= $1,000	0.05%
		double transferAmt = 190;
		double fromAmt = 1990;
		double toAmt = 1010;
		double expectedfee = (0.05 * transferAmt)/100;
		assertEquals(expectedfee, calculator.calculateTransferFee(transferAmt, fromAmt, toAmt, true));
	}
	
	@Test
	void transferStudentLow3() {
		// Student	< $200	>= $2,000	< $1,000	0.05%
		double transferAmt = 190;
		double fromAmt = 2010;
		double toAmt = 990;
		double expectedfee = (0.05 * transferAmt)/100;
		assertEquals(expectedfee, calculator.calculateTransferFee(transferAmt, fromAmt, toAmt, true));
	}
	
	@Test
	void transferStudentLow4() {
		// Student	< $200	>= $2,000	>= $1,000	0.025%
		double transferAmt = 190;
		double fromAmt = 2010;
		double toAmt = 1010;
		double expectedfee = (0.025 * transferAmt)/100;
		assertEquals(expectedfee, calculator.calculateTransferFee(transferAmt, fromAmt, toAmt, true));
	}
	
	@Test
	void transferStudentHigh1() {
		// Student	>= $200	< $2,000	< $1,000	0.05%
		double transferAmt = 210;
		double fromAmt = 1990;
		double toAmt = 990;
		double expectedfee = (0.05 * transferAmt)/100;
		assertEquals(expectedfee, calculator.calculateTransferFee(transferAmt, fromAmt, toAmt, true));
	}
	
	@Test
	void transferStudentHigh2() {
		// Student	>= $200	< $2,000	>= $1,000	0.025%
		double transferAmt = 210;
		double fromAmt = 1990;
		double toAmt = 1010;
		double expectedfee = (0.025 * transferAmt)/100;
		assertEquals(expectedfee, calculator.calculateTransferFee(transferAmt, fromAmt, toAmt, true));
	}
	
	@Test
	void transferStudentHigh3() {
		// Student	>= $200	>= $2,000	< $1,000	0.25%
		double transferAmt = 210;
		double fromAmt = 2010;
		double toAmt = 990;
		double expectedfee = (0.25 * transferAmt)/100;
		assertEquals(expectedfee, calculator.calculateTransferFee(transferAmt, fromAmt, toAmt, true));
	}
	
	@Test
	void transferStudentHigh4() {
		// Student	>= $200	>= $2,000	>= $1,000	0.125%
		double transferAmt = 210;
		double fromAmt = 2010;
		double toAmt = 1010;
		double expectedfee = (0.125 * transferAmt)/100;
		assertEquals(expectedfee, calculator.calculateTransferFee(transferAmt, fromAmt, toAmt, true));
	}
	
	@Test
	void transferNotStudentLow1() {
		// Non-student	< $100	< $4,000	< $2,000	0.2%
		double transferAmt = 90;
		double fromAmt = 3990;
		double toAmt = 1990;
		double expectedfee = (0.2 * transferAmt)/100;
		assertEquals(expectedfee, calculator.calculateTransferFee(transferAmt, fromAmt, toAmt, false));
	}
	
	@Test
	void transferNotStudentLow2() {
		// Non-student	< $100	< $4,000	>= $2,000	0.1%
		double transferAmt = 90;
		double fromAmt = 3990;
		double toAmt = 2010;
		double expectedfee = (0.1 * transferAmt)/100;
		assertEquals(expectedfee, calculator.calculateTransferFee(transferAmt, fromAmt, toAmt, false));
	}
	
	@Test
	void transferNotStudentLow3() {
		// Non-student	< $100	>= $4,000	< $2,000	1%
		double transferAmt = 90;
		double fromAmt = 4010;
		double toAmt = 1990;
		double expectedfee = (1 * transferAmt)/100;
		assertEquals(expectedfee, calculator.calculateTransferFee(transferAmt, fromAmt, toAmt, false));
	}
	
	@Test
	void transferNotStudentLow4() {
		// Non-student	< $100	>= $4,000	>= $2,000	0.5%
		double transferAmt = 90;
		double fromAmt = 4010;
		double toAmt = 2010;
		double expectedfee = (0.5 * transferAmt)/100;
		assertEquals(expectedfee, calculator.calculateTransferFee(transferAmt, fromAmt, toAmt, false));
	}
	
	@Test
	void transferNotStudentHigh1() {
		// Non-student	>= $100	< $2,000	< $1,000	0.2%
		double transferAmt = 110;
		double fromAmt = 1990;
		double toAmt = 990;
		double expectedfee = (0.2 * transferAmt)/100;
		assertEquals(expectedfee, calculator.calculateTransferFee(transferAmt, fromAmt, toAmt, false));
	}
	
	@Test
	void transferNotStudentHigh2() {
		// Non-student	>= $100	< $2,000	>= $1,000	0.1%
		double transferAmt = 110;
		double fromAmt = 1990;
		double toAmt = 1010;
		double expectedfee = (0.1 * transferAmt)/100;
		assertEquals(expectedfee, calculator.calculateTransferFee(transferAmt, fromAmt, toAmt, false));
	}
	
	@Test
	void transferNotStudentHigh3() {
		// Non-student	>= $100	>= $2,000	< $1,000	0.5%
		double transferAmt = 110;
		double fromAmt = 2010;
		double toAmt = 990;
		double expectedfee = (0.5 * transferAmt)/100;
		assertEquals(expectedfee, calculator.calculateTransferFee(transferAmt, fromAmt, toAmt, false));
	}
	
	@Test
	void transferNotStudentHigh4() {
		// Non-student	>= $100	>= $2,000	>= $1,000	0.25%
		double transferAmt = 110;
		double fromAmt = 2010;
		double toAmt = 1010;
		double expectedfee = (0.25 * transferAmt)/100;
		assertEquals(expectedfee, calculator.calculateTransferFee(transferAmt, fromAmt, toAmt, false));
	}

	
}
