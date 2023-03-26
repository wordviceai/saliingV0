package com.boot.saliingv0.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {
  @GetMapping({"/", "/home"})
  public String home(){
    return "views/home";
  }
  @GetMapping("/rest")
  @ResponseBody
  public String doRest(){
    String strHtml="<html><body> Hi Rest, Controller + ResponseBody !! <hr> Hi. </body></html>";
    return strHtml;
  }

}
