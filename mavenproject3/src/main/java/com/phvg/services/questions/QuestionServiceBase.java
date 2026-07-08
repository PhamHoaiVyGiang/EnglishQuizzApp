/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.phvg.services.questions;

import com.phvg.pojo.Choice;
import com.phvg.pojo.Questions;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author admin
 */
public abstract class QuestionServiceBase {
     public abstract List<Questions> getQuestions() throws SQLException ;
}
