package com.example.recipe_jpa.service.entity;

import com.example.recipe_jpa.model.DTO.form.RecipeForm;
import com.example.recipe_jpa.model.entities.Recipe;

import java.util.List;

public interface RecipeEntityService {

    Recipe create (RecipeForm recipeForm);
    Recipe findById(String id);
    List<Recipe> findAll();
    void delete(String id);

}
