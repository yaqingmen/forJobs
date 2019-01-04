package com.seu.servlet;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CarServlet
 */
public class CarServlet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取商品id
		int id = Integer.parseInt(request.getParameter("id"));
		String[] names= {"Iphone7","小米6","三星note8","魅族7","华为9"};
		String name=names[id];
		
		response.setContentType("text/html;charset=utf-8");
		
		//2.获取购物车存放的session
		Map<String,Integer> map = (Map<String, Integer>) request.getSession().getAttribute("cart");
		if(map==null) {
			//首次没有属性cart ---map存放iphon7 3等购物车信息
			map=new LinkedHashMap<String,Integer>();
			//map.put(name,1); 
			request.getSession().setAttribute("cart", map);		
		}
		
		//3.判读购物车中是否包含要购的商品
		if(map.containsKey(name)) {
			map.put(name, map.get(name)+1);//如果以前已经购过该商品，在原来数量的基础+1
		}
		else {
			map.put(name,1);   //如果第一次购物，数量为 1
		}
		
		//4.输出界面（跳转）
		response.getWriter().write("<a href='product_list.jsp'><h3>继续购物</h3></a><br>");
		response.getWriter().write("<a href='cart.jsp'><h3>去购物车结算</h3></a>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
