/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.DAL;

import bookstore.Entity.BaoCaoPX;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author HieuNguyen
 */
public class BaoCaoPXDAL extends SqlDataConnection{
    public ArrayList<BaoCaoPX> getAll(String WHERE, String ORDER) {
        String GET_ALL = "select maPhieuXuat,tenKH, ngayXuat,(select sum(soluong)"
                +" from tb_CTPx where tb_CTPX.maPhieuXuat = tb_PhieuXuat.maPhieuXuat)"
                +" as 'SoLuongSach',thanhTien from tb_PhieuXuat";
        ArrayList<BaoCaoPX> arr = new ArrayList<>();
        if (WHERE.length() != 0) {
            GET_ALL += " WHERE " + WHERE;
        }
        if (ORDER.length() != 0) {
            GET_ALL += " ORDER BY " + ORDER;
        }
//        System.out.println(GET_ALL);
        try {
            openConnection();
            PreparedStatement ps = con.prepareStatement(GET_ALL);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    BaoCaoPX item = new BaoCaoPX();
                    item.setMaPhieuXuat(rs.getString("maPhieuXuat"));
                    item.setTenKH(rs.getString("tenKH"));
                    item.setNgayXuat(rs.getString("ngayXuat"));
                    item.setSoLuongSach(rs.getInt("SoLuongSach"));
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
}
