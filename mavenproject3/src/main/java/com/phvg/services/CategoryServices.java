/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.phvg.services;

import com.phvg.pojo.Category;
import com.phvg.utils.MyConnSingleton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class CategoryServices extends QueryServiceBase<Category>{
    

    @Override
    public Category getObject(ResultSet rs) throws SQLException {
        return new Category(rs.getInt("id"),rs.getString("name"));// Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
     @Override
    public PreparedStatement getStm() throws SQLException {  
         return MyConnSingleton.getInstance().connect().prepareCall("SELECT * FROM Category");
    }
    

//    public List<Category> getCates() throws SQLException {
//        Connection conn = MyConnSingleton.getInstance().connect();
//        String sql = "SELECT * FROM Category";
//        PreparedStatement stm =conn.prepareCall(sql);
//        ResultSet rs = stm.executeQuery(sql);
//
//        List<Category> cates = new ArrayList<>();
//        while (rs.next()) {
//            int id = rs.getInt("id");
//            String name = rs.getString("name");
//
//            cates.add(new Category(id, name));
//        }
//        return cates;
//    }

   
}
