/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project4;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Used for testing assignment 4's main method.
 *
 * @author - Tyler Crowe
 * @version 1.0 [Student Free to Use]
 */
public class Project4Test {

    /**
     *
     */
    @Test
    public void testMain() {
        System.out.println("Testing main method");
        final ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
        final PrintStream outOrig = System.out;
        final InputStream inOrig = System.in;
        InputStream commandStream = new ByteArrayInputStream(("ADD\nuser\n123\n456\n"
                + "ADD\nuser\n456\n789\n"
                + "MAIL\nuser\n123\n"
                + "MAIL\nuser\n456\n"
                + "REMOVE\nuser\n123\n456\n"
                + "QUIT").getBytes());
        System.setIn(commandStream);
        System.setOut(new PrintStream(byteOutputStream));
        Project4.main(null);
        String consoleOutput = byteOutputStream.toString();
        assertTrue(consoleOutput.contains("Added"));
        assertTrue(consoleOutput.contains("Send to 789"));
        assertTrue(consoleOutput.contains("Removed"));
        assertTrue(consoleOutput.contains("Goodbye"));
        System.setIn(inOrig);
        System.setOut(outOrig);
        Project4 p4 = new Project4();
        p4.hashCode();
        System.out.println(consoleOutput);
    }
}
