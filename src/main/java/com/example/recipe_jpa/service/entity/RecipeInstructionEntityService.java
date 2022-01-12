package com.example.recipe_jpa.service.entity;

import com.example.recipe_jpa.model.DTO.form.RecipeInstructionForm;
import com.example.recipe_jpa.model.entities.RecipeInstruction;

import java.util.List;

public interface RecipeInstructionEntityService {

    RecipeInstruction create (RecipeInstructionForm recipeInstructionForm);
    RecipeInstruction findById(String id);
    List<RecipeInstruction> findAll();
    void delete(String id);

}
