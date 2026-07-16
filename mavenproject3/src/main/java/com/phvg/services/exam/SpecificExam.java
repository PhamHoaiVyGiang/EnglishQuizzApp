/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.phvg.services.exam;

import com.phvg.pojo.QuestionQueryBuilder;
import com.phvg.pojo.Questions;
import com.phvg.services.questions.QuestionFacade;
import com.phvg.utils.Configs;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class SpecificExam extends ExamStrategy {

    private int num;

    public SpecificExam(int num) {
        this.num = num;
    }
       public SpecificExam(String num) {
        this(Integer.parseInt(num));
    }


    @Override
    public List<Questions> getQuestions() {
        QuestionQueryBuilder q = new QuestionQueryBuilder().setLimit(this.num).setOrderBy("rand() ");
        
        try {
            return QuestionFacade.getQuestion(q);
        } catch (SQLException ex) {
            Logger.getLogger(SpecificExam.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
