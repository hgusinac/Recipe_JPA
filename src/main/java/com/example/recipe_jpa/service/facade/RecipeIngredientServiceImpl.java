package com.example.recipe_jpa.service.facade;

import com.example.recipe_jpa.database.RecipeIngredientDAO;
import com.example.recipe_jpa.model.DTO.form.RecipeIngredientForm;
import com.example.recipe_jpa.model.DTO.view.RecipeIngredientDTO;
import com.example.recipe_jpa.model.entities.RecipeIngredient;
import com.example.recipe_jpa.service.entity.RecipeIngredientEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RecipeIngredientServiceImpl implements RecipeIngredientService{

    private final RecipeIngredientEntityService recipeIngredientEntityService;
    private final DTOService dtoService;

    @Autowired
    public RecipeIngredientServiceImpl(RecipeIngredientEntityService recipeIngredientEntityService, DTOService dtoService) {
        this.recipeIngredientEntityService = recipeIngredientEntityService;
        this.dtoService = dtoService;
    }

    @Override
    public RecipeIngredientDTO create(RecipeIngredientForm recipeIngredientForm) {
    return dtoService.toFullRecipeIngredientDTO(recipeIngredientEntityService.create(recipeIngredientForm));
    }

    @Override
    public RecipeIngredientDTO findById(String id) {
        return dtoService.toFullRecipeIngredientDTO(recipeIngredientEntityService.findById(id));
    }

    @Override
    public List<RecipeIngredientDTO> findAll() {
        return  recipeIngredientEntityService.findAll().stream()
                .map(dtoService::toFullRecipeIngredientDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RecipeIngredientDTO update(String id, RecipeIngredientForm recipeIngredientForm) {
        return dtoService.toFullRecipeIngredientDTO(recipeIngredientEntityService.update(id,recipeIngredientForm));

    }

    @Override
    public void delete(String id) {
    recipeIngredientEntityService.delete(id);

    }
}
