/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.DAL;

import bookstore.Entity.BaoCaoPN;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author HieuNguyen
 */
public class BaoCaoPNDAL extends SqlDataConnection {

    public ArrayList<BaoCaoPN> getAll(String WHERE, String ORDER) {
        String GET_ALL = "select maPhieuNhap,(select tenNXB from tb_NXB where tb_NXB.maNXB = tb_PhieuNhap.maNXB) "
                + " as 'NXB', ngayNhap,(select sum(soluong) from tb_CTPN where tb_CTPN.maPhieuNhap = tb_PhieuNhap.maPhieuNhap)"
                + " as 'SoLuongSach',thanhTien from tb_PhieuNhap";
        ArrayList<BaoCaoPN> arr = new ArrayList<>();
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
                    BaoCaoPN item = new BaoCaoPN();
                    item.setMaPhieuNhap(rs.getString("maPhieuNhap"));
                    item.setNhaXuatBan(rs.getString("NXB"));
                    item.setNgayNhap(rs.getString("ngayNhap"));
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
