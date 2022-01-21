package com.example.recipe_jpa.service.facade;

import com.example.recipe_jpa.model.DTO.view.*;
import com.example.recipe_jpa.model.entities.*;

public interface DTOService {
    IngredientDTO toFullIngredientDTO(Ingredient ingredient);

    RecipeCategoryDTO toFullRecipeCategoryDTO(RecipeCategory recipeCategory);


    RecipeInstructionDTO toFullRecipeInstructionDTO(RecipeInstruction recipeInstruction);



    RecipeIngredientDTO toFullRecipeIngredientDTO(RecipeIngredient recipeIngredient);
    RecipeIngredientDTO toSmallRecipeIngredientDTO(RecipeIngredient recipeIngredient);


    RecipeDTO toFullRecipeDTO(Recipe recipe);
    RecipeDTO toSmallRecipeDTO(Recipe recipe);

}
