/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wanchana.servlet.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author neng
 */
public class Myservlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        String greeting = req.getParameter("name");
//        resp.getWriter().append("Hello " + greeting);
        String fileName = req.getParameter("name");
        
        File file = new File("/home/neng/" + fileName);

        OutputStream outputStream = null;
        FileInputStream fileInputStream = null;

        try {
            outputStream = resp.getOutputStream();
            fileInputStream = new FileInputStream(file);

            byte[] buffer = new byte[1024];
            int length = 0;
            
            while((length = fileInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, length);
                outputStream.flush();
            }

        } catch (Exception e) {
            System.out.println("An error accured!");
            e.printStackTrace();
        } finally {
            fileInputStream.close();
            outputStream.close();
        }
    }
}
