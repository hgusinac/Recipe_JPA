package com.example.recipe_jpa.database;

import com.example.recipe_jpa.model.entities.RecipeInstruction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeInstructionDAO extends JpaRepository<RecipeInstruction,String> {
}
