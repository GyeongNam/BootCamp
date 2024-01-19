package com.encore.Spring_basic.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
controller 가 아닌 WebServlet 를 통해 라우팅
 */
@WebServlet("/hello-servlet-jsp-post")
public class HttpServletJspPost extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name") ;
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        // 콘솔 출력
        System.out.println(name + " " + email + " " + password);

        // 응답 header
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");

        // 응답 body
        PrintWriter out = resp.getWriter();
        out.print("ok");
        out.flush();
    }
}
