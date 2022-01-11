package com.example.recipe_jpa.model.DTO.form;

import com.example.recipe_jpa.model.entities.Measurment;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;
@Validated
public class RecipeIngredientForm implements Serializable {
    private String id;
    private double amount;
    private Measurment measurment;

    public RecipeIngredientForm() {
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
}
