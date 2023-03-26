package com.boot.saliingv0.service;

import com.boot.saliingv0.dao.MenuDao;
import com.boot.saliingv0.vo.CoffeeMenu;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@Log4j2
public class MenuService {
  @Autowired
  MenuDao menuDao;

  public MenuService(){
    log.info("/생성자 호출 ====================================================");
  }

  public List<CoffeeMenu> doList() {
    List<CoffeeMenu> list = menuDao.doList();
    log.info(list);
    return list;
  }
  public Map<String, Object> doUListOne(String strNo) {
    Map<String, Object> map = menuDao.doListOne(strNo);
    return map;
  }

  public int doInsert(CoffeeMenu coffeeMenu) {

    int addCoffee = menuDao.doInsert(coffeeMenu);
    return addCoffee;
  }

  public int doDelete(CoffeeMenu coffeeMenu) {
    int delCoffee = menuDao.doDelete(coffeeMenu);
    return delCoffee;
  }
  // One row 조회
  public Map<String, Object> doListOne(String strNo) {
    Map<String, Object> map = menuDao.doListOne(strNo);
    return map;
  }

  //  UPdate
  public int doUpdate(CoffeeMenu coffeeMenu) {
    int modCoffee = menuDao.doUpdate(coffeeMenu);
    return modCoffee;
  }

  public List<CoffeeMenu> doSearch(String strStartDate, String strEndDate, String strCoffee, String strKind) {
    List<CoffeeMenu> list = menuDao.doSearch(strStartDate, strEndDate, strCoffee, strKind);
    return list;
  }

//  public int doUpdatePrice(@RequestParam("chkList")List<String> chkList,
//                           @RequestParam("hidden_price") String strPrice) {
////    int updatePrice = menuDao.doUpdatePrice(strNo, strPrice);
////    return updatePrice;
//
//    File file = new File("not_existing_file.txt");
//    FileInputStream fileInputStream = new FileInputStream(file);
//
//
//    try {
//      if (chkList != null) {
//        for (String strNo : chkList) {
//          int int1 = menuDao.doInsertLogOne(strNo, strPrice);
//          int int2 = menuDao.doUpdatePrice(strNo, strPrice);
//        }
//        int int1 = menuSvc.doUpdateInsert(chkList, strPrice);
//
//      }
//    } catch (Exception e) {
//      System.out.println(e.getMessage());
//    }
//    return file;
//  }
//
//  public int doInsertLog(String strNo, String strPrice) {
//    int insertLog = menuDao.doInsertLog(strNo, strPrice);
//    return insertLog;
//  }

  public int insertLogOne(List<String> chkList, String strPrice) {
    int insertLogOne = menuDao.doInsertLogOne(chkList, strPrice);
    return insertLogOne;
  }
  public int doUpdatePriceOne(List<String> chkList, String strPrice) {
    int updatePriceOne = menuDao.doUpdatePriceOne(chkList, strPrice);
    return updatePriceOne;
  }

  @Transactional
  public int doUpdateInsert(List<String> chkList, String strPrice) {
    log.info("===============================================================================");

    int insertLogOne = menuDao.doInsertLogOne(chkList, strPrice);
    int updatePriceOne = menuDao.doUpdatePriceOne(chkList, strPrice);
    return insertLogOne;
  }
//  @Transactional
//  public int doUpdateInsertFile(List<String> chkList, String strPrice){
//
//  }

}
