package TestServlet.controller;

import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TabServlet")
public class TabServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JSONObject tab = new JSONObject();

        if(getInitParameter("default_tab").equals("1")){
           tab.put("default_tab", "1");
        }
        else if (getInitParameter("default_tab").equals("2")) {
            tab.put("default_tab", "2");
        }
        else if(getInitParameter("default_tab").equals("3")){
            tab.put("default_tab", "3");
        }
        PrintWriter out = response.getWriter();
        out.println(tab);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
