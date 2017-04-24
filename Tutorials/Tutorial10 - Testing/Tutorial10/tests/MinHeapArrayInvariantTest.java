/**
 * Created by nickwhite on 4/18/17.
 */
import static org.junit.Assert.*;

import java.util.Arrays;

import java.util.Collections;

import java.util.Random;



import org.junit.Before;

import org.junit.Test;





public class MinHeapArrayInvariantTest {

    private static final long SEED = 42;

    private static final long VALUES_TO_TEST = 1000;



    private Random random;

    private HeapArray<Integer> heap;



    @Before

    public void setUp() {

        random = new Random(SEED);

        heap = new HeapArray<Integer>();

    }



    @Test

    public void testWithRandomAdds() {

        for (int i=0; i < VALUES_TO_TEST; i++) {

            int addMe = random.nextInt();

            heap.add(addMe);

            assertTrue(invariantHolds());

        }

    }



    @Test

    public void testWithRandomRemoves() {

        fillWithRandomValues(VALUES_TO_TEST);

        while (heap.size() > 0) {

            int indexToRemove = random.nextInt(heap.size());

            Integer removeMe = heap.get(indexToRemove);

            heap.remove(removeMe);

            assertTrue(invariantHolds());

        }

    }



    @Test

    public void testPop() {

        fillWithRandomValues(VALUES_TO_TEST);

        while (heap.size() > 0) {

            heap.pop();

            assertTrue(invariantHolds());

        }

    }



    @Test

    public void testClear() {

        fillWithRandomValues(VALUES_TO_TEST);

        heap.clear();

        assertTrue(invariantHolds());

    }

    //Test for property array[n]<=array[2*n]
    @Test
    public void test2N() {
        boolean checkState;
        fillWithRandomValues(VALUES_TO_TEST);
        for(int i = 0; i < VALUES_TO_TEST/2; i++) {
            int initial = heap.get(i);
            int j = 2*i;
            int val2N = heap.get(j);

            if(initial > val2N) {

                checkState = false;
                assertFalse(checkState);
            }

        }
        checkState = true;
        assertTrue(checkState);

    }

    //Test for property array[n] = array[2*n +1]
    @Test
    public void testCase2() {
        boolean checkState;
        fillWithRandomValues(VALUES_TO_TEST);
        for(int i = 0; i < VALUES_TO_TEST/2; i++) {
            int initial = heap.get(i);
            int j = (2*i) + 1;
            int val = heap.get(j);

            if(initial > val) {
                checkState = false;
                assertFalse(checkState);
            }
        }

        checkState = true;
        assertTrue(checkState);
    }



    private boolean invariantHolds() {

        Integer top = heap.peek();

        if (top == null) {

            return true;

        }



        Integer[] contents = new Integer[heap.size()];

        Integer min = Collections.min(Arrays.asList(heap.toArray(contents)));

        if (min > top) {

            System.out.println("Whoops!");

        }

        return min <= top;

    }



    private void fillWithRandomValues(long numValues) {

        for (int i = 0; i < numValues; i++){

            heap.add(random.nextInt());

        }

    }

}
