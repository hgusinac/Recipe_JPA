package com.example.recipe_jpa.model.DTO.view;

import java.io.Serializable;

public class RecipeCategoryDTO implements Serializable {

    private String id;
    private String category;


    public RecipeCategoryDTO() {
    }

    public RecipeCategoryDTO(String id, String category) {
        this.id = id;
        this.category = category;
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
