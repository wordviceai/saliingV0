package com.boot.saliingv0.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MenuServiceTest {

  @Autowired
  MenuService menuService;
  @Test
  void doUpdateInsert() {
    List<String> chkList = new ArrayList<>();
    chkList.add("1");
    chkList.add("2");

    String strPrice = "22222";
    try{
      menuService.doUpdateInsert(chkList, strPrice);
    }catch (Exception e){
      System.out.println("============================= Test ================" e.getMessage());
    }

  }
}