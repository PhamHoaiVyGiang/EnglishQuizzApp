/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.phvg.services;


import com.phvg.pojo.Level;
import com.phvg.utils.MyConnSingleton;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class LevelServices {

    public List<Level> getLevels() throws SQLException {
        Connection conn = MyConnSingleton.getInstance().connect();
        String sql = "SELECT * FROM level";
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);

        List<Level> levels = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");

            levels.add(new Level(id, name));
        }
        return levels;
    }
}
