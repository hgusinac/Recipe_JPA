package com.example.recipe_jpa.database;

import com.example.recipe_jpa.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientDAO extends JpaRepository<Ingredient,Integer> {
    List<Ingredient> findByIngredientNameIgnoreCase(String ingredientName);
    List<Ingredient> findByIngredientNameLike(String ingredientName);

}
