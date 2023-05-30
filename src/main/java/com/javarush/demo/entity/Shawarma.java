package com.javarush.demo.entity;

import lombok.Data;

import java.util.List;

@Data
public class Shawarma {

  private String name;

  private List<Ingredient> ingredients;

}
