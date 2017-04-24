/**
 * Created by nickwhite on 4/18/17.
 */
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ArrayListTest {
    List<Integer> testArray;

    /**
     * This method is invoked before each test is run to set up the test array
     * with a known set of values.
     */
    @Before
    // Informs JUnit that this method should be run before each test
    public void setUp() {
        testArray = new ArrayList<Integer>(Arrays.asList(3, 1, 4, 1, 5));
    }

    /**
     * This method is invoked after each test is run to perform tear down
     * activities (not needed in this test fixture).
     */
    @After
    // Informs JUnit that this method should be run after each test
    public void tearDown() {
        // No tear down needed for this test
    }

    /**
     * Adds a value to the array and verifies the add was successful.
     */
    @Test
    public void testAdd() {
        testArray.add(9);

        List<Integer> expected =
                new ArrayList<Integer>(Arrays.asList(3, 1, 4, 1, 5, 9));

        assertEquals(testArray, expected);
    }

    /**
     * Removes a value from the array and verifies the remove was successful.
     */
    @Test
    public void testRemoveObject() {
        testArray.remove(new Integer(5));

        List<Integer> expected =
                new ArrayList<Integer>(Arrays.asList(3, 1, 4, 1));

        assertEquals(testArray, expected);
    }

    /**
     * Tests the indexOf method and verifies the expected return value.
     */
    @Test
    public void testIndexOf() {
        assertEquals(testArray.indexOf(4), 2);
    }

    //Tests the clear method and verify the array is empty
    @Test
    public void testClear() {
        testArray.clear();
        assertNull(testArray);
    }

    //Tests the contains method and verifies an element in the array
    @Test
    public void testContains() {
        assertTrue(testArray.contains(1));
    }

    //Tests the contains method by verifying that returns false for an element that does not exist in the array
    @Test
    public void testContainsFalse() {
        assertFalse(testArray.contains(54));
    }

    //Tests the get method and verifies true
    @Test
    public void testGet() {
        int currentNum = 1;
        int correctIndex = 1;
        assertEquals((int)testArray.get(correctIndex), currentNum);
    }
}
