/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import model.Customers;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Admin;
import model.Coupon;
import model.Order;
import model.OrderDetails;
import model.Product;
import model.Review;

/**
 *
 * @author admin
 */
public class DBcontext {

    Connection connection;

    public DBcontext() throws ClassNotFoundException, SQLException {
        String user = "manhnthe";
        String pass = "123456";
        String url = "jdbc:sqlserver://localhost:1433;databaseName=project";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        connection = DriverManager.getConnection(url, user, pass);
    }

    public Customers login(String user, String pass) throws SQLException {
        ArrayList<Customers> list = new ArrayList<>();
        String sql = "select * from Customers\n"
                + "where Email = ? and Password = ?";

        PreparedStatement sta = connection.prepareStatement(sql);
        sta.setString(1, user);
        sta.setString(2, pass);
        ResultSet rs = sta.executeQuery();
        while (rs.next()) {
            return new Customers(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
        }
        return null;
    }

    public Admin login_admin(String user, String pass) throws SQLException {
        ArrayList<Admin> list = new ArrayList<>();
        String sql = "select * from Administrators\n"
                + "where Email = ? and Password =?";
        PreparedStatement sta = connection.prepareStatement(sql);
        sta.setString(1, user);
        sta.setString(2, pass);
        ResultSet rs = sta.executeQuery();
        while (rs.next()) {
            return new Admin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
        }
        return null;
    }

    public ArrayList<Product> get_list_product() throws SQLException {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "select * from Products";
        PreparedStatement sta = connection.prepareStatement(sql);
        ResultSet rs = sta.executeQuery();
        while (rs.next()) {
            int productID = rs.getInt(1);
            String productName = rs.getString(2);
            float price = rs.getFloat(3);
            String description = rs.getString(4);
            int quantity = rs.getInt(5);
            String img = rs.getString(6);
            int categoryID = rs.getInt(7);

            Product p = new Product(productID, productName, price, description, quantity, img, categoryID);
            list.add(p);
        }
        return list;
    }

    public Coupon get_list_Coupons(String couponCode) throws SQLException {
        ArrayList<Coupon> list = new ArrayList<>();
        String sql = "select * from Coupons\n"
                + "where CouponCode = ?";
        PreparedStatement sta = connection.prepareStatement(sql);
        sta.setString(1, couponCode);
        ResultSet rs = sta.executeQuery();
        while (rs.next()) {
            String code = rs.getString(2);
            float discount = rs.getFloat(3);

            return new Coupon(code, discount);
        }
        return null;
    }

    public ArrayList<Customers> get_list_Customer(String email) throws SQLException {
        ArrayList<Customers> list = new ArrayList<>();
        String sql = "select * from Customers where Email = ?";
        PreparedStatement sta = connection.prepareStatement(sql);
        sta.setString(1, email);
        ResultSet rs = sta.executeQuery();
        while (rs.next()) {
            int cusID = rs.getInt(1);
            String customerName = rs.getString(2);
            String e = rs.getString(3);
            String address = rs.getString(4);
            String phone = rs.getString(5);
            String pass = rs.getString(6);

            Customers c = new Customers(cusID, customerName, e, address, phone, pass);

            list.add(c);
        }
        return list;
    }

    public ArrayList<Product> get_list_product(int id) throws SQLException {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "select * from Products where ProductID = ?";
        PreparedStatement sta = connection.prepareStatement(sql);
        sta.setInt(1, id);
        ResultSet rs = sta.executeQuery();
        while (rs.next()) {
            int productID = rs.getInt(1);
            String productName = rs.getString(2);
            float price = rs.getFloat(3);
            String description = rs.getString(4);
            int quantity = rs.getInt(5);
            String img = rs.getString(6);
            int categoryID = rs.getInt(7);

            Product p = new Product(productID, productName, price, description, quantity, img, categoryID);
            list.add(p);
        }
        return list;
    }

    public ArrayList<Product> searchByName(String txt) throws SQLException {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "select * from Products\n"
                + "where ProductName like ?";
        PreparedStatement sta = connection.prepareStatement(sql);
        sta.setString(1, "%" + txt + "%");
        ResultSet rs = sta.executeQuery();
        while (rs.next()) {
            int productID = rs.getInt(1);
            String productName = rs.getString(2);
            float price = rs.getFloat(3);
            String description = rs.getString(4);
            int quantity = rs.getInt(5);
            String img = rs.getString(6);
            int categoryID = rs.getInt(7);

            Product p = new Product(productID, productName, price, description, quantity, img, categoryID);
            list.add(p);
        }
        return list;
    }

    public boolean deleteUser(int id) throws SQLException {
        String sql = "DELETE FROM [dbo].[Customers]\n"
                + "      WHERE [CustomerID] =?";
        PreparedStatement sta = connection.prepareStatement(sql);
        sta.setInt(1, id);
        int rs = sta.executeUpdate();
        if (rs > 0) {
            return true;
        }
        return false;
    }

    public boolean deleteProduct(int id) throws SQLException {
        String sql = "DELETE FROM [dbo].[Products]\n"
                + "      WHERE ProductID = ?";
        PreparedStatement sta = connection.prepareStatement(sql);
        sta.setInt(1, id);
        int rs = sta.executeUpdate();
        if (rs > 0) {
            return true;
        }
        return false;
    }

    public void deleteOrderDetailsByCustomerId(int customerId) {
        try {
            // SQL query to delete data from OrderDetails table for a specific customer
            String sql = "DELETE FROM OrderDetails WHERE CustomerID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, customerId);

            // Execute delete statement
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error deleting data from OrderDetails: " + e.getMessage());
        }
    }

    public ArrayList<OrderDetails> get_list_orderDetailID_byCustomer(int customerID) throws SQLException {
        ArrayList<OrderDetails> list = new ArrayList<>();
        String sql = "select * from OrderDetails od \n"
                + "join Customers c on c.CustomerID= od.CustomerID\n"
                + "where c.CustomerID = ?";
        PreparedStatement sta = connection.prepareStatement(sql);
        sta.setInt(1, customerID);
        ResultSet rs = sta.executeQuery();
        while (rs.next()) {
            int orderDetailID = rs.getInt(1);

            OrderDetails od = new OrderDetails(orderDetailID);
            list.add(od);
        }
        return list;

    }

    public void deleteOrderDetails(int orID) {
        try {
            // SQL query to delete data from OrderDetails table for a specific customer
            String sql = "DELETE FROM [dbo].[OrderDetails]\n"
                    + "      WHERE OrderDetailID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, orID);

            // Execute delete statement
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error deleting data from OrderDetails: " + e.getMessage());
        }
    }

    public void deleteOrderDetailsByProductID(int productID) {
        try {
            // SQL query to delete data from OrderDetails table for a specific customer
            String sql = "DELETE FROM OrderDetails WHERE ProductID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, productID);

            // Execute delete statement
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error deleting data from OrderDetails: " + e.getMessage());
        }
    }

    public ArrayList<OrderDetails> get_list_OrderDetails(int customer) throws SQLException {
        ArrayList<OrderDetails> list = new ArrayList<>();
        String sql = "select * from OrderDetails\n"
                + "where CustomerID=?";
        PreparedStatement sta = connection.prepareStatement(sql);
        sta.setInt(1, customer);
        ResultSet rs = sta.executeQuery();
        while (rs.next()) {
            int orderDetailID = rs.getInt(1);
            int product_ID = rs.getInt(2);
            int quantity = rs.getInt(3);
            float price = rs.getFloat(4);
            String img = rs.getString(5);
            String productName = rs.getString(6);
            int customerID = rs.getInt(7);

            OrderDetails od = new OrderDetails(orderDetailID, productName, product_ID, quantity, price, img, customerID);
            list.add(od);
        }
        return list;
    }

    public void add_Customer(Customers c) {
        PreparedStatement sta = null;
        try {
            String sql = "INSERT INTO [dbo].[Customers]\n"
                    + "           ([CustomerID]\n"
                    + "           ,[Name]\n"
                    + "           ,[Email]\n"
                    + "           ,[Address]\n"
                    + "           ,[PhoneNumber]\n"
                    + "           ,[Password])\n"
                    + "     VALUES\n"
                    + "           (?,?,?,?,?,?)";
            sta = connection.prepareStatement(sql);
            sta.setInt(1, c.getCustomerID());
            sta.setString(2, c.getName());
            sta.setString(3, c.getEmail());
            sta.setString(4, c.getAddress());
            sta.setString(5, c.getPhoneNumber());
            sta.setString(6, c.getPassword());

            sta.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBcontext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (sta != null) {
                try {
                    sta.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBcontext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBcontext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void add_order(Order o) {
        PreparedStatement sta = null;
        try {
            String sql = "INSERT INTO [dbo].[Checkout]\n"
                    + "           ([OrderDetailID]\n"
                    + "           ,[paymethod])\n"
                    + "     VALUES\n"
                    + "           (?,?)";
            sta = connection.prepareStatement(sql);
            sta.setString(2, o.getPaymethod());
            sta.setInt(1, o.getOrderDetaiID());

            sta.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBcontext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (sta != null) {
                try {
                    sta.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBcontext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBcontext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void add_Product(Product c) {
        PreparedStatement sta = null;
        try {
            String sql = "INSERT INTO [dbo].[Products]\n"
                    + "           ([ProductID]\n"
                    + "           ,[ProductName]\n"
                    + "           ,[Price]\n"
                    + "           ,[Description]\n"
                    + "           ,[QuantityInStock]\n"
                    + "           ,[ProductImage]\n"
                    + "           ,[CategoryID])\n"
                    + "     VALUES\n"
                    + "           (?,?,?,?,?,?,?)";
            sta = connection.prepareStatement(sql);
            sta.setInt(1, c.getProductID());
            sta.setString(2, c.getProductName());
            sta.setFloat(3, c.getPrice());
            sta.setString(4, c.getDescription());
            sta.setInt(5, c.getQuantityInStock());
            sta.setString(6, c.getProductImage());
            sta.setInt(7, c.getCategoryID());

            sta.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBcontext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (sta != null) {
                try {
                    sta.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBcontext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBcontext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void add_OrderDetail(OrderDetails od) {
        PreparedStatement sta = null;
        try {
            String sql = "INSERT INTO [dbo].[OrderDetails]\n"
                    + "           ([ProductID]\n"
                    + "           ,[Quantity]\n"
                    + "           ,[Price]\n"
                    + "           ,[ProductImage]\n"
                    + "           ,[ProductName]\n"
                    + "           ,[CustomerID])\n"
                    + "     VALUES\n"
                    + "           (?,?,?,?,?,?)";
            sta = connection.prepareStatement(sql);
            sta.setInt(1, od.getProductID());
            sta.setInt(2, od.getQuantity());
            sta.setFloat(3, od.getPrice());
            sta.setString(4, od.getProductimage());
            sta.setString(5, od.getProductName());
            sta.setInt(6, od.getCustomerID());

            sta.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBcontext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (sta != null) {
                try {
                    sta.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBcontext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
//            if (connection != null) {
//                try {
//                    connection.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(DBcontext.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
        }
    }

    public ArrayList<Review> reviews(int productID) throws SQLException {
        ArrayList<Review> list = new ArrayList<>();
        String sql = "select *\n"
                + "from Products p \n"
                + "join Reviews r on p.ProductID = r.ProductID\n"
                + "where p.ProductID = ?";
        PreparedStatement sta = connection.prepareStatement(sql);
        sta.setInt(1, productID);
        ResultSet rs = sta.executeQuery();
        while (rs.next()) {
            int reviewID = rs.getInt(8);
            String customerName = rs.getString(16);
            int productid = rs.getInt(1);
            String img = rs.getString(14);
            String comment = rs.getString(12);

            Review r = new Review(reviewID, customerName, productid, img, comment);

            list.add(r);
        }
        return list;
    }

    public void update_Product(Product p) {
        String sql = "UPDATE [dbo].[Products]\n"
                + "   SET [ProductName] = ?\n"
                + "      ,[Price] = ?\n"
                + "      ,[Description] = ?\n"
                + "      ,[QuantityInStock] = ?\n"
                + "      ,[ProductImage] = ?\n"
                + "      ,[CategoryID] = ?\n"
                + " WHERE [ProductID] = ?";
        PreparedStatement stm = null;
        try {
            //tạo khay chứa câu lệnh
            stm = connection.prepareStatement(sql);
            stm.setString(1, p.getProductName());
            stm.setFloat(2, p.getPrice());
            stm.setString(3, p.getDescription());
            stm.setInt(4, p.getQuantityInStock());
            stm.setString(5, p.getProductImage());
            stm.setInt(6, p.getCategoryID());
            stm.setInt(7, p.getProductID());
            //chạy câu lệnh và tạo khay chứa kết quả câu lệnh
            stm.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DBcontext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(DBcontext.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(DBcontext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void update_User(Customers c) {
        String sql = "UPDATE [dbo].[Customers]\n"
                + "   SET [Name] = ?\n"
                + "      ,[Email] = ?\n"
                + "      ,[Address] = ?\n"
                + "      ,[PhoneNumber] = ?\n"
                + "      ,[Password] = ?\n"
                + " WHERE  [CustomerID] = ?";
        PreparedStatement stm = null;
        try {
            //tạo khay chứa câu lệnh
            stm = connection.prepareStatement(sql);
            stm.setString(1, c.getName());
            stm.setString(2, c.getEmail());
            stm.setString(3, c.getAddress());
            stm.setString(4, c.getPhoneNumber());
            stm.setString(5, c.getPassword());
            stm.setInt(6, c.getCustomerID());
            //chạy câu lệnh và tạo khay chứa kết quả câu lệnh
            stm.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DBcontext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(DBcontext.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(DBcontext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public ArrayList<Customers> get_listCustomerses() throws SQLException {
        ArrayList<Customers> list = new ArrayList<>();
        String sql = "select * from Customers";
        PreparedStatement sta = connection.prepareStatement(sql);
        ResultSet rs = sta.executeQuery();
        while (rs.next()) {
            int cusID = rs.getInt(1);
            String customerName = rs.getString(2);
            String email = rs.getString(3);
            String address = rs.getString(4);
            String phone = rs.getString(5);
            String pass = rs.getString(6);

            Customers c = new Customers(cusID, customerName, email, address, phone, pass);

            list.add(c);
        }
        return list;

    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DBcontext db = new DBcontext();
        System.out.println(db.get_list_orderDetailID_byCustomer(1));
    }
}
