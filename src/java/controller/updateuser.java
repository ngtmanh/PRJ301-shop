/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DBcontext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Customers;

/**
 *
 * @author admin
 */
public class updateuser extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet updateuser</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet updateuser at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            DBcontext db = new DBcontext();
            String email = request.getParameter("email");

            ArrayList<Customers> customerses = db.get_list_Customer(email);
            if (customerses.isEmpty()) {
                request.setAttribute("msg", "Not find email");
            } else {
                request.setAttribute("user", customerses);
            }
            request.getRequestDispatcher("updateuser.jsp").forward(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(updateproduct.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(updateproduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id =Integer.parseInt(request.getParameter("id"));
            String user =request.getParameter("name");
            String email = request.getParameter("email");
            String pass = request.getParameter("password");
            String address = request.getParameter("address");
            String phone = request.getParameter("phone");
            
            Customers c = new Customers();
            c.setCustomerID(id);
            c.setName(user);
            c.setEmail(email);
            c.setAddress(address);
            c.setPassword(pass);
            c.setPhoneNumber(phone);
            DBcontext db = new DBcontext();
            db.update_User(c);
            
            request.setAttribute("msg", "SUCCESFULL");
            request.getRequestDispatcher("updateuser.jsp").forward(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(updateuser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(updateuser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
