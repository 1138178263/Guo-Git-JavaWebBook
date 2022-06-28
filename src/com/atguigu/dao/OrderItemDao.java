package com.atguigu.dao;

import com.atguigu.pojo.Order;
import com.atguigu.pojo.OrderItem;

import java.util.List;

public interface OrderItemDao {
    /**
     * 保存订单项
     * @param orderItem
     * @return
     */
    public int saveOrderItem(OrderItem orderItem);

    /**
     * 根据订单号查看订单明细
     * @param id
     * @return
     */
    public List<OrderItem> queryOrderItemsByOrderId(Order id);
}
