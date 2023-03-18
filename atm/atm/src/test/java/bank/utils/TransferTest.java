package bank.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

// Use of Parameterized helps in this case, since multiple runs of same test are required

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
	void transferP1() {
		
		// Student, Amount < $200, fromAccountBalance < $2,000, toAccountBalance < $1,000 -> fee % = 0.001	
		double transferAmt = 190;
		double fromAmt = 1990;
		double toAmt = 990;
		double expectedfee = (0.001 * transferAmt);
		assertEquals(expectedfee, calculator.calculateTransferFee(transferAmt, fromAmt, toAmt, true));
	}
	
	@Test
	void transferP2() {
		
		// Student, Amount < $200, fromAccountBalance < $2,000, toAccountBalance > $1,000 -> fee % = 0.0005	
		double transferAmt = 190;
		double fromAmt = 1990;
		double toAmt = 1010;
		double expectedfee = (0.0005 * transferAmt);
		assertEquals(expectedfee, calculator.calculateTransferFee(transferAmt, fromAmt, toAmt, true));
	}
	
	@Test
	void transferP3() {
		
		// Student, Amount < $200, fromAccountBalance > $2,000, toAccountBalance < $1,000 -> fee % = 0.0005	
		double transferAmt = 190;
		double fromAmt = 2010;
		double toAmt = 990;
		double expectedfee = (0.0005 * transferAmt);
		assertEquals(expectedfee, calculator.calculateTransferFee(transferAmt, fromAmt, toAmt, true));
	}
	
	@Test
	void transferP4() {
		
		// Student, Amount < $200, fromAccountBalance > $2,000, toAccountBalance > $1,000 -> fee % = 0.0025
		double transferAmt = 190;
		double fromAmt = 2010;
		double toAmt = 1010;
		double expectedfee = (0.0025 * transferAmt);
		assertEquals(expectedfee, calculator.calculateTransferFee(transferAmt, fromAmt, toAmt, true));
	}
	
	@Test
	void transferP5() {
		
		// Student, Amount > $200, fromAccountBalance < $2,000, toAccountBalance < $1,000 -> fee % = 0.0005
		double transferAmt = 210;
		double fromAmt = 1990;
		double toAmt = 990;
		double expectedfee = (0.0005 * transferAmt);
		assertEquals(expectedfee, calculator.calculateTransferFee(transferAmt, fromAmt, toAmt, true));
	}
	
	@Test
	void transferP6() {
		
		// Student, Amount > $200, fromAccountBalance < $2,000, toAccountBalance > $1,000 -> fee % = 0.00025
		double transferAmt = 210;
		double fromAmt = 1990;
		double toAmt = 1010;
		double expectedfee = (0.00025 * transferAmt);
		assertEquals(expectedfee, calculator.calculateTransferFee(transferAmt, fromAmt, toAmt, true));
	}
	
	@Test
	void transferP7() {
		
		// Student, Amount > $200, fromAccountBalance > $2,000, toAccountBalance < $1,000 -> fee % = 0.0025
		double transferAmt = 210;
		double fromAmt = 2010;
		double toAmt = 990;
		double expectedfee = (0.0025 * transferAmt);
		assertEquals(expectedfee, calculator.calculateTransferFee(transferAmt, fromAmt, toAmt, true));
	}
	
	@Test
	void transferP8() {
		
		// Student, Amount > $200, fromAccountBalance > $2,000, toAccountBalance > $1,000 -> fee % = 0.00125
		double transferAmt = 210;
		double fromAmt = 2010;
		double toAmt = 1010;
		double expectedfee = (0.00125 * transferAmt);
		assertEquals(expectedfee, calculator.calculateTransferFee(transferAmt, fromAmt, toAmt, true));
	}
	
	@Test
	void transferP9() {
		
		// Not Student, Amount < $100, fromAccountBalance < $4,000, toAccountBalance < $2,000 -> fee % = 0.002
		double transferAmt = 90;
		double fromAmt = 3990;
		double toAmt = 1990;
		double expectedfee = (0.002 * transferAmt);
		assertEquals(expectedfee, calculator.calculateTransferFee(transferAmt, fromAmt, toAmt, false));
	}
	
	@Test
	void transferP10() {
		
		// Not Student, Amount < $100, fromAccountBalance < $4,000, toAccountBalance > $2,000 -> fee % = 0.001
		double transferAmt = 90;
		double fromAmt = 3990;
		double toAmt = 2010;
		double expectedfee = (0.001 * transferAmt);
		assertEquals(expectedfee, calculator.calculateTransferFee(transferAmt, fromAmt, toAmt, false));
	}
	
	@Test
	void transferP11() {
		
		// Not Student, Amount < $100, fromAccountBalance > $4,000, toAccountBalance < $2,000 -> fee % = 0.01
		double transferAmt = 90;
		double fromAmt = 4010;
		double toAmt = 1990;
		double expectedfee = (0.01 * transferAmt);
		assertEquals(expectedfee, calculator.calculateTransferFee(transferAmt, fromAmt, toAmt, false));
	}
	
	@Test
	void transferP12() {
		
		// Not Student, Amount < $100, fromAccountBalance > $4,000, toAccountBalance > $2,000 -> fee % = 0.005
		double transferAmt = 90;
		double fromAmt = 4010;
		double toAmt = 2010;
		double expectedfee = (0.005 * transferAmt);
		assertEquals(expectedfee, calculator.calculateTransferFee(transferAmt, fromAmt, toAmt, false));
	}
	
	@Test
	void transferP13() {
		
		// Not Student, Amount > $100, fromAccountBalance < $2,000, toAccountBalance < $1,000 -> fee % = 0.002
		double transferAmt = 110;
		double fromAmt = 1990;
		double toAmt = 990;
		double expectedfee = (0.002 * transferAmt);
		assertEquals(expectedfee, calculator.calculateTransferFee(transferAmt, fromAmt, toAmt, false));
	}
	
	@Test
	void transferP14() {
		
		// Not Student, Amount > $100, fromAccountBalance < $2,000, toAccountBalance > $1,000 -> fee % = 0.001
		double transferAmt = 110;
		double fromAmt = 1990;
		double toAmt = 1010;
		double expectedfee = (0.001 * transferAmt);
		assertEquals(expectedfee, calculator.calculateTransferFee(transferAmt, fromAmt, toAmt, false));
	}
	
	@Test
	void transferP15() {
		
		// Not Student, Amount > $100, fromAccountBalance > $2,000, toAccountBalance < $1,000 -> fee % = 0.005
		double transferAmt = 110;
		double fromAmt = 2010;
		double toAmt = 990;
		double expectedfee = (0.005 * transferAmt);
		assertEquals(expectedfee, calculator.calculateTransferFee(transferAmt, fromAmt, toAmt, false));
	}
	
	@Test
	void transferP16() {
		
		// Not Student, Amount > $100, fromAccountBalance > $2,000, toAccountBalance > $1,000 -> fee % = 0.0025
		double transferAmt = 110;
		double fromAmt = 2010;
		double toAmt = 1010;
		double expectedfee = (0.0025 * transferAmt);
		assertEquals(expectedfee, calculator.calculateTransferFee(transferAmt, fromAmt, toAmt, false));
	}
	




}