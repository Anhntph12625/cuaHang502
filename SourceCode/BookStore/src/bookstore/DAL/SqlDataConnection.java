/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.DAL;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author HieuNguyen
 */
public class SqlDataConnection {
    protected Connection con;
    private final String url = "jdbc:sqlserver://localhost:1433;databaseName=BookShop;user=sa;password=123456";
    public boolean openConnection() throws SQLException{
        try{
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = java.sql.DriverManager.getConnection(url);
//            JOptionPane.showMessageDialog(null, "Connected!");
            return true;
            }
        catch (ClassNotFoundException | SQLException e){
          }
        return false;
    }
    
    public void closeConnection() throws SQLException{
        con.close();
    }
//    public static void main(String[] args) throws SQLException {
//        SqlDataConnection obj = new SqlDataConnection();
//        if(obj.openConnection()){
//            System.out.println("xxx");
//        }
//        
//        
//    }
}
