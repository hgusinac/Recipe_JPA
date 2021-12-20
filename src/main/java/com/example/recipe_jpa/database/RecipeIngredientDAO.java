package com.example.recipe_jpa.database;

import com.example.recipe_jpa.model.entities.RecipeIngredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeIngredientDAO extends JpaRepository<RecipeIngredient,String> {
}
