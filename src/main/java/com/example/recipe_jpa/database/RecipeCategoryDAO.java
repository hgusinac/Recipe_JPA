package com.example.recipe_jpa.database;

import com.example.recipe_jpa.model.entities.RecipeCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeCategoryDAO extends JpaRepository<RecipeCategory,String> {

}
