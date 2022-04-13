package com.company;

public class Recipe extends Instruction{
    public String name;
    public String ingredient;
    public String instruction;
    public int cost;
    public int rating;
    public String cuisine;
    public boolean spicy;

    public Recipe(String s, String name, String ingredient, String instruction, int cost, int rating, String cuisine, boolean spicy){
        super();
        this.name = name;
        this.ingredient = ingredient;
        this.instruction = instruction;
        this.cost = cost;
        this.rating = rating;
        this.cuisine = cuisine;
        this.spicy = spicy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public boolean getSpicy() {
        return spicy;
    }

    public void setSpicy(boolean spicy) {
        this.spicy = spicy;
    }




    @Override
    public String toString() {
        return "Recipe{" +
                "Name = " + name +
                ", Ingredient = " + ingredient +
                ", Instruction = " + instruction +
                ", Cost = " + cost +
                ", Rating = " + rating +
                ", Spicy = " + spicy +
                '}';
    }
}
