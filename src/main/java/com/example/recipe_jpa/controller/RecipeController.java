package com.example.recipe_jpa.controller;

import com.example.recipe_jpa.model.DTO.form.RecipeForm;
import com.example.recipe_jpa.model.DTO.view.RecipeDTO;
import com.example.recipe_jpa.service.facade.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping("/api/v1/recipes")
    public ResponseEntity<RecipeDTO>create(@RequestBody RecipeForm form){
        return ResponseEntity.status(201).body(
                recipeService.create(form)
        );

    }

    @GetMapping("/api/v1/recipes")
    public ResponseEntity<List<RecipeDTO>>find(){
        return ResponseEntity.ok(
                recipeService.findAll()
        );
    }

    @GetMapping("/api/v1/recipes/{id}")
    public ResponseEntity<RecipeDTO>findById(@PathVariable("id") String id){
        return ResponseEntity.ok(
                recipeService.findById(id)
        );
    }

    @PutMapping("/api/v1/recipes/{id}")
    public ResponseEntity<RecipeDTO>update(@PathVariable("id") String id,@RequestBody RecipeForm form){

        return ResponseEntity.ok(recipeService.update(id,form));

    }

    @DeleteMapping("/api/v1/recipes/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id){
        recipeService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
