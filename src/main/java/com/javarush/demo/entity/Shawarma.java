package com.javarush.demo.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
