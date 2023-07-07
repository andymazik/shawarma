package com.javarush.demo.controller;

import com.javarush.demo.entity.Order;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Controller
@RequestMapping("/order")
@SessionAttributes("order")
public class OrderController {

  @GetMapping
  public String orderForm() {
    return "order";
  }

  @PostMapping
  public String processOrder(@Valid Order order,
                             Errors errors,
                             SessionStatus sessionStatus) {
    if (errors.hasErrors()) {
      return "order";
    }

    sessionStatus.setComplete();

    return "redirect:/";
  }

}
