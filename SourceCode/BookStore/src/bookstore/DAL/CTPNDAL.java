/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.DAL;

import bookstore.Entity.CTPN;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author HieuNguyen
 */
public class CTPNDAL extends SqlDataConnection{
    private final String INSERT = "insert into tb_CTPN(maCTPN,maPhieuNhap,maSach,soLuong,donGia,thanhTien) values(?,?,?,?,?,?)";
    private final String UPDATE = "UPDATE [dbo].[tb_CTPN] SET [maSach] = ? ,[soLuong] = ?, donGia = ?,thanhTien = ?  WHERE [maCTPN] = ?";
    private final String DELETE_ALL = "DELETE FROM [dbo].[tb_CTPN] WHERE maPhieuNhap = ?";
    private final String DELETE = "DELETE FROM [dbo].[tb_CTPN] WHERE maCTPN = ?";
    
    public ArrayList<CTPN> getAll(String TOP, String WHERE, String ORDER) {
        String GET_ALL = "select * from tb_CTPN";
        ArrayList<CTPN> arr = new ArrayList<>();
        if (TOP.length() != 0 || WHERE.length() != 0 || ORDER.length() != 0) {
            GET_ALL = "SELECT ";
            if (TOP.length() != 0) {
                GET_ALL += "TOP " + TOP;
            }
            GET_ALL += "* FROM tb_CTPN ";
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
                    CTPN item = new CTPN();
                    item.setMaCTPN(rs.getString("maCTPN"));
                    item.setMaPhieuNhap(rs.getString("maPhieuNhap"));
                    item.setMaSach(rs.getString("maSach"));
                    item.setSoLuong(rs.getInt("soLuong"));
                    item.setDonGia(rs.getInt("donGia"));
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

    public boolean insertData(CTPN data) {
        boolean check = false;
        try {
            openConnection();
            PreparedStatement ps = con.prepareStatement(INSERT);
//            System.out.println(data.getMaCTPN()+" "+data.getMaPhieuNhap()+" "+data.getMaSach() + " " +data.getSoLuong()+" "+data.getDonGia() +" "+data.getThanhTien());
            ps.setString(1, data.getMaCTPN());
            ps.setString(2, data.getMaPhieuNhap());
            ps.setString(3, data.getMaSach());
            ps.setInt(4, data.getSoLuong());
            ps.setInt(5, data.getDonGia());
            ps.setInt(6, data.getThanhTien());
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

    public boolean updateData(CTPN data) {
        boolean check = false;
        try {
            openConnection();
            PreparedStatement ps = con.prepareCall(UPDATE);
//            ps.setString(1, data.getMaPhieuNhap());
            ps.setString(1, data.getMaSach());
            ps.setInt(2, data.getSoLuong());
            ps.setInt(3, data.getDonGia());
            ps.setInt(4, data.getThanhTien());
            ps.setString(5, data.getMaCTPN());
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

    public boolean deleteData_PN(String id) {
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
    public boolean deleteData_CTPN(String id) {
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
