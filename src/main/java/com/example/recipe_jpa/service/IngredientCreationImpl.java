package com.example.recipe_jpa.service;

import com.example.recipe_jpa.database.IngredientDAO;
import com.example.recipe_jpa.model.DTO.IngredientForm;
import com.example.recipe_jpa.model.entities.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class IngredientCreationImpl implements IngredientCreation{

    private IngredientDAO ingredientDAO;

    @Autowired
    public IngredientCreationImpl(IngredientDAO ingredientDAO) {
        this.ingredientDAO = ingredientDAO;
    }

    @Override
    public Ingredient save(IngredientForm ingredientForm) {
        Ingredient ingredient = new Ingredient();
        ingredient.setId(ingredientForm.getId());
        ingredient.setIngredientName(ingredientForm.getIngredientName());

        return ingredientDAO.save(ingredient);
    }

    @Override
    public Ingredient findById(String id) {
        return ingredientDAO.findById(id).isPresent() ? ingredientDAO.findById(id).get() :null;
    }

    @Override
    public List<Ingredient> findAll() {
        return ingredientDAO.findAll();
    }

    @Override
    public void delete(String id) {
    ingredientDAO.deleteById(id);
    }
}
