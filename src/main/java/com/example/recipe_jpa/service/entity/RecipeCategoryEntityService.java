package com.example.recipe_jpa.service.entity;

import com.example.recipe_jpa.model.DTO.form.RecipeCategoryForm;
import com.example.recipe_jpa.model.entities.RecipeCategory;

import java.util.List;

public interface RecipeCategoryEntityService {

    RecipeCategory create (RecipeCategoryForm recipeCategoryForm);
    RecipeCategory findById(String id);
    List<RecipeCategory> findAll();
    void delete(String id);
}
