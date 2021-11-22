/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.BLL;

import bookstore.DAL.BaoCaoPNDAL;
import bookstore.Entity.BaoCaoPN;
import java.util.ArrayList;

/**
 *
 * @author HieuNguyen
 */
public class BaoCaoPNBLL {
    BaoCaoPNDAL obj = new BaoCaoPNDAL();
    
    public ArrayList<BaoCaoPN> getAll(String where,String order){
        return obj.getAll(where,order);
    }
}
