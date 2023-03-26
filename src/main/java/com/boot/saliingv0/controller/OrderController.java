package com.boot.saliingv0.controller;

import com.boot.saliingv0.service.OrderService;
import com.boot.saliingv0.vo.Order_list;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log4j2
public class OrderController {
  @Autowired
  OrderService orderService;
  @GetMapping("/order")
  public String order(Model model){
    // Data 만들기
    List<Order_list> list = orderService.doList();

    log.info("================================================================");
    log.info(list);
    log.info("================================================================");
    model.addAttribute("list", list);
    model.addAttribute("hello", " ======================= OrderCon =======================");
    return "views/order/order";
  }

}
