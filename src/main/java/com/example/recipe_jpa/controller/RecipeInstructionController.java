package com.example.recipe_jpa.controller;

import com.example.recipe_jpa.model.DTO.form.RecipeInstructionForm;
import com.example.recipe_jpa.model.DTO.view.RecipeInstructionDTO;
import com.example.recipe_jpa.service.facade.RecipeInstructionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecipeInstructionController {

    private final RecipeInstructionService recipeInstructionService;

    public RecipeInstructionController(RecipeInstructionService recipeInstructionService) {
        this.recipeInstructionService = recipeInstructionService;
    }
    //Funkar
    @PostMapping("/api/v1/instructions")
    public ResponseEntity<RecipeInstructionDTO>create(@RequestBody RecipeInstructionForm form){
        RecipeInstructionDTO instructionDTO = recipeInstructionService.create(form);
        return ResponseEntity.status(201).body(instructionDTO);
    }
    //Funkar
    @GetMapping("/api/v1/instructions")
    public ResponseEntity<List<RecipeInstructionDTO>>find(){
        return ResponseEntity.ok(
                recipeInstructionService.findAll()
        );
    }

    //Funkar
    @GetMapping("/api/v1/instructions/{id}")

    public ResponseEntity<RecipeInstructionDTO>findById(@PathVariable("id") String id){
        return ResponseEntity.ok(
                recipeInstructionService.findById(id)
        );
    }

    @PutMapping("/api/v1/instructions/{id}")
    public ResponseEntity<RecipeInstructionDTO>update(@PathVariable("id") String id,@RequestBody RecipeInstructionForm form){

        return ResponseEntity.ok(recipeInstructionService.update(id,form));

    }
    //Funkar
    @DeleteMapping("/api/v1/instructions/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id){
        recipeInstructionService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
