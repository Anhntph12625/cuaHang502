/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.DAL;

import bookstore.Entity.NguoiDung;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author HieuNguyen
 */
public class NguoiDungDAL extends SqlDataConnection{
    private final String INSERT = "insert into tb_NguoiDung(taiKhoan,matKhau) values(?,?)";
    private final String UPDATE = "UPDATE [dbo].[tb_NguoiDung] SET [matKhau] = ? WHERE [taiKhoan] = ?";
    private final String DELETE = "DELETE FROM [dbo].[tb_NguoiDung] WHERE taiKhoan = ?";

    public ArrayList<NguoiDung> getAll(String TOP, String WHERE, String ORDER) {
        String GET_ALL = "select * from tb_NguoiDung";
        ArrayList<NguoiDung> arr = new ArrayList<>();
        if (TOP.length() != 0 || WHERE.length() != 0 || ORDER.length() != 0) {
            GET_ALL = "SELECT ";
            if (TOP.length() != 0) {
                GET_ALL += "TOP " + TOP;
            }
            GET_ALL += "* FROM tb_NguoiDung ";
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
                    NguoiDung item = new NguoiDung();
                    item.setTaiKhoan(rs.getString("taiKhoan"));
                    item.setMatKhau(rs.getString("matKhau"));
                    arr.add(item);
                }
            }
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arr;
    }

    public boolean insertData(NguoiDung data) {
        boolean check = false;
        try {
            openConnection();
            PreparedStatement ps = con.prepareStatement(INSERT);
            ps.setString(1, data.getTaiKhoan());
            ps.setString(2, data.getMatKhau());
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

    public boolean updateData(NguoiDung data) {
        boolean check = false;
        try {
            openConnection();
            PreparedStatement ps = con.prepareCall(UPDATE);
            ps.setString(1, data.getMatKhau());
            ps.setString(2, data.getTaiKhoan());
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

    public boolean updateDataSave(NguoiDung data) {
        boolean check = false;
        try {
            openConnection();
            PreparedStatement ps = con.prepareCall("update tb_NguoiDung set taiKhoan = '@root:' + ?, matKhau = ? where TaiKhoan like '@root:%'");
            ps.setString(1, data.getTaiKhoan());
            ps.setString(2, data.getMatKhau());
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
    public boolean deleteDataSave(){
        boolean check = false;
        try {
            openConnection();
            PreparedStatement ps = con.prepareCall("DELETE FROM [dbo].[tb_NguoiDung] WHERE taiKhoan like '@root:%'");
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
