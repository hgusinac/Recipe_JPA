package com.example.recipe_jpa.model.DTO;

import com.example.recipe_jpa.model.entities.RecipeInstruction;

import java.io.Serializable;
import java.util.List;

public class RecipeForm implements Serializable {
    private String id;
    private String recepeName;
    private RecipeInstructionForm recipeInstructionForm;
    private List<String> recipeCategoryId;
    private List<String> recipeIngredientId;

    public RecipeForm() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRecepeName() {
        return recepeName;
    }

    public void setRecepeName(String recepeName) {
        this.recepeName = recepeName;
    }

    public RecipeInstructionForm getRecipeInstructionForm() {
        return recipeInstructionForm;
    }

    public void setRecipeInstructionForm(RecipeInstructionForm recipeInstructionForm) {
        this.recipeInstructionForm = recipeInstructionForm;
    }

    public List<String> getRecipeCategoryId() {
        return recipeCategoryId;
    }

    public void setRecipeCategoryId(List<String> recipeCategoryId) {
        this.recipeCategoryId = recipeCategoryId;
    }

    public List<String> getRecipeIngredientId() {
        return recipeIngredientId;
    }

    public void setRecipeIngredientId(List<String> recipeIngredientId) {
        this.recipeIngredientId = recipeIngredientId;
    }
}
