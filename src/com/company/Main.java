package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.StringJoiner;

public class Main {

    Ingredient[] ingredientArray = new Ingredient[3];
    Pantry[] pantryArray = new Pantry[3];
    Recipe[] recipeArray = new Recipe[7];
    int ingredientCounter = 0;
    int recipeCounter = 0;


    public Main() {
        IBIO.output("Welcome to the Recipe system.");
        if (ReadIngredient() && ReadRecipe()) {
            IBIO.output("Data file located and loaded with " + ingredientCounter + recipeCounter + " existing items.\n");
            getMenuCommandMAIN();
        } else {
            IBIO.output("No data file found");
            writeToFileIngredient();
            writeToFileRecipe();
        }
    }


//-------------------------------MENU--------------------------------------

    public static void main(String args[]) {
        new Main();
    }

    public char getMenuCommandMAIN() {
        {
            IBIO.output("");
            IBIO.output("*********Main Menu*********");
            IBIO.output("a) Recipe Menu");
            IBIO.output("b) Pantry Menu");
            IBIO.output("e) Exit");

            char ch = IBIO.inputChar("Enter the command: "); //prompts user to enter their menu command
            if (ch != 'a' && ch != 'b' && ch != 'e') {
                ch = 0; //verifies that user entry is a selectable option
                IBIO.output("Invalid entry, please try again. ");
            }


            if (ch == 'a') {
                getMenuCommandRecipe();
            } else if (ch == 'b') {
                getMenuCommandPantry();
            } else if (ch == 'e' || ch == 'q') {
                IBIO.output("Saving Ingredient list...");
                writeToFileIngredient();
            }
        }

        return 0;
    }


    public char getMenuCommandPantry() {
        {
            IBIO.output("");
            IBIO.output("*********Pantry Menu*********");
            IBIO.output("a) Add an Ingredient");
            IBIO.output("b) Update Ingredient");
            IBIO.output("c) Edit Ingredient");
            IBIO.output("d) Remove Ingredient");
            IBIO.output("s) Display Pantry");
            IBIO.output("e) Exit");

            char ch = IBIO.inputChar("Enter the command: "); //prompts user to enter their menu command
            if (ch != 'a' && ch != 'd' && ch != 'e' && ch != 's') {
                ch = 0; //verifies that user entry is a selectable option
                IBIO.output("Invalid entry, please try again. ");
            }

            if (ch == 'a') {
                addIngredient();
            } else if (ch == 'b') {
                updateIngredient();
            } else if (ch == 'c') {
                editIngredient();
            } else if (ch == 'd') {
                removeIngredient();
            } else if (ch == 's') {
                displayAllIngredient();
            } else if (ch == 'e' || ch == 'q') {
                IBIO.output("Saving Ingredient list...");
                writeToFileIngredient();
            }
        }

        return 0;
    }


    public char getMenuCommandRecipe() {
        {
            IBIO.output("");
            IBIO.output("*********Recipe Menu*********");
            IBIO.output("a) Add an Recipe");
            IBIO.output("b) Edit Recipe");
            IBIO.output("c) Remove Recipe");
            IBIO.output("d) Search Recipe");
            IBIO.output("s) Display Recipe");
            IBIO.output("e) Exit");

            char ch = IBIO.inputChar("Enter the command: "); //prompts user to enter their menu command
            if (ch != 'a' && ch != 'b' && ch != 'e' && ch != 'd') {
                ch = 0; //verifies that user entry is a selectable option
                IBIO.output("Invalid entry, please try again. ");
            }

            if (ch == 'a') {
                addRecipe();
            } else if (ch == 'b') {
                editRecipe();
            } else if (ch == 'c') {
                removeRecipe();
            } else if (ch == 'd') {
                searchRecipe();
            } else if (ch == 's') {
                displayAllRecipe();
            } else if (ch == 'e' || ch == 'q') {
                IBIO.output("Saving Recipe list...");
                writeToFileRecipe();

            }

        }
        return 0;
    }


    //------------------------------ ADD ALL ------------------------------


    public void addRecipe() {
        IBIO.output("");
        System.out.println("*********ADD an Recipe*********");
        String name = IBIO.inputString("Enter Name: ");
        String ingredient = IBIO.inputString("Enter Ingredient: ");
        String instruction = IBIO.inputString("Enter Instruction: ");
        int cost = IBIO.inputInt("Enter Cost: ");
        int rating = IBIO.inputInt("Enter Rating: ");
        String cuisine = IBIO.inputString("Enter Cuisine: ");
        Boolean spicy = IBIO.inputBoolean("Enter Spicy: ");

        Recipe myRecipe = new Recipe(name, name, ingredient, instruction, cost, rating, cuisine, spicy);

        recipeArray[recipeCounter] = myRecipe;
        recipeCounter++;


        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-Recipe ADDED-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
        IBIO.output(recipeArray[recipeCounter - 1].toString());
        writeToFileRecipe();
        getMenuCommandMAIN();
    }


    public void addIngredient() {
        IBIO.output("");
        System.out.println("*********ADD an Ingredient*********");
        String name = IBIO.inputString("Enter Name: ");
        int amount = IBIO.inputInt("Enter Amount: ");
        Boolean inStock = IBIO.inputBoolean("Enter InStock: ");


        Ingredient myIngredient = new Ingredient(name, amount, inStock);

        ingredientArray[ingredientCounter] = myIngredient;
        ingredientCounter++;

        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-Ingredient ADDED-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
        IBIO.output(ingredientArray[ingredientCounter - 1].toString());
        writeToFileIngredient();
        getMenuCommandMAIN();
    }


    //--------------------------------  UPDATE INGREDIENT --------------------------


    private void updateIngredient() {
        searchIngredient();


    }


    //-------------------------------- EDIT ALL ----------------------------------------


    private void editRecipe() {
    }


    private void editIngredient() {
    }


    //-------------------------------- REMOVE ALL ----------------------------------


    private void removeRecipe() {
    }


    private void removeIngredient() {
    }


    //------------------------- DISPLAY ALL -----------------------------------


    private void displayAllIngredient() {

        IBIO.output("\nList of Ingredients: ");
        IBIO.output("_____________________________");

        for (int x = 0; x < ingredientCounter; x = x + 1) {
            IBIO.output(pantryArray[x].toString());
        }

        IBIO.output("There are currently " + ingredientCounter + " Ingredients in the Pantry.");
    }


    private void displayAllRecipe() {

        IBIO.output("\nList of Recipes: ");
        IBIO.output("_____________________________");

        for (int x = 0; x < recipeCounter; x = x + 1) {
            IBIO.output(recipeArray[x].toString());
        }

        IBIO.output("There are currently " + recipeCounter + " Recipes in the Cookbook.");
    }


    //------------------------------- FILE WRITERS -----------------------------


    public void writeToFileIngredient() {
        try {

            FileWriter fileID = new FileWriter("Ingredients.txt");
            PrintWriter outFile = new PrintWriter(fileID);
            IBIO.output(ingredientCounter);
            for (int i = 0; i < ingredientCounter; i++) {
                outFile.println(ingredientArray[i].getName());
                outFile.println(ingredientArray[i].getAmount());
                outFile.println(ingredientArray[i].getInStock());

            }
            outFile.close();
            IBIO.output("File saved");
        } catch (IOException io) {
            IBIO.output("An error occurred when writing to file." + io.getMessage());
        }
    }


    public void writeToFileRecipe() {
        try {


            Path path = Path.of("./Recipe.txt");
            StringJoiner joiner = new StringJoiner("\n");
            for (int i = 0; i < recipeCounter; i++) {
                joiner.add(recipeArray[i].getName())
                        .add(recipeArray[i].getIngredient())
                        .add(recipeArray[i].getInstruction())
                        .add(String.valueOf(recipeArray[i].getCost()))
                        .add(String.valueOf(recipeArray[i].getRating()))
                        .add(recipeArray[i].getCuisine())
                        .add(String.valueOf(recipeArray[i].getSpicy()));
            }
            Files.writeString(path, joiner.toString());
            IBIO.output(recipeCounter);


            IBIO.output("File saved");
        } catch (IOException io) {
            IBIO.output("An error occurred when writing to file." + io.getMessage());
        }
    }


    // ----------------------------------- SEARCH RECIPE -----------------------------


    public void searchRecipe() {
        System.out.println("*************Searching for Recipe*************");
        String author = IBIO.inputString("Please type the Name of Recipe: ");

        for (int i = 0; i < recipeArray.length; i++) {
            if (author.equals(recipeArray[i].getName())) {
                IBIO.output(recipeArray[i].toString());
            } else {
                System.out.println("Sorry, we couldn't find the Recipe.");
            }
            getMenuCommandMAIN();
        }
    }


    private boolean ReadRecipe() {
        try {
            //see if a file exists
            FileReader theFileID = new FileReader("./Recipe.txt");
            BufferedReader inFile = new BufferedReader(theFileID);
            String Name;
            String Ingredient;
            String Instruction;
            int Cost;
            int Rating;
            String Cuisine;
            Boolean Spicy;
            int x = 0;

            while ((Name = inFile.readLine()) != null) {
                Ingredient = inFile.readLine();
                Instruction = inFile.readLine();
                Cost = Integer.parseInt(inFile.readLine());
                Rating = Integer.parseInt(inFile.readLine());
                Cuisine = inFile.readLine();
                Spicy = Boolean.valueOf(inFile.readLine());

                recipeArray[x] = new Recipe(Name, Ingredient, Instruction, Instruction, Cost, Rating, Cuisine, Spicy);
                IBIO.output(recipeArray[x].toString());
                x = x + 1;
            }
            inFile.close();
            return true;
        } catch (IOException io) {
            IBIO.output("Error trying to open file " + io.getMessage());
        }
        return false;
    }


    //------------------------------------- SEARCH INGREDIENT -----------------------------


    public void searchIngredient() {
        System.out.println("*************Searching for Ingredient*************");
        String author = IBIO.inputString("Please type the Name of Ingredient: ");

        for (int i = 0; i < ingredientArray.length; i++) {
            if (author.equals(ingredientArray[i].getName())) {
                IBIO.output(ingredientArray[i].toString());
            } else {
                System.out.println("Sorry, we couldn't find the Ingredient.");
            }
        }
    }

    private boolean ReadIngredient() {
        try {
            //see if a file exists
            FileReader theFileID = new FileReader("Ingredients.txt");
            BufferedReader inFile = new BufferedReader(theFileID);
            String Name;
            int Amount;
            boolean InStock;
            int x = 0;

            while ((Name = inFile.readLine()) != null) {
                Amount = Integer.parseInt(inFile.readLine());
                InStock = Boolean.parseBoolean(inFile.readLine());

                ingredientArray[x] = new Ingredient(Name, Amount, InStock);
                IBIO.output(ingredientArray[x].toString());
                x = x + 1;
            }
            ingredientCounter = x;
            inFile.close();
            return true;
        } catch (IOException io) {
            IBIO.output("Error trying to open file " + io.getMessage());
        }
        return false;
    }
}


