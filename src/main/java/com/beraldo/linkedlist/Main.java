package com.beraldo.linkedlist;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);
        boolean running = true;
        ArrayLinked<Patient> linked = new ArrayLinked<>();
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
                    while(true){
                        System.out.println("Adding...");
                        System.out.println("Patient's name");
                        String name = scann.nextLine();
                        int id = readInt(scann, "Patient's id");
                        System.out.println("Patient's status");
                        String status = scann.nextLine();
                       try{
                           linked.addFirst(new Patient(id, name, status));
                          break;
                       }catch (IllegalArgumentException e){
                           System.out.println(e.getMessage());
                       }
                    }
                    break;
                case 2:
                    System.out.println("Removing...");
                    if(linked.size() == 0){
                        System.out.println("Empty list");
                    }else{
                        System.out.println(linked);
                        int id = readInt(scann, "Patient's id");
                        if(linked.removeIf(patient -> patient.id() == id))
                        {
                       3     System.out.println("Removed");
                        }else{
                            System.out.println("Something went wrong");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Listing...");
                    if(linked.size() == 0){
                        System.out.println("Empty list");
                    }else{
                        System.out.println(linked);
                    }
                    break;
                case 0:
                    System.out.println("Exiting...");
                    running = false;
                    break;
                default:
                    System.out.println("Wrong number");
            }
        }
        System.out.println("Ended");

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
