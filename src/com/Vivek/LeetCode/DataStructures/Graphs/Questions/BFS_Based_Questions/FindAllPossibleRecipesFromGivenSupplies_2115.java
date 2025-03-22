package com.Vivek.LeetCode.DataStructures.Graphs.Questions.BFS_Based_Questions;

import java.util.*;

public class FindAllPossibleRecipesFromGivenSupplies_2115 {
//    This question is based on Graph (Topological Sorting using Kahn's Algorithm - BFS)

    private static List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        // Step 1: Initialize graph and in-degree map
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> inDegree = new HashMap<>();
        Set<String> supplySet = new HashSet<>(Arrays.asList(supplies)); // Convert supplies to a set for quick lookup

        // Step 2: Build the graph
        for (int i = 0; i < recipes.length; i++) {
            String recipe = recipes[i];
            inDegree.put(recipe, ingredients.get(i).size()); // Initial in-degree is the number of ingredients

            for (String ingredient : ingredients.get(i)) {
                graph.computeIfAbsent(ingredient, k -> new ArrayList<>()).add(recipe);
            }
        }

        // Step 3: Add all available supplies to the queue
        Queue<String> queue = new LinkedList<>();
        for (String supply : supplies) {
            queue.offer(supply);
        }

        // Step 4: Process the queue (Topological Sorting)
        List<String> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            String current = queue.poll();

            if (inDegree.containsKey(current) && inDegree.get(current) == 0) {
                result.add(current); // We can create this recipe
            }

            // Check if this ingredient helps unlock any recipes
            if (graph.containsKey(current)) {
                for (String nextRecipe : graph.get(current)) {
                    inDegree.put(nextRecipe, inDegree.get(nextRecipe) - 1);

                    if (inDegree.get(nextRecipe) == 0) {
                        queue.offer(nextRecipe); // Add to queue when all ingredients are available
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read number of recipes
        System.out.println("Enter number of recipes: ");
        int numberOfRecipes = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String[] recipes = new String[numberOfRecipes];

        System.out.println("Enter each recipe: ");
        for (int i = 0; i < numberOfRecipes; i++) {
            recipes[i] = scanner.nextLine();
        }

        List<List<String>> ingredientsForRecipeI = new ArrayList<>();
        for (int i = 0; i < numberOfRecipes; i++) {
            System.out.print("How many ingredients for recipe[" + recipes[i] + "]: ");
            int numberOfIngredients = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.println("Enter each ingredient: ");
            List<String> ingredientList = new ArrayList<>();
            for (int j = 0; j < numberOfIngredients; j++) {
                ingredientList.add(scanner.nextLine());
            }

            ingredientsForRecipeI.add(ingredientList);
        }

        // Read number of supplies
        System.out.println("Enter number of supplies: ");
        int numberOfSupplies = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String[] supplies = new String[numberOfSupplies];
        System.out.println("Enter each supply: ");
        for (int i = 0; i < numberOfSupplies; i++) {
            supplies[i] = scanner.nextLine();
        }

        // Output the possible recipes
        System.out.println("Recipes that we can make: " + findAllRecipes(recipes, ingredientsForRecipeI, supplies));

        scanner.close();
    }
}