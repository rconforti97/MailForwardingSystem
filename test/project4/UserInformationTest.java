/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project4;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rachel
 * @version 1.0
 *
 */
public class UserInformationTest {

    /**
     * @param oldAddress stores the oldAddress
     */
    String oldAddress = "1357 Foxboro Drive, Florida, FL 33511";

    /**
     * @param testString test string
     */
    String testString = "6925 University City Blvd Ste 440, Charlotte, NC 28262";

    /**
     * @param newAddress stored forwarding address
     */
    String newAddress = "6939 Brachnell View Drive, Charlotte, NC 28269";

    /**
     * @param name my name
     */
    String name = "Rachel Conforti";

    /**
     * @param testSet general UI HashMap to use through out.
     */
    UserInformation testSet = new UserInformation(oldAddress, newAddress);

    /**
     * Test of containsStorageKey method, of class UserInformation.
     */
    @Test
    public void testContainsStorageKey() {
        System.out.println("Testing containsStorageKey");
        System.out.println("Printing the hashmap: " + testSet.toString()
                + "\nThe key for the hashmap is: " + oldAddress);
        System.out.println("Using the containsStorageKey method it says are key stated above is: "
                + testSet.containsStorageKey(oldAddress));
        assertEquals(testSet.containsStorageKey(oldAddress), true);
    }

    /**
     * Test of getValue method, of class UserInformation.
     */
    @Test
    public void testGetValue() {
        System.out.println("Testing getValue");
        System.out.println("Creating HashMap: " + testSet.toString());
        System.out.println("Using the getValue it will return just the forwarding address: "
                + testSet.getValue(oldAddress));
        assertEquals(newAddress, "6939 Brachnell View Drive, Charlotte, NC 28269");

    }

    /**
     * Test of add method, of class UserInformation.
     */
    @Test
    public void testAdd() {
        System.out.println("Testing add");
        System.out.println("The current set is: " + testSet.toString());
        System.out.println("Adding the same information into the set will prompt false. Result: "
                + testSet.add(oldAddress, newAddress));
        boolean expResultFalse = testSet.add(oldAddress, newAddress);
        assertFalse(expResultFalse);
        boolean expResultTrue = testSet.add("123", "456");
        System.out.println("Adding new informaiton into the set will prompt true. Proof: "
                + expResultTrue);
        assertTrue(expResultTrue);
    }

    /**
     * Test of remove method, of class UserInformation.
     */
    @Test
    public void testRemove() {
        System.out.println("Test remove");
        System.out.println("The current set is: " + testSet.toString());
        boolean expResultTrue = testSet.remove(oldAddress, newAddress);
        System.out.println("Removing using the information above should prompt true. Result: "
                + expResultTrue);
        assertTrue(expResultTrue);
        boolean expResultFalse = testSet.remove("123", "456");
        System.out.println(
                "Removing using the information that was never added should prompt true. Proof: "
                + expResultFalse);
        assertFalse(expResultFalse);
    }

    /**
     * Test of toString method, of class UserInformation.
     */
    @Test
    public void testToString() {
        System.out.println("Testing toString");
        System.out.println("What prints out using the method: " + testSet.toString());
        String expResult = testSet.toString();
        assertEquals(expResult, testSet.toString());
    }

}
