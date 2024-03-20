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
import model.OrderDetails;
import model.Product;

/**
 *
 * @author admin
 */
public class Addtocart extends HttpServlet {

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
            out.println("<title>Servlet Addtocart</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Addtocart at " + request.getContextPath() + "</h1>");
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
            OrderDetails od = new OrderDetails();
            String productID = request.getParameter("productID");
            String customerID = request.getParameter("customerID");
            if (customerID == null||customerID.isEmpty()) {
                response.sendRedirect("login.jsp");
            } else {
                int cus_ID = Integer.parseInt(customerID);
                for (Product p : list) {
                    if (p.getProductID() == Integer.parseInt(productID)) {
                        int product_ID = p.getProductID();
                        int quantity = 1;
                        float price = p.getPrice();
                        String img = p.getProductImage();
                        String productName = p.getProductName();

                        od.setProductID(product_ID);
                        od.setPrice(price);
                        od.setQuantity(quantity);
                        od.setProductName(productName);
                        od.setProductimage(img);
                        od.setCustomerID(cus_ID);

                        db.add_OrderDetail(od);
                    }
                }
                ArrayList<OrderDetails> list_rs = db.get_list_OrderDetails(Integer.parseInt(customerID));
                float total = 0;
                for (OrderDetails od1 : list_rs) {
                    total+=od1.getPrice();
                }
                //PrintWriter out = response.getWriter();out.print(total);
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
        processRequest(request, response);
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
