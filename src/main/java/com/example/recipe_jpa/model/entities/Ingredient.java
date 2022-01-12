package com.example.recipe_jpa.model.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import static com.example.recipe_jpa.model.entities.constants.EntityConstants.GENERATOR;
import static com.example.recipe_jpa.model.entities.constants.EntityConstants.UUID_GENERATOR;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue(generator = GENERATOR)
    @GenericGenerator(name = GENERATOR, strategy = UUID_GENERATOR)
    @Column(updatable = false)
    private String id;
    @Column(unique = true)
    private String ingredientName;

    public Ingredient(String id, String ingredientName) {
        this.id = id;
        this.ingredientName = ingredientName;
    }

    public Ingredient() {
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
