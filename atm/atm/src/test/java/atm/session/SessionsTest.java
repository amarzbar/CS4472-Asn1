package atm.session;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import atm.dispatcher.MessageDispatcher;
import atm.ui.panels.MainPanel;

class SessionsTest {
    Session session;
    MessageDispatcher dispatcher;

    @BeforeEach
	public void setUp() throws Exception {
		dispatcher = Mockito.mock(MessageDispatcher.class);
		
		MainPanel mainPanel = Mockito.mock(MainPanel.class);
        session = new Session(mainPanel, dispatcher);
	}

    @AfterEach
	public void tearDown() throws Exception {
	}

    public void checkCorrectPINTest() {
		Mockito.when(dispatcher.checkCredentials(null, new char[] {'5','5','5','5'})).thenReturn(true);
		Assertions.assertDoesNotThrow(() -> atm.checkPin(new char[] {'5','5','5','5'}));
	}
}


/*
 * Checks ::
 * 
 * PIN FORMAT
 * 
 * 
 * Valid amount chosen for withdrawwal transaction choince 1
 * 
 * RWCBVA (Robus Worst Case Boundary Value Analysis) Single fault assumption principle.
 * 
 * Create account with daily limit 1000 and balance of 5000 == Upper boundary = 1000
 * 
 * 
 * Requirements for class
 * public Session(MainPanel mainPanel, MessageDispatcher dispatcher)
 * main panel and dispatcher
 */