package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLEncoder;
import java.net.http.HttpRequest;

@Controller
@ResponseBody
public class C {


    @GetMapping("/set")
    public String setContext(HttpServletRequest request) {
        request.getServletContext().setAttribute("hello", "world");
        return "ok";
    }

    @GetMapping("get")
    public String getContext(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String hello = (String) request.getServletContext().getAttribute("hello");
        if (hello == null) {
            RequestDispatcher requestDispatcher = request.getServletContext().getRequestDispatcher("/set");
            requestDispatcher.forward(request, response);
            System.out.println("你是第一次访问本站，已经转发到set");
        }
        return "Hello " + hello;
    }

    @GetMapping("/down")
    public void download(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode("中文名.png","UTF-8"));
        FileInputStream fileInputStream = new FileInputStream("/home/ray/Pictures/2021-08-24_20-41_1.png");
        ServletOutputStream outputStream = response.getOutputStream();
        byte[] bytes = new byte[128];
        int len = 0;
        while ((len = fileInputStream.read(bytes)) > 0) {
            outputStream.write(bytes);
        }
        fileInputStream.close();
        outputStream.close();


    }
    @GetMapping("redirect")
    public void redirect(String website,HttpServletResponse response)
    {
        try {
            response.sendRedirect(website);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @GetMapping("/setCookie")
    public void setCookie(HttpServletRequest request,HttpServletResponse response) {
        response.addCookie(new Cookie("lastLoginTime", System.currentTimeMillis() + ""));
        Cookie lastLoginTime = new Cookie("lastLoginTime", System.currentTimeMillis() + "");
        lastLoginTime.setMaxAge(24);
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(24 * 60 * 60);

    }
    @RequestMapping("/cookieTest")
    public String cookieTest(HttpServletRequest request,Ht)
    {
        request.getCookies()


}
