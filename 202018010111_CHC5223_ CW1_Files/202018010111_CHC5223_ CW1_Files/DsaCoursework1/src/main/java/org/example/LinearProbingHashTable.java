package org.example;
import java.io.*;
import java.util.*;

    // Java Program to Implement Hash Tables with Linear Probing
//class - LinearProbingHashTable
    class LinearProbingHashTable {
        // Member variables of this class
        private int currentSize, maxSize;
        private String[] vals;
        // Constructor of this class
        public LinearProbingHashTable(int capacity) {
            currentSize = 0;
            maxSize = capacity;
            vals = new String[maxSize];
        }

        // Method 1
        // Function to clear hash table
        public void makeEmpty() {
            currentSize = 0;
            vals = new String[maxSize];
        }

        // Method 2
        // Function to get the size of the hash table
        public int getSize() {return currentSize;
        }

        // Method 3
        // Function to check if the hash table is full
        public boolean isFull() {
            return currentSize == maxSize;
        }

        // Method 4
        // Function to check if the hash table is empty
        public boolean isEmpty() {
            return getSize() == 0;
        }

        // Method 5
        // Function to check if the hash table contains a value
        public boolean contains(String value) {
            return get(value) != null;
        }
        // Method 6
        // Function to get the hash code of a given string



        private int hash(String value) {
//            int hashcode=0;
//            for(int i=0;i<value.length();i++){
//                hashcode+=value.charAt(i);
//            }
//            hashcode=hashcode%maxSize;
//            return hashcode;
            int hashcode=0;
        for(int i=0;i<value.length();i++){
            hashcode+=value.charAt(i)*Math.pow(10,i+1);
        }
        hashcode=hashcode%maxSize;
        return hashcode;
        }

        // Method 7
        // Function to insert value
        public void insert(String value) {
            int tmp = hash(value);
            int i = tmp;


            while (vals[i] != null )  {

                if (vals[i].equals(value)){
                    System.out.println("The value has been exsited");
                    return;
                }
                i++;
                if (i == maxSize) {
                    i = 0;
                }
                if (i == tmp) {
                    return;
                }


            }
            vals[i] = value;
            currentSize++;
        }



        // Method 8
        // Function to get value for the given key
        public String get(String key)
        {
            int tmp = hash(key);
            int i = tmp;


            while (vals[i] != null && !vals[i].equals(key)) {
                i++;
                if (i == maxSize) {
                    i = 0;
                }
                if (i == tmp) {
                    return null;
                }
            }
            return vals[i];
        }

        // Method 9
        // Function to remove the value
        public void remove(String value) {
            int tmp = hash(value);
            int i = tmp;
            if(vals[i]==null){
                System.out.println("This value don't exist in hash table");
            }

            while (vals[i] != null && !vals[i].equals(value)) {
                if (i == maxSize) {
                    i = 0;
                }
                if (i == tmp) {
                    System.out.println("This value don't exist in hash table");
                    return;
                }
                i++;
            }
            vals[i]=null;
            currentSize--;
        }



        // Method 10
        // Function to print the whole HashTable
        public void printHashTable() {
            System.out.println("\nHash Table: ");
            for (int i = 0; i < maxSize; i++) {
                    System.out.println(i + " " + vals[i]);


            }
            System.out.println("Load factor: "+(double)currentSize/maxSize*100+"%");
        }}


