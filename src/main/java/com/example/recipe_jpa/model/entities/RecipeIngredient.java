package com.example.recipe_jpa.model.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import static com.example.recipe_jpa.model.entities.constants.EntityConstants.GENERATOR;
import static com.example.recipe_jpa.model.entities.constants.EntityConstants.UUID_GENERATOR;

@Entity
public class RecipeIngredient {

    @Id
    @GeneratedValue(generator = GENERATOR)
    @GenericGenerator(name = GENERATOR, strategy = UUID_GENERATOR)
    private String id;
    private double amount;
    private Measurment measurment;



    @ManyToOne(
            cascade = {CascadeType.REFRESH,CascadeType.DETACH},
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "fk_ingredient_id",table = "recipe_ingredient")
    private Ingredient ingredient;
    @ManyToOne(
            cascade = {CascadeType.DETACH,CascadeType.REFRESH},
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "fk_recipe_id",table = "recipe_ingredient")
    private Recipe recipe;


    public RecipeIngredient(double amount, Measurment measurment) {
        this.amount = amount;
        this.measurment = measurment;
    }

    public RecipeIngredient() {
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

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
