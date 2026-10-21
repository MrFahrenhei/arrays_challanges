package com.beraldo.arraylist;

public record Product( String name, int quantity ) {
    private static final int MIN_NAME_LENGTH = 3;
    public Product{
        if(name == null || name.strip().length() < MIN_NAME_LENGTH){
            throw new IllegalArgumentException("Name must have at least "+ MIN_NAME_LENGTH + " characters");
        }
        if(quantity < 0){
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        name = name.strip();
    }
    public Product(String name){
        this(name, 0);
    }
}
