package com.example.recipe_jpa.service;

import com.example.recipe_jpa.model.DTO.RecipeForm;
import com.example.recipe_jpa.model.entities.Recipe;

import java.util.List;

public interface RecipeCreation {

    Recipe save (RecipeForm recipeForm);
    Recipe findById(String id);
    List<Recipe> findAll();
    void delete(String id);

}
