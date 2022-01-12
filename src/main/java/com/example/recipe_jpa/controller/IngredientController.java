package com.example.recipe_jpa.controller;


import com.example.recipe_jpa.model.DTO.form.IngredientForm;
import com.example.recipe_jpa.model.DTO.view.IngredientDTO;
import com.example.recipe_jpa.model.entities.Ingredient;
import com.example.recipe_jpa.service.facade.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IngredientController {

   private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }



    @PostMapping("/api/v1/ingredient")
    public ResponseEntity<IngredientDTO>create(@RequestBody IngredientForm form){

        IngredientDTO ingredient = ingredientService.create(form);
        return ResponseEntity.status(201).body(ingredient);

    }

    @GetMapping("/api/v1/ingredient")

    public ResponseEntity<List<IngredientDTO>> find(){
        return ResponseEntity.ok(
                ingredientService.findAll()
        );
    }


    @GetMapping("/api/v1/ingredient/{id}")
    public ResponseEntity<IngredientDTO>findById(@PathVariable ("id") String id){
        return ResponseEntity.ok(ingredientService.findById(id)
        );
    }

    @PutMapping("/api/v1/ingredient/{id}")
    public ResponseEntity<IngredientDTO>update(@PathVariable("id") String id,@RequestBody IngredientForm form){
        return ResponseEntity.ok(ingredientService.update(id,form));

    }
    @DeleteMapping("/api/v1/ingredient/{id}")

    public ResponseEntity<IngredientDTO>delete(@PathVariable("id") String id){
        ingredientService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
