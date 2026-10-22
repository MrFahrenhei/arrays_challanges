package com.beraldo.linkedlist;

public record Patient(
        int id,
        String name,
        String status
) {
    public Patient{
        if(name == null || name.strip().length() < 3){
            throw new IllegalArgumentException("Name must have at least 3 characters");
        }
        if(status == null || status.strip().length() < 3){
            throw new IllegalArgumentException("Status must have at least 3 characters");
        }
        if(id < 0){
            throw new IllegalArgumentException("id cannot be negative");
        }
        name = name.strip();
        status = status.strip();
    }

}
