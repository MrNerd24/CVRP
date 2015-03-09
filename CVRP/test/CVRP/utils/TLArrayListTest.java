/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CVRP.utils;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Juuso
 */
public class TLArrayListTest {
    
    private static TLArrayList<Integer> list;
    
    @BeforeClass
    public static void setUpClass() {
        list = new TLArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGet() {
        int index = 2;
        TLArrayList instance = list;
        Integer expResult = 3;
        Integer result = (Integer) instance.get(index);
        assertEquals(expResult, result);
    }

    @Test
    public void testAdd() {
        Integer item = 5;
        TLArrayList instance = list;
        instance.add(item);
        assertEquals(item, list.get(4));
    }

    @Test
    public void testSet() {
        int index = 0;
        Integer item = 10;
        TLArrayList instance = list;
        instance.set(index, item);
        assertEquals(item, list.get(index));
    }

    @Test
    public void testRemove_GenericType() {
        Integer item = 3;
        TLArrayList instance = list;
        int expResult = 2;
        int result = instance.remove(item);
        assertEquals(expResult, result);
    }

    @Test
    public void testRemove_int() {
        int index = 0;
        TLArrayList instance = new TLArrayList();
        Object expResult = null;
        Object result = instance.remove(index);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testContains() {
        System.out.println("contains");
        Object item = null;
        TLArrayList instance = new TLArrayList();
        boolean expResult = false;
        boolean result = instance.contains(item);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testClear() {
        System.out.println("clear");
        TLArrayList instance = new TLArrayList();
        instance.clear();
        fail("The test case is a prototype.");
    }

    @Test
    public void testIndexOf() {
        System.out.println("indexOf");
        Object item = null;
        TLArrayList instance = new TLArrayList();
        int expResult = 0;
        int result = instance.indexOf(item);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        TLArrayList instance = new TLArrayList();
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testToArray() {
        System.out.println("toArray");
        TLArrayList instance = new TLArrayList();
        Object[] expResult = null;
        Object[] result = instance.toArray();
        assertArrayEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSize() {
        System.out.println("size");
        TLArrayList instance = new TLArrayList();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
