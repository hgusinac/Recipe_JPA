package com.example.recipe_jpa.service.entity;

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
public class RecipeEntityServiceImpl implements RecipeEntityService {


    private final RecipeDAO recipeDAO;
    private final RecipeInstructionEntityService recipeInstructionEntityService;
    private  final RecipeCategoryDAO recipeCategoryDAO;
    private final RecipeIngredientDAO recipeIngredientDAO;

    @Autowired
    public RecipeEntityServiceImpl(RecipeDAO recipeDAO, RecipeInstructionEntityService recipeInstructionEntityService, RecipeCategoryDAO recipeCategoryDAO, RecipeIngredientDAO recipeIngredientDAO) {
        this.recipeDAO = recipeDAO;
        this.recipeInstructionEntityService = recipeInstructionEntityService;
        this.recipeCategoryDAO = recipeCategoryDAO;
        this.recipeIngredientDAO = recipeIngredientDAO;
    }

    @Override
    public Recipe create(RecipeForm recipeForm) {
        if(recipeForm == null){
            throw new IllegalArgumentException("RecipeForm was null.");
        }
        Recipe recipe = new Recipe();
        recipe.setRecipeName(recipeForm.getRecepeName());
        recipe.setRecipeInstruction(recipeInstructionEntityService.create(
                recipeForm.getRecipeInstructionForm()
        ));
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
    public Recipe update(String id, RecipeForm form) {
        Recipe recipe = findById(id);
        recipe.setRecipeName(form.getRecepeName());
        recipe.setRecipeInstruction(recipeInstructionEntityService.create(form.getRecipeInstructionForm()));

        return recipeDAO.save(recipe);
    }

    @Override
    public void delete(String id) {
        if (id.isEmpty()) throw new IllegalArgumentException("id is not assign");
    Recipe recipe = findById(id);
    recipe.setRecipeIngredients(null);
    recipe.setCategories(null);
    recipe.setRecipeInstruction(null);
    recipeDAO.deleteById(id);
    }
}
