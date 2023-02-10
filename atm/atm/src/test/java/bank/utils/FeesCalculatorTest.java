package bank.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

// Use of Parameterized helps in this case, since multiple runs of same test are required

public class FeesCalculatorTest {

	@Nested
	public class WithdrawalTest {
		FeesCalculator calculator = new FeesCalculator();
		private int	withdrawalAmount = 200;
		
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
				assertEquals(withdrawalAmount * 0.0, calculator.calculateWithdrawalFee(withdrawalAmount, 1000, true, i));
			}
		}
		
		@Test
		void withdrawalStudentWeekendTest() {
			assertEquals(withdrawalAmount * 0.001, calculator.calculateWithdrawalFee(withdrawalAmount, 1000, true, 1));
			assertEquals(withdrawalAmount * 0.001, calculator.calculateWithdrawalFee(withdrawalAmount, 1000, true, 7));
		}
		
		@Test
		void withdrawalNotStudentBelowMinBalanceSundayTest() {
			assertEquals(withdrawalAmount * 0.003, calculator.calculateWithdrawalFee(withdrawalAmount, -1, false, 1));
		}
		
		@Test
		void withdrawalNotStudentMinBalanceSundayTest() {
			assertEquals(withdrawalAmount * 0.003, calculator.calculateWithdrawalFee(withdrawalAmount, 0, false, 1));
		}
		
		@Test
		void withdrawalNotStudentAboveMinBalanceSundayTest() {
			assertEquals(withdrawalAmount * 0.003, calculator.calculateWithdrawalFee(withdrawalAmount, 1, false, 1));
		}
		
		@Test
		void withdrawalNotStudentBelowLowerBVBalanceSundayTest() {
			assertEquals(withdrawalAmount * 0.003, calculator.calculateWithdrawalFee(withdrawalAmount, 999, false, 1));
		}
		
		@Test
		void withdrawalNotStudentLowerBVBalanceSundayTest() {
			assertEquals(withdrawalAmount * 0.001, calculator.calculateWithdrawalFee(withdrawalAmount, 1000, false, 1));
		}

		@Test
		void withdrawalNotStudentAboveLowerBVBalanceSundayTest() {
			assertEquals(withdrawalAmount * 0.001, calculator.calculateWithdrawalFee(withdrawalAmount, 1001, false, 1));
		}

		@Test
		void withdrawalNotStudentBelowUpperBVBalanceSundayTest() {
			assertEquals(withdrawalAmount * 0.001, calculator.calculateWithdrawalFee(withdrawalAmount, 4999, false, 1));
		}

		@Test
		void withdrawalNotStudentUpperBVBalanceSundayTest() {
			assertEquals(withdrawalAmount * 0.000, calculator.calculateWithdrawalFee(withdrawalAmount, 5000, false, 1));
		}
		
		@Test
		void withdrawalNotStudentAboveUpperBVBalanceSundayTest() {
			assertEquals(withdrawalAmount * 0.000, calculator.calculateWithdrawalFee(withdrawalAmount, 5001, false, 1));
		}

		
		
		@Test
		void withdrawalNotStudentBelowMinBalanceSaturdayTest() {
			assertEquals(withdrawalAmount * 0.003, calculator.calculateWithdrawalFee(withdrawalAmount, -1, false, 7));
		}
		
		@Test
		void withdrawalNotStudentMinBalanceSaturdayTest() {
			assertEquals(withdrawalAmount * 0.003, calculator.calculateWithdrawalFee(withdrawalAmount, 0, false, 7));
		}
		
		@Test
		void withdrawalNotStudentAboveMinBalanceSaturdayTest() {
			assertEquals(withdrawalAmount * 0.003, calculator.calculateWithdrawalFee(withdrawalAmount, 1, false, 7));
		}
		
		@Test
		void withdrawalNotStudentBelowLowerBVBalanceSaturdayTest() {
			assertEquals(withdrawalAmount * 0.003, calculator.calculateWithdrawalFee(withdrawalAmount, 999, false, 7));
		}
		
		@Test
		void withdrawalNotStudentLowerBVBalanceSaturdayTest() {
			assertEquals(withdrawalAmount * 0.001, calculator.calculateWithdrawalFee(withdrawalAmount, 1000, false, 7));
		}

		@Test
		void withdrawalNotStudentAboveLowerBVBalanceSaturdayTest() {
			assertEquals(withdrawalAmount * 0.001, calculator.calculateWithdrawalFee(withdrawalAmount, 1001, false, 7));
		}

		@Test
		void withdrawalNotStudentBelowUpperBVBalanceSaturdayTest() {
			assertEquals(withdrawalAmount * 0.001, calculator.calculateWithdrawalFee(withdrawalAmount, 4999, false, 7));
		}

		@Test
		void withdrawalNotStudentUpperBVBalanceSaturdayTest() {
			assertEquals(withdrawalAmount * 0.000, calculator.calculateWithdrawalFee(withdrawalAmount, 5000, false, 7));
		}
		
		@Test
		void withdrawalNotStudentAboveUpperBVBalanceSaturdayTest() {
			assertEquals(withdrawalAmount * 0.000, calculator.calculateWithdrawalFee(withdrawalAmount, 5001, false, 7));
		}

		
		
		@Test
		void withdrawalNotStudentBelowMinBalanceMondayTest() {
			assertEquals(withdrawalAmount * 0.003, calculator.calculateWithdrawalFee(withdrawalAmount, -1, false, 2));
		}
		
		@Test
		void withdrawalNotStudentMinBalanceMondayTest() {
			assertEquals(withdrawalAmount * 0.003, calculator.calculateWithdrawalFee(withdrawalAmount, 0, false, 2));
		}
		
		@Test
		void withdrawalNotStudentAboveMinBalanceMondayTest() {
			assertEquals(withdrawalAmount * 0.003, calculator.calculateWithdrawalFee(withdrawalAmount, 1, false, 2));
		}
		
		@Test
		void withdrawalNotStudentBelowLowerBVBalanceMondayTest() {
			assertEquals(withdrawalAmount * 0.003, calculator.calculateWithdrawalFee(withdrawalAmount, 999, false, 2));
		}
		
		@Test
		void withdrawalNotStudentLowerBVBalanceMondayTest() {
			assertEquals(withdrawalAmount * 0.001, calculator.calculateWithdrawalFee(withdrawalAmount, 1000, false, 2));
		}

		@Test
		void withdrawalNotStudentAboveLowerBVBalanceMondayTest() {
			assertEquals(withdrawalAmount * 0.001, calculator.calculateWithdrawalFee(withdrawalAmount, 1001, false, 2));
		}

		@Test
		void withdrawalNotStudentBelowUpperBVBalanceMondayTest() {
			assertEquals(withdrawalAmount * 0.001, calculator.calculateWithdrawalFee(withdrawalAmount, 4999, false, 2));
		}

		@Test
		void withdrawalNotStudentUpperBVBalanceMondayTest() {
			assertEquals(withdrawalAmount * 0.000, calculator.calculateWithdrawalFee(withdrawalAmount, 5000, false, 2));
		}
		
		@Test
		void withdrawalNotStudentAboveUpperBVBalanceMondayTest() {
			assertEquals(withdrawalAmount * 0.000, calculator.calculateWithdrawalFee(withdrawalAmount, 5001, false, 2));
		}

		
		
		@Test
		void withdrawalNotStudentBelowMinBalanceFridayTest() {
			assertEquals(withdrawalAmount * 0.003, calculator.calculateWithdrawalFee(withdrawalAmount, -1, false, 6));
		}
		
		@Test
		void withdrawalNotStudentMinBalanceFridayTest() {
			assertEquals(withdrawalAmount * 0.003, calculator.calculateWithdrawalFee(withdrawalAmount, 0, false, 6));
		}
		
		@Test
		void withdrawalNotStudentAboveMinBalanceFridayTest() {
			assertEquals(withdrawalAmount * 0.003, calculator.calculateWithdrawalFee(withdrawalAmount, 1, false, 6));
		}
		
		@Test
		void withdrawalNotStudentBelowLowerBVBalanceFridayTest() {
			assertEquals(withdrawalAmount * 0.003, calculator.calculateWithdrawalFee(withdrawalAmount, 999, false, 6));
		}
		
		@Test
		void withdrawalNotStudentLowerBVBalanceFridayTest() {
			assertEquals(withdrawalAmount * 0.001, calculator.calculateWithdrawalFee(withdrawalAmount, 1000, false, 6));
		}

		@Test
		void withdrawalNotStudentAboveLowerBVBalanceFridayTest() {
			assertEquals(withdrawalAmount * 0.001, calculator.calculateWithdrawalFee(withdrawalAmount, 1001, false, 6));
		}

		@Test
		void withdrawalNotStudentBelowUpperBVBalanceFridayTest() {
			assertEquals(withdrawalAmount * 0.001, calculator.calculateWithdrawalFee(withdrawalAmount, 4999, false, 6));
		}

		@Test
		void withdrawalNotStudentUpperBVBalanceFridayTest() {
			assertEquals(withdrawalAmount * 0.000, calculator.calculateWithdrawalFee(withdrawalAmount, 5000, false, 6));
		}
		
		@Test
		void withdrawalNotStudentAboveUpperBVBalanceFridayTest() {
			assertEquals(withdrawalAmount * 0.000, calculator.calculateWithdrawalFee(withdrawalAmount, 5001, false, 6));
		}

		
		

	}

	@Nested
	public class DepositTest {
		FeesCalculator calculator = new FeesCalculator();

		@BeforeEach
		void setUp() throws Exception {
		}

		@AfterEach
		void tearDown() throws Exception {
		}

		@Test
		void testStudentDepositTwentyFiveBalanceThreeHundred() {
			int depositAmount = 25;
			assertEquals(depositAmount * 0.0, calculator.calculateDepositInterest(depositAmount, 300, true));
		}

		@Test
		void testNotStudentDepositThreeHundredBalanceOneThousand() {
			int depositAmount = 300;

			assertEquals(depositAmount * 0.004, calculator.calculateDepositInterest(depositAmount, 1000, false));
		}

		@Test
		void testNotStudentDepositOneHundredBalanceTwelveThousand() {
			int depositAmount = 100;

			assertEquals(depositAmount * 0.0, calculator.calculateDepositInterest(depositAmount, 12000, false));
		}

		@Test
		void testStudentDepositThreeHundredBalanceThreeHundred() {
			int depositAmount = 300;

			assertEquals(depositAmount * 0.0025, calculator.calculateDepositInterest(depositAmount, 300, true));
		}

		@Test
		void testStudentDepositTwentyFiveBalanceSevenThousandFiveHundred() {
			int depositAmount = 25;

			assertEquals(depositAmount * 0.005, calculator.calculateDepositInterest(depositAmount, 7500, true));
		}

		

	}

	@Nested
	public class TransferTest {

		FeesCalculator calculator = new FeesCalculator();

		@BeforeEach
		void setUp() throws Exception {
			// Client Type Amount Transferred Balance(From) Balance(To) Fee
		}

		@AfterEach
		void tearDown() throws Exception {
		}

		@Test
		void transferStudentLow1() {
			// Student < $200 < $2,000 < $1,000 0.1%
			double transferAmt = 190;
			double fromAmt = 1990;
			double toAmt = 990;
			double expectedfee = (0.1 * transferAmt) / 100;
			assertEquals(expectedfee, calculator.calculateTransferFee(0, 0, 0, true));
		}

		@Test
		void transferStudentLow2() {
			// Student < $200 < $2,000 >= $1,000 0.05%
			double transferAmt = 190;
			double fromAmt = 1990;
			double toAmt = 1010;
			double expectedfee = (0.05 * transferAmt) / 100;
			assertEquals(expectedfee, calculator.calculateTransferFee(transferAmt, fromAmt, toAmt, true));
		}

		@Test
		void transferStudentLow3() {
			// Student < $200 >= $2,000 < $1,000 0.05%
			double transferAmt = 190;
			double fromAmt = 2010;
			double toAmt = 990;
			double expectedfee = (0.05 * transferAmt) / 100;
			assertEquals(expectedfee, calculator.calculateTransferFee(transferAmt, fromAmt, toAmt, true));
		}

		@Test
		void transferStudentLow4() {
			// Student < $200 >= $2,000 >= $1,000 0.025%
			double transferAmt = 190;
			double fromAmt = 2010;
			double toAmt = 1010;
			double expectedfee = (0.025 * transferAmt) / 100;
			assertEquals(expectedfee, calculator.calculateTransferFee(transferAmt, fromAmt, toAmt, true));
		}

		@Test
		void transferStudentHigh1() {
			// Student >= $200 < $2,000 < $1,000 0.05%
			double transferAmt = 210;
			double fromAmt = 1990;
			double toAmt = 990;
			double expectedfee = (0.05 * transferAmt) / 100;
			assertEquals(expectedfee, calculator.calculateTransferFee(transferAmt, fromAmt, toAmt, true));
		}

		@Test
		void transferStudentHigh2() {
			// Student >= $200 < $2,000 >= $1,000 0.025%
			double transferAmt = 210;
			double fromAmt = 1990;
			double toAmt = 1010;
			double expectedfee = (0.025 * transferAmt) / 100;
			assertEquals(expectedfee, calculator.calculateTransferFee(transferAmt, fromAmt, toAmt, true));
		}

		@Test
		void transferStudentHigh3() {
			// Student >= $200 >= $2,000 < $1,000 0.25%
			double transferAmt = 210;
			double fromAmt = 2010;
			double toAmt = 990;
			double expectedfee = (0.25 * transferAmt) / 100;
			assertEquals(expectedfee, calculator.calculateTransferFee(transferAmt, fromAmt, toAmt, true));
		}

		@Test
		void transferStudentHigh4() {
			// Student >= $200 >= $2,000 >= $1,000 0.125%
			double transferAmt = 210;
			double fromAmt = 2010;
			double toAmt = 1010;
			double expectedfee = (0.125 * transferAmt) / 100;
			assertEquals(expectedfee, calculator.calculateTransferFee(transferAmt, fromAmt, toAmt, true));
		}

		@Test
		void transferNotStudentLow1() {
			// Non-student < $100 < $4,000 < $2,000 0.2%
			double transferAmt = 90;
			double fromAmt = 3990;
			double toAmt = 1990;
			double expectedfee = (0.2 * transferAmt) / 100;
			assertEquals(expectedfee, calculator.calculateTransferFee(transferAmt, fromAmt, toAmt, false));
		}

		@Test
		void transferNotStudentLow2() {
			// Non-student < $100 < $4,000 >= $2,000 0.1%
			double transferAmt = 90;
			double fromAmt = 3990;
			double toAmt = 2010;
			double expectedfee = (0.1 * transferAmt) / 100;
			assertEquals(expectedfee, calculator.calculateTransferFee(transferAmt, fromAmt, toAmt, false));
		}

		@Test
		void transferNotStudentLow3() {
			// Non-student < $100 >= $4,000 < $2,000 1%
			double transferAmt = 90;
			double fromAmt = 4010;
			double toAmt = 1990;
			double expectedfee = (1 * transferAmt) / 100;
			assertEquals(expectedfee, calculator.calculateTransferFee(transferAmt, fromAmt, toAmt, false));
		}

		@Test
		void transferNotStudentLow4() {
			// Non-student < $100 >= $4,000 >= $2,000 0.5%
			double transferAmt = 90;
			double fromAmt = 4010;
			double toAmt = 2010;
			double expectedfee = (0.5 * transferAmt) / 100;
			assertEquals(expectedfee, calculator.calculateTransferFee(transferAmt, fromAmt, toAmt, false));
		}

		@Test
		void transferNotStudentHigh1() {
			// Non-student >= $100 < $2,000 < $1,000 0.2%
			double transferAmt = 110;
			double fromAmt = 1990;
			double toAmt = 990;
			double expectedfee = (0.2 * transferAmt) / 100;
			assertEquals(expectedfee, calculator.calculateTransferFee(transferAmt, fromAmt, toAmt, false));
		}

		@Test
		void transferNotStudentHigh2() {
			// Non-student >= $100 < $2,000 >= $1,000 0.1%
			double transferAmt = 110;
			double fromAmt = 1990;
			double toAmt = 1010;
			double expectedfee = (0.1 * transferAmt) / 100;
			assertEquals(expectedfee, calculator.calculateTransferFee(transferAmt, fromAmt, toAmt, false));
		}

		@Test
		void transferNotStudentHigh3() {
			// Non-student >= $100 >= $2,000 < $1,000 0.5%
			double transferAmt = 110;
			double fromAmt = 2010;
			double toAmt = 990;
			double expectedfee = (0.5 * transferAmt) / 100;
			assertEquals(expectedfee, calculator.calculateTransferFee(transferAmt, fromAmt, toAmt, false));
		}

		@Test
		void transferNotStudentHigh4() {
			// Non-student >= $100 >= $2,000 >= $1,000 0.25%
			double transferAmt = 110;
			double fromAmt = 2010;
			double toAmt = 1010;
			double expectedfee = (0.25 * transferAmt) / 100;
			assertEquals(expectedfee, calculator.calculateTransferFee(transferAmt, fromAmt, toAmt, false));
		}

	}

}