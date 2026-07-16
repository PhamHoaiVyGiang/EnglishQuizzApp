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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class FixedExam extends ExamStrategy{

    @Override
    public List<Questions> getQuestions() {
        List<Questions> questions=new ArrayList<>();
        
        for(int i=0;i<Configs.RATES.length;i++){
            QuestionQueryBuilder q=new QuestionQueryBuilder().withLevel(i+1).
                    setOrderBy("Rand() ").setLimit((int)(Configs.RATES[i]*Configs.EXAM_NUM));
            try {
                questions.addAll(QuestionFacade.getLazyQuestion(q));
            } catch (SQLException ex) {
                Logger.getLogger(FixedExam.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return questions;
    }
    
}
