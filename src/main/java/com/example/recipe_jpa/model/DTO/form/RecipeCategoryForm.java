package com.example.recipe_jpa.model.DTO.form;


import java.io.Serializable;

public class RecipeCategoryForm implements Serializable {

    private String id;

    private String category;

    public RecipeCategoryForm() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
