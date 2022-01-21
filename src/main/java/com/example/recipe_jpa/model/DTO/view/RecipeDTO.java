package com.example.recipe_jpa.model.DTO.view;

import com.example.recipe_jpa.model.entities.RecipeCategory;
import com.example.recipe_jpa.model.entities.RecipeIngredient;
import com.example.recipe_jpa.model.entities.RecipeInstruction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

public class RecipeDTO implements Serializable {

    private String id;
    private String recipeName;
    private List<RecipeIngredientDTO> recipeIngredientDTOS;
    private RecipeInstructionDTO recipeInstructionDTO;
    private List<RecipeCategoryDTO> recipeCategoryDTOS;

    public RecipeDTO() {
    }

    public RecipeDTO(String id, String recipeName, List<RecipeIngredientDTO> recipeIngredientDTOS, RecipeInstructionDTO recipeInstructionDTO, List<RecipeCategoryDTO> recipeCategoryDTOS) {

        this.id = id;
        this.recipeName = recipeName;
        this.recipeIngredientDTOS = recipeIngredientDTOS;
        this.recipeInstructionDTO = recipeInstructionDTO;
        this.recipeCategoryDTOS = recipeCategoryDTOS;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public List<RecipeIngredientDTO> getRecipeIngredientDTOS() {
        return recipeIngredientDTOS;
    }

    public void setRecipeIngredientDTOS(List<RecipeIngredientDTO> recipeIngredientDTOS) {
        this.recipeIngredientDTOS = recipeIngredientDTOS;
    }

    public RecipeInstructionDTO getRecipeInstructionDTO() {
        return recipeInstructionDTO;
    }

    public void setRecipeInstructionDTO(RecipeInstructionDTO recipeInstructionDTO) {
        this.recipeInstructionDTO = recipeInstructionDTO;
    }

    public List<RecipeCategoryDTO> getRecipeCategoryDTOS() {
        return recipeCategoryDTOS;
    }

    public void setRecipeCategoryDTOS(List<RecipeCategoryDTO> recipeCategoryDTOS) {
        this.recipeCategoryDTOS = recipeCategoryDTOS;
    }
}
