package com.boot.saliingv0.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LogController {
  @GetMapping("/login")
  public String login(){
    return "/views/login/login";
  }
}
