package com.example.recipe_jpa.service;

import com.example.recipe_jpa.database.RecipeCategoryDAO;
import com.example.recipe_jpa.model.DTO.form.RecipeCategoryForm;
import com.example.recipe_jpa.model.entities.RecipeCategory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RecipeCategoryCreationImpl implements RecipeCategoryCreation{

   public final RecipeCategoryDAO recipeCategoryDAO;

    public RecipeCategoryCreationImpl(RecipeCategoryDAO recipeCategoryDAO) {
        this.recipeCategoryDAO = recipeCategoryDAO;
    }

    @Override
    public RecipeCategory save(RecipeCategoryForm recipeCategoryForm) {
        RecipeCategory recipeCategory = new RecipeCategory();

        recipeCategory.setId(recipeCategory.getId());
        recipeCategory.setCategory(recipeCategory.getCategory());

        return recipeCategoryDAO.save(recipeCategory);
    }

    @Override
    public RecipeCategory findById(String id) {
        Optional<RecipeCategory> recipeCategory = recipeCategoryDAO.findById(id);
        return  recipeCategory.orElseThrow(() -> new  RuntimeException("Recipe category not found"));
    }

    @Override
    public List<RecipeCategory> findAll() {
        return recipeCategoryDAO.findAll();
    }

    @Override
    public void delete(String id) {
    recipeCategoryDAO.deleteById(id);
    }
}
