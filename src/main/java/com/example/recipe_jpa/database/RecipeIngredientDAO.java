package com.example.recipe_jpa.database;

import com.example.recipe_jpa.model.RecipeIngredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeIngredientDAO extends JpaRepository<RecipeIngredient,Integer> {
}
