/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.phvg.utils;

import com.phvg.services.CategoryServices;
import com.phvg.services.LevelServices;
import com.phvg.services.questions.QuestionsServices;
import com.phvg.services.questions.UpdateQuestionServices;

/**
 *
 * @author GIANG
 */
public class Configs {

    public static final CategoryServices cateServices = new CategoryServices();
    public static final QuestionsServices questionServices = new QuestionsServices();
    public static final LevelServices lvlServices = new LevelServices();
    public static final UpdateQuestionServices uQuestionServices=new UpdateQuestionServices();
}
