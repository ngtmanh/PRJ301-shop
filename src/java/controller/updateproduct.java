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
public class updateproduct extends HttpServlet {

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
            out.println("<title>Servlet updateproduct</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet updateproduct at " + request.getContextPath() + "</h1>");
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
            String id = request.getParameter("id");
            try {
                if (id.isEmpty() || id == null) {
                    throw new NullPointerException();
                } else {
                    ArrayList<Product> product = db.get_list_product(Integer.parseInt(id));
                    if (product.isEmpty()) {
                        request.setAttribute("msg", "Not find id");
                    } else {
                        request.setAttribute("product", product);
                    }
                }

            } catch (NullPointerException e) {
                request.setAttribute("msg", "Enter ID");
            } catch(NumberFormatException exception){
                request.setAttribute("msg", "Eter ID Integer");
            }

            //PrintWriter out = response.getWriter();out.print(product);
            request.getRequestDispatcher("updateproduct.jsp").forward(request, response);
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
            DBcontext db = new DBcontext();
            String productID = request.getParameter("id");
            String product_name = request.getParameter("name");
            String description = request.getParameter("description");
            String category = request.getParameter("category");
            String price = request.getParameter("price");
            String stock = request.getParameter("stock");
            String img = request.getParameter("img");

            Product p = new Product();
            p.setProductName(product_name);
            p.setPrice(Float.parseFloat(price));
            p.setDescription(description);
            p.setCategoryID(Integer.parseInt(category));
            p.setQuantityInStock(Integer.parseInt(stock));
            p.setProductImage(img);
            p.setProductID(Integer.parseInt(productID));

            db.update_Product(p);
            request.setAttribute("msg", "SUCCESFULL");
            request.getRequestDispatcher("updateproduct.jsp").forward(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(updateproduct.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(updateproduct.class.getName()).log(Level.SEVERE, null, ex);
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
