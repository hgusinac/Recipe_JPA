package com.example.recipe_jpa.service.facade;

import com.example.recipe_jpa.model.DTO.view.IngredientDTO;
import com.example.recipe_jpa.model.DTO.view.RecipeCategoryDTO;
import com.example.recipe_jpa.model.entities.Ingredient;
import com.example.recipe_jpa.model.entities.RecipeCategory;
import org.springframework.stereotype.Component;

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
}
