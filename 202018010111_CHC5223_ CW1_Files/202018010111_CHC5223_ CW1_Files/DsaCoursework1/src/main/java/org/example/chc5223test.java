package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class chc5223test {
    // Main driver method
    public static void main(String[] args)
    {
        // Creating a scanner object
        // to take input from user
        Scanner scan = new Scanner(System.in);
        // Display messages
        System.out.println("Hash Table Test");
        System.out.println("Choose the Hash table:");
        System.out.println("1.LinearProbingHashTable");
        System.out.println("2.ChainingHashTable");
        System.out.println("Please enter the choice");
        int hashTableChoice = 0;
        while (true){
            try{
                hashTableChoice = scan.nextInt();
                break;
            }catch (InputMismatchException e){
                System.out.println("Enter again");
                scan.nextLine();
            }
        }

        if (hashTableChoice==1){
        System.out.println("Welcome to LinearProbingHashTable");}
        else{
            System.out.println("Welcome to ChainingHashTable");
        }
        int size;
        scan.nextLine();
        while(true){
            System.out.println("Enter size:");
            if(scan.hasNextInt()){
                size=scan.nextInt();
                break;
            }
            else{
                System.out.println("Wrong input,enter integer");
                scan.nextLine();
            }
        }

        // maxSizeake object of LinearProbingHashTable
//        System.out.println("Enter the capacity of Hashtable");
        LinearProbingHashTable lpht = new LinearProbingHashTable(size);
        ChainingHashTable cnht = new ChainingHashTable(size);
        char ch;
        // Do-while loop
        // Do part for performing actions
        do
        // Menu is displayed
        // LinearProbingHashTable operations performed as
        // per keys Users enter 'y' to continue 'n' if
        // entered by user , the program terminates
        {
            // Menu
            // Display messages
            System.out.println("\nHash Table Operations");
            System.out.println("1. insert ");
            System.out.println("2. remove");
            System.out.println("3. get");
            System.out.println("4. clear");
            System.out.println("5. size");
            // Reading integer using nextInt()

//            int choice =0;
//            while (true){
//                try{
//                    choice = scan.nextInt();
//                    break;
//                }catch (InputMismatchException e){
//                    System.out.println("Enter again");
//                    scan.nextLine();
//                }
//            }
            int choice = scan.nextInt();
            // Switch case
            switch (choice) {
                // Case 1
                case 1:
                    // Display message
                    System.out.println("Enter value");
                    if(hashTableChoice==1) {lpht.insert(scan.next());}
                    else{cnht.insert(scan.next());}

// Break statement to terminate a case
                    break;
                // Case 2
                case 2:
                    // Display message
                    System.out.println("Enter value");
                    if(hashTableChoice==1){
                        lpht.remove(scan.next());}
                    else{cnht.remove(scan.next());}
                    // Break statement to terminate a case
                    break;
                // Case 3
                case 3:
                    // Print statements
                    System.out.println("Enter key");
                    if(hashTableChoice==1){
                        System.out.println("Value = "
                                + lpht.get(scan.next()));}
                    else{
                    System.out.println("Value = "
                            + cnht.get(scan.next()));}
                    // Break statement to terminate a case
                    break;
                // Case 4
                case 4:
                    if(hashTableChoice==1){
                    lpht.makeEmpty();}
                    else {cnht.makeEmpty();}
                    // Print statement
                    System.out.println("Hash Table Cleared\n");
                    // Break statement to terminate a case
                    break;
                // Case 5
                case 5:
                    if(hashTableChoice==1){
                        System.out.println("Size= "+lpht.getSize());}
                    // Print statement


                    else{System.out.println("Size= "+cnht.getSize());}
                    break;
                // Default case
                // Executed when mentioned switch cases are not
                // matched
                default:
                    // Print statement
                    System.out.println("Wrong Entry \n ");
                    // Break statement
                    break;
            }
            // Display hash table
            if(hashTableChoice==1){
                lpht.printHashTable();
            }
            else{cnht.printHashTable();}

            // Display message asking the user whether
            // he/she wants to continue
            System.out.println(
                    "Do you want to continue (Type y or n)");
            // Reading character using charAt() method to
            // fetch
            ch = scan.next().charAt(0);
        } while (ch == 'Y' || ch == 'y');
    }
}
