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
 */
public class MailForwardingSystemTest {

    /**
     * @param testMFS1 general Mail forwarding system instance
     */
    MailForwardingSystem testMFS1 = new MailForwardingSystem();

    /**
     * Basic constructor test
     */
    @Test
    public void testMailForwardingSystem() {
        System.out.println(testMFS1.toString());
        assertEquals(testMFS1.toString(), "{}");
        MailForwardingSystem testTwo = new MailForwardingSystem("rachel", "1", "2");
        System.out.println(testTwo.toString());
        assertEquals(testTwo.toString(), "{rachel={1=2}}");
    }

    /**
     * Test of add method, of class MailForwardingSystem.
     */
    @Test
    public void testAdd() {
        boolean expResult;
        System.out.println("Testing add - MailForwardingSystem");
        System.out.println("Printing out testMFS1: " + testMFS1.toString());
        expResult = testMFS1.add("Will Smith", "123", "456");
        assertTrue(expResult);
        expResult = testMFS1.add("Rachel Conforti", "789", "1011");
        assertTrue(expResult);
        System.out.println("After using the add method testMFS1 reprinted: " + testMFS1.toString());
        expResult = testMFS1.add("Will Smith", "123", "456");
        assertFalse(expResult);
        testMFS1.add("a", "1", "2");
        testMFS1.add("a", "2", "3");
        testMFS1.add("a", "3", "4");
        System.out.println(testMFS1 + "\n Adding duplicate entries");
        testMFS1.add("a", "3", "4");
        testMFS1.add("a", "1", "2");
    }

    /**
     * Test of remove method, of class MailForwardingSystem.
     */
    @Test
    public void testRemove() {
        boolean expResult;
        System.out.println("Testing Remove - MailForwardingSystem");
        System.out.println("\nPrinting out testMFS1: " + testMFS1.toString());

        testMFS1.remove("Rachel Conforti", "1011", "789");
        testMFS1.add("Will Smith", "123", "456");
        testMFS1.add("Rachel Conforti", "789", "1011");
        System.out.println("After add: "
                + testMFS1.toString());

        System.out.println("\nRemove Will");
        expResult = testMFS1.remove("Will Smith", "123", "456");
        assertTrue(expResult);
        System.out.println("testMFS1 after removing Will: " + testMFS1.toString());

        System.out.println("\nRemove Rachel");
        expResult = testMFS1.remove("Rachel Conforti", "789", "1011");
        assertTrue(expResult);
        System.out.println("testMFS1 after removing Rachel: " + testMFS1.toString());

        System.out.println("\nRemove non existant entry - Sarah Williams");
        expResult = testMFS1.remove("Sarah Williams", "111", "222");
        assertFalse(expResult);

        System.out.println("\nAdding 5 instances of bane and pritning below:");
        testMFS1.add("bane", "1", "2");
        testMFS1.add("bane", "2", "3");
        testMFS1.add("bane", "3", "4");
        testMFS1.add("bane", "4", "5");
        testMFS1.add("bane", "5", "6");
        System.out.println(testMFS1.toString() + "\nRemoving bane:");
        testMFS1.remove("bane", "1", "2");
        System.out.println("testMFS1 after  remove: ");
        System.out.println(testMFS1.toString());
        System.out.println("Attempting to remove again:");
        testMFS1.remove("bane", "1", "2");

        testMFS1.add("user", "123", "456");
        testMFS1.add("user", "456", "789");
        testMFS1.mail("user", "123");
        testMFS1.mail("user", "456");
        testMFS1.remove("user", "123", "456");

    }

    /**
     * Test of mail method, of class MailForwardingSystem.
     */
    @Test
    public void testMail() {
        System.out.println("Testing Mail - MailForwardingSystem");
        //Add - p1, a1, a2
        testMFS1.add("p1", "a1", "a2");
        System.out.println(testMFS1.toString());
        //Add - p1, a2, a3
        testMFS1.add("p1", "a2", "a3");
        System.out.println(testMFS1.toString());
        //Add - p1, a3, a4
        testMFS1.add("p1", "a3", "a4");
        System.out.println(testMFS1.toString());
        //Add - p1, a5, a6
        testMFS1.add("p1", "a5", "a6");
        System.out.println(testMFS1.toString());
        //Add - p1, a6, a7
        testMFS1.add("p1", "a6", "a7");
        System.out.println(testMFS1.toString());
        //Add - p2, a1, a3
        testMFS1.add("p2", "a1", "a3");
        System.out.println(testMFS1.toString());
        //Add - p2, a3, a4
        testMFS1.add("p2", "a3", "a4");
        System.out.println(testMFS1.toString());
        //Add - p3, a4, a3
        testMFS1.add("p3", "a4", "a3");
        System.out.println(testMFS1.toString());

        //Add p1, a2, a9 -> Should result in false case since 
        //a2 is already set up to forward somewhere
        testMFS1.add("p1", "a2", "a9");

        //Mail - p1, a1 -> Should send to a4 (through a2 and a3)
        assertEquals(testMFS1.mail("p1", "a1"), "a4");
        //Mail - p1, a2 -> Should send to a4 (through a3)
        assertEquals(testMFS1.mail("p1", "a2"), "a4");
        //Mail - p1, a4 -> Should send to a4
        assertEquals(testMFS1.mail("p1", "a4"), "a4");
        //Mail - p1, a999 -> Should send to a999
        assertEquals(testMFS1.mail("p1", "a999"), "a999");
        //Mail - p1, a5 -> Should sent to a7 (through a6)
        assertEquals(testMFS1.mail("p1", "a5"), "a7");
        //Mail - p2, a1 -> Should send to a4 (through a3)
        assertEquals(testMFS1.mail("p2", "a1"), "a4");
        //Mail - p2, a3 -> Should send to a4
        assertEquals(testMFS1.mail("p2", "a3"), "a4");
        //Mail - p3, a4 -> Should send to a3
        assertEquals(testMFS1.mail("p3", "a4"), "a3");
    }

    /**
     * Test of toString method, of class MailForwardingSystem.
     */
    @Test
    public void testToString() {
        System.out.println("Testing toString");
        System.out.println("What prints out using the method: " + testMFS1.toString());
        String expResult = testMFS1.toString();
        assertEquals(expResult, testMFS1.toString());
    }

}
