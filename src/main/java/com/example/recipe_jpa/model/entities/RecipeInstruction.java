package com.example.recipe_jpa.model.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import static com.example.recipe_jpa.model.entities.constants.EntityConstants.GENERATOR;
import static com.example.recipe_jpa.model.entities.constants.EntityConstants.UUID_GENERATOR;

@Entity
public class RecipeInstruction {

    @Id
    @GeneratedValue(generator = GENERATOR)
    @GenericGenerator(name = GENERATOR, strategy = UUID_GENERATOR)

    private String id;
    @Column(length = 2000)
    private String instructions;

    public RecipeInstruction(String  id, String instructions) {
        this.id = id;
        this.instructions = instructions;
    }

    public RecipeInstruction() {
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
