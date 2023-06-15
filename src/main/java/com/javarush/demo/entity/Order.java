package com.javarush.demo.entity;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import java.util.ArrayList;
import java.util.List;

@Data
public class Order {
  @NotBlank(message = "Укажите имя")
  private String deliveryName;

  @NotBlank(message = "Укажите адрес доставки")
  private String deliveryStreet;

  @NotBlank(message = "Укажите город проживания")
  private String deliveryCity;

  @NotBlank(message = "Укажите индекс")
  private String deliveryZip;

  @CreditCardNumber(message = "Номер карты указан неверно")
  private String ccNumber;

  @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$",
          message="Дата экспирации должна иметь вид MM/YY")
  private String ccExpiration;

  @Digits(integer=3, fraction=0, message="Неверный CVV")
  private String ccCVV;

  private List<Shawarma> shawarmas = new ArrayList<>();

  public void addShawarma(Shawarma shawarma) {
    this.shawarmas.add(shawarma);
  }
}
