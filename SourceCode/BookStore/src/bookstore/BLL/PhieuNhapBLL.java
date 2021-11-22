/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.BLL;

import bookstore.DAL.PhieuNhapDAL;
import bookstore.Entity.PhieuNhap;
import java.util.ArrayList;

/**
 *
 * @author HieuNguyen
 */
public class PhieuNhapBLL {
    PhieuNhapDAL obj = new PhieuNhapDAL();
    
    public ArrayList<PhieuNhap> getAll(String top,String where,String order){
        return obj.getAll(top,where,order);
    }
    
    
    public boolean insertData(PhieuNhap data){
        return obj.insertData(data);
    }
    public boolean updateData(PhieuNhap data){
        return obj.updateData(data);
    }
    public boolean deleteData(String id){
        return obj.deleteData(id);
    }
}
