/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.phvg.services.questions;

import com.phvg.pojo.Category;
import com.phvg.pojo.Choice;
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
public class ChoiceServices {
    public List<Choice> getChoiceByQuestionId(int questionId) throws SQLException{
         Connection conn = MyConnSingleton.getInstance().connect();
        String sql = "SELECT * FROM choice WHERE question_id=? ";
        PreparedStatement stm =conn.prepareCall(sql);
        stm.setInt()
        ResultSet rs = stm.executeQuery(sql);

        List<Choice> choices = new ArrayList<>();
        while (rs.next()) {
            choices.add(new Choice(rs.getInt("id"), rs.getString("content"), rs.getBoolean("is_correct")));
        }
        return choices;
    }
}
