/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.BLL;

import bookstore.DAL.CTPNDAL;
import bookstore.Entity.CTPN;
import bookstore.Entity.CTPN;
import java.util.ArrayList;

/**
 *
 * @author HieuNguyen
 */
public class CTPNBLL {
    CTPNDAL obj = new CTPNDAL();
    
    public ArrayList<CTPN> getAll(String top,String where,String order){
        return obj.getAll(top,where,order);
    }
    
    
    public boolean insertData(CTPN data){
        return obj.insertData(data);
    }
    public boolean updateData(CTPN data){
        return obj.updateData(data);
    }
    public boolean deleteData_PN(String id){
        return obj.deleteData_PN(id);
    }
    public boolean deleteData_CTPN(String id){
        return obj.deleteData_CTPN(id);
    }
}
