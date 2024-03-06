import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class FileReader {
    private ArrayList<Recipe> recipes;

    public FileReader() {
        this.recipes = new ArrayList<>();
    }

    public ArrayList<Recipe> getRecipes() {
        return recipes;
    }

    public void read(String fileName) {
        try (Scanner fileReader = new Scanner(Paths.get(fileName))) {
            ArrayList<String> parts = new ArrayList<>();

            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                if (!line.isEmpty()) {
                    parts.add(line);
                } else {
                    if (!parts.isEmpty()) {
                        String name = parts.get(0);
                        int cookingTime = Integer.valueOf(parts.get(1));
                        ArrayList<String> ingredients = new ArrayList<>();
                        for (int i = 2; i < parts.size(); i++) {
                            ingredients.add(parts.get(i));
                        }
                        recipes.add(new Recipe(name, cookingTime, ingredients));
                        parts.clear();
                    }
                }
            }

            // Add the last recipe if there are any remaining parts
            if (!parts.isEmpty()) {
                String name = parts.get(0);
                int cookingTime = Integer.valueOf(parts.get(1));
                ArrayList<String> ingredients = new ArrayList<>();
                for (int i = 2; i < parts.size(); i++) {
                    ingredients.add(parts.get(i));
                }
                recipes.add(new Recipe(name, cookingTime, ingredients));
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}