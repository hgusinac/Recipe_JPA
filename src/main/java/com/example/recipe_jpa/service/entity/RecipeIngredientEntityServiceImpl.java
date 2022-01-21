package com.example.recipe_jpa.service.entity;

import com.example.recipe_jpa.database.RecipeIngredientDAO;
import com.example.recipe_jpa.model.DTO.form.RecipeIngredientForm;
import com.example.recipe_jpa.model.entities.RecipeIngredient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RecipeIngredientEntityServiceImpl implements RecipeIngredientEntityService {


    private final RecipeIngredientDAO recipeIngredientDAO;

    public RecipeIngredientEntityServiceImpl(RecipeIngredientDAO recipeIngredientDAO) {
        this.recipeIngredientDAO = recipeIngredientDAO;
    }

    @Override
    public RecipeIngredient create(RecipeIngredientForm recipeIngredientForm) {
        if(recipeIngredientForm == null) throw new IllegalArgumentException("RecipeIngredientForm was null");
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
    public RecipeIngredient update(String id, RecipeIngredientForm recipeIngredientForm) {

        RecipeIngredient recipeIngredient=findById(id);
        recipeIngredient.setAmount(recipeIngredientForm.getAmount());
        recipeIngredient.setMeasurment(recipeIngredientForm.getMeasurment());
        recipeIngredient = recipeIngredientDAO.save(recipeIngredient);

        return recipeIngredient;
    }



    @Override
    public void delete(String id) {
        RecipeIngredient recipeIngredient = findById(id);
        recipeIngredient.setIngredient(null);
        recipeIngredientDAO.delete(recipeIngredient);
    }


}
