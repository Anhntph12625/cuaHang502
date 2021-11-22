/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.BLL;

import bookstore.DAL.LoginDAL;

/**
 *
 * @author HieuNguyen
 */
public class LoginBLL {
    LoginDAL obj = new LoginDAL();
    public  boolean getLogin(String u,String p){
        return obj.getLogin(u, p);
    }
}
