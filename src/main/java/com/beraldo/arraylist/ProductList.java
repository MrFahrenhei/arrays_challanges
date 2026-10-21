package com.beraldo.arraylist;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ProductList {
    private final List<Product> productList = new ArrayList<>();

    public void addItem(Product product){
        productList.add(product);
    }

    public void removeItem(int id){
        productList.remove(id);
    }

    public boolean isEmpty(){
        return productList.isEmpty();
    }

    public int getSize(){
        return productList.size();
    }
    public String getItem(int id){
        return productList.get(id).name();
    }

    public void listItems(){
        IntStream.range(0, productList.size())
                .forEach(l -> System.out.println((l+1) + ": " + productList.get(l).name() + " qtd: " + productList.get(l).quantity()));
    }
}
