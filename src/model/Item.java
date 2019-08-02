/*
 * TCSS 305 – Fall 2017
 * Assignment 2 - ShoppingCart
 */

package model;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;

/**
 * This Item class is used to hold various information about the Item. These
 * include the name of the item, the price, quantity required for a bulk
 * discount, and the bulk price itself. All instances of Item will have a
 * default bulk value of 1 with the bulk price being the single price unless
 * otherwise instantiated. This makes Item easier to work with.
 * 
 * @author eduardk
 * @version 10 Oct 2017
 *
 */
public final class Item {

    /**
     * Integer constant used used as the default value for items that are not
     * actually bulk.
     */
    private static final int DEFAULT_BULK_QUANTITY = 1;

    /**
     * The name of the item stored as a String.
     */
    private String myName;

    /**
     * The single price of the item stored as BigDecimal.
     */
    private BigDecimal myPrice;

    /**
     * The amount of this specific item required for the bulk price.
     */
    private int myBulkQuantity;

    /**
     * This is the bulk price for buying multiple items.
     */
    private BigDecimal myBulkPrice;

    /**
     * Constructor with two parameters. Automatically sent to overload constructor
     * to be filled with default bulk and bulk price values. Exception handling is
     * done inside the main constructor.
     * 
     * @param theName the name assigned to this Item
     * @param thePrice the price assigned to this Item
     */
    public Item(final String theName, final BigDecimal thePrice) {
        this(theName, thePrice, DEFAULT_BULK_QUANTITY, thePrice);

    }

    /**
     * The main constructor. Assigns default values for Item with only two
     * parameters sent in. Assigns all values if the instantiation is used with the
     * four parameters.
     * 
     * @param theName the name of the Item
     * @param thePrice the price of the Item
     * @param theBulkQuantity the bulk quantity of the Item
     * @param theBulkPrice the bulk price of the Item
     * @throws NullPointerException if either theName, thePrice, or theBulkPrice is
     *             null
     * @throws IllegalArgumentException if theName is empty or if either thePrice,
     *             theBulkQuantity, or theBulkPrice is less that zero
     */
    public Item(final String theName, final BigDecimal thePrice, final int theBulkQuantity,
                final BigDecimal theBulkPrice) {
        Objects.requireNonNull(theName);
        Objects.requireNonNull(thePrice);
        Objects.requireNonNull(theBulkPrice);
        if (theName.isEmpty() || (BigDecimal.ZERO.compareTo(thePrice) > 0)
            || (theBulkQuantity < 1) || (BigDecimal.ZERO.compareTo(theBulkPrice) > 0)) {
            throw new IllegalArgumentException();
        }
        myName = theName;
        myPrice = thePrice;
        myBulkQuantity = theBulkQuantity;
        myBulkPrice = theBulkPrice;
    }

    /**
     * Getter method for the price of the item.
     * 
     * @return the price of the item
     */
    public BigDecimal getPrice() {
        return myPrice;
    }

    /**
     * Getter method for the bulk quantity.
     * 
     * @return the bulk quantity of the Item
     */
    public int getBulkQuantity() {
        return myBulkQuantity;
    }

    /**
     * Getter method for the bulk price.
     * 
     * @return the bulk price of the Item
     */
    public BigDecimal getBulkPrice() {
        return myBulkPrice;
    }

    /**
     * Method to get the bulk boolean. If the quantity is greater than the default
     * then the boolean is true.
     * 
     * @return true if myBulkQuantity is greater than one.
     */
    public boolean isBulk() {
        return myBulkQuantity > 1;
    }

    /**
     * Overridden method to print various information about Item (such as myName,
     * myPrice, myBulkQuantity, and myBulkPrice).
     * 
     * @return string representation of instance fields of Item.
     */
    @Override
    public String toString() {
        final NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
        final StringBuilder sb = new StringBuilder();
        sb.append(myName);
        sb.append(", ");
        sb.append(nf.format(myPrice));
        if (this.isBulk()) {
            sb.append(" (");
            sb.append(myBulkQuantity);
            sb.append(" for ");
            sb.append(nf.format(myBulkPrice));
            sb.append(')');
        }
        return sb.toString();
    }

    /**
     * Overridden method that compares Items based on class fields (myName, myPrice,
     * myBulkQuantity, myBulkPrice).
     * 
     * @return true if they are the same, false if they are not
     */
    @Override
    public boolean equals(final Object theOther) {
        boolean result = false;
        if ((theOther != null) && (theOther.getClass() == this.getClass())) {
            final Item otherItem = (Item) theOther;
            result = myName.equals(otherItem.myName) && myPrice.equals(otherItem.myPrice)
                     && myBulkQuantity == otherItem.myBulkQuantity
                     && myBulkPrice.equals(otherItem.myBulkPrice);
        }
        return result;
    }

    /**
     * Overridden method that creates hash based on Item class fields (myName,
     * myPrice, myBulkQuantity, myBulkPrice). Is consistent with equals() method.
     * 
     * @return integer representation of hash for this Item.
     */
    @Override
    public int hashCode() {
        return Objects.hash(myName, myPrice, myBulkQuantity, myBulkPrice);
    }
}