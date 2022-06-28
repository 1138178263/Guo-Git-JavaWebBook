package com.atguigu.web;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.utils.WebUtils;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CartServlet extends BaseServlet{

    private BookService bookService = new BookServiceImpl();

    /**
     * 加入购物车
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取请求的参数【商品编号】
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        //调用bookService.queryBookById(id);得到图书信息
        Book book = bookService.queryBookById(id);
        //把图书信息，转化成为CartItem商品项
        CartItem cartItem = new CartItem(book.getId(),book.getName(),1,book.getPrice(),book.getPrice());
        //调用Cart.addItem(cartItem);添加商品项
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if(cart==null){
            cart = new Cart();
            req.getSession().setAttribute("cart",cart);
        }
        cart.addItem(cartItem);
        //最后一个添加的商品名称
        req.getSession().setAttribute("lastName",cartItem.getName());
        //重定向回原来商品的地址页面
        resp.sendRedirect(req.getHeader("Referer"));
    }

    protected void ajaxAddItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取请求的参数【商品编号】
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        //调用bookService.queryBookById(id);得到图书信息
        Book book = bookService.queryBookById(id);
        //把图书信息，转化成为CartItem商品项
        CartItem cartItem = new CartItem(book.getId(),book.getName(),1,book.getPrice(),book.getPrice());
        //调用Cart.addItem(cartItem);添加商品项
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if(cart==null){
            cart = new Cart();
            req.getSession().setAttribute("cart",cart);
        }
        cart.addItem(cartItem);
        //最后一个添加的商品名称
        req.getSession().setAttribute("lastName",cartItem.getName());
        //返回购物车总的商品数量和最后一个添加的商品名称
        Map<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.put("totalCount",cart.getTotalCount());
        resultMap.put("lastName",cartItem.getName());

        Gson gson = new Gson();
        String resultMapJsonString = gson.toJson(resultMap);

        resp.getWriter().write(resultMapJsonString);
    }


    /**
     * 删除商品项
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取商品编号
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        //调用Cart里的deleteItem()方法
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart!=null){
            cart.deleteItem(id);
        }
        //重定向原来购物车展示页面
        resp.sendRedirect(req.getHeader("Referer"));
    }

    /**
     * 清空购物车
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        //2、如果cart对象不为空，调用clear()方法
        if (cart!=null){
            cart.clear();
        }
        //3、重定向回原来购物车展示页面
        resp.sendRedirect(req.getHeader("Referer"));
    }

    /**
     * 修改商品数量
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取请求的参数，商品编号，商品数量
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        int count = WebUtils.parseInt(req.getParameter("count"),1);
        //2、获取购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        //3、如果cart对象不为空，调用clear()方法
        if (cart!=null){
            cart.updateCount(id,count);
        }
        //3、重定向回原来购物车展示页面
        resp.sendRedirect(req.getHeader("Referer"));
    }

}
