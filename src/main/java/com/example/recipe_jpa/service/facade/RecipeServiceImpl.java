package com.example.recipe_jpa.service.facade;

import com.example.recipe_jpa.database.RecipeCategoryDAO;
import com.example.recipe_jpa.database.RecipeDAO;
import com.example.recipe_jpa.database.RecipeIngredientDAO;
import com.example.recipe_jpa.model.DTO.form.RecipeForm;
import com.example.recipe_jpa.model.DTO.view.RecipeDTO;
import com.example.recipe_jpa.model.entities.Recipe;
import com.example.recipe_jpa.model.entities.RecipeCategory;
import com.example.recipe_jpa.service.entity.RecipeEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RecipeServiceImpl implements RecipeService{

   private final RecipeEntityService recipeEntityService;
   private final DTOService dtoService;

    public RecipeServiceImpl(RecipeEntityService recipeEntityService, DTOService dtoService) {
        this.recipeEntityService = recipeEntityService;
        this.dtoService = dtoService;
    }

    @Override
    public RecipeDTO create(RecipeForm recipeForm) {
       return dtoService.toFullRecipeDTO(recipeEntityService.create(recipeForm));
    }

    @Override
    public RecipeDTO findById(String id) {
        return dtoService.toFullRecipeDTO(recipeEntityService.findById(id));
    }

    @Override
    public List<RecipeDTO> findAll() {
        return  recipeEntityService.findAll().stream()
                .map(dtoService::toFullRecipeDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RecipeDTO update(String id, RecipeForm recipeForm) {
        return dtoService.toFullRecipeDTO(recipeEntityService.update(id,recipeForm));
    }

    @Override
    public void delete(String id) {

        recipeEntityService.delete(id);
    }
}

