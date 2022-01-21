package com.example.recipe_jpa.service.facade;

import com.example.recipe_jpa.model.DTO.form.RecipeForm;
import com.example.recipe_jpa.model.DTO.view.RecipeDTO;
import com.example.recipe_jpa.model.entities.Recipe;
import com.example.recipe_jpa.service.entity.GenericEntityService;
import org.springframework.stereotype.Service;


public interface RecipeService extends GenericEntityService<RecipeDTO, RecipeForm> {
}
