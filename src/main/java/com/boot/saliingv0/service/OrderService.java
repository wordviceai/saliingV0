package com.boot.saliingv0.service;

import com.boot.saliingv0.dao.OrderDao;
import com.boot.saliingv0.vo.Order_list;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
  @Autowired
  OrderDao orderDao;

  public List<Order_list> doList() {
    List<Order_list> list = orderDao.doList();

    return list;
  }
}
