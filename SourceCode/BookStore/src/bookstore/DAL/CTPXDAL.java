/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.DAL;

import bookstore.Entity.CTPX;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author HieuNguyen
 */
public class CTPXDAL extends SqlDataConnection{
    private final String INSERT = "insert into tb_CTPX(maCTPX,maPhieuXuat,maSach,soLuong,thanhTien) values(?,?,?,?,?)";
    private final String UPDATE = "UPDATE [dbo].[tb_CTPX] SET [maSach] = ? ,[soLuong] = ?,thanhTien = ?  WHERE [maCTPX] = ?";
    private final String DELETE_ALL = "DELETE FROM [dbo].[tb_CTPX] WHERE maPhieuXuat = ?";
    private final String DELETE = "DELETE FROM [dbo].[tb_CTPX] WHERE maCTPX = ?";

    public ArrayList<CTPX> getAll(String TOP, String WHERE, String ORDER) {
        String GET_ALL = "select * from tb_CTPX";
        ArrayList<CTPX> arr = new ArrayList<>();
        if (TOP.length() != 0 || WHERE.length() != 0 || ORDER.length() != 0) {
            GET_ALL = "SELECT ";
            if (TOP.length() != 0) {
                GET_ALL += "TOP " + TOP;
            }
            GET_ALL += "* FROM tb_CTPX ";
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
                    CTPX item = new CTPX();
                    item.setMaCTPX(rs.getString("maCTPX"));
                    item.setMaPhieuXuat(rs.getString("maPhieuXuat"));
                    item.setMaSach(rs.getString("maSach"));
                    item.setSoLuong(rs.getInt("soLuong"));
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

    public boolean insertData(CTPX data) {
        boolean check = false;
        try {
            openConnection();
            PreparedStatement ps = con.prepareStatement(INSERT);
            ps.setString(1, data.getMaCTPX());
            ps.setString(2, data.getMaPhieuXuat());
            ps.setString(3, data.getMaSach());
            ps.setInt(4, data.getSoLuong());
            ps.setInt(5, data.getThanhTien());
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

    public boolean updateData(CTPX data) {
        boolean check = false;
        try {
            openConnection();
            PreparedStatement ps = con.prepareCall(UPDATE);
//            ps.setString(1, data.getMaPhieuXuat());
            ps.setString(1, data.getMaSach());
            ps.setInt(2, data.getSoLuong());
            ps.setInt(3, data.getThanhTien());
            ps.setString(4, data.getMaCTPX());
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

    public boolean deleteData_PX(String id) {
        boolean check = false;
        try {
            openConnection();
            PreparedStatement ps = con.prepareCall(DELETE_ALL);
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
    public boolean deleteData_CTPX(String id) {
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
