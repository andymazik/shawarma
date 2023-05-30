package com.javarush.demo.entity;

import lombok.Data;

@Data
public class Ingredient {
  
  private final String id;
  private final String name;
  private final Type type;

}
