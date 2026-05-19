package com.example.android.jaldi5;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import static org.junit.Assert.*;

public class LogicUnitTest {

    @Test
    public void testRandomNumberRange() {
        Random r = new Random();
        for (int i = 0; i < 1000; i++) {
            int genNumber = (r.nextInt(90) + 1);
            assertTrue("Number " + genNumber + " out of range", genNumber >= 1 && genNumber <= 90);
        }
    }

    @Test
    public void testUniqueNumberGeneration() {
        ArrayList<Integer> numbList = new ArrayList<>();
        Random r = new Random();

        while (numbList.size() < 90) {
            int genNumber = (r.nextInt(90) + 1);
            if (!numbList.contains(genNumber)) {
                numbList.add(genNumber);
            }
        }

        assertEquals(90, numbList.size());
        Collections.sort(numbList);
        for (int i = 1; i <= 90; i++) {
            assertEquals(Integer.valueOf(i), numbList.get(i-1));
        }
    }
}
