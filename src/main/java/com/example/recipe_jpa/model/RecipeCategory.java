package com.example.recipe_jpa.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class RecipeCategory {

    @Id
    private int id;
    private String category;

    @ManyToMany(
            cascade = {CascadeType.DETACH,CascadeType.REFRESH},
            fetch = FetchType.LAZY
    )
    @JoinTable(
            name = "recipe_recipe_category",
            joinColumns = @JoinColumn(name = "fk_recipe_id",table = "recipe_recipe_category"),
            inverseJoinColumns = @JoinColumn(name = "fk_recipe_category_id",table = "recipe_recipe_category")
    )
    private Set<Recipe> recipes;

    public RecipeCategory(String category) {
        this.category = category;
    }

    public RecipeCategory() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Set<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }
}
