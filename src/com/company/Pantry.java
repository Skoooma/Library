package com.company;

public class Pantry extends Ingredient {

    private String ingredient;


    public Pantry() {
        super();
        this.ingredient = ingredient;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    @Override
    public String toString() {
        return "Pantry{" +
                "Ingredient = " + ingredient + '\'' +
                '}';
    }
}
