package com.boot.saliingv0.dao;

import com.boot.saliingv0.vo.CoffeeMenu;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MenuDao {

  List<CoffeeMenu> doList();
  List<CoffeeMenu> doSearch(@Param("strStartDate")String strStartDate, @Param("strEndDate")String strEndDate,
                                    @Param("strCoffee")String strCoffee, @Param("strKind")String strKind);
  Map<String, Object> doListOne(@Param("strNo") String strNo);
  int doInsert(CoffeeMenu coffeeMenu);

  int doDelete(CoffeeMenu coffeeMenu);

  int doUpdate(CoffeeMenu coffeeMenu);


//  int doUpdatePrice(@Param("strNo")String strNo, @Param("strPrice")String strPrice);
//
//  int doInsertLog(@Param("strNo")String strNo, @Param("strPrice")String strPrice);

  int doInsertLogOne(@Param("chkList")List<String> chkList, @Param("strPrice")String strPrice);
  int doUpdatePriceOne(@Param("chkList")List<String> chkList, @Param("strPrice")String strPrice);

    int doUpdatePrice(String strNo, String strPrice);
}
