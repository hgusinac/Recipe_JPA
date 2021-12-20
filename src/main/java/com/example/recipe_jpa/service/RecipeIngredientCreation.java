package com.example.recipe_jpa.service;

import com.example.recipe_jpa.model.DTO.RecipeIngredientForm;
import com.example.recipe_jpa.model.entities.RecipeIngredient;

import java.util.List;

public interface RecipeIngredientCreation {
    RecipeIngredient save(RecipeIngredientForm recipeIngredientForm);

    RecipeIngredient findById(String id);

    List<RecipeIngredient> findAll();

    void delete(String id);

}