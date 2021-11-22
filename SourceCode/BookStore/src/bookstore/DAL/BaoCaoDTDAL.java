/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.DAL;

import bookstore.Entity.BaoCaoDT;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author HieuNguyen
 */
public class BaoCaoDTDAL extends SqlDataConnection {

    public ArrayList<BaoCaoDT> getAll(String w1, String w2) {
        String GET_ALL;
        ArrayList<BaoCaoDT> arr = new ArrayList<>();
        if (w1.length() != 0 && w2.length() != 0) {
            GET_ALL = "select maSach,tieuDe,giaBia,soLuongTon, (select tenGianHang from tb_GianHang"
                    + " where tb_Sach.maGianHang = tb_GianHang.maGianHang) as 'GianHang', "
                    + "(select sum(soLuong) from tb_CTPN,tb_PhieuNhap where tb_CTPN.maSach = tb_Sach.maSach"
                    + " and tb_CTPN.maPhieuNhap = tb_PhieuNhap.maPhieuNhap and ngayNhap >= " + w1 + " and "
                    + "ngayNhap <= " + w2 + ") as 'SLNhap', (select sum(tb_PhieuNhap.thanhTien)"
                    + " from tb_CTPN,tb_PhieuNhap where tb_CTPN.maSach = tb_Sach.maSach and "
                    + "tb_PhieuNhap.maPhieuNhap = tb_CTPN.maPhieuNhap and ngayNhap >= " + w1 + " "
                    + "and ngayNhap <= " + w2 + ") as 'TienNhap', (select sum(tb_PhieuXuat.thanhTien) "
                    + "from tb_CTPX,tb_PhieuXuat where tb_CTPX.maSach = tb_Sach.maSach and "
                    + "tb_CTPX.maPhieuXuat = tb_PhieuXuat.maPhieuXuat and ngayXuat >= " + w1 + " and"
                    + " ngayXuat <= " + w2 + ") as 'SLXuat', (select sum(tb_PhieuXuat.thanhTien) "
                    + "from tb_CTPX,tb_PhieuXuat where tb_CTPX.maSach = tb_Sach.maSach and "
                    + "tb_CTPX.maPhieuXuat = tb_PhieuXuat.maPhieuXuat and ngayXuat >= " + w1 + " "
                    + "and ngayXuat <= " + w2 + ") as 'TienXuat' from tb_Sach";
        } else if (w1.length() != 0) {
            GET_ALL = "select maSach,tieuDe,giaBia,soLuongTon, (select tenGianHang from tb_GianHang"
                    + " where tb_Sach.maGianHang = tb_GianHang.maGianHang) as 'GianHang', "
                    + "(select sum(soLuong) from tb_CTPN,tb_PhieuNhap where tb_CTPN.maSach = tb_Sach.maSach"
                    + " and tb_CTPN.maPhieuNhap = tb_PhieuNhap.maPhieuNhap and ngayNhap >= " + w1 + ") as 'SLNhap', (select sum(tb_PhieuNhap.thanhTien)"
                    + " from tb_CTPN,tb_PhieuNhap where tb_CTPN.maSach = tb_Sach.maSach and "
                    + "tb_PhieuNhap.maPhieuNhap = tb_CTPN.maPhieuNhap and ngayNhap >= " + w1 + ") as 'TienNhap', (select sum(tb_PhieuXuat.thanhTien) "
                    + "from tb_CTPX,tb_PhieuXuat where tb_CTPX.maSach = tb_Sach.maSach and "
                    + "tb_CTPX.maPhieuXuat = tb_PhieuXuat.maPhieuXuat and ngayXuat >= " + w1 + ") as 'SLXuat', (select sum(tb_PhieuXuat.thanhTien) "
                    + "from tb_CTPX,tb_PhieuXuat where tb_CTPX.maSach = tb_Sach.maSach and "
                    + "tb_CTPX.maPhieuXuat = tb_PhieuXuat.maPhieuXuat and ngayXuat >= " + w1 + " "
                    + ") as 'TienXuat' from tb_Sach";
        } else if (w2.length() != 0) {
            GET_ALL = "select maSach,tieuDe,giaBia,soLuongTon, (select tenGianHang from tb_GianHang"
                    + " where tb_Sach.maGianHang = tb_GianHang.maGianHang) as 'GianHang', "
                    + "(select sum(soLuong) from tb_CTPN,tb_PhieuNhap where tb_CTPN.maSach = tb_Sach.maSach"
                    + " and tb_CTPN.maPhieuNhap = tb_PhieuNhap.maPhieuNhap and "
                    + "ngayNhap <= " + w2 + ") as 'SLNhap', (select sum(tb_PhieuNhap.thanhTien)"
                    + " from tb_CTPN,tb_PhieuNhap where tb_CTPN.maSach = tb_Sach.maSach and "
                    + "tb_PhieuNhap.maPhieuNhap = tb_CTPN.maPhieuNhap and ngayNhap <= " + w2 + ") as 'TienNhap', (select sum(tb_PhieuXuat.thanhTien) "
                    + "from tb_CTPX,tb_PhieuXuat where tb_CTPX.maSach = tb_Sach.maSach and "
                    + "tb_CTPX.maPhieuXuat = tb_PhieuXuat.maPhieuXuat and"
                    + " ngayXuat <= " + w2 + ") as 'SLXuat', (select sum(tb_PhieuXuat.thanhTien) "
                    + "from tb_CTPX,tb_PhieuXuat where tb_CTPX.maSach = tb_Sach.maSach and "
                    + "tb_CTPX.maPhieuXuat = tb_PhieuXuat.maPhieuXuat and ngayXuat <= " + w2 + ") as 'TienXuat' from tb_Sach";
        } else {
            GET_ALL = "select maSach,tieuDe,giaBia,soLuongTon, (select tenGianHang from tb_GianHang"
                    + " where tb_Sach.maGianHang = tb_GianHang.maGianHang) as 'GianHang', "
                    + "(select sum(soLuong) from tb_CTPN,tb_PhieuNhap where tb_CTPN.maSach = tb_Sach.maSach"
                    + " and tb_CTPN.maPhieuNhap = tb_PhieuNhap.maPhieuNhap ) as 'SLNhap', (select sum(tb_PhieuNhap.thanhTien)"
                    + " from tb_CTPN,tb_PhieuNhap where tb_CTPN.maSach = tb_Sach.maSach and "
                    + "tb_PhieuNhap.maPhieuNhap = tb_CTPN.maPhieuNhap) as 'TienNhap', (select sum(tb_PhieuXuat.thanhTien) "
                    + "from tb_CTPX,tb_PhieuXuat where tb_CTPX.maSach = tb_Sach.maSach and "
                    + "tb_CTPX.maPhieuXuat = tb_PhieuXuat.maPhieuXuat) as 'SLXuat', (select sum(tb_PhieuXuat.thanhTien) "
                    + "from tb_CTPX,tb_PhieuXuat where tb_CTPX.maSach = tb_Sach.maSach and "
                    + "tb_CTPX.maPhieuXuat = tb_PhieuXuat.maPhieuXuat) as 'TienXuat' from tb_Sach";
        }
//        System.out.println(GET_ALL);
        try {
            openConnection();
            PreparedStatement ps = con.prepareStatement(GET_ALL);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    BaoCaoDT item = new BaoCaoDT();
                    item.setMaSach(rs.getString("maSach"));
                    item.setTieuDe(rs.getString("tieuDe"));
                    item.setGiaBia(rs.getInt("giaBia"));
                    item.setSoLuongTon(rs.getInt("soLuongTon"));
                    item.setGianHang(rs.getString("gianHang"));
                    item.setSlNhap(rs.getInt("SLNhap"));
                    item.setTienNhap(rs.getInt("TienNhap"));
                    item.setSlXuat(rs.getInt("SLXuat"));
                    item.setTienBan(rs.getInt("TienXuat"));
                    item.setTienLai(item.getTienBan() - item.getTienNhap());
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
