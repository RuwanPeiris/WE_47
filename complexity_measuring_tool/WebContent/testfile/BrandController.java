/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools  Templates
 * and open the template in the editor.
 */

package com.ruwan.ruwanhardware.controller;

import com.ruwan.ruwanhardware.db.DBConnection;
import com.ruwan.ruwanhardware.model.Brand;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author RPP
 */
public class BrandController implements ABC{
    public static int addBrand(Brand brand) throws ClassNotFoundException, SQLException{
        String sql="Insert into Brand values('"+brand.getBrandId()+"','"+brand.getBrandName()+"')";
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        return  stm.executeUpdate(sql);
    }
    public static Brand getBrandByName(String brandName) throws ClassNotFoundException, SQLException{
        String sql="select * from Brand where brandName='"+brandName+"'";
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
         
        Brand brand=null;
        while (rst.next()){
            brand=new Brand(rst.getString("brandId"), rst.getString("brandName"));
        }
        return brand;
    }
    
    public static int updateBrandName(Brand brand) throws ClassNotFoundException, SQLException{
        String sql="Update Brand set brandName='"+brand.getBrandName()+"' where brandId='"+brand.getBrandId()+"'";
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        int respond = stm.executeUpdate(sql);
        if (respond>0){
            return 1;
        }
        return -1;
    }
	
	class A {
		System.out.println("Ruwan");
	}
	
	for (int i = 0; i < 10; i++) {
		System.out.println("Loop");
	}
	ArrayList<String> bb=new ArrayList<>();
	for (String a:bb){
		System.out.println("Print A");
		if (true){
			System.out.println("condition");
		}
	}
    
	if (true){
		System.out.println("Check 1");
	}
}
