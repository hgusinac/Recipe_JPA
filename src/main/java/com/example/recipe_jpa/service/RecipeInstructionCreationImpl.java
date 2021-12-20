package com.example.recipe_jpa.service;

import com.example.recipe_jpa.database.RecipeInstructionDAO;
import com.example.recipe_jpa.model.DTO.RecipeInstructionForm;
import com.example.recipe_jpa.model.entities.RecipeInstruction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RecipeInstructionCreationImpl implements RecipeInstructionCreation{

    private final RecipeInstructionDAO recipeInstructionDAO;

    @Autowired
    public RecipeInstructionCreationImpl(RecipeInstructionDAO recipeInstructionDAO) {
        this.recipeInstructionDAO = recipeInstructionDAO;
    }

    @Override
    public RecipeInstruction save(RecipeInstructionForm recipeInstructionForm) {
        RecipeInstruction recipeInstruction = new RecipeInstruction();

        recipeInstruction.setId(recipeInstruction.getId());
        recipeInstruction.setInstructions(recipeInstruction.getInstructions());

        return recipeInstructionDAO.save(recipeInstruction);
    }

    @Override
    public RecipeInstruction findById(String id) {
        Optional<RecipeInstruction> recipeInstruction = recipeInstructionDAO.findById(id);
        return  recipeInstruction.orElseThrow(()-> new RuntimeException("recipe instruction was not found"));
    }

    @Override
    public List<RecipeInstruction> findAll() {
        return recipeInstructionDAO.findAll();
    }

    @Override
    public void delete(String id) {
        recipeInstructionDAO.deleteById(id);

    }
}
