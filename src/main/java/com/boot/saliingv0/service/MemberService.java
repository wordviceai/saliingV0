package com.boot.saliingv0.service;

import com.boot.saliingv0.dao.MemberDao;
import com.boot.saliingv0.vo.Cust_Info;
import com.boot.saliingv0.vo.Order_list;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Log4j2
public class MemberService {
  @Autowired
  MemberDao memberDao;

  public List<Cust_Info> doList() {
    List<Cust_Info> list = memberDao.doList();
    return list;
  }

  public List<Cust_Info> doSearch(String strStartDate, String strEndDate, String strCoffee, String strName) {
    List<Cust_Info> list = memberDao.doSearch(strStartDate,strEndDate,strCoffee,strName);
    return list;
  }
}
