/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project4;

import java.util.HashMap;

/**
 * This hold the information for the customer such as name, old address, and the
 * new address that they wish to forward their mail to.
 *
 * @author Rachel Conforti
 * @version 1.0
 */
public class UserInformation {

    /**
     * @param addressStorage general empty UserInformation HashMap.
     */
    HashMap<String, String> addressStorage = new HashMap<>();

    /**
     * Basic constructor that sets everything to null
     */
    public UserInformation() {
        addressStorage = new HashMap<>();
    }

    /**
     * Constructor if given the information will create a userInformation with
     * the information stored in it.
     *
     * @param inOldAddress old address
     * @param inNewAddress forwarding address
     */
    public UserInformation(String inOldAddress, String inNewAddress) {
        addressStorage.put(inOldAddress, inNewAddress);
    }

    /**
     * see if the addressStorage contains the key
     *
     * @param inOldAddress the old address
     * @return boolean true or false
     */
    public boolean containsStorageKey(String inOldAddress) {
        return addressStorage.containsKey(inOldAddress);
    }

    /**
     * returns the value from the key
     *
     * @param inOldAddress the old address
     * @return String the value associated with the key
     */
    public String getValue(String inOldAddress) {
        return addressStorage.get(inOldAddress);
    }

    /**
     * you can make an add method that accepts two parameters of old and new
     * addresses and if the hash map contains the old address, then you add the
     * new address
     *
     * @param inOldAddress the old address
     * @param inNewAddress forwarding address
     * @return boolean true if added false if not added
     */
    public boolean add(String inOldAddress, String inNewAddress) {
        boolean wasItAdded = false;
        //if the addressStorage doesnt contain the the oldAddress then add it into
        //address storage and return true
        if (!addressStorage.containsKey(inOldAddress)) {
            addressStorage.put(inOldAddress, inNewAddress);
            wasItAdded = true;
        }
        //if it never entered the if stated it will return false 
        return wasItAdded;
    }

    /**
     * Remove the forwarding address
     *
     * @param inOldAddress old address
     * @param inNewAddress forwarding address
     * @return boolean true if removed false if not
     */
    public boolean remove(String inOldAddress, String inNewAddress) {
        boolean wasItRemoved = false;
        // if the address storage contains the old address then it will remove the entry
        // returns true if it entered the if statement and false if it did not
        //removed a ! from here 
        if (addressStorage.containsKey(inOldAddress)) {
            //addressStorage.remove(inOldAddress, inNewAddress);
            addressStorage.remove(inOldAddress);
            wasItRemoved = true;
        }
        return wasItRemoved;
    }

    /**
     * Returns the customers information as a string.
     *
     * @return oldAddress, newAddress
     */
    @Override
    public String toString() {
        return addressStorage.toString();
    }

}
