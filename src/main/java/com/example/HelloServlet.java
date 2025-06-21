package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "helloServlet", urlPatterns = {"/hello"})
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Xin chào</title></head>");
        out.println("<body>");
        out.println("<h1>Chào mừng bạn đến với dự án Java Servlet của chúng tôi!</h1>");
        out.println("<p>Đây là một ví dụ đơn giản về cách sử dụng Servlet.</p>");
        out.println("</body>");
        out.println("</html>");
    }
}

