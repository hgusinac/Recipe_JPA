package com.example.recipe_jpa.model.DTO;

import org.springframework.validation.annotation.Validated;

import java.io.Serializable;

@Validated
public class IngredientForm implements Serializable {

    private String id;

    private String ingredientName;

    public IngredientForm() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }
}
