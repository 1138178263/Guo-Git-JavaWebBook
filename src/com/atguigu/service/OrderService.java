package com.atguigu.service;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.Order;
import com.atguigu.pojo.OrderItem;
import com.atguigu.pojo.User;

import java.util.List;

public interface OrderService {
    /**
     * 生成订单
     * @param cart
     * @param userId
     * @return
     */
    public String createOrder(Cart cart, Integer userId);

    /**
     * 查询全部订单
     * @return
     */
    public List<Order> showAllOrders();

    /**
     * 发货
     * @param id
     * @return
     */
    public int sendOrder(Order id);

    /**
     * 根据订单号查找Order
     * @param id
     * @return
     */
    public Order queryOrderByOrderId(String id);

    /**
     * 查看订单详情
     * @param id
     * @return
     */
    public List<OrderItem> showOrderDetail(Order id);

    /**
     * 查询我的订单
     * @param id
     * @return
     */
    public List<Order> showMyOrder(User id);
}
