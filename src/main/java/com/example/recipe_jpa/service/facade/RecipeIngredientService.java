package com.example.recipe_jpa.service.facade;

import com.example.recipe_jpa.model.DTO.form.RecipeIngredientForm;
import com.example.recipe_jpa.model.DTO.view.RecipeIngredientDTO;
import com.example.recipe_jpa.model.entities.RecipeIngredient;
import com.example.recipe_jpa.service.entity.GenericEntityService;

public interface RecipeIngredientService extends GenericEntityService<RecipeIngredientDTO, RecipeIngredientForm> {
}
