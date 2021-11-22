/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author HieuNguyen
 */
public class LoginDAL extends SqlDataConnection{
    private final String query = "select * from tb_NguoiDung where taiKhoan = ? and MatKhau = ?";
    
    public boolean getLogin(String u, String p){
        boolean check = false;
        try {
            openConnection();
            PreparedStatement ps = con.prepareCall(query);
            ps.setString(1, u);
            ps.setString(2, p);
            ResultSet rs = ps.executeQuery();
            if(rs != null && rs.next()) check = true;
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }
    
}
