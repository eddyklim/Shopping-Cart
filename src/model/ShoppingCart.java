/*
 * TCSS 305 – Fall 2017
 * Assignment 2 - ShoppingCart
 */

package model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/**
 * This class uses a map to store ItemOrders and also calculates the total price
 * of the order.
 * 
 * @author eduardk
 * @version 11 Oct 2017
 */
public class ShoppingCart {
    
    /**
     * Collection of all ItemOrders using a Map.
     */
    private final Map<Item, ItemOrder> myCart;

    /**
     * Membership status.
     */
    private boolean myMembership;

    /**
     * Constructor method, creates new HaspMap.
     */
    public ShoppingCart() {
        myCart = new HashMap<Item, ItemOrder>();
    }
    
    /**
     * Adds an ItemOrder to the cart.
     *
     * @param theOrder item order
     */
    public void add(final ItemOrder theOrder) {
        Objects.requireNonNull(theOrder);
        myCart.put(theOrder.getItem(), theOrder);
    }

    /**
     * Setter method for membership status.
     * 
     * @param theMembership true if member, false otherwise
     */
    public void setMembership(final boolean theMembership) {
        myMembership = theMembership;
    }

    /**
     * Calculates the total cost of the entire cart.
     * 
     * @return total cost of cart
     */
    public BigDecimal calculateTotal() {
        BigDecimal cartTotal = BigDecimal.ZERO;
        final Iterator<Item> iterator = myCart.keySet().iterator();
        while (iterator.hasNext()) {
            cartTotal = cartTotal.add(orderTotal(myCart.get(iterator.next())));
        }
        return cartTotal.setScale(2, RoundingMode.HALF_EVEN);
    }

    /**
     * Clears all keys and values of the HashMap.
     */
    public void clear() {
        myCart.clear();
    }

    /**
     * Helper method to calculate the total.
     * 
     * @param theItemOrder takes in this order
     * @return the total cost of the ItemOrder
     */
    private BigDecimal orderTotal(final ItemOrder theItemOrder) {
        BigDecimal total = BigDecimal.ZERO;
        if (!myMembership
            || theItemOrder.getQuantity() < theItemOrder.getItem().getBulkQuantity()) {
            total = theItemOrder.getItem().getPrice().multiply
                            (new BigDecimal(theItemOrder.getQuantity()));
        } else {
            final int numOfBulk = theItemOrder.getQuantity()
                                  / theItemOrder.getItem().getBulkQuantity();
            final int numOfLeftover = theItemOrder.getQuantity()
                                      % theItemOrder.getItem().getBulkQuantity();
            total = theItemOrder.getItem().getBulkPrice().multiply(new BigDecimal
            (numOfBulk)).add(theItemOrder.getItem().getPrice().multiply
                             (new BigDecimal(numOfLeftover)));
        }
        return total;
    }

    /**
     * Prints out all the contents of the shopping cart.
     * 
     * @return string representation of the whole cart
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        final Iterator<Item> iterator = myCart.keySet().iterator();
        while (iterator.hasNext()) {
            sb.append(myCart.get(iterator.next()).toString());
        }
        return sb.toString();
    }
}
