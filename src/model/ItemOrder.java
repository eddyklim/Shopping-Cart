/*
 * TCSS 305 – Fall 2017
 * Assignment 2 - ShoppingCart
 */

package model;

import java.util.Objects;

/**
 * This class holds information about the Item and the quantity of that specific
 * Item.
 * 
 * @author eduardk
 * @version 11 Oct 2017
 */
public final class ItemOrder {

    /**
     * The Item of the ItemOrder.
     */
    private final Item myItem;

    /**
     * The quantity of Item.
     */
    private final int myQuantity;

    /**
     * Default constructor for the order.
     * 
     * @param theItem the Item of the order
     * @param theQuantity the quantity of the Item
     * @throws NullPointerException if theItem is null
     * @throws IllegalArgumentException if theQuantity is < 0
     */
    public ItemOrder(final Item theItem, final int theQuantity) {
        myItem = Objects.requireNonNull(theItem);
        if (theQuantity < 0) {
            throw new IllegalArgumentException();
        }
        myQuantity = theQuantity;
    }

    /**
     * Getter method for Item.
     * 
     * @return the Item.
     */
    public Item getItem() {
        return myItem;
    }

    /**
     * Getter method for quantity of Item.
     * 
     * @return the quantity of Item.
     */
    public int getQuantity() {
        return myQuantity;
    }

    /**
     * Overridden method that compares ItemOrders based on class fields (myItem, myQuantity).
     * 
     * @return true if they are the same, false if they are not
     */
    @Override
    public boolean equals(final Object theOther) {
        boolean result = false;
        if ((theOther != null) && (theOther.getClass() == this.getClass())) {
            final ItemOrder otherItem = (ItemOrder) theOther;
            result = myItem.equals(otherItem.myItem)
                     && myQuantity == otherItem.myQuantity;
        }
        return result;
    }

    /**
     * Overridden method that creates hash based on ItemOrder class fields (myItem,
     * myQuantity). Is consistent with equals() method.
     * 
     * @return integer representation of hash for this Item.
     */
    @Override
    public int hashCode() {
        return Objects.hash(myItem, myQuantity);
    }
    
    /**
     * Overridden method that prints Item and the quantity of Item.
     * 
     * @return string representation of ItemOrder
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(" Item: ");
        sb.append(myItem.toString());
        sb.append(" Quantity: ");
        sb.append(myQuantity);
        return sb.toString();
    }
}
