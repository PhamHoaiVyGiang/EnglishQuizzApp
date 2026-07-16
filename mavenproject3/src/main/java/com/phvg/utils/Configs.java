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
    public static final String CATE_KEY= "categories";
    public static final String LVL_KEY= "Lvels";
    public static final int EXAM_NUM=10;
    public static final double[] RATES ={0.4,0.4,0.2};
}
