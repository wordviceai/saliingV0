package com.boot.saliingv0.dao;

import com.boot.saliingv0.vo.Order_list;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderDao {

  List<Order_list> doList();
}
