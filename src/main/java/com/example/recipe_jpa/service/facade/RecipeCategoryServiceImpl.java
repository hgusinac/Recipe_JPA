package com.example.recipe_jpa.service.facade;

import com.example.recipe_jpa.database.RecipeCategoryDAO;
import com.example.recipe_jpa.model.DTO.form.RecipeCategoryForm;
import com.example.recipe_jpa.model.DTO.view.RecipeCategoryDTO;
import com.example.recipe_jpa.model.entities.RecipeCategory;
import com.example.recipe_jpa.service.entity.RecipeCategoryEntityService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class RecipeCategoryServiceImpl implements RecipeCategoryService{

    public final RecipeCategoryEntityService recipeCategoryService;
    public final DTOService dtoConverter;

    public RecipeCategoryServiceImpl(RecipeCategoryEntityService recipeCategoryService, DTOService dtoConverter) {
        this.recipeCategoryService = recipeCategoryService;
        this.dtoConverter = dtoConverter;
    }

    @Override
    public RecipeCategoryDTO create(RecipeCategoryForm recipeCategoryForm) {
        RecipeCategoryDTO recipeCategoryDTO = new RecipeCategoryDTO();
        RecipeCategory recipeCategory = recipeCategoryService.create(recipeCategoryForm);

        recipeCategoryDTO.setId(recipeCategory.getId());
        recipeCategoryDTO.setCategory(recipeCategory.getCategory());

        return recipeCategoryDTO;

    }

    @Override
    public RecipeCategoryDTO findById(String id) {
        RecipeCategory recipeCategory = recipeCategoryService.findById(id);

        return dtoConverter.toFullRecipeCategoryDTO(recipeCategory);
    }

    @Override
    public List<RecipeCategoryDTO> findAll() {
        List<RecipeCategoryDTO> recipeCategoryDTOS = new ArrayList<>();
        List<RecipeCategory> recipeCategoryList = recipeCategoryService.findAll();
        for (RecipeCategory r : recipeCategoryList){
            RecipeCategoryDTO dto = new RecipeCategoryDTO();
            dto.setId(r.getId());
            dto.setCategory(r.getCategory());
            recipeCategoryDTOS.add(dto);
        }
        return recipeCategoryDTOS;
    }


    @Override
    public RecipeCategoryDTO update(String id, RecipeCategoryForm recipeCategoryForm) {
        RecipeCategory recipeCategory = recipeCategoryService.update(id,recipeCategoryForm);

        return dtoConverter.toFullRecipeCategoryDTO(recipeCategory);
    }

    @Override
    public void delete(String id) {
        recipeCategoryService.delete(id);

    }
}
