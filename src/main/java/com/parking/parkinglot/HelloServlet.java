package com.parking.parkinglot;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");

        String contextPath = request.getContextPath();
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\"><head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
        out.println("<title>Hello Servlet - Parking Lot</title>");
        out.println("<link rel=\"stylesheet\" href=\"" + contextPath + "/css/bootstrap.min.css\">");
        out.println("</head><body>");
        out.println("<div class=\"container py-5\">");
        out.println("<div class=\"card shadow-sm\"><div class=\"card-body\">");
        out.println("<h1 class=\"card-title text-primary\">" + message + "</h1>");
        out.println("<p class=\"card-text\">Served with Bootstrap styling.</p>");
        out.println("<a href=\"" + (contextPath.isEmpty() ? "/" : contextPath) + "\" class=\"btn btn-outline-secondary\">Back to Home</a>");
        out.println("</div></div></div>");
        out.println("<script src=\"" + contextPath + "/js/bootstrap.bundle.min.js\"></script>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}
