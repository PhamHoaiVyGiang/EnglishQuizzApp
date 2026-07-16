/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.phvg.services.exam;

import com.phvg.pojo.Questions;
import java.util.List;

/**
 *
 * @author admin
 */
public abstract class ExamStrategy {
    public abstract List<Questions> getQuestions();
}
