package com.example.recipe_jpa.model.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

import static com.example.recipe_jpa.model.entities.constants.EntityConstants.GENERATOR;
import static com.example.recipe_jpa.model.entities.constants.EntityConstants.UUID_GENERATOR;

@Entity
public class RecipeCategory {

    @Id
    @GeneratedValue(generator = GENERATOR)
    @GenericGenerator(name = GENERATOR, strategy = UUID_GENERATOR)
    private String id;
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
    private List<Recipe> recipes;

    public RecipeCategory(String id, String category, List<Recipe> recipes) {
        this.id = id;
        this.category = category;
        this.recipes = recipes;
    }

    public RecipeCategory(String category) {
        this.category = category;
    }

    public RecipeCategory() {
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

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }
}
