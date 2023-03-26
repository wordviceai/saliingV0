package com.boot.saliingv0.controller;

import com.boot.saliingv0.service.MemberService;
import com.boot.saliingv0.vo.Cust_Info;
import com.boot.saliingv0.vo.Order_list;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Log4j2
public class MemberController {
  @Autowired
  MemberService memberService;
  @GetMapping("/member")
  public String order(Model model){
    // Data 만들기
    List<Cust_Info> list = memberService.doList();

    log.info("================================================================");
    log.info(list);
    log.info("================================================================");
    model.addAttribute("list", list);
    model.addAttribute("hello", " ======================= OrderCon =======================");
    return "views/member/member";
  }
  @GetMapping("/member_search")
  public String memberSearch(){
    return "views/member/member_search";
  }
  @PostMapping("/member_search")
  public String memberSearchPost(@RequestParam("start_date") String strStartDate,
                                @RequestParam("end_date") String strEndDate,
                                @RequestParam(value="coffee", defaultValue = "ALL")String strCoffee,
                                @RequestParam("name") String strName,
                                Model model){
    log.info("========================================================================================================================");
    log.info("start_date:" + strStartDate + ", end_date:" + strEndDate + ", coffee:" + strCoffee + ", name:" + strName);
    log.info("========================================================================================================================");
    List<Cust_Info> list = memberService.doSearch(strStartDate,strEndDate,strCoffee,strName);
    model.addAttribute("list", list);
    return "views/member/member";
  }
}
