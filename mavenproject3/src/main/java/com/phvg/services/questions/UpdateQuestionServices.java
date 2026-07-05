/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.phvg.services.questions;

import com.phvg.pojo.Choice;
import com.phvg.pojo.Questions;
import com.phvg.utils.MyConnSingleton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


/**
 *
 * @author GIANG
 */
public class UpdateQuestionServices {
     public void addQuestion(Questions q, List<Choice> choices) throws SQLException {
        Connection conn = MyConnSingleton.getInstance().connect();
        conn.setAutoCommit(false);
        String sql = "INSERT INTO question(content, category_id, level_id) VALUES(?, ?, ?)";
        PreparedStatement stm = conn.prepareCall(sql);
        stm.setString(1, q.getContent());
        stm.setInt(2, q.getCategory().getId());
        stm.setInt(3, q.getLevel().getId());

        if (stm.executeUpdate() > 0) {
            ResultSet r = stm.getGeneratedKeys();
            if (r.next()) {
                int qId = r.getInt(1);
                if (qId > 0) {
                    sql = "INSERT INTO choice(content, is_correct, question_id) VALUES(?, ?, ?)";
                    stm = conn.prepareCall(sql);

                    for (var c : choices) {
                        stm.setString(1, c.getContent());
                        stm.setBoolean(2, c.isCorrect());
                        stm.setInt(3, qId);
                        stm.executeUpdate();
                    }
                    
                    conn.commit();
                }
            }

        }
    }
}
