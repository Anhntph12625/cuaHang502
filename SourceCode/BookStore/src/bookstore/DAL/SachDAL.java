/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.DAL;

import bookstore.Entity.Sach;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author HieuNguyen
 */
public class SachDAL extends SqlDataConnection {

    private final String INSERT = "insert into tb_Sach(maSach,tieuDe,tacGia,namXuatBan,giaBia,maNXB,soLuongTon,maGianHang)"
            + " values(?,?,?,?,?,?,?,?)";
    private final String UPDATE = "UPDATE [dbo].[tb_Sach] SET [tieuDe] = ? ,[tacGia] = ? ,[namXuatBan] = ?"
            + " ,[giaBia] = ?, [maNXB] = ?, [soLuongTon] = ?, [maGianHang] = ? WHERE [maSach] = ?";
    private final String DELETE = "DELETE FROM [dbo].[tb_Sach] WHERE maSach = ?";

    public ArrayList<Sach> getAll(String TOP, String WHERE, String ORDER) {
        String GET_ALL = "SELECT [maSach] ,[tieuDe] ,[tacGia] ,[namXuatBan] ,[giaBia] ,(Select tenNXB from tb_NXB"
            + " where tb_NXB.maNXB = tb_Sach.maNXB) as maNXB ,[soLuongTon] ,(Select tenGianhang from tb_GianHang"
            + " where tb_GianHang.[maGianHang] = tb_Sach.[maGianHang]) as maGianHang FROM [dbo].[tb_Sach]";
//        String GET_ALL = "Select * FROM [dbo].[tb_Sach]";
        ArrayList<Sach> arr = new ArrayList<>();
        if (TOP.length() != 0 || WHERE.length() != 0 || ORDER.length() != 0) {
            GET_ALL = "SELECT ";
            if (TOP.length() != 0) {
                GET_ALL += "TOP " + TOP;
            }
            GET_ALL += "* FROM tb_Sach ";
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
                    Sach item = new Sach();
                    item.setMaSach(rs.getString("maSach"));
                    item.setTieuDe(rs.getString("tieuDe"));
                    item.setTacGia(rs.getString("tacGia"));
                    item.setNamXuatBan(rs.getInt("namXuatBan"));
                    item.setGiaBia(rs.getInt("giaBia"));
                    item.setMaNXB(rs.getString("maNXB"));
                    item.setSoLuongTon(rs.getInt("soLuongTon"));
                    item.setMaGianHang(rs.getString("maGianHang"));
                    arr.add(item);
                }
            }
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arr;
    }

    public boolean insertData(Sach data) {
        boolean check = false;
        try {
            openConnection();
            PreparedStatement ps = con.prepareStatement(INSERT);
            ps.setString(1, data.getMaSach());
            ps.setString(2, data.getTieuDe());
            ps.setString(3, data.getTacGia());
            ps.setInt(4, data.getNamXuatBan());
            ps.setInt(5, data.getGiaBia());
            ps.setString(6, data.getMaNXB());
            ps.setInt(7, data.getSoLuongTon());
            ps.setString(8, data.getMaGianHang());
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

    public boolean updateData(Sach data) {
        boolean check = false;
        try {
            openConnection();
            PreparedStatement ps = con.prepareCall(UPDATE);
            ps.setString(1, data.getTieuDe());
            ps.setString(2, data.getTacGia());
            ps.setInt(3, data.getNamXuatBan());
            ps.setInt(4, data.getGiaBia());
            ps.setString(5, data.getMaNXB());
            ps.setInt(6, data.getSoLuongTon());
            ps.setString(7, data.getMaGianHang());
            ps.setString(8, data.getMaSach());
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
