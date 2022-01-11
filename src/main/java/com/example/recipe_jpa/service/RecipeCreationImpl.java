package com.example.recipe_jpa.service;

import com.example.recipe_jpa.database.RecipeCategoryDAO;
import com.example.recipe_jpa.database.RecipeDAO;
import com.example.recipe_jpa.database.RecipeIngredientDAO;
import com.example.recipe_jpa.model.DTO.form.RecipeForm;
import com.example.recipe_jpa.model.entities.Recipe;
import com.example.recipe_jpa.model.entities.RecipeCategory;
import com.example.recipe_jpa.model.entities.RecipeIngredient;
import com.example.recipe_jpa.model.entities.RecipeInstruction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RecipeCreationImpl implements RecipeCreation{


    private final RecipeDAO recipeDAO;
    private final RecipeInstructionCreation recipeInstructionCreation;
    private  final RecipeCategoryDAO recipeCategoryDAO;
    private final RecipeIngredientDAO recipeIngredientDAO;

    @Autowired
    public RecipeCreationImpl(RecipeDAO recipeDAO, RecipeInstructionCreation recipeInstructionCreation, RecipeCategoryDAO recipeCategoryDAO, RecipeIngredientDAO recipeIngredientDAO) {
        this.recipeDAO = recipeDAO;
        this.recipeInstructionCreation = recipeInstructionCreation;
        this.recipeCategoryDAO = recipeCategoryDAO;
        this.recipeIngredientDAO = recipeIngredientDAO;
    }

    @Override
    public Recipe save(RecipeForm recipeForm) {
        Recipe recipe = new Recipe();

        RecipeInstruction recipeInstruction = recipeInstructionCreation.save(recipeForm.getRecipeInstructionForm());
        List<RecipeCategory> recipeCategoryList = recipeForm.getRecipeCategoryId().stream()
                .map(id -> recipeCategoryDAO.findById(id).get())
                .collect(Collectors.toList());

        List<RecipeIngredient> recipeIngredientList = recipeForm.getRecipeIngredientId().stream()
                .map(id -> recipeIngredientDAO.findById(id).get())
                .collect(Collectors.toList());

        recipe.setId(recipeForm.getId());
        recipe.setRecipeName(recipeForm.getRecepeName());
        recipe.setRecipeInstruction(recipeInstruction);
        recipe.setCategories(recipeCategoryList);
        recipe.setRecipeIngredients(recipeIngredientList);

        return recipeDAO.save(recipe);

    }

    @Override
    public Recipe findById(String id) {
        if (id.isEmpty()) throw new IllegalArgumentException("Id is not assign");
        return recipeDAO.findById(id).orElseThrow(()-> new RuntimeException("Recipe is not found"));
    }

    @Override
    public List<Recipe> findAll() {
        return recipeDAO.findAll();
    }

    @Override
    public void delete(String id) {
        if (id.isEmpty()) throw new IllegalArgumentException("id is not assign");
    recipeDAO.deleteById(id);
    }
}
