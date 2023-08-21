package com.example.product_thymeleaf.entity;

import java.util.List;

public class Product {
    private int id;
    private String name;
    private double price;
    private String description;
    private String producer;
    private List<String> typeOfProduct;

    public Product() {
    }

    public Product(int id, String name, double price, String description, String producer, List<String> typeOfProduct) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.producer = producer;
        this.typeOfProduct = typeOfProduct;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public List<String> getTypeOfProduct() {
        return typeOfProduct;
    }

    public void setTypeOfProduct(List<String> typeOfProduct) {
        this.typeOfProduct = typeOfProduct;
    }


    public  String displayTypeProduct(){
        StringBuilder stringBuilder = new StringBuilder();
        boolean flag = true;
        if(typeOfProduct == null){
            return  "";
        }
        for (String t: typeOfProduct) {
            if(flag){
                flag = false;
            }else {
                stringBuilder.append(",");
            }
            stringBuilder.append(t);
        }
        return stringBuilder.toString();
    }
}
