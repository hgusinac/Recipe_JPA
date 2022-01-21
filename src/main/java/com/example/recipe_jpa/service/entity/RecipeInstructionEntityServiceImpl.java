package com.example.recipe_jpa.service.entity;

import com.example.recipe_jpa.database.RecipeInstructionDAO;
import com.example.recipe_jpa.model.DTO.form.RecipeInstructionForm;
import com.example.recipe_jpa.model.entities.RecipeInstruction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RecipeInstructionEntityServiceImpl implements RecipeInstructionEntityService {

    private final RecipeInstructionDAO recipeInstructionDAO;

    @Autowired
    public RecipeInstructionEntityServiceImpl(RecipeInstructionDAO recipeInstructionDAO) {
        this.recipeInstructionDAO = recipeInstructionDAO;
    }

    @Override
    public RecipeInstruction create(RecipeInstructionForm recipeInstructionForm) {
        if(recipeInstructionForm == null){
            throw new IllegalArgumentException("RecipeInstructionForm was null");
        }

        RecipeInstruction recipeInstruction = new RecipeInstruction();

        recipeInstruction.setId(recipeInstructionForm.getId());
        recipeInstruction.setInstructions(recipeInstructionForm.getInstructions());

        return recipeInstructionDAO.save(recipeInstruction);
    }

    @Override
    public RecipeInstruction findById(String id) {
        return recipeInstructionDAO.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Could not find RecipeInstruction whit id " + id));
    }

    @Override
    public List<RecipeInstruction> findAll() {
        return recipeInstructionDAO.findAll();
    }

    @Override
    public RecipeInstruction update(String id, RecipeInstructionForm recipeInstructionForm) {
       RecipeInstruction recipeInstruction = findById(id);

       recipeInstruction.setInstructions(recipeInstructionForm.getInstructions());

       return recipeInstructionDAO.save(recipeInstruction);
    }

    @Override
    public void delete(String id) {
        RecipeInstruction recipeInstruction = findById(id);
        recipeInstructionDAO.delete(recipeInstruction);

    }
}
