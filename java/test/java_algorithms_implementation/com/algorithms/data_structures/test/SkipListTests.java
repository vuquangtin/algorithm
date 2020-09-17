package com.algorithms.data_structures.test;

import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Test;

import com.algorithms.data_structures.SkipList;
import com.algorithms.data_structures.test.common.JavaCollectionTest;
import com.algorithms.data_structures.test.common.SetTest;
import com.algorithms.data_structures.test.common.Utils;
import com.algorithms.data_structures.test.common.Utils.TestData;

public class SkipListTests {

    @Test
    public void testSkipList() {
        TestData data = Utils.generateTestData(1000);

        String sName = "SkipList";
        SkipList<Integer> sList = new SkipList<Integer>();
        Collection<Integer> lCollection = sList.toCollection();

        assertTrue(SetTest.testSet(sList, sName,
                                   data.unsorted, data.invalid));
        assertTrue(JavaCollectionTest.testCollection(lCollection, Integer.class, sName,
                                                     data.unsorted, data.sorted, data.invalid));
    }
}
