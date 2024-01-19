package com.encore.Spring_basic.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
controller 가 아닌 WebServlet 를 통해 라우팅
 */
@WebServlet("/hello-servlet-jsp-get")
public class HttpServletJspGet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
        기본 패턴 : req 를 받아 res 를 반환해주는 형식
         */
        req.setAttribute("myData", "jsp test data");
        // 실행시 단일 프로젝트로 실행해야 패스설정이 다른 것 같음
        req.getRequestDispatcher("/WEB-INF/views/hello-jsp.jsp").forward(req, resp);
    }


    /*
    service() 메서드는 서블릿에 들어오는 모든 요청(get, post, put, delete) 을 처리
    다만, 구체적으로 doGet, doPost 메서드를 쓰는게 더 좋은사황
     */
//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setAttribute("myData", "jsp test data");
//        req.getRequestDispatcher("/WEB-INF/views/hello-jsp.jsp").forward(req, resp);
//    }
}
