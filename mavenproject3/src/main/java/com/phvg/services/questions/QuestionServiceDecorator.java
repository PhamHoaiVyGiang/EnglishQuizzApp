/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.phvg.services.questions;

import com.phvg.pojo.Questions;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author admin
 */
public class QuestionServiceDecorator extends QuestionServiceBase{
     private QuestionServiceBase q;

    public QuestionServiceDecorator(QuestionServiceBase q) {
        this.q = q;
    }

    
     
    @Override
    public List<Questions> getQuestions() throws SQLException {
        List<Questions> questions=this.q.getQuestions(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        ChoiceServices se= new ChoiceServices();
        for(var c : questions){
            c.setChoices(se.getChoiceByQuestionId(c.getId()));
        }
        return questions;
    }
    
    
}
