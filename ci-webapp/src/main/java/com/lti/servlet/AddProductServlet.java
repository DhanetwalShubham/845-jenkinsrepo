package com.lti.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lti.dao.ProductDao;
import com.lti.entity.Product;

/**
 * Servlet implementation class AddProductServlet
 */
public class AddProductServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Product p = new Product();
		p.setId(Integer.parseInt(request.getParameter("id")));
		p.setName(request.getParameter("name"));
		p.setPrice(Float.parseFloat(request.getParameter("price")));
		
		ProductDao dao = new ProductDao();
		dao.insert(p);
		//below line if getting servlet html response as string output
		response.setContentType("text/html");
		response.getWriter().write("Product added successfully. <a href='addProduct.jsp'>Click Here</a> to add more products");
		//response.sendRedirect("addProduct.jsp");
	}

}