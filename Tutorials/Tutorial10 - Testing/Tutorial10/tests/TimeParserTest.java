import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;


/**
 * Created by nickwhite on 4/18/17.
 */
public class TimeParserTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }


    //Minimal full statement coverage
    @Test
    public void parseTimeToSeconds() throws Exception {


        assertEquals(TimeParser.parseTimeToSeconds("12:00:00 am"), 0);

    }

    //Full branch coverage testing
    @Test(expected = NumberFormatException.class)
    public void parseNegativeCoverage() {

        int newTime = TimeParser.parseTimeToSeconds("21");
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseMinutesFormat() {
        TimeParser.parseTimeToSeconds("12:2112");
    }

    @Test(expected = NumberFormatException.class)
    public void parseMissingColon() {
        TimeParser.parseTimeToSeconds("12:21");
    }

    //Full path coverage
    //Illegal arguments and branches cover previously -- focus on paths for legal args
    @Test
    public void testPM() {
        assertEquals(TimeParser.parseTimeToSeconds("1:00:00 pm"), 46800);
    }


}