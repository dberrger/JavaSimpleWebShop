package TestServlet.controller;

import TestServlet.service.CommentManager;
import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "CommentHandler",urlPatterns = "/CommentHandler")
public class CommentHandler extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JSONObject jsonObject = new JSONObject();
        int indicator;
        CommentManager commentManager = new CommentManager();
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        System.out.println("OKei 2222222232323231!");
        System.out.println(request.getParameter("all"));
        System.out.println(request.getParameter("params"));
        if(request.getParameter("all").equals("1")){
            System.out.println("OKei 1!");
        indicator = 1;
        request.getParameter("params");
        System.out.println(request.getParameter("params"));
        commentManager.addComment(request.getUserPrincipal().getName(), request.getParameter("params"));
        jsonObject = commentManager.getCommentsList(request.getUserPrincipal().getName(), indicator);
        System.out.println(jsonObject);
        PrintWriter printWriter = response.getWriter();
        printWriter.println(jsonObject);
        }
        else if(request.getParameter("all").equals("all")){
            indicator = 2;
            System.out.println("OKei ALL!");
            jsonObject = commentManager.getCommentsList(request.getUserPrincipal().getName(),indicator);
            PrintWriter printWriter = response.getWriter();
            printWriter.println(jsonObject);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Hello CommentHandler");
    }
}
