/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CVRP.utils;

import java.util.Random;
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
    
    TLArrayList<Integer> list = new TLArrayList<>();
    TLArrayList<Integer> list2 = new TLArrayList<>(false);

    public TLArrayListTest() {
        for (int i = 1; i < 20; i++) {
            list.add(i);
            list2.add(i);
        }
    }

    @BeforeClass
    public static void setUpClass() {
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
    public void noErrorsTest() {
        Random random = new Random();
        TLArrayList<Integer> list = new TLArrayList<Integer>(false);
        for (int i = 0; i < 10000; i++) {
            int komento = random.nextInt(13);
            int number;
            int index;
            switch (komento) {
                case 0:
                    if (list.isEmpty()) {
                        break;
                    }
                    number = random.nextInt(list.size());
                    list.get(number);
                    break;
                case 1:
                    number = random.nextInt(1000);
                    list.add(number);
                    break;
                case 2:
                    number = random.nextInt(1000);
                    index = random.nextInt(1000);
                    list.set(index, number);
                    break;
                case 3:
                    number = random.nextInt(1000);
                    list.remove(new Integer(number));
                    break;
                case 4:
                    if (list.isEmpty()) {
                        break;
                    }
                    number = random.nextInt(list.size());
                    list.remove(number);
                    break;
                case 5:
                    number = random.nextInt(1000);
                    list.contains(number);
                    break;
                case 6:
                    list.clear();
                    break;
                case 7:
                    number = random.nextInt(1000);
                    list.indexOf(number);
                    break;
                case 8:
                    list.isEmpty();
                    break;
                case 9:
                    list.toArray();
                    break;
                case 10:
                    list.size();
                    break;
                case 11:
                    if (list.isEmpty()) {
                        break;
                    }
                    TLArrayList.shuffle(list);
                    break;
                case 12:
                    if (list.size() < 2) {
                        break;
                    }
                    TLArrayList.sort(list);
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }

    @Test
    public void testGet() {
        assertEquals(new Integer(5), list.get(4));
        assertEquals(new Integer(15), list.get(14));
    }

    @Test
    public void testAdd() {
        list.add(50);
        list2.add(30);
        
        assertEquals(new Integer(50), list.get(19));
        assertEquals(new Integer(30), list2.get(19));
    }

    @Test
    public void testSet() {
        list.set(6, 42);
        list2.set(9, 1337);
        
        assertEquals(new Integer(42), list.get(6));
        assertEquals(new Integer(1337), list2.get(9));
        
        list.set(42, 6);
        list2.set(1337, 9);
        
        assertEquals(new Integer(6), list.get(42));
        assertEquals(new Integer(9), list2.get(1337));
    }

    @Test
    public void testRemove_GenericType() {
        list.remove(new Integer(7));
        list2.remove(new Integer(13));
        
        assertEquals(new Integer(8), list.get(6));
        assertEquals(null, list2.get(12));
        
        assertEquals(false, list.contains(7));
        assertEquals(false, list2.contains(13));
    }

    @Test
    public void testRemove_int() {
        int index = 5;

        list.remove(index);
        assertEquals(false, list.contains(6));
    }

    @Test
    public void testContains() {

        assertEquals(true, list.contains(5));
        assertEquals(false, list.contains(25));
    }

    @Test
    public void testClear() {
        list.clear();
        assertEquals(false, list.contains(1));
        assertEquals(false, list.contains(4));
        assertEquals(false, list.contains(8));
        assertEquals(false, list.contains(0));
    }

    @Test
    public void testIndexOf() {
        assertEquals(4, list.indexOf(5));
        assertEquals(6, list.indexOf(7));
        assertEquals(12, list.indexOf(13));
    }

    @Test
    public void testIsEmpty() {
        assertEquals(false, list.isEmpty());
        list.remove(5);
        assertEquals(false, list.isEmpty());
        list.clear();
        assertEquals(true, list.isEmpty());
    }

    @Test
    public void testToArray() {
        Integer[] testArray = new Integer[19];
        for (int i = 0; i < 19; i++) {
            testArray[i] = i+1;
        }
        
        assertArrayEquals(testArray, list.toArray());
    }

    @Test
    public void testSize() {
        assertEquals(19, list.size());
        list.remove(4);
        list.remove(7);
        assertEquals(17, list.size());
        list.add(5);
        assertEquals(18, list.size());
    }

    @Test
    public void testSort() {
        TLArrayList<Integer> list = new TLArrayList<Integer>();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            list.add(random.nextInt(100));
        }
        list = TLArrayList.sort(list);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i-1) > list.get(i)) {
                fail(list.get(i) + " > " + list.get(i-1));
            }
        }
    }

    @Test
    public void testShuffle() {
        TLArrayList.shuffle(list);
        boolean notSorted = false;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < list.get(i-1)) {
                notSorted = true;
            }
        }
        if (!notSorted) {
            fail("List was sorted.");
        }
    }

}
