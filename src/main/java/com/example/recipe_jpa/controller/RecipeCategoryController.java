package com.example.recipe_jpa.controller;

import com.example.recipe_jpa.model.DTO.form.IngredientForm;
import com.example.recipe_jpa.model.DTO.form.RecipeCategoryForm;
import com.example.recipe_jpa.model.DTO.form.RecipeForm;
import com.example.recipe_jpa.model.DTO.view.IngredientDTO;
import com.example.recipe_jpa.model.DTO.view.RecipeCategoryDTO;
import com.example.recipe_jpa.service.facade.RecipeCategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecipeCategoryController {

    private final RecipeCategoryService recipeCategoryService;

    public RecipeCategoryController(RecipeCategoryService recipeCategoryService) {
        this.recipeCategoryService = recipeCategoryService;
    }


    //Funkar-dock ingen text på category
    @PostMapping("/api/v1/recipeCategory")
    public ResponseEntity<RecipeCategoryDTO> create(@RequestBody RecipeCategoryForm form){

        RecipeCategoryDTO categoryDTO = recipeCategoryService.create(form);
        return ResponseEntity.status(201).body(categoryDTO);


    }


    //FUNKAR
    @GetMapping("/api/v1/recipeCategory")
   public ResponseEntity<List<RecipeCategoryDTO>>find(){
        return ResponseEntity.ok(
                recipeCategoryService.findAll()
        );
    }

    //FUNKAR
    @GetMapping("/api/v1/recipeCategory/{id}")
    public ResponseEntity<RecipeCategoryDTO>findById(@PathVariable("id") String id){
        return ResponseEntity.ok(recipeCategoryService.findById(id)
        );
    }

    //FUNKAR
    @PutMapping("/api/v1/recipeCategory/{id}")
    public ResponseEntity<RecipeCategoryDTO>update(@PathVariable("id") String id,@RequestBody RecipeCategoryForm form){
        return  ResponseEntity.ok(recipeCategoryService.update(id,form));
    }

    //FUNKAR
    @DeleteMapping("/api/v1/recipeCategory/{id}")
    public ResponseEntity<RecipeCategoryDTO>delete(@PathVariable("id") String id){
        recipeCategoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
