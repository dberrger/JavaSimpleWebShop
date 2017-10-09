package TestServlet.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MyProfile", urlPatterns = "/MyProfile")
public class MyProfile extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        HttpSession session = request.getSession();
        printWriter.println("Hidden page! <br> your name is:"+request.getUserPrincipal().getName());
        printWriter.println("Default tab is:"+session.getAttribute("default_tab"));

    }

}

