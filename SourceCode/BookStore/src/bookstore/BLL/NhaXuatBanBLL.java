/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.BLL;

import bookstore.DAL.NhaXuatBanDAL;
import bookstore.Entity.NhaXuatBan;
import java.util.ArrayList;

/**
 *
 * @author HieuNguyen
 */
public class NhaXuatBanBLL {
    NhaXuatBanDAL obj = new NhaXuatBanDAL();
    
    public ArrayList<NhaXuatBan> getAll(String top,String where,String order){
        return obj.getAll(top,where,order);
    }
    
    
    public boolean insertData(NhaXuatBan data){
        return obj.insertData(data);
    }
    public boolean updateData(NhaXuatBan data){
        return obj.updateData(data);
    }
    public boolean deleteData(String id){
        return obj.deleteData(id);
    }
}
