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
import model.Product;

/**
 *
 * @author admin
 */
public class shop extends HttpServlet {

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
            out.println("<title>Servlet shop</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet shop at " + request.getContextPath() + "</h1>");
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
            ArrayList<Product> list = db.get_list_product();
            ArrayList<Product> list_rs = new ArrayList<>();
            String categoryID = request.getParameter("categoryID");
            if (request.getParameter("categoryID") != null) {
                for (Product p : list) {
                    if (p.getCategoryID() == Integer.parseInt(categoryID)) {
                        list_rs.add(p);
                    }
                }
                request.setAttribute("list_rs", list_rs);
            } else {
                request.setAttribute("list_rs", list);
            }
            request.getRequestDispatcher("shop.jsp").forward(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(shop.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(shop.class.getName()).log(Level.SEVERE, null, ex);
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
            ArrayList<Product> list = db.get_list_product();
            ArrayList<Product> list_rs = new ArrayList<>();
            String price = request.getParameter("price");
            String[] price1 = price.split("-");
            String min = price1[0].trim();
            float price_min = Float.parseFloat(min.substring(1, min.length()));
            String max = price1[1].trim();
            float price_max = Float.parseFloat(max.substring(1, max.length()));
            for (Product p : list) {
                if (p.getPrice() > price_min && p.getPrice() < price_max) {
                    list_rs.add(p);
                }
            }
            request.setAttribute("list_rs", list_rs);
            request.getRequestDispatcher("shop.jsp").forward(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(shop.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(shop.class.getName()).log(Level.SEVERE, null, ex);
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
