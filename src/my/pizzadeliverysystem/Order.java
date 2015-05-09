/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.pizzadeliverysystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author 14056682
 */
public class Order {

    private static final String url = "jdbc:mysql://localhost:3306/Pizza";
    private static final String user = "root";
    private static final String password = "root";
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private String id;
    private String name;
    private String adress;
    private String phone;
    private String pizza;
    private String pizzaprice;

    public Order(String id, String name, String adress, String phone, String pizza, String pizzaprice) {
        this.id = id;
        this.name = name;
        this.adress = adress;
        this.phone = phone;
        this.pizza = pizza;
        this.pizzaprice = pizzaprice;

    }

    public void addOrder() {
        String OrderId = this.id;
        String Clientname = this.name;
        String clientadress = this.adress;
        String clienttel = this.phone;
        String Pizzaname = this.pizza;
        String price = this.pizzaprice;
        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            conn = DriverManager.getConnection(url, user, password);

            //STEP 4: Execute a query
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT id FROM Orders";
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                int id = rs.getInt("id");
                String Strinid = Integer.toString(id);
                if (Strinid.equals(OrderId)) {

                    JOptionPane.showMessageDialog(null, "The client already exist. Start again");
                }

            }

            String sql1 = "INSERT INTO Orders "
                    + "VALUES( " + "'" + OrderId + "'" + "," + "'" + Clientname + "'" + "," + "'" + clientadress + "'" + "," + "'" + clienttel + "'" + "," + "'" + Pizzaname + "'" + "," + "'" + price + "'" + ")";

            stmt.executeUpdate(sql1);

            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
            JOptionPane.showMessageDialog(null, "The data inserted successfully");

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }// do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try

    }

}
