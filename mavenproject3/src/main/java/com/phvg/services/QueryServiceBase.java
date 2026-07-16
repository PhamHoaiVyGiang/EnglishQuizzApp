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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public abstract class QueryServiceBase <T> {
     public List<T> list() throws SQLException {
        Connection conn = MyConnSingleton.getInstance().connect();
        PreparedStatement stm =this.getStm();
      
        ResultSet rs = stm.executeQuery();

        List<T> resutls = new ArrayList<>();
        while (rs.next()) {
            resutls.add(this.getObject(rs));
        }
        return resutls;
    }
     public abstract PreparedStatement getStm()  throws SQLException;
     public abstract T getObject(ResultSet rs) throws SQLException;
}
