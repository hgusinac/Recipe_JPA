package com.example.recipe_jpa.service.entity;

import com.example.recipe_jpa.database.IngredientDAO;
import com.example.recipe_jpa.model.DTO.form.IngredientForm;
import com.example.recipe_jpa.model.entities.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IngredientEntityEntityServiceImpl implements IngredientEntityService {



    private IngredientDAO ingredientDAO;

    @Autowired
    public IngredientEntityEntityServiceImpl(IngredientDAO ingredientDAO) {
        this.ingredientDAO = ingredientDAO;
    }

    @Override
    public Ingredient create(IngredientForm ingredientForm) {
        if (ingredientForm == null) throw new IllegalArgumentException("IngredientForm was null");
        if (ingredientForm.getId()!=null) throw new IllegalArgumentException("Id was not null");

        Ingredient ingredient = new Ingredient();

        ingredient.setIngredientName(ingredientForm.getIngredientName().trim());
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
    public Ingredient update(String id, IngredientForm form) {
        return null;
    }

    @Override
    public void delete(String id) {
    ingredientDAO.deleteById(id);
    }
}
