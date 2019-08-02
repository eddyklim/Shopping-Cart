/*
 * TCSS 305 – Fall 2017
 * Assignment 2 - ShoppingCart
 */

package tests;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import model.Item;
import org.junit.Before;
import org.junit.Test;

/**
 * Set of test cases for the Item Class.
 * 
 * @author eduardk
 * @version 9 Oct 2017
 *
 */
public class ItemTest {

    /**
     * This is the test Item to be initialized with 2 parameters 
     * (used to test default values).
     */
    private Item myTestItem;

    /**
     * This is the test Item to be initialized with 4 parameters.
     */
    private Item myTestBulkItem;

    /**
     * This initializes the object tested before each test.
     */
    @Before
    public void setUp() {
        myTestItem = new Item("SingleItem", new BigDecimal("3.99"));
        myTestBulkItem = new Item("BulkItem", new BigDecimal("4.99"), 5,
                                  new BigDecimal("25.00"));
    }

    /**
     * Tests if 2 parameter constructor was initialized correctly.
     * 
     * Test method for
     * {@link model.Item#Item(java.lang.String, java.math.BigDecimal)}.
     */
    @Test
    public void testConstructor() {
        assertEquals(new BigDecimal("3.99"), myTestItem.getPrice());
        assertEquals(1, myTestItem.getBulkQuantity());
        assertEquals(new BigDecimal("3.99"), myTestItem.getBulkPrice());
    }

    /**
     * Tests if name is not null.
     * 
     * Test method for
     * {@link model.Item#Item(java.lang.String, java.math.BigDecimal)}.
     */
    @Test(expected = NullPointerException.class)
    public void testConstructorNullName() {
        new Item(null, new BigDecimal("3.99"));
    }

    /**
     * Tests if name is not empty.
     * 
     * Test method for
     * {@link model.Item#Item(java.lang.String, java.math.BigDecimal)}.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorEmptyName() {
        new Item("", new BigDecimal("3.99"));
    }

    /**
     * Tests if price is not null.
     * 
     * Test method for
     * {@link model.Item#Item(java.lang.String, java.math.BigDecimal)}.
     */
    @Test(expected = NullPointerException.class)
    public void testConstructorNullPrice() {
        new Item("myTestItem", null);
    }

    /**
     * Tests if price is not negative.
     * 
     * Test method for
     * {@link model.Item#Item(java.lang.String, java.math.BigDecimal)}.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNegativePrice() {
        new Item("myTestItem", new BigDecimal("-1.00"));
    }

    /**
     * Tests if overload constructor initialized correctly.
     * 
     * Test method for
     * {@link model.Item#Item(java.lang.String, 
     * java.math.BigDecimal, int, java.math.BigDecimal)}.
     */
    @Test
    public void testConstructorOverload() {
        assertEquals(new BigDecimal("4.99"), myTestBulkItem.getPrice());
        assertEquals(5, myTestBulkItem.getBulkQuantity());
        assertEquals(new BigDecimal("25.00"), myTestBulkItem.getBulkPrice());
    }

    /**
     * Tests if overload constructor name is not null.
     * 
     * Test method for
     * {@link model.Item#Item(java.lang.String, 
     * java.math.BigDecimal, int, java.math.BigDecimal)}.
     */
    @Test(expected = NullPointerException.class)
    public void testConstructorOverloadNullName() {
        new Item(null, new BigDecimal("3.99"), 5, new BigDecimal("25.00"));
    }

    /**
     * Tests if overload constructor name is not empty.
     * 
     * Test method for
     * {@link model.Item#Item(java.lang.String, 
     * java.math.BigDecimal, int, java.math.BigDecimal)}.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorOverloadEmptyName() {
        new Item("", new BigDecimal("3.99"), 5, new BigDecimal("25.00"));
    }

    /**
     * Tests if overload constructor price is not null.
     * 
     * Test method for
     * {@link model.Item#Item(java.lang.String, 
     * java.math.BigDecimal, int, java.math.BigDecimal)}.
     */
    @Test(expected = NullPointerException.class)
    public void testConstructorOverloadNullPrice() {
        new Item("myTestBulkItem", null, 5, new BigDecimal("25.00"));
    }

    /**
     * Tests if overload constructor price is not negative.
     * 
     * Test method for
     * {@link model.Item#Item(java.lang.String, 
     * java.math.BigDecimal, int, java.math.BigDecimal)}.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorOverloadNegativePrice() {
        new Item("myTestBulkItem", new BigDecimal("-3.99"), 5, new BigDecimal("25.00"));
    }

    /**
     * Tests if overload constructor bulk quantity is not negative.
     * 
     * Test method for
     * {@link model.Item#Item(java.lang.String, 
     * java.math.BigDecimal, int, java.math.BigDecimal)}.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorOverloadNegativeBulkQuantity() {
        new Item("myTestBulkItem", new BigDecimal("3.99"), -1, new BigDecimal("25.00"));
    }

    /**
     * Tests if overload constructor bulk price is not null.
     * 
     * Test method for
     * {@link model.Item#Item(java.lang.String, 
     * java.math.BigDecimal, int, java.math.BigDecimal)}.
     */
    @Test(expected = NullPointerException.class)
    public void testConstructorOverloadNullBulkPrice() {
        new Item("myTestBulkItem", new BigDecimal("3.99"), 5, null);
    }

    /**
     * Tests if overload constructor bulk price is not negative.
     * 
     * Test method for
     * {@link model.Item#Item(java.lang.String, 
     * java.math.BigDecimal, int, java.math.BigDecimal)}.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorOverloadNegativeBulkPrice() {
        new Item("myTestBulkItem", new BigDecimal("3.99"), 5, new BigDecimal("-1.00"));
    }

    /**
     * Tests getter method for price.
     * 
     * Test method for {@link model.Item#getPrice()}.
     */
    @Test
    public void testGetPrice() {
        assertEquals(new BigDecimal("3.99"), myTestItem.getPrice());
        assertEquals(new BigDecimal("4.99"), myTestBulkItem.getPrice());
    }

    /**
     * Tests getter method for bulk quantity.
     * 
     * Test method for {@link model.Item#getBulkQuantity()}.
     */
    @Test
    public void testGetBulkQuantity() {
        assertEquals(1, myTestItem.getBulkQuantity());
        assertEquals(5, myTestBulkItem.getBulkQuantity());
    }

    /**
     * Tests getter method for bulk price.
     * 
     * Test method for {@link model.Item#getBulkPrice()}.
     */
    @Test
    public void testGetBulkPrice() {
        assertEquals(new BigDecimal("3.99"), myTestItem.getBulkPrice());
        assertEquals(new BigDecimal("25.00"), myTestBulkItem.getBulkPrice());
    }

    /**
     * Tests if items are bulk.
     * 
     * Test method for {@link model.Item#isBulk()}.
     */
    @Test
    public void testIsBulk() {
        assertEquals(false, myTestItem.isBulk());
        assertEquals(true, myTestBulkItem.isBulk());
    }

    /**
     * Tests if toString output follows format. 
     * 
     * Test method for {@link model.Item#toString()}.
     */
    @Test
    public void testToString() {
        assertEquals("SingleItem, $3.99", myTestItem.toString());
        assertEquals("BulkItem, $4.99 (5 for $25.00)", myTestBulkItem.toString());
    }

    /**
     * Tests if Item is equal.
     * 
     * Test method for {@link model.Item#equals(java.lang.Object)}.
     */
    @Test
    public void testEqualsObject() {
        assertEquals(myTestItem, myTestItem);
        assertEquals(myTestBulkItem, myTestBulkItem);
        assertNotEquals(myTestItem, null);
        assertNotEquals(myTestItem, BigDecimal.ZERO);
        final Item testItem2 = new Item("SingleItem", new BigDecimal("3.99"));
        assertEquals(myTestItem, testItem2);
        assertEquals(testItem2, myTestItem);
        assertFalse(myTestItem.equals(new Item("RandomItem", new BigDecimal("3.99"))));
        assertFalse(myTestItem.equals(new Item("SingleItem", new BigDecimal("2.99"))));
        assertFalse(myTestBulkItem.equals(new Item("BulkItem", new BigDecimal("4.99"), 4,
                                                   new BigDecimal("25.00"))));
        assertFalse(myTestBulkItem.equals(new Item("BulkItem", new BigDecimal("4.99"), 5,
                                                   new BigDecimal("20.00"))));
    }

    /**
     * Tests if hashCode works.
     * 
     * Test method for {@link model.Item#hashCode()}.
     */
    @Test
    public void testHashCode() {
        assertEquals(myTestItem.hashCode(),
                     new Item("SingleItem", new BigDecimal("3.99")).hashCode());
        assertEquals(myTestBulkItem.hashCode(),
                     new Item("BulkItem", new BigDecimal("4.99"), 5, 
                              new BigDecimal("25.00")).hashCode());
        assertNotEquals(myTestBulkItem.hashCode(),
                     new Item("BulkItems", new BigDecimal("4.99"), 5, 
                              new BigDecimal("25.00")).hashCode());
        assertNotEquals(myTestBulkItem.hashCode(),
                        new Item("BulkItem", new BigDecimal("5.99"), 5, 
                                 new BigDecimal("25.00")).hashCode());
        assertNotEquals(myTestBulkItem.hashCode(),
                        new Item("BulkItem", new BigDecimal("4.99"), 6, 
                                 new BigDecimal("25.00")).hashCode());
        assertNotEquals(myTestBulkItem.hashCode(),
                        new Item("BulkItem", new BigDecimal("4.99"), 5, 
                                 new BigDecimal("26.00")).hashCode());
    }
}
