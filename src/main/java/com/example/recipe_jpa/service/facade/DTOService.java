package com.example.recipe_jpa.service.facade;

import com.example.recipe_jpa.model.DTO.view.IngredientDTO;
import com.example.recipe_jpa.model.DTO.view.RecipeCategoryDTO;
import com.example.recipe_jpa.model.entities.Ingredient;
import com.example.recipe_jpa.model.entities.RecipeCategory;

public interface DTOService {
    IngredientDTO toFullIngredientDTO(Ingredient ingredient);
    RecipeCategoryDTO toFullRecipeCategoryDTO(RecipeCategory recipeCategory);
}
