package com.beraldo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);
        boolean running = true;
        List<Product> productList = new ArrayList<>();
        while(running){
            String menu = """
                    0   -   exit
                    1   -   add
                    2   -   remove
                    3   -   list
                    """;
            System.out.println(menu);
            int chose = scann.nextInt();
            scann.nextLine();
            switch (chose){
                case 1:
                    System.out.println("Adding list");
                    System.out.println("Name the item");
                    String item = scann.nextLine();
                    productList.add(new Product(item));
                    break;
                case 2:
                    System.out.println("Remove item");
                    IntStream.range(0, productList.size())
                            .forEach(l -> System.out.println((l+1) + ": " + productList.get(l).name()));
                    int index = scann.nextInt();
                    if (index >= 0 && index < productList.size()) {
                        productList.remove(index);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case 3:
                    System.out.println("List item");
                    IntStream.range(0, productList.size())
                            .forEach(l -> System.out.println((l+1) + ": " + productList.get(l).name()));
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
}
