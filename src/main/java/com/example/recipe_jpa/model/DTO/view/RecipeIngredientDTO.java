package com.example.recipe_jpa.model.DTO.view;

import com.example.recipe_jpa.model.entities.Ingredient;
import com.example.recipe_jpa.model.entities.Measurment;
import com.example.recipe_jpa.model.entities.Recipe;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

public class RecipeIngredientDTO implements Serializable {

    private String id;
    private double amount;
    private Measurment measurment;
    private RecipeDTO recipeDTO;
    private IngredientDTO ingredientDTO;

    public RecipeIngredientDTO() {
    }

    public RecipeIngredientDTO(String id, double amount, Measurment measurment, RecipeDTO recipeDTO, IngredientDTO ingredientDTO) {
        this.id = id;
        this.amount = amount;
        this.measurment = measurment;
        this.recipeDTO = recipeDTO;
        this.ingredientDTO = ingredientDTO;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Measurment getMeasurment() {
        return measurment;
    }

    public void setMeasurment(Measurment measurment) {
        this.measurment = measurment;
    }

    public RecipeDTO getRecipeDTO() {
        return recipeDTO;
    }

    public void setRecipeDTO(RecipeDTO recipeDTO) {
        this.recipeDTO = recipeDTO;
    }

    public IngredientDTO getIngredientDTO() {
        return ingredientDTO;
    }

    public void setIngredientDTO(IngredientDTO ingredientDTO) {
        this.ingredientDTO = ingredientDTO;
    }
}
