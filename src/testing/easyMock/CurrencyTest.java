package testing.easyMock;

import static org.junit.Assert.*;

import java.io.IOException;

import org.easymock.EasyMock;
import org.junit.Test;

/**
 * This class tests the toEuros() method in Currency class using EasyMock
 * @author chq-vasanthakumars
 *
 */
public class CurrencyTest {

	@Test
    public void toEuros() throws IOException {
    	// 1 USD = 1.5 EUR
        Currency testObject = new Currency(2.50, "USD");
        Currency expected = new Currency(3.75, "EUR");
        
        /* create mock for an external class that is being used 
         * by the class under test (Currency)
         */
        ExchangeRate mock = EasyMock.createMock(ExchangeRate.class);
       
		/*
		 * This tells that the mocked class will be sent getRate method and that
		 * it should return 1.5
		 */
        EasyMock.expect(mock.getRate("USD", "EUR")).andReturn(1.5);
        EasyMock.replay(mock);
        Currency actual = testObject.toEuros(mock);
        assertEquals(expected, actual);
    }
    

    //simulate network error during getRate()
	@Test
    public void toEurosWithIOException() throws IOException {
        Currency testObject = new Currency(2.50, "USD");
        ExchangeRate mock=EasyMock.createMock(ExchangeRate.class);
        EasyMock.expect(mock.getRate("USD","EUR")).andThrow(new IOException());
        EasyMock.replay(mock);
        Currency actual=testObject.toEuros(mock);
        assertNull(actual);
    }
}