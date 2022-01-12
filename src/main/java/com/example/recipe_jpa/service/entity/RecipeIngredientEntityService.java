package com.example.recipe_jpa.service.entity;

import com.example.recipe_jpa.model.DTO.form.RecipeIngredientForm;
import com.example.recipe_jpa.model.entities.RecipeIngredient;

import java.util.List;

public interface RecipeIngredientEntityService {
    RecipeIngredient create(RecipeIngredientForm recipeIngredientForm);

    RecipeIngredient findById(String id);

    List<RecipeIngredient> findAll();

    void delete(String id);

}