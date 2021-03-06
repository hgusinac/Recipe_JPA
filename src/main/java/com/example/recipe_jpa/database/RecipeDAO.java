package com.example.recipe_jpa.database;

import com.example.recipe_jpa.model.entities.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeDAO extends JpaRepository<Recipe,String> {
    List<Recipe> findByRecipeNameContaining(String recipeName);
}
