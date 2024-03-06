

import java.util.ArrayList;
import java.util.Scanner;

public class RecipeSearch {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("File to read: ");
        String file = scan.nextLine();
        System.out.println();
        System.out.println("Commands:\n" +
                "list - lists the recipes\n" +
                "stop - stops the program\n" +
                "find name - searches recipes by name\n" +
                "find cooking time - searches recipes by cooking time\n" +
                "find ingredient - searches recipes by ingredient\n");

        FileReader reader = new FileReader();
        reader.read(file);
        ArrayList<Recipe> recipes = reader.getRecipes();

        while (true) {
            System.out.print("Enter command: ");
            String command = scan.nextLine();

            switch (command) {
                case "stop":
                    return; // Exit the method and the loop
                case "list":
                    System.out.println();
                    System.out.println("Recipes:");
                    for (Recipe recipe : recipes) {
                        recipe.printRecipe();
                    }
                    System.out.println();
                    break;
                case "find name":
                    System.out.print("Searched word: ");
                    String word = scan.nextLine();
                    for (Recipe recipe : recipes) {
                        if (recipe.getName().contains(word)) {
                            recipe.printRecipe();
                        }
                    }
                    System.out.println();
                    break;
                case "find cooking time":
                    System.out.print("Max cooking time: ");
                    int time = Integer.valueOf(scan.nextLine());
                    System.out.println();
                    System.out.println("Recipes: ");
                    for (Recipe recipe : recipes) {
                        if (recipe.getCookingTime() <= time) {
                            recipe.printRecipe();
                        }
                    }
                    System.out.println();
                    break;
                case "find ingredient":
                    System.out.print("Ingredient: ");
                    String ingredientToSearch = scan.nextLine();
                    System.out.println();
                    System.out.println("Recipes: ");
                    for (Recipe recipe : recipes) {
                        ArrayList<String> ingredients = recipe.getIngredients();
                        for (String inredient : ingredients) {
                            if (inredient.equals(ingredientToSearch)) {
                                recipe.printRecipe();
                            }
                        }
                    }
                    System.out.println();
                    break;
                default:
                    System.out.println("Unknown command");
                    break;
            }
        }
    }
}
