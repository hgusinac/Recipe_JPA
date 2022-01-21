package com.example.recipe_jpa.service.facade;

import com.example.recipe_jpa.model.DTO.form.RecipeInstructionForm;
import com.example.recipe_jpa.model.DTO.view.RecipeInstructionDTO;
import com.example.recipe_jpa.model.entities.RecipeInstruction;
import com.example.recipe_jpa.service.entity.GenericEntityService;

public interface RecipeInstructionService extends GenericEntityService<RecipeInstructionDTO, RecipeInstructionForm> {
}
