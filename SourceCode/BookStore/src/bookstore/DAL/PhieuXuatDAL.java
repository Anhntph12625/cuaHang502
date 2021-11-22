/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.DAL;

import bookstore.Entity.PhieuXuat;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author HieuNguyen
 */
public class PhieuXuatDAL extends SqlDataConnection{
    private final String INSERT = "insert into tb_PhieuXuat(maPhieuXuat,tenKH,ngayXuat,thanhTien) values(?,?,?,?)";
    private final String UPDATE = "UPDATE [dbo].[tb_PhieuXuat] SET [tenKH] = ? ,[thanhTien] = ? WHERE [maPhieuXuat] = ?";
    private final String DELETE = "DELETE FROM [dbo].[tb_PhieuXuat] WHERE maPhieuXuat = ?";

    public ArrayList<PhieuXuat> getAll(String TOP, String WHERE, String ORDER) {
        String GET_ALL = "select * from tb_PhieuXuat";
        ArrayList<PhieuXuat> arr = new ArrayList<>();
        if (TOP.length() != 0 || WHERE.length() != 0 || ORDER.length() != 0) {
            GET_ALL = "SELECT ";
            if (TOP.length() != 0) {
                GET_ALL += "TOP " + TOP;
            }
            GET_ALL += "* FROM tb_PhieuXuat ";
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
                    PhieuXuat item = new PhieuXuat();
                    item.setMaPhieuXuat(rs.getString("maPhieuXuat"));
                    item.setTenKH(rs.getString("tenKH"));
                    item.setNgayXuat(rs.getDate("ngayXuat"));
                    item.setThanhTien(rs.getInt("thanhTien"));
                    arr.add(item);
                }
            }
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arr;
    }

    public boolean insertData(PhieuXuat data) {
        boolean check = false;
        try {
            openConnection();
            PreparedStatement ps = con.prepareStatement(INSERT);
            ps.setString(1, data.getMaPhieuXuat());
            ps.setString(2, data.getTenKH());
            ps.setDate(3, data.getNgayXuat());
            ps.setInt(4, data.getThanhTien());
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

    public boolean updateData(PhieuXuat data) {
        boolean check = false;
        try {
            openConnection();
            PreparedStatement ps = con.prepareCall(UPDATE);
            ps.setString(1, data.getTenKH());
            ps.setInt(2, data.getThanhTien());
            ps.setString(3, data.getMaPhieuXuat());
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
