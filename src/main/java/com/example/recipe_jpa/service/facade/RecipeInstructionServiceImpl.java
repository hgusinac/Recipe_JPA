package com.example.recipe_jpa.service.facade;

import com.example.recipe_jpa.database.RecipeIngredientDAO;
import com.example.recipe_jpa.database.RecipeInstructionDAO;
import com.example.recipe_jpa.model.DTO.form.RecipeInstructionForm;
import com.example.recipe_jpa.model.DTO.view.RecipeInstructionDTO;
import com.example.recipe_jpa.model.entities.RecipeInstruction;
import com.example.recipe_jpa.service.entity.RecipeInstructionEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RecipeInstructionServiceImpl implements RecipeInstructionService {

    private final RecipeInstructionEntityService recipeInstructionEntityService;
    private final DTOService dtoService;

    @Autowired
    public RecipeInstructionServiceImpl(RecipeInstructionEntityService recipeInstructionEntityService, DTOService dtoService) {
        this.recipeInstructionEntityService = recipeInstructionEntityService;
        this.dtoService = dtoService;
    }

    @Override
    public RecipeInstructionDTO create(RecipeInstructionForm recipeInstructionForm) {

        RecipeInstruction recipeInstruction = recipeInstructionEntityService.create(recipeInstructionForm);
        return dtoService.toFullRecipeInstructionDTO(recipeInstruction);
    }

    @Override
    public RecipeInstructionDTO findById(String id) {
        RecipeInstruction recipeInstruction = recipeInstructionEntityService.findById(id);
        return dtoService.toFullRecipeInstructionDTO(recipeInstruction);
    }

    @Override
    public List<RecipeInstructionDTO> findAll() {
        return recipeInstructionEntityService.findAll().stream()
                .map(dtoService::toFullRecipeInstructionDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RecipeInstructionDTO update(String id, RecipeInstructionForm recipeInstructionForm) {
        RecipeInstruction recipeInstruction = recipeInstructionEntityService.update(id,recipeInstructionForm);
        return dtoService.toFullRecipeInstructionDTO(recipeInstruction);
    }

    @Override
    public void delete(String id) {
        recipeInstructionEntityService.delete(id);

    }
}
