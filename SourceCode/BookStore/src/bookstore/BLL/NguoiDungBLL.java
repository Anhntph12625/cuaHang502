/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.BLL;

import bookstore.DAL.NguoiDungDAL;
import bookstore.Entity.NguoiDung;
import java.util.ArrayList;

/**
 *
 * @author HieuNguyen
 */
public class NguoiDungBLL {
    NguoiDungDAL obj = new NguoiDungDAL();
    
    public ArrayList<NguoiDung> getAll(String top,String where,String order){
        return obj.getAll(top,where,order);
    }
    
    public boolean insertData(NguoiDung data){
        return obj.insertData(data);
    }
    public boolean updateData(NguoiDung data){
        return obj.updateData(data);
    }
    public boolean deleteData(String id){
        return obj.deleteData(id);
    }
    public boolean updateDataSave(NguoiDung data){
        return obj.updateDataSave(data);
    }
    public boolean deleteDataSave(){
        return obj.deleteDataSave();
    }
}
