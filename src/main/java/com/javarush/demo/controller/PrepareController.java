package com.javarush.demo.controller;

import com.javarush.demo.entity.Ingredient;
import com.javarush.demo.entity.Order;
import com.javarush.demo.entity.Shawarma;
import com.javarush.demo.entity.Type;
import com.javarush.demo.repository.IngredientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/prepare")
@SessionAttributes("order")
public class PrepareController {
    private final IngredientRepository ingredientRepository;

    public PrepareController(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @ModelAttribute
public void addIngredientsToModel(Model model) {
	List<Ingredient> ingredients = ingredientRepository.findAll();

	Type[] types = Type.values();
	for (Type type : types) {
	  model.addAttribute(type.toString().toLowerCase(),
	      filterByType(ingredients, type));
	}
  }

  @ModelAttribute(name = "order")
  public Order order() {
    return new Order();
  }

  @ModelAttribute(name = "shawarma")
  public Shawarma shawarma() {
    return new Shawarma();
  }

  @GetMapping
  public String showDesignForm() {
    return "prepare";
  }

  @PostMapping
  public String processShawarma(Shawarma shawarma,
  			@ModelAttribute Order order) {
      order.addShawarma(shawarma);

    return "redirect:/order";
  }


  private Iterable<Ingredient> filterByType(
      List<Ingredient> ingredients, Type type) {
    return ingredients
              .stream()
              .filter(x -> x.getType().equals(type))
              .toList();
  }

}
