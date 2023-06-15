package com.javarush.demo.controller;

import com.javarush.demo.entity.Ingredient;
import com.javarush.demo.entity.Order;
import com.javarush.demo.entity.Shawarma;
import com.javarush.demo.entity.Type;
import com.javarush.demo.repository.IngredientRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/prepare", produces = "application/json")
@CrossOrigin(origins = "http://shwarma:8080")
public class PrepareRestController {
    private final IngredientRepository ingredientRepository;

    public PrepareRestController(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }


    @GetMapping
    public List<Ingredient> showIngredients() {
        return ingredientRepository.findAll();
    }

    @GetMapping("/{id}")
    public Ingredient showIngredientById(@PathVariable("id") String id) {
        return ingredientRepository.fidById(id);
    }

    @PostMapping
    public Ingredient addIngredient(@RequestBody Ingredient ingredient) {
        ingredientRepository.save(ingredient);
        System.out.println("Post"+ingredient);
        return ingredient;
    }

    @PutMapping(value = "/{id}", consumes = "application/json")
    public Ingredient putIngredient(@PathVariable("id") String id,
                                    @RequestBody Ingredient ingredient) {
        ingredientRepository.save(ingredient);
        System.out.println("Put"+ingredient);
        return ingredient;
    }

    @PatchMapping(value = "/{id}", consumes = "application/json")
    public Ingredient patchIngredient(@PathVariable("id") String id,
                                    @RequestBody Ingredient ingredient) {
        ingredientRepository.save(ingredient);
        System.out.println("Patch"+ingredient);
        return ingredient;
    }

}
