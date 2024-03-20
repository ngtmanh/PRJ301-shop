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
import model.Coupon;
import model.Customers;
import model.OrderDetails;

/**
 *
 * @author admin
 */
public class cart extends HttpServlet {

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
            out.println("<title>Servlet cart</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet cart at " + request.getContextPath() + "</h1>");
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
            String customerID = request.getParameter("customerID"); 
            String code = request.getParameter("code");
            
            if (customerID == null || customerID.isEmpty()) {
                response.sendRedirect("login.jsp");
            } else {
                int customer = Integer.parseInt(customerID);
                ArrayList<OrderDetails> list_rs = db.get_list_OrderDetails(customer);

                float total = 0;
                for (OrderDetails od1 : list_rs) {
                    total += od1.getPrice();
                }
                request.setAttribute("total", total);
                request.setAttribute("list_rs", list_rs);
                request.getRequestDispatcher("cart.jsp").forward(request, response);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(cart.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(cart.class.getName()).log(Level.SEVERE, null, ex);
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
            DBcontext db = new DBcontext();
            String code = request.getParameter("code");
            Customers user = (Customers) request.getSession().getAttribute("acc");
            Coupon coupon = db.get_list_Coupons(code);
            int customer = user.getCustomerID();
                ArrayList<OrderDetails> list_rs = db.get_list_OrderDetails(customer);
                float total = 0;
                for (OrderDetails od1 : list_rs) {
                    total += od1.getPrice();
                }
                request.setAttribute("total", total);
            if (coupon==null) {
                request.setAttribute("discount",0);
                request.setAttribute("grand", total+2);
            }else{
                
                    if (coupon.getCode().equals(code)) {
                        request.setAttribute("discount", coupon.getDiscount());
                        request.setAttribute("grand", total-coupon.getDiscount()+2);
                    }
                
                
                
            }
            request.setAttribute("list_rs", list_rs);
            request.getRequestDispatcher("cart.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(cart.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(cart.class.getName()).log(Level.SEVERE, null, ex);
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
