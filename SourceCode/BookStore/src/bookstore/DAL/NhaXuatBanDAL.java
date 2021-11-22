/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.DAL;

import bookstore.Entity.NhaXuatBan;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author HieuNguyen
 */
public class NhaXuatBanDAL extends SqlDataConnection {

    private final String INSERT = "insert into tb_NXB(maNXB,tenNXB,diaChi,dienThoai,email) values(?,?,?,?,?)";
    private final String UPDATE = "UPDATE [dbo].[tb_NXB] SET [tenNXB] = ? ,[diaChi] = ? ,[dienThoai] = ? ,[email] = ? WHERE [maNXB] = ?";
    private final String DELETE = "DELETE FROM [dbo].[tb_NXB] WHERE maNXB = ?";

    public ArrayList<NhaXuatBan> getAll(String TOP, String WHERE, String ORDER) {
        String GET_ALL = "select * from tb_NXB";
        ArrayList<NhaXuatBan> arr = new ArrayList<>();
        if (TOP.length() != 0 || WHERE.length() != 0 || ORDER.length() != 0) {
            GET_ALL = "SELECT ";
            if (TOP.length() != 0) {
                GET_ALL += "TOP " + TOP;
            }
            GET_ALL += "* FROM tb_NXB ";
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
                    NhaXuatBan item = new NhaXuatBan();
                    item.setMaNXB(rs.getString("maNXB"));
                    item.setTenNXB(rs.getString("tenNXB"));
                    item.setDiaChi(rs.getString("diaChi"));
                    item.setDienThoai(rs.getString("dienThoai"));
                    item.setEmail(rs.getString("email"));
                    arr.add(item);
                }
            }
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arr;
    }

    public boolean insertData(NhaXuatBan data) {
        boolean check = false;
        try {
            openConnection();
            PreparedStatement ps = con.prepareStatement(INSERT);
            ps.setString(1, data.getMaNXB());
            ps.setString(2, data.getTenNXB());
            ps.setString(3, data.getDiaChi());
            ps.setString(4, data.getDienThoai());
            ps.setString(5, data.getEmail());
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

    public boolean updateData(NhaXuatBan data) {
        boolean check = false;
        try {
            openConnection();
            PreparedStatement ps = con.prepareCall(UPDATE);
            ps.setString(1, data.getTenNXB());
            ps.setString(2, data.getDiaChi());
            ps.setString(3, data.getDienThoai());
            ps.setString(4, data.getEmail());
            ps.setString(5, data.getMaNXB());
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
