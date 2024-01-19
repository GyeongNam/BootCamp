package com.encore.Spring_basic.servlet;

import com.encore.Spring_basic.domain.Hello;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello-servlet-rest-post")
public class HelloServletRestPost extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        Hello hello = null;
        if(req.getContentType().equals("application/json")){
            hello = mapper.readValue(req.getReader(),Hello.class);
            System.out.println(hello);
        }

        // 응답 header
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");

        // 응답 body
        PrintWriter out = resp.getWriter();
        out.print("ok");
        out.flush();
    }
}
