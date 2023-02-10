package atm.session;
import atm.exceptions.*;
import atm.exceptions.InvalidPinFormatException;
import atm.session.transactions.ATMTransaction;
import atm.session.transactions.ATMWithdrawal;
import atm.ui.panels.MainPanel;
import bank.transactions.utils.TransactionType;
import atm.dispatcher.MessageDispatcher;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import org.mockito.Spy;

class SessionTest {
	@Spy
    Session session;
    MessageDispatcher dispatcher;

	@BeforeEach
	void setUp() throws Exception {
		dispatcher = Mockito.mock(MessageDispatcher.class);
		
		MainPanel mainPanel = Mockito.mock(MainPanel.class);
        session = new Session(mainPanel, dispatcher);
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	public static Stream<Arguments> pins(){
		return Stream.of(
				// format is the value and the expected output
				Arguments.of(new char[]{'5','5','5','5'}),
				Arguments.of(new char[]{'5','5','5','5','5','5'}),
				Arguments.of(new char[]{'5','5','5'}),
				Arguments.of(new char[]{'5','5','5','a','5'}),
				Arguments.of(new char[]{'5',':','5','5','5'}),
				Arguments.of(new char[]{'5','/','5','5','5'}),
				Arguments.of(new char[]{'5','5','5','5','5'})

		);
	}
	
	public static Stream<Arguments> amounts(){
		return Stream.of(
				// format is the value and the expected output
				Arguments.of(-1),
				Arguments.of(0),
				Arguments.of(20),
				Arguments.of(50),
				Arguments.of(70),
				Arguments.of(980),
				Arguments.of(250),
				Arguments.of(1000),
				Arguments.of(1001)


		);
	}

	
	/* TESTING */
	@ParameterizedTest
	@MethodSource("pins")
	void checkAddPin(char[] pins, int amount) {
		// Valid 
		// Note InvalidPINException does not exist!
		session.setTransaction(new ATMWithdrawal());  
		session.performTransaction();

		Assertions.assertThrows(Exception.class, () -> session.addPin(pins));

	}
	

	// set alleged amount to 5000
	@ParameterizedTest
	@MethodSource("amounts")
	void checkWithdrawl(int amount) {

		session.setTransaction(new ATMWithdrawal());  
		session.performTransaction();
		session.addPin(new char[] {'5','5','5','5','5'});
		Assertions.assertThrows(InvalidAmountException.class,  () -> {session.setAmount(amount);}, "Testing withdrawal");
		


	}
	
	
}
