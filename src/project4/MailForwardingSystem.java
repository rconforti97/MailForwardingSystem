/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project4;

import java.util.*;

/**
 *
 * @author Rachel Conforti
 * @version 1.0
 */
public class MailForwardingSystem extends UserInformation {

    /**
     * @param customerHashMap general HM for class
     */
    HashMap<String, UserInformation> customerHashMap = new HashMap<>();

    /**
     * @param customerInformation general UserInformation variable for class
     */
    UserInformation customerInformation = new UserInformation();

    /**
     * Basic constructor. It will create a empty HashMap and a UserInformation
     * will null values.
     */
    public MailForwardingSystem() {
        customerHashMap = new HashMap<>();
        customerInformation = new UserInformation();
    }

    /**
     * Constructor that will take in parameters. Will populate the
     * customerInformation with the information to make a userInformation
     * variable. It will put the customer name into the HashMap.
     *
     * @param inName the name of the customer
     * @param inOldAddress the old address
     * @param inNewAddress the new forwarding address
     */
    public MailForwardingSystem(String inName, String inOldAddress, String inNewAddress) {
        customerInformation = new UserInformation(inOldAddress, inNewAddress);
        // Set the HashMap as Rachel Conforti(Key) = (oldAddress, newAddress)
        customerHashMap.put(inName, customerInformation);
    }

    /**
     * This method is adding the customers information into the HashMap. Will
     * return add if it is not a duplicate entry otherwise will indicate that it
     * is and will not add the information.
     *
     * @param customer name of customer
     * @param oldAddress the old address
     * @param newAddress forwarding address
     * @return boolean true or false
     */
    public boolean add(String customer, String oldAddress, String newAddress) {
        UserInformation temp;
        boolean wasItAdded = false;
        // if the HM contains the key customername then enter
        if (customerHashMap.containsKey(customer)) {
            //setting temo to equal the value of the customer
            temp = customerHashMap.get(customer);
            // since add method is boolean it will change the value of wasItAdded
            wasItAdded = temp.add(oldAddress, newAddress);
            if (!wasItAdded) {
                // if it already exists
                System.out.println("Entry already exists");
                //System.out.println("Entry already exists");
            }
        } else {
            //creating a new userInformation to pass into the HM
            temp = new UserInformation(oldAddress, newAddress);
            customerHashMap.put(customer, temp);
            System.out.println("Added");
            wasItAdded = true;
        }
        return wasItAdded;
    }

    /**
     * Remove the entry from the HashMap
     *
     * @param customer customer name
     * @param oldAddress old address
     * @param newAddress forwarding address
     * @return boolean true or false
     */
    public boolean remove(String customer, String oldAddress, String newAddress) {
        UserInformation temp;
        boolean wasItRemoved = false;
        //if the HM contains the customer name enter
        if (customerHashMap.containsKey(customer)) {
            temp = customerHashMap.get(customer);
            // if it contains the name just remove the entry             
            if (temp.containsStorageKey(oldAddress)) {
                temp.remove(oldAddress, newAddress);
                System.out.println("Removed");
                wasItRemoved = true;
            }
            return wasItRemoved;
        } else {
            System.out.println("No such entry exists");
        }
        return wasItRemoved;
    }

    /**
     * Information coming from a piece of mail looking if it needs to be
     * forwarded to a different address
     *
     * @param customer customer name
     * @param address new forwarding address
     * @return String the address the mail should be forwarded too
     */
    public String mail(String customer, String address) {
        UserInformation temp;
        String sendTo = "Send to ";
        // if the HM contains the customer name then enter 
        if (customerHashMap.containsKey(customer)) {
            //setting temp the the value assosciated with the customer
            temp = customerHashMap.get(customer);
            //setting the string to equal the vlaue of the address 
            String fa = temp.getValue(address);
            if (fa == null) {
                fa = address;
            }
            //while it contains the value of FA then it will keep looping
            while (temp.containsStorageKey(fa)) {
                // continuously sets fa to its new self 
                fa = temp.getValue(fa);
            } //return Send to plus whatever FA is set to
            //System.out.println(sendTo + fa);
            address = fa;
            System.out.println(sendTo + address);
            return address;
        }
        return address;
    }

    /**
     * Returns the HashMap to string
     *
     * @return String HashMap to string
     */
    @Override
    public String toString() {
        return customerHashMap.toString();
    }
}
