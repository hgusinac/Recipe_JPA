package com.example.recipe_jpa.service;

import com.example.recipe_jpa.model.DTO.IngredientForm;
import com.example.recipe_jpa.model.entities.Ingredient;

import java.util.List;

public interface IngredientCreation {


    Ingredient save (IngredientForm ingredientForm);
    Ingredient findById(String id);
    List<Ingredient> findAll();
    void delete(String id);

}
