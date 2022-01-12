package com.example.recipe_jpa.service.facade;

import com.example.recipe_jpa.model.DTO.view.IngredientDTO;
import com.example.recipe_jpa.model.entities.Ingredient;

public interface DTOService {
    IngredientDTO toFullIngredientDTO(Ingredient ingredient);
}
