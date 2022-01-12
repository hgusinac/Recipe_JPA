package com.example.recipe_jpa.service.facade;

import com.example.recipe_jpa.model.DTO.view.IngredientDTO;
import com.example.recipe_jpa.model.entities.Ingredient;
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

}
