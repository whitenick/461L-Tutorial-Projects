import org.junit.Test;

import static org.junit.Assert.*;

public class PhiladelphiaTest {

	@Test
	public void testIsItSunny() {
		assertTrue(Philadelphia.isItSunny());

	}

	@Test
	public void falseTestSunny() {



	    assertFalse(Philadelphia.isItSunny());


	}

    @Test
    public void assertionMethod() {
	    boolean phillyWeather = true;

	    assertEquals(Philadelphia.isItSunny(), phillyWeather);

    }

    @Test
    public void exceptionTest() throws Exception{
        try {

        } catch (Exception e) {
            throw new Exception("Thrown Test Method Exception");
        }


    }
}
