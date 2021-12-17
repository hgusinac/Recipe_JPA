package com.example.recipe_jpa.database;

import com.example.recipe_jpa.model.RecipeInstruction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeInstructionDAO extends JpaRepository<RecipeInstruction,Integer> {
}
