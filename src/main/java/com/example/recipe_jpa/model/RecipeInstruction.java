package com.example.recipe_jpa.model;

import javax.persistence.*;

@Entity
public class RecipeInstruction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(length = 2000)
    private String instructions;

    public RecipeInstruction(int id, String instructions) {
        this.id = id;
        this.instructions = instructions;
    }

    public RecipeInstruction() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}
