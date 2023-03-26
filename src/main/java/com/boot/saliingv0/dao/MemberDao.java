package com.boot.saliingv0.dao;

import com.boot.saliingv0.vo.Cust_Info;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MemberDao {

  List<Cust_Info> doList();


  List<Cust_Info> doSearch(@Param("strStartDate") String strStartDate, @Param("strEndDate") String strEndDate, @Param("strCoffee") String strCoffee, @Param("strName") String strName);
}
