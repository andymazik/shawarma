package com.javarush.demo.entity;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class Shawarma {
  @NotNull
  @Size(min = 3, message = "Имя должно содержать минимум 3 символа")
  private String name;

  @NotNull
  @Size(min = 2, message = "Вы должны выбрать минимум 2 ингредиента")
  private List<Ingredient> ingredients;

}
