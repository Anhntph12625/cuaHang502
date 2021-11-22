/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.BLL;

import bookstore.DAL.CTPXDAL;
import bookstore.Entity.CTPX;
import java.util.ArrayList;

/**
 *
 * @author HieuNguyen
 */
public class CTPXBLL {
    CTPXDAL obj = new CTPXDAL();
    
    public ArrayList<CTPX> getAll(String top,String where,String order){
        return obj.getAll(top,where,order);
    }
    
    
    public boolean insertData(CTPX data){
        return obj.insertData(data);
    }
    public boolean updateData(CTPX data){
        return obj.updateData(data);
    }
    public boolean deleteData_PX(String id){
        return obj.deleteData_PX(id);
    }
    public boolean deleteData_CTPX(String id){
        return obj.deleteData_CTPX(id);
    }
}
