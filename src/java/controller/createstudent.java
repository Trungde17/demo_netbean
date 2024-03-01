/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import model.Student;

@WebServlet(name = "createstudent", urlPatterns = {"/createstudent"})
public class createstudent extends HttpServlet {

    private static ArrayList<Student> list;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String error = "";
        String numberStudent_Str = request.getParameter("numberStudent");
        if (numberStudent_Str.equals("")) {
            error = "Bạn cần nhập số lượng sinh viên!";
            list = null;
        } else {
            int numberStudent = Integer.parseInt(numberStudent_Str);
            if (numberStudent <= 0) {
                error = "Bạn cần nhập số lượng sinh viên lớn hơn 0!";
                list = null;
            } else {
                list = new ArrayList();
                for (int i = 1; i <= numberStudent; i++) {
                    Student st = new Student();
                    st.randomValues();
                    list.add(st);
                }
                
            }
        }
        Cookie cookU=new Cookie("userC", "TanChun");
        Cookie cookP=new Cookie("passC", "12345");
        cookU.setMaxAge(60);
        cookP.setMaxAge(60);
        response.addCookie(cookU);
        response.addCookie(cookP);
        HttpSession session = request.getSession();
        session.setAttribute("studentList", list);
        request.setAttribute("error", error);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
