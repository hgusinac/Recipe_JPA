package com.example.recipe_jpa.service;

import com.example.recipe_jpa.model.DTO.RecipeCategoryForm;
import com.example.recipe_jpa.model.entities.RecipeCategory;

import java.util.List;

public interface RecipeCategoryCreation {

    RecipeCategory save (RecipeCategoryForm recipeCategoryForm);
    RecipeCategory findById(String id);
    List<RecipeCategory> findAll();
    void delete(String id);
}
