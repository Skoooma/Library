package com.company;

public class Ingredient {
    public String name;
    public int amount;
    public boolean inStock;


    public Ingredient(String name, int amount, boolean instock){
        this.name = name;
        this.amount = amount;
        this.inStock = instock;
    }

    public Ingredient() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean getInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }


    @Override
    public String toString() {
        return "Ingredient{" +
                "Name = " + name + '\'' +
                ", Amount = " + amount + '\'' +
                ", InStock = " + inStock + '\'' +
                '}';
    }
}
