package TestServlet.controller;

import TestServlet.dao.Product;
import TestServlet.service.ProductManager;
import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//TODO rename &
@WebServlet(name = "FilterServlet", urlPatterns = "/FilterServlet")
public class FilterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        ProductManager toFilter = new ProductManager();
        JSONObject jsonObject = new JSONObject();

        System.out.println("ID;"+ toFilter.getElementById(1));

        Cookie c = new Cookie("lowerBound", request.getParameter("lowerBound"));
        Cookie d = new Cookie("upperBound", request.getParameter("upperBound"));
        Cookie e = new Cookie("indicator", request.getParameter("bua"));

        response.addCookie(c);
        response.addCookie(d);
        response.addCookie(e);

        out.println(toFilter.currentFilterToJSON(toFilter.FilterByPriceRange(request.getParameter("lowerBound"), request.getParameter("upperBound"))));

    }
}
