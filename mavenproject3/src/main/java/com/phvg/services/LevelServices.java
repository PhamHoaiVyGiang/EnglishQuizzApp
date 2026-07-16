/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.phvg.services;


import com.phvg.pojo.Category;
import com.phvg.pojo.Level;
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
public class LevelServices extends QueryServiceBase<Level>{
    @Override
    public Level getObject(ResultSet rs) throws SQLException {
        return new Level(rs.getInt("id"),rs.getString("name"));// Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
     @Override
    public PreparedStatement getStm() throws SQLException {  
         return MyConnSingleton.getInstance().connect().prepareCall("SELECT * FROM level");
    }

//    public List<Level> getLevels() throws SQLException {
//        Connection conn = MyConnSingleton.getInstance().connect();
//        String sql = "SELECT * FROM level";
//        Statement stm = conn.createStatement();
//        ResultSet rs = stm.executeQuery(sql);
//
//        List<Level> levels = new ArrayList<>();
//        while (rs.next()) {
//            int id = rs.getInt("id");
//            String name = rs.getString("name");
//
//            levels.add(new Level(id, name));
//        }
//        return levels;
//    }
}
