package com.example.recipe_jpa.database;

import com.example.recipe_jpa.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientDAOImpl extends JpaRepository<Ingredient,Integer> {
}
