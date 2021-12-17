package com.example.recipe_jpa.database;

import com.example.recipe_jpa.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeDAO extends JpaRepository<Recipe,Integer> {
    List<Recipe> findByRecipeNameContaining(String recipeName);
}
