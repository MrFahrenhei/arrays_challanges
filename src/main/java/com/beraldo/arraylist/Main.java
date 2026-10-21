package com.beraldo.arraylist;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);
        boolean running = true;
        ProductList listing = new ProductList();
        while(running){
            String menu = """
                    0   -   exit
                    1   -   add
                    2   -   remove
                    3   -   list
                    """;
            int chose = readInt(scann, menu);
            switch (chose){
                case 1:
                    while(true) {
                        System.out.println("Adding...");
                        System.out.println("Name the item");
                        String itemName = scann.nextLine();
                        int quantity = readInt(scann, "Quantity");
                        try {
                            listing.addItem(new Product(itemName, quantity));
                            break;
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case 2:
                    System.out.println("Remove item");
                    if(listing.isEmpty()){
                        System.out.println("Nothing to show");
                    }else {
                        IntStream.range(0, listing.getSize())
                                .forEach(l -> System.out.println((l + 1) + ": " + listing.getItem(l)));
                        int index = readInt(scann, "Quantity") - 1;
                        if (index >= 0 && index < listing.getSize()) {
                            listing.removeItem(index);
                        } else {
                            System.out.println("Invalid index");
                        }
                    }
                    break;
                case 3:
                    System.out.println("List item");
                    if(listing.isEmpty()){
                        System.out.println("Is empty");
                    }else{
                        listing.listItems();
                    }
                    break;
                case 0:
                    System.out.println("exiting");
                    running = false;
                    break;
                default:
                    System.out.println("Wrong number");
            }
        }
        System.out.println("ended");
    }
    private static int readInt(Scanner scanner, String prompt){
        System.out.println(prompt);
        while(!scanner.hasNextInt()){
            System.out.println("This is not allowed, only numbers");
            scanner.next();
        }
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }
}
