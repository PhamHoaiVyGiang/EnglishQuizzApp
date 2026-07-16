/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.phvg.services.questions;

import com.phvg.pojo.QuestionQueryBuilder;
import com.phvg.pojo.Questions;
import com.phvg.utils.Configs;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author admin
 */
public class QuestionFacade {
    public static List<Questions> getQuestion(QuestionQueryBuilder q) throws SQLException{
        Configs.questionServices.setQuery(q);
        return Configs.questionServices.list();
        
    }
      public static List<Questions> getLazyQuestion(QuestionQueryBuilder q) throws SQLException{
        Configs.questionServices.setQuery(q);
        return new QuestionServiceDecorator(Configs.questionServices).list();
        
    }
}
