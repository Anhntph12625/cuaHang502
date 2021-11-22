/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.DAL;

import bookstore.Entity.GianHang;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author HieuNguyen
 */
public class GianHangDAL extends SqlDataConnection{
    private final String INSERT = "insert into tb_GianHang(maGianHang,tenGianHang,moTa) values(?,?,?)";
    private final String UPDATE = "UPDATE [dbo].[tb_GianHang] SET [tenGianHang] = ? ,[moTa] = ? WHERE [maGianHang] = ?";
    private final String DELETE = "DELETE FROM [dbo].[tb_GianHang] WHERE maGianHang = ?";

    public ArrayList<GianHang> getAll(String TOP, String WHERE, String ORDER) {
        String GET_ALL = "select * from tb_GianHang";
        ArrayList<GianHang> arr = new ArrayList<>();
        if (TOP.length() != 0 || WHERE.length() != 0 || ORDER.length() != 0) {
            GET_ALL = "SELECT ";
            if (TOP.length() != 0) {
                GET_ALL += "TOP " + TOP;
            }
            GET_ALL += "* FROM tb_GianHang ";
            if (WHERE.length() != 0) {
                GET_ALL += "WHERE " + WHERE;
            }
            if (ORDER.length() != 0) {
                GET_ALL += "ORDER BY " + ORDER;
            }
        }
//        System.out.println(GET_ALL);
        try {
            openConnection();
            PreparedStatement ps = con.prepareStatement(GET_ALL);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    GianHang item = new GianHang();
                    item.setMaGianHang(rs.getString("MaGianHang"));
                    item.setTenGianHang(rs.getString("TenGianHang"));
                    item.setMoTa(rs.getString("moTa"));
                    arr.add(item);
                }
            }
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arr;
    }

    public boolean insertData(GianHang data) {
        boolean check = false;
        try {
            openConnection();
            PreparedStatement ps = con.prepareStatement(INSERT);
            ps.setString(1, data.getMaGianHang());
            ps.setString(2, data.getTenGianHang());
            ps.setString(3, data.getMoTa());
            int rs = ps.executeUpdate();
            if (rs > 0) {
                check = true;
            }
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    public boolean updateData(GianHang data) {
        boolean check = false;
        try {
            openConnection();
            PreparedStatement ps = con.prepareCall(UPDATE);
            ps.setString(1, data.getTenGianHang());
            ps.setString(2, data.getMoTa());
            ps.setString(3, data.getMaGianHang());
            
            int rs = ps.executeUpdate();
            if (rs > 0) {
                check = true;
            }
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    public boolean deleteData(String id) {
        boolean check = false;
        try {
            openConnection();
            PreparedStatement ps = con.prepareCall(DELETE);
            ps.setString(1, id);
            int rs = ps.executeUpdate();
            if (rs > 0) {
                check = true;
            }
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }
}
