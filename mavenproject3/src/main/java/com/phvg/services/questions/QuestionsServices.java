/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.phvg.services.questions;

import com.phvg.pojo.Category;
import com.phvg.pojo.Level;
import com.phvg.pojo.QuestionQueryBuilder;
import com.phvg.pojo.Questions;
import com.phvg.services.QueryServiceBase;
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
public class QuestionsServices extends QueryServiceBase<Questions> implements  QuestionServiceBase{

    private QuestionQueryBuilder query;

    public QuestionsServices() {
    }

    public QuestionsServices(QuestionQueryBuilder query) {
        this.query = query;
    }
    

//   @Override
//    public List<Questions> list() throws SQLException {
//
//        PreparedStatement stm = this.query.build();
//
//        ResultSet rs = stm.executeQuery();
//
//        List<Questions> questions = new ArrayList<>();
//        while (rs.next()) {
//            int id = rs.getInt("id");
//            String content = rs.getString("content");
//
//            questions.add(new Questions.Builder().setId(id).setContent(content).build());
//        }
//
//        return questions;
//    }

    /**
     * @return the query
     */
    public QuestionQueryBuilder getQuery() {
        return query;
    }

    /**
     * @param query the query to set
     */
    public void setQuery(QuestionQueryBuilder query) {
        this.query = query;
    }

    @Override
    public PreparedStatement getStm() throws SQLException {
      return this.query.build(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Questions getObject(ResultSet rs) throws SQLException {
        return (new Questions.Builder().setId(rs.getInt("id")).setContent(rs.getString("content")).build()); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
