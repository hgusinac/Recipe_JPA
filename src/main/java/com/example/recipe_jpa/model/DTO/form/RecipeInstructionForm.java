package com.example.recipe_jpa.model.DTO.form;

import org.springframework.validation.annotation.Validated;

import java.io.Serializable;

@Validated
public class RecipeInstructionForm implements Serializable {

    private String id;
    private String instructions;

    public RecipeInstructionForm() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}
