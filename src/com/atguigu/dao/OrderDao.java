package com.atguigu.dao;

import com.atguigu.pojo.Order;
import com.atguigu.pojo.User;

import java.util.List;


public interface OrderDao {
    /**
     * 保存订单
     * @param order
     * @return
     */
    public int saveOrder(Order order);

    /**
     *查询全部订单
     * @return
     */
    public List<Order> queryOrders();

    /**
     * 修改订单状态
     * @param id
     * @param status
     * @return
     */
    public int changeOrderStatus(Order id,Integer status);

    /**
     * 根据订单号查找Order
     * @param id
     * @return
     */
    public Order queryOrderByOrderId(String id);

    /**
     * 根据用户编号查询订单信息
     * @param id
     * @return
     */
    public List<Order> queryOrdersByUserId(User id);
}
