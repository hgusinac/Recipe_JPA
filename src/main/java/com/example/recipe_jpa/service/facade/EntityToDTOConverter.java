package com.example.recipe_jpa.service.facade;

import com.example.recipe_jpa.model.DTO.view.*;
import com.example.recipe_jpa.model.entities.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EntityToDTOConverter implements DTOService {

   public  IngredientDTO toFullIngredientDTO(Ingredient ingredient){
       if (ingredient == null) return null;
       IngredientDTO ingredientDTO = new IngredientDTO();
       ingredientDTO.setId(ingredient.getId());
       ingredientDTO.setIngredientName(ingredient.getIngredientName());
       return ingredientDTO;

   }

    @Override
    public RecipeCategoryDTO toFullRecipeCategoryDTO(RecipeCategory recipeCategory) {
        if (recipeCategory == null) return null;
        RecipeCategoryDTO recipeCategoryDTO = new RecipeCategoryDTO();
        recipeCategoryDTO.setCategory(recipeCategory.getCategory());
        return recipeCategoryDTO;
    }



    @Override
    public RecipeInstructionDTO toFullRecipeInstructionDTO(RecipeInstruction recipeInstruction) {
       if (recipeInstruction == null) return null;
       RecipeInstructionDTO recipeInstructionDTO = new RecipeInstructionDTO();
      recipeInstructionDTO.setId(recipeInstruction.getId());
      recipeInstructionDTO.setInstruction(recipeInstruction.getInstructions());
      return recipeInstructionDTO;
    }



    @Override
    public RecipeIngredientDTO toSmallRecipeIngredientDTO(RecipeIngredient recipeIngredient) {
        if (recipeIngredient == null) return null;
        RecipeIngredientDTO recipeIngredientDTO = new RecipeIngredientDTO();
        recipeIngredientDTO.setId(recipeIngredient.getId());
        recipeIngredientDTO.setAmount(recipeIngredient.getAmount());
        recipeIngredientDTO.setMeasurment(recipeIngredient.getMeasurment());
        return recipeIngredientDTO;
    }
    @Override
    public RecipeIngredientDTO toFullRecipeIngredientDTO(RecipeIngredient recipeIngredient) {
        if (recipeIngredient == null) return null;
        RecipeIngredientDTO recipeIngredientDTO = toSmallRecipeIngredientDTO(recipeIngredient);
        recipeIngredientDTO.setRecipeDTO(toSmallRecipeDTO(recipeIngredient.getRecipe()));
        return recipeIngredientDTO;
    }



    @Override
    public RecipeDTO toFullRecipeDTO(Recipe recipe) {
        if (recipe == null )return null;

        RecipeDTO recipeDTO = toSmallRecipeDTO(recipe);
        recipeDTO.setRecipeInstructionDTO(toFullRecipeInstructionDTO(recipe.getRecipeInstruction()));
        List<RecipeCategoryDTO> recipeCategoryDTOS = recipe.getCategories().stream()
                .map(this::toFullRecipeCategoryDTO)
                .collect(Collectors.toList());

        List<RecipeIngredientDTO> recipeIngredientDTOS = recipe.getRecipeIngredients().stream()
                .map(this::toSmallRecipeIngredientDTO)
                .collect(Collectors.toList());

        recipeDTO.setRecipeIngredientDTOS(recipeIngredientDTOS);
        recipeDTO.setRecipeCategoryDTOS(recipeCategoryDTOS);

        return recipeDTO;

    }

    @Override
    public RecipeDTO toSmallRecipeDTO(Recipe recipe) {
        if (recipe == null) return null;

        RecipeDTO recipeDTO = new RecipeDTO();
        recipeDTO.setId(recipe.getId());
        recipeDTO.setRecipeName(recipe.getRecipeName());

        return recipeDTO;
    }
}
