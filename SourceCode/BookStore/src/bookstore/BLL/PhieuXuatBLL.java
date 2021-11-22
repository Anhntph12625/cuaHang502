/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.BLL;

import bookstore.DAL.PhieuXuatDAL;
import bookstore.Entity.PhieuXuat;
import java.util.ArrayList;

/**
 *
 * @author HieuNguyen
 */
public class PhieuXuatBLL {
    PhieuXuatDAL obj = new PhieuXuatDAL();
    
    public ArrayList<PhieuXuat> getAll(String top,String where,String order){
        return obj.getAll(top,where,order);
    }
    
    
    public boolean insertData(PhieuXuat data){
        return obj.insertData(data);
    }
    public boolean updateData(PhieuXuat data){
        return obj.updateData(data);
    }
    public boolean deleteData(String id){
        return obj.deleteData(id);
    }
}
