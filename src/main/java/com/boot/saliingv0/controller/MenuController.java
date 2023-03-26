package com.boot.saliingv0.controller;

import com.boot.saliingv0.service.MenuService;
import com.boot.saliingv0.vo.CoffeeMenu;
import java.util.List;
import java.util.Map;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Log4j2
public class MenuController {

  @Autowired
  MenuService menuService;
  @GetMapping("/menu")
  public String doMenu(Model model){
    List<CoffeeMenu> list = menuService.doList();
    model.addAttribute("list", list);
    return "views/menu/menu";
  }

  //  조회하기
  @PostMapping("/menu_search")
  public String doSearch(@RequestParam("start_date")String strStartDate,
      @RequestParam("end_date")String strEndDate,
      @RequestParam(value="coffee", defaultValue = "ALL")String strCoffee,
      @RequestParam("kind")String strKind,
      Model model){

    List<CoffeeMenu> list = menuService.doSearch(strStartDate, strEndDate, strCoffee, strKind);
    log.info("===============================================================================");
    log.info("strStarDate:" + strStartDate);
    log.info("===============================================================================");
    model.addAttribute("list", list);
    return "views/menu/menu";
  }

  @GetMapping("/menu_insert")
  public String doInsert(){
    return "views/menu/menu_insert";
  }
  @PostMapping("/menu_insert")
  public String doInsertPost(@ModelAttribute CoffeeMenu coffeeMenu) {

    log.info("===========================================");
    log.info(coffeeMenu);
    int addCoffee = menuService.doInsert(coffeeMenu);
    log.info("===========================================");
    return "redirect:/menu";
  }
  @GetMapping("/menu_del")
  public String doDelete(CoffeeMenu coffeeMenu){
    log.info("===============================================================================");
    log.info(coffeeMenu);
    log.info("===============================================================================");
    int delCoffee = menuService.doDelete(coffeeMenu);
    return "redirect:/menu";
  }
  //  수정 페이지
  @GetMapping("/menu_update")
  public String doUpdate(Model model, @RequestParam("no") String strNo){
    Map<String, Object> map = menuService.doListOne(strNo);
    log.info("===============================================================================");
    log.info(strNo);
    model.addAttribute("map", map);
    return "views/menu/menu_update";
  }
  @PostMapping("/menu_update")
  public String doUpdatePost(CoffeeMenu coffeeMenu){
    log.info("===============================================================================");
    log.info(coffeeMenu);
    log.info("===============================================================================");
    int modCoffee = menuService.doUpdate(coffeeMenu);
    return "redirect:/menu";
  }

  //가격 수정 ~ 다중 체크
  @PostMapping("/menu_updatePrice")
  public String doUpdatePrice(@RequestParam("chkCoffeeNo") List<String> chkList,
                              @RequestParam("hidden_price") String strPrice){

    if(chkList != null){
//      for(String strNo : chkList){
//        int updatePrice = menuService.doUpdatePrice(strNo, strPrice);
//        int insertLog = menuService.doInsertLog(strNo, strPrice);
//      }
      // 순서가 뒤바뀌면 로그가 찍히지 않음.
      int updateInsert = menuService.doUpdateInsert(chkList, strPrice);
//      int insertPriceOne = menuService.insertLogOne(chkList, strPrice);
//      int updatePriceOne = menuService.doUpdatePriceOne(chkList, strPrice);
    }
    return "redirect:/menu";
  }
}