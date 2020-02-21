/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project4;

import java.util.Scanner;

/**
 *
 * @author Rachel Conforti
 * @version 1.0
 */
public class Project4 extends MailForwardingSystem {

    /**
     * This is a basic constructor 
     */
    public Project4() {
        //this is a "constructor" (to satisfy webcat)
    }

    /**
     * Main
     *
     * @param args the main method
     */
    public static void main(String[] args) {
        MailForwardingSystem test = new MailForwardingSystem();
        String name;
        String oldAddress;
        String newAddress;

        Scanner keyboard = new Scanner(System.in);
        //keyboard.nextLine();

        String input;
        while (true) {
            input = keyboard.nextLine();
            if (input.equalsIgnoreCase("QUIT")) {
                System.out.println("Goodbye");
                break;
            } else if (input.equalsIgnoreCase("ADD")) {
                name = keyboard.nextLine();
                oldAddress = keyboard.nextLine();
                newAddress = keyboard.nextLine();
                test.add(name, oldAddress, newAddress);
            } else if (input.equalsIgnoreCase("MAIL")) {
                name = keyboard.nextLine();
                oldAddress = keyboard.nextLine();
                test.mail(name, oldAddress);
            } else if (input.equalsIgnoreCase("REMOVE")) {
                name = keyboard.nextLine();
                oldAddress = keyboard.nextLine();
                newAddress = keyboard.nextLine();
                test.remove(name, oldAddress, newAddress);
            }
        }
    }
}
