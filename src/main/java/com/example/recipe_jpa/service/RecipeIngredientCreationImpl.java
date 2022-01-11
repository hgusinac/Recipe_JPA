package com.example.recipe_jpa.service;

import com.example.recipe_jpa.database.RecipeIngredientDAO;
import com.example.recipe_jpa.model.DTO.form.RecipeIngredientForm;
import com.example.recipe_jpa.model.entities.RecipeIngredient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RecipeIngredientCreationImpl implements RecipeIngredientCreation{


    private final RecipeIngredientDAO recipeIngredientDAO;

    public RecipeIngredientCreationImpl(RecipeIngredientDAO recipeIngredientDAO) {
        this.recipeIngredientDAO = recipeIngredientDAO;
    }

    @Override
    public RecipeIngredient save(RecipeIngredientForm recipeIngredientForm) {
        RecipeIngredient recipeIngredient = new RecipeIngredient();

        recipeIngredient.setId(recipeIngredient.getId());
        recipeIngredient.setAmount(recipeIngredient.getAmount());
        recipeIngredient.setMeasurment(recipeIngredient.getMeasurment());

        return recipeIngredientDAO.save(recipeIngredient);
    }

    @Override
    public RecipeIngredient findById(String id) {
        Optional<RecipeIngredient> recipeIngredient = recipeIngredientDAO.findById(id);
        return  recipeIngredient.orElseThrow(()-> new RuntimeException("recipe ingredient not found"));
    }

    @Override
    public List<RecipeIngredient> findAll() {
        return recipeIngredientDAO.findAll();
    }

    @Override
    public void delete(String id) {

        recipeIngredientDAO.deleteById(id);
    }
}
