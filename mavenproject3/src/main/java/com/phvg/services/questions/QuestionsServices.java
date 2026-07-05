/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.phvg.services.questions;

import com.phvg.pojo.Category;
import com.phvg.pojo.Level;
import com.phvg.pojo.Questions;
import com.phvg.utils.MyConnSingleton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author GIANG
 */
public class QuestionsServices {
      public List<Questions> getQuestions(String kw, Category cate, Level lvl) throws SQLException {
        Connection conn = MyConnSingleton.getInstance().connect();
       
        String sql = "SELECT * FROM question WHERE 1=1"; // ORDER BY id DESC
        
        
        List<Object> params = new ArrayList<>();
        if (kw != null && !kw.isEmpty()) {
            sql += " content like concat('%', ?, '%')";
            params.add(kw);
        }
        
        if (cate != null) {
            sql += " category_id = ?";
            params.add(cate.getId());
        }
        
        if (lvl != null) {
            sql += " level_id = ?";
            params.add(lvl.getId());
        }
        
        PreparedStatement stm = conn.prepareCall(sql);
        for (int i = 0; i < params.size(); i++)
            stm.setObject(i + 1, params.get(i));
        
        ResultSet rs = stm.executeQuery();

        List<Questions> questions = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String content = rs.getString("content");

            questions.add(new Questions.Builder().setId(id).setContent(content).build());
        }

        return questions;
    }
}
