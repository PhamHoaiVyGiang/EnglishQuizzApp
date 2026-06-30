/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.phvg.services;

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
    public List<Questions> getQuestions() throws SQLException {
        Connection conn = MyConnSingleton.getInstance().connect();
        
        String sql = "SELECT * FROM question";
        PreparedStatement stm = conn.prepareCall(sql);
        ResultSet rs = stm.executeQuery(sql);

        List<Questions> questions = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String content = rs.getString("content");

            questions.add(new Questions.Builder().setId(id).setContent(content).build());
        }
        return questions;
    }
}
