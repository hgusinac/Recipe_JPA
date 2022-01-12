package com.example.recipe_jpa.service.facade;

import com.example.recipe_jpa.model.DTO.form.IngredientForm;
import com.example.recipe_jpa.model.DTO.view.IngredientDTO;
import com.example.recipe_jpa.model.entities.Ingredient;
import com.example.recipe_jpa.service.entity.IngredientEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class IngredientServiceImpl implements com.example.recipe_jpa.service.facade.IngredientService {


  public final IngredientEntityService ingredientEntityService;
  public final DTOService dtoConverter;



    public IngredientServiceImpl(IngredientEntityService ingredientEntityService, DTOService dtoConverter) {
        this.ingredientEntityService = ingredientEntityService;
        this.dtoConverter = dtoConverter;
    }



    @Override
    public IngredientDTO create(IngredientForm form) {
        IngredientDTO ingredientDTO = new IngredientDTO();
        Ingredient ingredient = ingredientEntityService.create(form);

        ingredientDTO.setId(ingredient.getId());
        ingredientDTO.setIngredientName(ingredient.getIngredientName());

        return ingredientDTO;

    }

    @Override
    public IngredientDTO findById(String id) {

      Ingredient ingredient = ingredientEntityService.findById(id);
        return dtoConverter.toFullIngredientDTO(ingredient);
    }

    @Override
    public List<IngredientDTO> findAll() {

      List<IngredientDTO> ingredientDTOS = new ArrayList<>();
      List<Ingredient> ingredients = ingredientEntityService.findAll();
      for (Ingredient i :ingredients){
          IngredientDTO dto = new IngredientDTO();
          dto.setId(i.getId());
          dto.setIngredientName(i.getIngredientName());
          ingredientDTOS.add(dto);
      }
      return ingredientDTOS;
    }

    @Override
    public IngredientDTO update(String id, IngredientForm form) {
       Ingredient ingredient = ingredientEntityService.update(id,form);
       return dtoConverter.toFullIngredientDTO(ingredient);
    }

    @Override
    public void delete(String id) {
        ingredientEntityService.delete(id);

    }
}
