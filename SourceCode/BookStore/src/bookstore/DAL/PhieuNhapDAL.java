/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.DAL;

import bookstore.Entity.PhieuNhap;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author HieuNguyen
 */
public class PhieuNhapDAL extends SqlDataConnection{
    private final String INSERT = "insert into tb_PhieuNhap(maPhieuNhap,maNXB,ngayNhap,thanhTien) values(?,?,?,?)";
    private final String UPDATE = "UPDATE [dbo].[tb_PhieuNhap] SET [maNXB] = ? ,[thanhTien] = ? WHERE [maPhieuNhap] = ?";
    private final String DELETE = "DELETE FROM [dbo].[tb_PhieuNhap] WHERE maPhieuNhap = ?";

    public ArrayList<PhieuNhap> getAll(String TOP, String WHERE, String ORDER) {
        String GET_ALL = "select maPhieuNhap,(select tenNXB from tb_NXB where tb_NXB.maNXB = tb_PhieuNhap.maNXB) as 'maNXB', ngayNhap,thanhTien from tb_PhieuNhap";
        ArrayList<PhieuNhap> arr = new ArrayList<>();
        if (TOP.length() != 0 || WHERE.length() != 0 || ORDER.length() != 0) {
            GET_ALL = "SELECT ";
            if (TOP.length() != 0) {
                GET_ALL += "TOP " + TOP;
            }
            GET_ALL += "* FROM tb_PhieuNhap ";
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
                    PhieuNhap item = new PhieuNhap();
                    item.setMaPhieuNhap(rs.getString("maPhieuNhap"));
                    item.setMaNXB(rs.getString("maNXB"));
                    item.setNgayNhap(rs.getDate("ngayNhap"));
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

    public boolean insertData(PhieuNhap data) {
        boolean check = false;
        try {
            openConnection();
            PreparedStatement ps = con.prepareStatement(INSERT);
            ps.setString(1, data.getMaPhieuNhap());
            ps.setString(2, data.getMaNXB());
            ps.setDate(3, data.getNgayNhap());
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

    public boolean updateData(PhieuNhap data) {
        boolean check = false;
        try {
            openConnection();
            PreparedStatement ps = con.prepareCall(UPDATE);
            ps.setString(1, data.getMaNXB());
            ps.setInt(2, data.getThanhTien());
            ps.setString(3, data.getMaPhieuNhap());
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
